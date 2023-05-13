package com.selvs.dj.desafiojava.controller;

import com.selvs.dj.desafiojava.model.Projeto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String index() {
        return "index";
    }


    @GetMapping("projeto")
    public String projetos(final HttpServletRequest request, final ModelMap model) {
        model.addAttribute("projeto", new Projeto());
        return "projeto";
    }

}