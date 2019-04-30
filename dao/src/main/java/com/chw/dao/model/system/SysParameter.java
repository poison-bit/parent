package com.chw.dao.model.system;

import com.chw.basic.model.BaseModel;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 参数实体类
 * @author c
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SysParameter extends BaseModel{
	
	private static final long serialVersionUID = -3062675752054399533L;

	/**
     * SYS_PARAMETER
     */
    private Long sysParameterId;

    /**
     * 参数名称
     */
    private String parName;
    /**
     * 参数代码
     */
    private String parCode;
    /**
     * 参数类型
     */
    private String parType;
    /**
     * 参数值
     */
    private String parValue;
    /**
     * 参数说明
     */
    private String parRemark;
}