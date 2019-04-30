package com.chw.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chw.basic.service.impl.BaseServiceImpl;
import com.chw.dao.mapper.system.DatainfoMapper;
import com.chw.dao.model.system.Datainfo;
import com.chw.service.system.DatainfoService;
import com.github.pagehelper.PageHelper;

@Service
public class DatainfoServiceImpl extends BaseServiceImpl implements DatainfoService {
	@Autowired
	private DatainfoMapper datainfoMapper;

	@Override
	public List<Datainfo> queryByMap(Map<String, Object> requestParameterAsMap, int page, int pageSize) {
		PageHelper.startPage(page, pageSize);
		debug("Service分页日志:page=" + page + "pageSize=" + pageSize);
		return datainfoMapper.selectDatainfoByMap(requestParameterAsMap);
	}

	@Override
	public void saveCodeParent(Datainfo datainfo, boolean b) {
		if (datainfo.getDatainfoId() != null) {
			datainfoMapper.updateByPrimaryKeySelective(datainfo);
		} else {
			datainfo.setDatainfoId(Long.parseLong(datainfoMapper.insert(datainfo) + ""));
		}
	}

	@Override
	public Datainfo queryByPrimaryKey(Long datainfoId) {
		return datainfoMapper.selectByPrimaryKey(datainfoId);
	}

	@Override
	public int deleteDataInfo(Datainfo datainfo) {
		int i = 0;
		i += datainfoMapper.deleteByPrimaryKey(datainfo);// 删除主记录
		datainfo.setParentId(datainfo.getDatainfoId());
		datainfo.setDatainfoId(null);
		i += datainfoMapper.delete(datainfo);// 删除子类信息
		return i;
	}

	@Override
	public List<Datainfo> queryCodeListByCode(Datainfo datainfo) {
		Datainfo data = datainfoMapper.selectOne(datainfo);
		Datainfo temp = new Datainfo();
		temp.setParentId(data.getDatainfoId());
		return datainfoMapper.select(temp);
	}

	@Override
	public Datainfo queryDataInfoByCodeAndValue(String code, String value) {
		Datainfo d = new Datainfo();
		d.setCode(code);
		Datainfo data = datainfoMapper.selectOne(d);
		Datainfo d1 = new Datainfo();
		d1.setCode(value);
		d1.setParentId(data.getDatainfoId());
		return datainfoMapper.selectOne(d1);
	}

	@Override
	public List<Datainfo> queryChildInfoByParentCode(Datainfo datainfo) {
		Datainfo d = new Datainfo();
		d = datainfoMapper.selectOne(datainfo);
		datainfo.setCode(null);
		datainfo.setParentId(d.getDatainfoId());
		return datainfoMapper.select(datainfo);
	}
	
	@Override
	public List<Datainfo> queryChildInfoByParentCode(String parentCode) {
		Datainfo d = new Datainfo();
		d.setCode(parentCode);
		d = datainfoMapper.selectOne(d);
		Datainfo datainfo = new Datainfo();
		datainfo.setParentId(d.getDatainfoId());
		return datainfoMapper.select(datainfo);
	}

	@Override
	public Datainfo queryDataInfoByCodeAndPinyin(String parentCode, String childrenPinyin) {
		Datainfo d = new Datainfo();
		d.setCode(parentCode);
		Datainfo data = datainfoMapper.selectOne(d);
		Datainfo d1 = new Datainfo();
		d1.setPinyin(childrenPinyin);
		d1.setParentId(data.getDatainfoId());
		return datainfoMapper.selectOne(d1);
	}

	@Override
	public Datainfo queryDatainfoInfo(Datainfo datainfo) {
		return datainfoMapper.selectOne(datainfo);
	}

	@Override
	public Datainfo queryDatainfoInfoByCode(String code) {
		Datainfo datainfo = new Datainfo();
		datainfo.setCode(code);
		return datainfoMapper.selectOne(datainfo);
	}

	@Override
	public List<Datainfo> queryDatainfoByRole(Map<String, Object> map) {
		return datainfoMapper.queryDatainfoByRole(map);
	}

	@Override
	public Datainfo selectDatainfoByParentcodeAndchildrencode(String parentCode, String childrenCode) {
		Map<String, Object> map = new HashMap<>();
		map.put("parentCode", parentCode);
		map.put("childrenCode", childrenCode);
		Datainfo datainfo = datainfoMapper.selectDatainfoByParentcodeAndchildrencode1(map);
		return datainfo;
	}

	@Override
	public Datainfo getDatainfo(Long useType) {
		Datainfo datainfo = datainfoMapper.selectByPrimaryKey(useType);
		return datainfo;
	}
}