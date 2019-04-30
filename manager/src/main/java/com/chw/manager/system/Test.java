package com.chw.manager.system;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chw.service.system.SysLogService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {

	@Autowired
	private SysLogService sysLogService;
	
	@org.junit.Test
	public void saveLog(){
		SysLog sysLog = new SysLog();
		sysLog.setEventName("da");
		sysLogService.saveSysLog(sysLog);
	}
	
}
