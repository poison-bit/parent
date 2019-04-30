package com.chw.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chw.basic.service.impl.BaseServiceImpl;
import com.chw.dao.mapper.system.SysParameterMapper;
import com.chw.dao.model.system.SysParameter;
import com.chw.service.system.SysParameterService;
import com.github.pagehelper.PageHelper;

@Service
public class SysParameterServiceImpl extends BaseServiceImpl implements SysParameterService{

	@Autowired
	private SysParameterMapper sysParameterMapper;
	
	@Override
	public List<SysParameter> querySysParameterByMap(Map<String, Object> requestSysParameter, int page, int pageSize) {
		PageHelper.startPage(page,pageSize);
		debug("Service分页日志:page=" + page + "pageSize=" + pageSize);		
		return sysParameterMapper.selectSysParameter(requestSysParameter);
	}

	@Override
	public void saveSysParameter(SysParameter sysParameter, boolean b) {
		if(sysParameter.getSysParameterId() != null){
			sysParameterMapper.updateByPrimaryKey(sysParameter);
		}else{
			sysParameter.setSysParameterId(Long.parseLong(sysParameterMapper.insert(sysParameter)+""));
		}
	}

	@Override
	public SysParameter querySysParameterById(Long sysParameterId) {
		return sysParameterMapper.selectByPrimaryKey(sysParameterId);
	}

	@Override
	public int deleteSysParameter(SysParameter sysParameter) {
		return sysParameterMapper.deleteByPrimaryKey(sysParameter);
	}

	@Override
	public SysParameter querySysParameterByCode(String parCode) {
		SysParameter sysParameter = new SysParameter();
		sysParameter.setParCode(parCode);
		return sysParameterMapper.selectOne(sysParameter);
	}

	@Override
	public void updateSysParameter(SysParameter sysParameter) {
		sysParameter.setParValue("1");
		sysParameterMapper.updateByPrimaryKey(sysParameter);
	}

	@Override
	public List<SysParameter> getSysParameterList(Map<String, Object> map) {
		return sysParameterMapper.getSysParameterList(map);
	}

	@Override
	public void updateBySysParameter(SysParameter sysParameter) {
		sysParameterMapper.updateByPrimaryKey(sysParameter);
	}
}
