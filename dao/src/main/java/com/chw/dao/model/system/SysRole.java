package com.chw.dao.model.system;

import java.util.Date;

import com.chw.basic.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 角色实体类
 * @author c
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysRole extends BaseModel{
	
	private static final long serialVersionUID = -434164338810146930L;

	/**
     * 主键
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色状态(0：禁用 1：正常)
     */
    private Integer state;
    
    /**
     * 角色类型
     */
    private Long roleType;

    /**
     * 创建时间
     */
    private Date createTime;
}