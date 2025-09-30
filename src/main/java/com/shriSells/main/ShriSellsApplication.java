package com.shriSells.main; // Change this to your package name

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShriSellsApplication {

    public static void main(String[] args) {
        System.out.println("Spring boot is running...");
        SpringApplication.run(ShriSellsApplication.class, args);
    }

}