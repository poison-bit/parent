package com.chw.basic.model;

import java.util.ArrayList;
import java.util.List;

import com.chw.basic.constant.CommonConstant;

/**
 * 类说明：树形结构VO
 * @author CHENWEI
 * 2016年8月30日
 */
public class ZtreeVO<T> {
	private Integer id;//节点ID
	private Integer pId;//父ID
	private String name;//名称
	private String openUrl;//URL
	private String target;//打开窗口名称
	private boolean open = CommonConstant.zTreeNodeIsOpen;//是否打开
	private boolean isChecked = CommonConstant.zTreeNodeIsOpen;//是否选中
	private String icon;//节点图标
	private String iconOpen;//节点展开图标
	private String iconClose;//节点关闭图标
	private String iconSkin;//节点个性化图标
	private List<ZtreeVO<T>> children = new ArrayList<ZtreeVO<T>>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public String getOpenUrl() {
		return openUrl;
	}
	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIconOpen() {
		return iconOpen;
	}
	public void setIconOpen(String iconOpen) {
		this.iconOpen = iconOpen;
	}
	public String getIconClose() {
		return iconClose;
	}
	public void setIconClose(String iconClose) {
		this.iconClose = iconClose;
	}
	public String getIconSkin() {
		return iconSkin;
	}
	public void setIconSkin(String iconSkin) {
		this.iconSkin = iconSkin;
	}
	public List<ZtreeVO<T>> getChildren() {
		return children;
	}
	public void setChildren(List<ZtreeVO<T>> children) {
		this.children = children;
	}
}
