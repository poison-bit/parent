package com.chw.service.system;

import java.util.List;
import java.util.Map;

import com.chw.basic.service.BaseService;
import com.chw.dao.model.system.SysParameter;

public interface SysParameterService extends BaseService{
	
	public List<SysParameter> querySysParameterByMap(Map<String, Object> requestSysParameter, int page, int pageSize);

	public void saveSysParameter(SysParameter sysParameter, boolean b);

	public SysParameter querySysParameterById(Long sysParameterId);
	
	public int deleteSysParameter(SysParameter sysParameter);
	
	public SysParameter querySysParameterByCode(String parCode);
	
	public void updateSysParameter(SysParameter sysParameter);
	
	public void updateBySysParameter(SysParameter sysParameter);
	
	/**
	 * 根据字符窜拼接查询系统参数
	 * @return
	 */
	public List<SysParameter> getSysParameterList(Map<String, Object> map);

}
