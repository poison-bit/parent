package com.chw.dao.model.system;

import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import com.chw.basic.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 菜单实体类
 * @author c
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysMenu extends BaseModel{
	
	private static final long serialVersionUID = 5149954618031069798L;

	/**
     * 主键
     */
    private Long menuId;

    /**
     * 菜单名称
     */
    private String menuName;
    
    /**
     * 菜单类别
     */
    private Integer menuType;

    /**
     * 菜单地址
     */
    private String menuUrl;

    /**
     * 父级菜单ID
     */
    private Long parentId;
    
    /**
     * 父级菜单名称
     */
    @Transient
    private String parentMenuName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 排序号
     */
    private Integer sort;
    
    /**
     * 级别
     */
    private Integer level;
    
    /**
     * 是否打开(节点)
     */
    private String isOpen;
    
    /**
     * 打开窗口(节点)
     */
    private String target;
    
    /**
     * 节点图标
     */
    private String icon;
    
    /**
     * 节点打开图标
     */
    private String iconOpen;
    
    /**
     * 节点关闭图标
     */
    private String iconClose;
    
    /**
     * 节点个性化图标
     */
    private String iconSkin;

    @Transient
    private List<SysMenu> sysMenus;
    
    
    /*
     * 状态(1:有效 0：无效)
     */
    private Integer state;
}