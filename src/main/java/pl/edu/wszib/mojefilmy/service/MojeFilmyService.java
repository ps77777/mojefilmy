package pl.edu.wszib.mojefilmy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.mojefilmy.dao.BazaFilmowDao;
import pl.edu.wszib.mojefilmy.dao.MojeFilmyDao;
import pl.edu.wszib.mojefilmy.domain.MojeFilmy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MojeFilmyService {
    @Autowired
    private MojeFilmyDao mojeFilmyDao;

     private MojeFilmy mojeFilmy;

    public List<MojeFilmy> getMojeFilmy(String login) {
        List<MojeFilmy> pelnaListFilmow = new ArrayList<>();
        mojeFilmyDao.findAll().forEach(pelnaListFilmow::add);

        List<MojeFilmy> listaMoichFilmow = new ArrayList<>();
        for (MojeFilmy x: pelnaListFilmow) {
            if (x.getLogin().equals(login)){
                listaMoichFilmow.add(x);
            }
        }
        return listaMoichFilmow;
    }

}
