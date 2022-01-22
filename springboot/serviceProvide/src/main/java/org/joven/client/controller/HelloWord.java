package org.joven.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client1")
public class HelloWord {
    @RequestMapping(value = "/hello")
    public String hello() {
        return "this is ClientApplication1 ,hi!";
    }

    @RequestMapping(value = "/hello2")
    public String hello2(String name) {
        return "this is ClientApplication1 ,hi!" + name;
    }
}
