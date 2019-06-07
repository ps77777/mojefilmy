package pl.edu.wszib.mojefilmy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.mojefilmy.domain.BazaFilmow;
import pl.edu.wszib.mojefilmy.domain.MojeFilmy;
import pl.edu.wszib.mojefilmy.service.BazaFilmowService;
import pl.edu.wszib.mojefilmy.service.MojeFilmyService;

import java.util.List;

@Controller
public class StrongGlownaController {
    @Value("${app.header.index}")
    private String header;

    @Autowired
    private BazaFilmowService bazaFilmowService;

    @GetMapping("/home")
    public String getWszystkieFilmy (Model model) {
        List<BazaFilmow> listaWszystkichFilmow =
                bazaFilmowService.getWszystkieFilmy();

        model.addAttribute("listaWszystkichFilmow", listaWszystkichFilmow);
        model.addAttribute("header", header);
        return "index";
    }
}

