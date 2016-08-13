package com.creditnet.test;

import com.creditnet.test.service.PingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private final static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public PingService pingService() {
        PingService pingService = new PingService();
        pingService.setVersion(Constants.ver);
        return pingService;
    }

    static class Constants {
        final static String ver = "0.0.2";
    }

}
