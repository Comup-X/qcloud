package com.czy.qcloud.face;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
@Lazy
public class QcloudFaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QcloudFaceApplication.class, args);
	}
}
