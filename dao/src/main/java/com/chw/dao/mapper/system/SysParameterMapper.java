package com.chw.dao.mapper.system;

import java.util.List;
import java.util.Map;

import com.chw.dao.model.system.SysParameter;

import tk.mybatis.mapper.common.Mapper;

public interface SysParameterMapper extends Mapper<SysParameter> {
	
	List<SysParameter> selectSysParameter(Map<String, Object> requestSysParameter);
	
	/**
	 * 根据字符窜拼接查询系统参数
	 * @return
	 */
	public List<SysParameter> getSysParameterList(Map<String, Object> map);
	
	/**
	 * 根据code获取系统参数
	 * @param code
	 * @return
	 */
	public SysParameter getSysParameterByCode(String parCode);
}