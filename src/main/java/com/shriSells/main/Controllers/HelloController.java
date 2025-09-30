package com.shriSells.main.Controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello World";
    }

    @GetMapping("/secure/hello")
    @SecurityRequirement(name = "bearerAuth")
    public String securehello(Authentication authentication) {
        return "hello World" + authentication.getName() + "!";
    }

}