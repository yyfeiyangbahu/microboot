package cn.mldn.microboot.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 与yml中http配置相同作用
 * @author Administrator
 *
 */
@Configuration
public class UploadConfig {
	@Bean	
	public MultipartConfigElement getMultipartConfig(){
			MultipartConfigFactory config = new MultipartConfigFactory();
			config.setMaxFileSize("10MB");
			config.setMaxRequestSize("100MB");
			config.setLocation("/");
			return config.createMultipartConfig();//返回一个配置
		}
}
