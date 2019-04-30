package com.chw.manager.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chw.dao.model.system.SysLog;
import com.chw.service.system.SysLogService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SysLogController {

	@Autowired
	private SysLogService sysLogService;

	@Test
	public void saveSysLog() {
		try {
			System.out.println("dasdada");
			SysLog sysLog = new SysLog();
			sysLog.setEventName("das");
			sysLogService.saveSysLog(sysLog);
			System.out.println("dasdada1");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}