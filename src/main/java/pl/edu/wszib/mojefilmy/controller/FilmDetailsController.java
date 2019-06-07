package pl.edu.wszib.mojefilmy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.mojefilmy.domain.BazaFilmow;
import pl.edu.wszib.mojefilmy.service.BazaFilmowService;

@Controller
public class FilmDetailsController {

    @Autowired
    private BazaFilmowService bazaFilmowService;

    @GetMapping("/film/{tytul}")
    public String getPojedynczyFilmKontroler(@RequestParam(name = "tytul") String nazwa, Model model) {
        BazaFilmow film = bazaFilmowService.getPojedynczyFilm(nazwa);
        model.addAttribute("film", film);
//        model.addAttribute("headerPojedynczyKraj", headerPojedynczyKraj);
        return "pojedynczyfilm";
    }
}
