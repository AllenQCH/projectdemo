package com.cctv.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Test1Controller {

    @PostMapping(value = "/queryUws")
    public String queryUws(){
        return "HELLO WORLD!";
    }

}
