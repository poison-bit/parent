package com.chw.manager.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chw.basic.constant.CommonConstant;
import com.chw.basic.controller.BaseController;
import com.chw.basic.img.VerifyCodeUtils;

@Controller
@RequestMapping(value="/validate")
public class CodeValidate extends BaseController{
	
	@RequestMapping(value = "/validateCode", method = RequestMethod.GET)
	public void validateCodeGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		try {
			response.setHeader("Pragma", "no-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setDateHeader("Expires", 0);
	        response.setContentType("image/jpeg");
	        HttpSession session = request.getSession();
	        String validateCodeType = request.getParameter("type");
	        if(validateCodeType == null || "".equals(validateCodeType)){
	            validateCodeType = "loginValidateCode";
	        }
	        String validateCodeLength = request.getParameter("length");
	        int codeLength = 6;
	        if(validateCodeLength != null && !"".equals(validateCodeLength)){
	        	codeLength = Integer.parseInt(validateCodeLength);
	        }
	        String s = VerifyCodeUtils.generateVerifyCode(codeLength);
	        session.setAttribute(validateCodeType, s);
	        session.setAttribute(CommonConstant.SESSION_VCODE_TIME, System.currentTimeMillis());
	        VerifyCodeUtils.outputImage(response.getOutputStream(), s);
		} catch (Exception e) {
			e.printStackTrace();
		}
 		
	}
	
	@RequestMapping(value = "/validateCode", method = RequestMethod.POST)
	public void validateCodePost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		 	response.setHeader("Pragma", "no-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setDateHeader("Expires", 0);
	        response.setContentType("image/jpeg");

	        HttpSession session = request.getSession();
	        String validateCodeType = request.getParameter("type");
	        if(validateCodeType == null || "".equals(validateCodeType)){
	            validateCodeType = "loginValidateCode";
	        }
	        
	        String validateCodeLength = request.getParameter("length");
	        int codeLength = 6;
	        if(validateCodeLength != null && !"".equals(validateCodeLength)){
	        	codeLength = Integer.parseInt(validateCodeLength);
	        }

	        String s = VerifyCodeUtils.generateVerifyCode(codeLength);
	        session.setAttribute(validateCodeType, s);
	        session.setAttribute(CommonConstant.SESSION_VCODE_TIME, System.currentTimeMillis());

	        VerifyCodeUtils.outputImage(response.getOutputStream(), s);
	}
}
