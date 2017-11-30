package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
    public String login(){
        return "index";
    }
	
	@RequestMapping("/")
    public String index(){
        return "redirect:/mahasiswa";
    }
}
