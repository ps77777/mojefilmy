package pl.edu.wszib.mojefilmy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.mojefilmy.controller.logowanie.FormularzLogowania;
import pl.edu.wszib.mojefilmy.domain.BazaFilmow;
import pl.edu.wszib.mojefilmy.domain.MojeFilmy;
import pl.edu.wszib.mojefilmy.domain.Users;
import pl.edu.wszib.mojefilmy.service.BazaFilmowService;
import pl.edu.wszib.mojefilmy.service.MojeFilmyService;
import pl.edu.wszib.mojefilmy.service.UsersDaoService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MojeFilmyController {
    @Value("${app.header.mojefilmy}")
    private String header;

    @Autowired
    private MojeFilmyService mojeFilmyService;
    @Autowired
    private UsersDaoService usersDaoService;

    @GetMapping("/login")
    public String getStronaLogowania(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String pobierzKatalogUsera (@ModelAttribute(name="formularzLogowania") FormularzLogowania formularzLogowania, Model model) {
        String username = formularzLogowania.getUsername();
        String password= formularzLogowania.getPassword();

        if (usersDaoService.weryfikacja(username, password)) {

            List<MojeFilmy> listaMoichFilmowKontroler = mojeFilmyService.getMojeFilmy(username);
            model.addAttribute("listaMoichFilmowKontroler", listaMoichFilmowKontroler);
            model.addAttribute("header", header);
            return "mojefilmy";

        }else {

            model.addAttribute("bledneDane", true);
            return "login";

        }

    }
}
