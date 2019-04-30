package com.chw.manager.servlet;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {

	/**
	 * 凭证匹配器
	 * 
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用md5算法;
		hashedCredentialsMatcher.setHashIterations(1);// 散列的次数，比如散列1次，相当于 md5(
														// md5(""));
		return hashedCredentialsMatcher;
	}

	/**
	 * 自定义realm,将凭证匹配器设置到realm中，realm按照凭证匹配器的要求进行散列
	 * 
	 * @return
	 */
	@Bean
	public Realm myShiroRealm() {
		AuthorityRealm authorityRealm = new AuthorityRealm();
		authorityRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return authorityRealm;
	}

	/**
	 * shiro 安全管理器，核心安全管理接口
	 * 
	 * @return
	 */
	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		securityManager.setSessionManager(shiroSessionManager());
		return securityManager;
	}

	@Bean
	public SimpleCookie sharesession() {
		SimpleCookie simpleCookie = new SimpleCookie();
		simpleCookie.setName("SHAREJSESSIONID");
		simpleCookie.setPath("/");
		simpleCookie.setHttpOnly(true);
		return simpleCookie;
	}

	@Bean
	public DefaultWebSessionManager shiroSessionManager() {
		DefaultWebSessionManager shiroSessionManager = new DefaultWebSessionManager();
		// 去掉JSESSIONID小尾巴
		shiroSessionManager.setSessionIdUrlRewritingEnabled(false);
		shiroSessionManager.setSessionValidationSchedulerEnabled(true);
		shiroSessionManager.setGlobalSessionTimeout(1800000);
		shiroSessionManager.setDeleteInvalidSessions(true);
		shiroSessionManager.setSessionIdCookie(sharesession());
		return shiroSessionManager;
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilter() {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager());
		// loginUrl认证提交地址，如果没有认证将会请求此地址进行认证，请求此地址将由formAuthenticationFilter进行表单认证
		shiroFilterFactoryBean.setLoginUrl("/system/login");
		// 认证成功统一跳转到first.action，建议不配置，shiro认证成功自动到上一个请求路径
		shiroFilterFactoryBean.setSuccessUrl("/system/main");
		// 通过unauthorizedUrl指定没有权限操作时跳转页面
		shiroFilterFactoryBean.setUnauthorizedUrl("/system/noAuthority");
		// 自定义过滤器
		Map<String, Filter> filterMap = new LinkedHashMap<>();
		shiroFilterFactoryBean.setFilters(filterMap);
		// 权限控制map,先进先出
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		// 配置不会被拦截的链接 顺序判断(静态资源过滤)
		filterChainDefinitionMap.put("/static/**", "anon");
		//验证码过滤
		filterChainDefinitionMap.put("/validate/validateCode", "anon");
		// 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/**", "authc");
		//authc 所有url都必须认证通过才可以访问
		//anon 所有url都都可以匿名访问
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}
}