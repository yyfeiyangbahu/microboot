package cn.mldn.microboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@EnableAutoConfiguration
//@ComponentScan("cn.mldn.microboot")//定义一个扫描路径
@SpringBootApplication //启动SpringBoot程序，自动子包扫描，代表上面两个注解
@EnableTransactionManagement  //启动事物管理
//@ImportResource(locations={"classpath:spring-common.xml"})
public class StartSpringBootMain {
	public static void main(String[] args) {
		SpringApplication.run(StartSpringBootMain.class, args);
	}
}

