package com.chw.dao.mapper.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chw.dao.model.system.SysUser;

import tk.mybatis.mapper.common.Mapper;
/**
 * 类说明：用户管理
 * @author CHENWEI
 * 2016年8月25日
 */

public interface SysUserMapper extends Mapper<SysUser> {
	
	/**
	 * 用户列表
	 * @param map
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<SysUser> querySysUserList(Map<String, Object> map);
	
	/**
	 * 转账用户列表
	 * @param map
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<SysUser> queryTransSysUserList(Map<String, Object> map);
	
	/**
	 * 根据用户ID查询用户
	 * @param userId
	 * @return
	 */
	public SysUser queryUserByUserId(Long userId);
	
	/**
	 * 根据登录帐号查询用户
	 * @param userId
	 * @return
	 */
	public SysUser queryUserByLoginName(String loginName);
	
	public SysUser querySysUser(Map<String, Object> map);
	
	/**
	 * 用户列表(前台)
	 * @param map
	 * @return
	 */
	public List<Map<String,	Object>> selectSysUserListByuserType(Map<String, Object> map);
	
	/**
	 * 根据用户Id查询用户信息(前台)
	 * @param userId
	 * @return
	 */
	public HashMap<String, Object> selectUserByShopId(Long userId);
	
	/**
	 * 商户列表
	 * @return
	 */
	public List<SysUser> querySysUserListByRole();

	public List<Map<String, Object>> selectSysUserListByType(Map<String, Object> map);

	


	
}