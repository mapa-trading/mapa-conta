package io.github.mapatrading.conta.controller;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@SpringBootApplication
public class HelloController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Get() {
        return "Hello World";
    }

}
