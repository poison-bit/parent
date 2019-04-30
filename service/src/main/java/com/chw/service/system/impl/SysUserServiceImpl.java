package com.chw.service.system.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chw.basic.cipher.Base64Util;
import com.chw.basic.constant.CommonConstant;
import com.chw.basic.service.impl.BaseServiceImpl;
import com.chw.dao.mapper.system.SysRoleMapper;
import com.chw.dao.mapper.system.SysUserMapper;
import com.chw.dao.mapper.system.SysUserRoleMapper;
import com.chw.dao.model.system.SysRole;
import com.chw.dao.model.system.SysUser;
import com.chw.dao.model.system.SysUserRole;
import com.chw.service.system.SysUserService;
import com.github.pagehelper.PageHelper;

/**
 * 类说明：用户管理
 * @author CHENWEI
 * 2016年8月25日
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl implements SysUserService{
	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private SysUserRoleMapper userRoleMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	
	public SysUser selectSysUser(Map<String, Object> map) {
		map.put("password", Base64Util.encryption(String.valueOf(map.get("password"))));
		return userMapper.querySysUser(map);
	}
	
	public int updateUserByEntity(SysUser user){
		return userMapper.updateByPrimaryKey(user);
	}

	public SysUser getSysUserByEntity(SysUser user) {
		return userMapper.selectOne(user);
	}

	public List<SysUser> selectSysUserList(Map<String, Object> map, int page, int pageSize) {
		PageHelper.startPage(page, pageSize);
		return userMapper.querySysUserList(map);
	}
	
	public List<SysUser> selectTransSysUserList(Map<String, Object> map, int page, int pageSize) {
		PageHelper.startPage(page, pageSize);
		return userMapper.queryTransSysUserList(map);
	}

	public void saveAndEditUser(SysUser sysUser,HttpServletRequest request) {
		String roleIds = request.getParameter("roleIds");
		Long roleId = Long.valueOf(roleIds.replace(",", "")); 
		//String password = new SimpleHash("MD5", sysUser.getPassword(), ByteSource.Util.bytes(sysUser.getPassword())).toHex();
		String password = "";
		if(sysUser.getUserId()==null){
			sysUser.setUserCredentials(sysUser.getPassword());
			sysUser.setPassword(password);
			userMapper.insertSelective(sysUser);
			
			SysRole sysrole=new SysRole();
			sysrole.setRoleId(roleId);
			sysrole = sysRoleMapper.selectOne(sysrole);
			
			SysUserRole saveRole = new SysUserRole();
			saveRole.setUserId(sysUser.getUserId());
			saveRole.setRoleId(Long.valueOf(roleId));
			userRoleMapper.insertSelective(saveRole);
			
		}else{ 
			if(sysUser.getPassword()!=null&&sysUser.getPassword()!=""){
				//二次加密 用于 shiro认证
				
				sysUser.setUserCredentials(sysUser.getPassword());
				sysUser.setPassword(password);
			}else{
				sysUser.setPassword(null);
			}
		 
			
			//如果当前用户是管理员,则可能修改角色
			SysUser nowUser = (SysUser) request.getSession().getAttribute(CommonConstant.SESSION_USER);
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setUserId(nowUser.getUserId());
			sysUserRole = userRoleMapper.selectOne(sysUserRole);
			SysRole sysrole=new SysRole();
			sysrole.setRoleId(sysUserRole.getRoleId());
			sysrole = sysRoleMapper.selectOne(sysrole);
			

			sysUser.setLoginName(null);
			userMapper.updateByPrimaryKeySelective(sysUser);
		}

	}

	public SysUser selectUserByUserId(Long userId) {
		return userMapper.queryUserByUserId(userId);
	}
	
	@Override
	public HashMap<String, Object> selectUserByShopId(Long userId) {
		return userMapper.selectUserByShopId(userId);
	}

	public SysUser selectUserByLoginName(String loginName) {
		return userMapper.queryUserByLoginName(loginName);
	}

}