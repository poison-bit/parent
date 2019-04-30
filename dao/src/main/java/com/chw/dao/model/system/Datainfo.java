package com.chw.dao.model.system;

import java.util.Date;

import com.chw.basic.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 字典表
 * @author c
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Datainfo extends BaseModel{
	
	private static final long serialVersionUID = 175539644811980847L;

	/**
     * DATAINFO_ID
     */
    private Long datainfoId;

    /**
     * 项目描述
     */
    private String name;

    /**
     * 项目代码
     */
    private String code;

    /**
     * 类型描述
     */
    private String typeDesc;

    /**
     * 类型拼音
     */
    private String pinyin;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 父类id
     */
    private Long parentId;
}