package com.chw.dao.mapper.system;

import java.util.List;
import java.util.Map;

import com.chw.dao.model.system.Datainfo;

import tk.mybatis.mapper.common.Mapper;
public interface DatainfoMapper extends Mapper<Datainfo> {

	List<Datainfo> selectDatainfoByMap(Map<String, Object> requestParameterAsMap);

	List<Datainfo> selectDatainfoByCodeAndPinyin(String parentCode, String childrenPinyin);

	Datainfo selectDatainfoByParentcodeAndchildrencode(String parentCode, String childrenCode);
	
	Datainfo queryDataInfo(String code);
	
	/**
	 * 根据角色查询优惠券使用分类
	 * @param map
	 * @return
	 */
	public List<Datainfo> queryDatainfoByRole(Map<String, Object> map);

	Datainfo getDataInfo(Datainfo record);

	Datainfo selectDatainfoByParentcodeAndchildrencode1(Map<String, Object> dataMap);

}