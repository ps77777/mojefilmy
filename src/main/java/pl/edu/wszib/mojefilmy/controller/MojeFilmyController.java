package pl.edu.wszib.mojefilmy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.mojefilmy.domain.Users;
import pl.edu.wszib.mojefilmy.logowanie.FormularzLogowania;
import pl.edu.wszib.mojefilmy.domain.MojeFilmy;
import pl.edu.wszib.mojefilmy.logowanie.FormularzRejestracji;
import pl.edu.wszib.mojefilmy.service.MojeFilmyService;
import pl.edu.wszib.mojefilmy.service.UsersDaoService;

import java.util.List;

@Controller
public class MojeFilmyController {
    @Value("${app.header.mojefilmy}")
    private String header;

    @Autowired
    private MojeFilmyService mojeFilmyService;
    @Autowired
    private UsersDaoService usersDaoService;
    private String  username;


    @GetMapping("/login")
    public String getStronaLogowania(){
        return "login";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String pobierzKatalogUsera (@ModelAttribute(name="formularzLogowania") FormularzLogowania formularzLogowania, Model model) {
        username = formularzLogowania.getUsername();
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


    @RequestMapping(value = "/rejestracja",method = RequestMethod.POST)
    public String zweryfikujIdodajUsera (@ModelAttribute(name="formularzRejestracji") FormularzRejestracji formularzRejestracji, Model model) {
        String loginName = formularzRejestracji.getLoginName();
        String password= formularzRejestracji.getPassword();
        if (loginName.isEmpty() || password.isEmpty()){
            model.addAttribute("wypelnijPola", true);
            return "login";
        };
        Users nowyUser = new Users(loginName, password);

        if (!usersDaoService.czyKontoJuzIstnieje(loginName)) {
            usersDaoService.zachowajNowyUser(nowyUser);
            username=loginName;
            model.addAttribute("username", username);
            model.addAttribute("header", header);
            return "mojefilmy";
        }else {
            model.addAttribute("userIstnieje", true);
            return "login";
        }
    }

    @RequestMapping(value = "/dodajFilm",method = RequestMethod.POST)
    public String dodajNowyFilm(@ModelAttribute(name="mojeFilmy") MojeFilmy mojeFilmy, Model model){
        String nowyFilm = mojeFilmy.getTytul();
        int nowaOcena= mojeFilmy.getOcena();
            System.out.println(nowyFilm);
            System.out.println(nowaOcena);
            System.out.println(username);

        MojeFilmy mojeFilmy1 = new MojeFilmy(username, nowyFilm, nowaOcena);
        mojeFilmyService.dodajNowyFilm(mojeFilmy1);
            List<MojeFilmy> listaMoichFilmowKontroler = mojeFilmyService.getMojeFilmy(username);
            model.addAttribute("listaMoichFilmowKontroler", listaMoichFilmowKontroler);
            model.addAttribute("header", header);
        return "mojefilmy";
    }
}
