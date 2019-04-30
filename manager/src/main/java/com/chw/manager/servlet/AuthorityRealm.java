package com.chw.manager.servlet;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chw.basic.constant.CommonConstant;
import com.chw.dao.model.system.SysUser;
import com.chw.service.system.ISysMenuService;
import com.chw.service.system.ISysRoleService;
import com.chw.service.system.ISysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorityRealm extends AuthorizingRealm {

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private ISysRoleService sysRoleService;

	@Autowired
	private ISysMenuService sysMenuService;

	/**
	 * 登录认证，创建用户的登录信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		String loginName = token.getUsername();
		SysUser user = sysUserService.selectOne(new EntityWrapper<SysUser>().eq("loginName",loginName));

		if (user == null) {
			throw new UnknownAccountException();
		}

		if (user.getNum() > 3) {
			throw new LockedAccountException();
		}

		String password = user.getPassword();

		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(loginName, password,
				ByteSource.Util.bytes(user.getUserCredentials()), getName());

		ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		ra.getRequest().getSession().setAttribute(CommonConstant.SESSION_USER, user);

		return simpleAuthenticationInfo;
	}

	/**
	 * 权限认证，获取登录用户的权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String loginName = (String) principals.fromRealm(getName()).iterator().next();
		SysUser user = sysUserService.selectUserByLoginName(loginName);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (user != null) {
			// 添加角色
			List<String> roles = sysRoleService.selectRoleNameByUserId(user.getUserId());
			info.addRoles(roles);

			// 添加权限
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", user.getUserId());
			info.addStringPermissions(sysMenuService.selectMenuNameList(map));
		}
		return info;
	}

}
