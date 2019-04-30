package com.chw.dao.model.system;

import com.chw.basic.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户角色实体类
 * @author c
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysUserRole extends BaseModel{
	
	private static final long serialVersionUID = -5139554305881409321L;

	/**
     * 主键
     */
    private Long userRoleId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 用户id
     */
    private Long userId;
}