package com.cosmos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @RequestMapping("/answerFallback")
    public String departmentFallbackMethod(){
        return "Answer Service taking too long to respond. Please try again later..";
    }
    @RequestMapping("/questionFallback")
    public String employeeFallbackMethod(){
        return "Question Service taking too long to respond. Please try again later..";
    }
}
