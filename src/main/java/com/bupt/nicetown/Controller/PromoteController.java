package com.bupt.nicetown.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promote")
public class PromoteController {

    @RequestMapping("/create")
    public String create() {
        return "You're creating a Promotion.";
    }
}