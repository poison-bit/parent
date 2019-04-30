package com.chw.dao.model.system;

import com.chw.basic.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色菜单实体类
 * @author c
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysRoleMenu extends BaseModel{
	
	private static final long serialVersionUID = 6237536235937390871L;

	/**
     * 主键
     */
    private Long roleMenuId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 菜单id
     */
    private Long menuId;
}