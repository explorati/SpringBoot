package com.explorati.luckymoney;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//        @RequestMapping(value="/hello", method= RequestMethod.GET)
    @GetMapping("/hello")
    public String say(){
        return "learning SpringBoot!";
    }
}
