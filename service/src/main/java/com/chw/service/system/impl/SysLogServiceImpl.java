package com.chw.service.system.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chw.basic.service.impl.BaseServiceImpl;
import com.chw.dao.mapper.system.SysLogMapper;
import com.chw.dao.model.system.SysLog;
import com.chw.service.system.SysLogService;

@Service
public class SysLogServiceImpl extends BaseServiceImpl implements SysLogService{

	@Autowired
	private SysLogMapper sysLogMapper;
	
	@Override
	@Transactional
	public void saveSysLog(SysLog sysLog) {
		sysLogMapper.insertSelective(sysLog);
	}
}
