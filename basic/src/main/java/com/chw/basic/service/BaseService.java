package com.chw.basic.service;

public interface BaseService {
	 /**
     * 写入debug日志
     * @param message
     */
    void debug(Object message);
    /**
     * 写入debug日志(包含异常)
     * @param message
     * @param t
     */
    void debug(Object message, Throwable t);
    /**
     * 写入info日志
     * @param message
     */
    void info(Object message);
    /**
     * 写入info日志(包含异常)
     * @param message
     * @param t
     */
    void info(Object message, Throwable t);
    /**
     * 写入warn日志
     * @param message
     */
    void warn(Object message);
    /**
     * 写入warn日志(包含异常)
     * @param message
     * @param t
     */
    void warn(Object message, Throwable t);
    /**
     * 写入error日志
     * @param message
     */
    void error(Object message);
    /**
     * 写入error日志(包含异常)
     * @param message
     * @param t
     */
    void error(Object message, Throwable t);
}
