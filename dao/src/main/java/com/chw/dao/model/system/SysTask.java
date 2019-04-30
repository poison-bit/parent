package com.chw.dao.model.system;

import java.util.Date;

import com.chw.basic.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 类说明：任务实体类
 * @author c
 * 2016年9月6日
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysTask extends BaseModel{
	
	private static final long serialVersionUID = 1630210352363103308L;

	/**
     * id
     */
    private Long taskId;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 运行状态(RUN: 运行：WAIT：等待中
     */
    private String runState;
    
    /**
     * 任务状态 DISABLE：停用， ENABLE：启用
     */
    private String taskState;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 时间表达式
     */
    private String timeExpression;
    
    /**
     * 任务组名
     */
    private String groupName;
    
    /**
     * 任务服务类
     */
    private String taskService;
    
    /**
     * 任务服务方法
     */
    private String taskMethod;
}