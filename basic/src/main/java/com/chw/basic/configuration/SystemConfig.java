package com.chw.basic.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@PropertySource("classpath:config.properties")
@Component
public class SystemConfig {
	
	@Value("${kaptcha.image.height}")
	public static String kaptchaHeight;
}
