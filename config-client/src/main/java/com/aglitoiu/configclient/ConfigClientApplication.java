package com.aglitoiu.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	@RefreshScope
	@RestController
	class MessageRestController {

		@Value("${name:notloaded}")
		private String name;

		@RequestMapping("/message")
		String getMessage() {
			return this.name;
		}
	}

}
