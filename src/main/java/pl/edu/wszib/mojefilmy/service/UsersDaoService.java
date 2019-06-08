package pl.edu.wszib.mojefilmy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.mojefilmy.controller.logowanie.FormularzLogowania;
import pl.edu.wszib.mojefilmy.dao.UsersDao;
import pl.edu.wszib.mojefilmy.domain.Users;

@Service
public class UsersDaoService {
    @Autowired
    private UsersDao usersDao;


    public boolean weryfikacja(String username, String password){


        if (usersDao.existsById(username)
                && usersDao.existsByPassword(password)){
            return true;
        } else return false;
    }
}
