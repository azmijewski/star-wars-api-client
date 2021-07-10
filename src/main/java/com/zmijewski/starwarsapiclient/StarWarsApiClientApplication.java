package com.zmijewski.starwarsapiclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StarWarsApiClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarWarsApiClientApplication.class, args);
    }

}
