package com.chw.manager.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chw.basic.configuration.SystemConfig;
import com.chw.basic.controller.BaseController;

@Controller
@RequestMapping("/system")
public class LoginController extends BaseController {

	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/system/login";
	}
}