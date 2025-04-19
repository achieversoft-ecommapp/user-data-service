package com.achieversoft.ecommapp.userdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The type User data application.
 */
@SpringBootApplication
public class UserDataApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		SpringApplication.run(UserDataApplication.class, args);
	}

}
