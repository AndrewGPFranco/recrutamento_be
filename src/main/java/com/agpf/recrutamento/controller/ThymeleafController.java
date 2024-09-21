package com.agpf.recrutamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class ThymeleafController {
    
    @GetMapping
    public String index(Model model) {
        String nome = "Andrew";
        model.addAttribute("nome", nome);
        return "animes/list";
    }
}
