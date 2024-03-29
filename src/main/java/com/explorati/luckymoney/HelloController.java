package com.explorati.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("/say")
//    @RequestMapping("say")
    public String say(@RequestParam(value="id", required = false, defaultValue = "0") Integer id){
//        return "说明: " + limitConfig.getDescription();
        return "id: " + id;
    }
}
