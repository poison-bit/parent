package com.chw.dao.model.system;

import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import com.chw.basic.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 后台用户实体类
 * @author c
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysUser extends BaseModel {
	
	private static final long serialVersionUID = 7485651453835368385L;

	/**
     * 主键
     */
    private Long userId;

    /**
     * 登录凭证
     */
    private String userCredentials;
    
	/**
     * 登录帐号
     */
    private String loginName;
    
    /**
     * 登录密码
     */
    private String password;
    
    /**
     * 姓名
     */
    private String userName;

    /**
     * 座机
     */
    private String telephone;
    
    /**
     * 手机
     */
    private String mobilePhone;

    /**
     * 性别
     */
    private Integer sex;
    
   /**
    * 注册时间
    */
    private Date createTime;

    /**
     * 最后一次登录时间
     */
    private Date lastLoginTime;

    /**
     * 状态(0：注销 1：正常 2：锁定 3：禁用)
     */
    private String state;

    /**
     * 错误登录次数
     */
    private Integer num;
 
    /**
     * 头像
     */
    private String img;
    
    @Transient
    private List<SysRole> roles;
    
    @Transient
    private List<SysRole> useRoles;
}