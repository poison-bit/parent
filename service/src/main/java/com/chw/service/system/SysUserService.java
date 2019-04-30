package com.chw.service.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.chw.dao.model.system.SysUser;

/**
 * 类说明：用户管理
 * @author CHENWEI
 * 2016年8月25日
 */
public interface SysUserService {
	
	/**
	 * 用户列表
	 * @param map
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<SysUser> selectSysUserList(Map<String, Object> map,int page,int pageSize);
	
	/**
	 * 转账用户列表
	 * @param map
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<SysUser> selectTransSysUserList(Map<String, Object> map,int page,int pageSize);
	
	/**
	 * 新增和修改用户
	 * @param sysMenu
	 */
	public void saveAndEditUser(SysUser sysUser,HttpServletRequest request);
	
	/**
	 * 根据用户ID查询用户
	 * @param menuId
	 * @return
	 */
	public SysUser selectUserByUserId(Long userId);
	
	/**
	 * 根据登录帐号查询用户
	 * @param menuId
	 * @return
	 */
	public SysUser selectUserByLoginName(String loginName);
	
	/**
	 * 方法说明：获取用户信息
	 * @author CHENWEI
	 * @return
	 * 2016年8月25日
	 */
	public SysUser selectSysUser(Map<String, Object> map);
	
	public SysUser getSysUserByEntity(SysUser user);
	
	public int updateUserByEntity(SysUser user);

	
	/**
	 * 根据用户ID查询用户信息(前台)
	 * @param userId
	 * @return
	 */
	public HashMap<String, Object> selectUserByShopId(Long userId) ;

	
	
}
