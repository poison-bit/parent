package com.chw.service.system;

import com.chw.basic.service.BaseService;
import com.chw.dao.model.system.SysLog;

public interface SysLogService extends BaseService{
	
	/**
	 * 保存日志
	 * @param sysLog
	 */
	public void saveSysLog(SysLog sysLog);
}