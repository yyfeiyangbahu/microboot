package cn.mldn.microboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.mldn.microboot.service.impl.MessageServiceImpl;

@Configuration// 此处为配置项
public class ServiceConfig {
	@Bean(name="configService")  //此处返回的是一个Spring的配置Bean，与XML的"<bean>"等价
	public MessageServiceImpl getMessageService() {// 方法名随便写
		return new MessageServiceImpl();
	}
}
