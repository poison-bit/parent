package com.chw.basic.cipher;

import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * BASE64加解密工具类
 * @author Administrator
 *
 */
public class Base64Util {
	/** 
	 * 对字符窜进行加密
	 * @param str
	 * @return
	 */
	public static String encryption(String str){
		byte[] b = null;  
        String s = null;  
        try {  
            b = str.getBytes("utf-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        if (b != null) {  
            s = new BASE64Encoder().encode(b);  
        }  
        return s;
	}
	
	/**
	 * 对字符窜进行解密
	 * @param str
	 * @return
	 */
	public static String decrypt(String str){
		byte[] b = null;  
        String result = null;  
        if (str != null) {  
            BASE64Decoder decoder = new BASE64Decoder();  
            try {  
                b = decoder.decodeBuffer(str);  
                result = new String(b, "utf-8");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
	}
}
