package br.com.marlonprado.ynab_clone_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    @GetMapping
    public String helloWorld(){
        return "Hello Account!";
    }
    
}
