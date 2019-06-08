package pl.edu.wszib.mojefilmy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.mojefilmy.dao.BazaFilmowDao;
import pl.edu.wszib.mojefilmy.domain.BazaFilmow;
import pl.edu.wszib.mojefilmy.service.BazaFilmowService;


@Controller
public class FilmDetailsController {
    @Value("${app.header.pojedynczyfilm}")
    private String header;

    @Autowired
    private BazaFilmowService bazaFilmowService;
    @Autowired
    private BazaFilmowDao bazaFilmowDao;


    @GetMapping("/film/{tytul}")
    public String getPojedynczyFilmKontroler(@PathVariable String tytul, Model model) {
        if (bazaFilmowDao.existsById(tytul)) {
            BazaFilmow film = bazaFilmowService.getPojedynczyFilm(tytul);
            model.addAttribute("film", film);
            model.addAttribute("header", header);
            return "pojedynczyfilm";
        } else {
            return "brakFilmu";
        }

    }
}
