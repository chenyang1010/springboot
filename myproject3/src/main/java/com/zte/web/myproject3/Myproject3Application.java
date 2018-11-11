package com.zte.web.myproject3;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Myproject3Application {

	public static void main(String[] args) {
		SpringApplication.run(Myproject3Application.class, args);
	}
}
