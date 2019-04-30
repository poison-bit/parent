package com.chw.service.system;

import java.util.List;
import java.util.Map;

import org.quartz.Scheduler;

import com.chw.dao.model.system.SysTask;

public interface SysTaskService {
	public List<SysTask> selectSysTaskList(Map<String, Object> map,int page,int pageSize);
	
	public void saveAndEditTask(SysTask sysTask);
	
	/*public Scheduler getScheduler();*/
	
	public SysTask selectTaskById(Long taskId);
	
	public SysTask selectTaskByMethod(String taskMethod);
	
	public List<SysTask> selectTaskListByState(String taskState);
}
