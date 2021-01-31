/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mega.JunitSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
public class HelloWordController {
    
    
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
    
}
