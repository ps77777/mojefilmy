package pl.edu.wszib.mojefilmy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.mojefilmy.domain.MojeFilmy;
import pl.edu.wszib.mojefilmy.service.MojeFilmyService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MojeFilmyController {
    @Value("${app.header.mojefilmy}")
    private String header;

    @Autowired
    private MojeFilmyService mojeFilmyService;

    @RequestMapping("/index/{login}")
    public String pobierzKatalogUsera (@PathVariable String login, Model model) {
        List<MojeFilmy > listaMoichFilmowKontroler = mojeFilmyService.getMojeFilmy(login);

        model.addAttribute("listaMoichFilmowKontroler", listaMoichFilmowKontroler);
        model.addAttribute("header", header);
        return "mojefilmy";
    }

}
