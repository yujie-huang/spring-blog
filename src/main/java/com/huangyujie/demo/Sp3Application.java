package com.huangyujie.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;



@SpringBootApplication
@ServletComponentScan
public class Sp3Application {

	public static void main(String[] args) {
		SpringApplication.run(Sp3Application.class, args);
	}

}
