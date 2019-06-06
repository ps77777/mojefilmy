package pl.edu.wszib.mojefilmy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.mojefilmy.dao.BazaFilmowDao;
import pl.edu.wszib.mojefilmy.domain.BazaFilmow;
import pl.edu.wszib.mojefilmy.domain.MojeFilmy;

import java.util.ArrayList;
import java.util.List;

@Service
public class BazaFilmowService {
    @Autowired
    private BazaFilmowDao bazaFilmowDao;

    public List<BazaFilmow> getWszystkieFilmy() {
        List<BazaFilmow> listaWszystkichFilmow = new ArrayList<>();

        bazaFilmowDao.findAll().forEach(listaWszystkichFilmow::add);
        return listaWszystkichFilmow;
    }
}
