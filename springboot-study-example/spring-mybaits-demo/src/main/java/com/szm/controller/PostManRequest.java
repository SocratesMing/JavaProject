package com.szm.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/szm")
public class PostManRequest {

    @RequestMapping("/request/{name}")
    public String getRequest(@PathVariable(value = "name") String name) {
        System.out.println(name);
        return "ok";

    }
}
