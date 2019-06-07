package pl.edu.wszib.mojefilmy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.mojefilmy.domain.BazaFilmow;
import pl.edu.wszib.mojefilmy.service.BazaFilmowService;

@Controller
public class FilmDetailsController {
    @Value("${app.header.pojedynczyfilm}")
    private String header;

    @Autowired
    private BazaFilmowService bazaFilmowService;

    @GetMapping("/film/{tytul}")
    public String getPojedynczyFilmKontroler(@PathVariable String tytul, Model model) {
        BazaFilmow film = bazaFilmowService.getPojedynczyFilm(tytul);
        model.addAttribute("film", film);
        model.addAttribute("header", header);
        return "pojedynczyfilm";
    }
}
