package com.chw.service.system;

import java.util.List;
import java.util.Map;

import com.chw.basic.service.BaseService;
import com.chw.dao.model.system.Datainfo;

public interface DatainfoService extends BaseService{
	public List<Datainfo> queryByMap(Map<String, Object> requestParameterAsMap, int page, int pageSize);

	public void saveCodeParent(Datainfo datainfo, boolean b);

	public Datainfo queryByPrimaryKey(Long datainfoId);

	public int deleteDataInfo(Datainfo datainfo);

	/**
	 * 通过代码类型查询子类型
	 * @param codeTypes
	 * @return
	 */
	public List<Datainfo> queryCodeListByCode(Datainfo datainfo);
	
	public Datainfo queryDataInfoByCodeAndValue(String code, String value);

	/**
	 * 通过父类code查询子类列表
	 * @param datainfo
	 * @return
	 */
	public List<Datainfo> queryChildInfoByParentCode(Datainfo datainfo);
	
	/**
	 * 通过父类code查询子类列表
	 * @param datainfo
	 * @return
	 */
	public List<Datainfo> queryChildInfoByParentCode(String parentCode);
	
	Datainfo queryDataInfoByCodeAndPinyin(String parentCode, String childrenPinyin);
	
	/**
	 * 根据对象查询唯一编码
	 * @param datainfo
	 * @return
	 */
	public Datainfo queryDatainfoInfo(Datainfo datainfo);
	
	/**
	 * 根据code查询
	 * @param code
	 * @return
	 */
	public Datainfo queryDatainfoInfoByCode(String code);
	
	/**
	 * 根据角色查询优惠券使用分类
	 * @param map
	 * @return
	 */
	public List<Datainfo> queryDatainfoByRole(Map<String, Object> map);

	/**
	 * 根据父类code和子类code查询
	 * @param parentCode
	 * @param childrenCode
	 * @return
	 */
	public Datainfo selectDatainfoByParentcodeAndchildrencode(String parentCode, String childrenCode);

	/**
	 * 根据ID查询数据
	 * @param useType
	 * @return
	 */
	public Datainfo getDatainfo(Long useType);
	
}
