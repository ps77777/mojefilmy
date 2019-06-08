package pl.edu.wszib.mojefilmy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.mojefilmy.dao.UsersDao;
import pl.edu.wszib.mojefilmy.domain.Users;
import pl.edu.wszib.mojefilmy.logowanie.FormularzRejestracji;

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

    public boolean czyKontoJuzIstnieje(String loginName){
        if (usersDao.existsById(loginName)){
            return true;
        }
        else{
            return false;
        }
    }

    public void zachowajNowyUser(Users nowyUser){
            usersDao.save(nowyUser);
    }



}
