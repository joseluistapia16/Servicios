/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.netbeans.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
//@RequestMapping("/api/v2")
@RequestMapping("/")
public class ApiController {
    //@GetMapping
    @RequestMapping(value = "saludo",method = RequestMethod.GET)
    public String saludo() {
        return "Netbeans";
    }

}
