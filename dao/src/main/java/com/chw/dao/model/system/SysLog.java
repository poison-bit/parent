package com.chw.dao.model.system;

import java.util.Date;

import com.chw.basic.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 类说明：日志实体类
 * @author c
 * 2016年9月5日
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysLog extends BaseModel{
	
	private static final long serialVersionUID = 1663372592247670268L;

	/**
     * ID
     */
    private Long logId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 事件名称
     */
    private String eventName;

    /**
     * 日志类型(1:操作日志 0:异常日志)
     */
    private Integer logType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户IP
     */
    private String userIp;

    /**
     * 描述
     */
    private String description;
}