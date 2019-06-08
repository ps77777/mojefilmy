package pl.edu.wszib.mojefilmy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.mojefilmy.domain.MojeFilmy;
import pl.edu.wszib.mojefilmy.domain.Users;
import pl.edu.wszib.mojefilmy.logowanie.FormularzRejestracji;
import pl.edu.wszib.mojefilmy.service.MojeFilmyService;
import pl.edu.wszib.mojefilmy.service.UsersDaoService;

import java.util.List;

@Controller
public class RejestracjaController {
    @Value("${app.header.mojefilmy}")
    private String header;

    @Autowired
   private UsersDaoService usersDaoService;
    @Autowired
    MojeFilmyService mojeFilmyService;

//    @RequestMapping(value = "/rejestracja",method = RequestMethod.POST)
//    public String zweryfikujIdodajUsera (@ModelAttribute(name="formularzRejestracji") FormularzRejestracji formularzRejestracji, Model model) {
//        String loginName = formularzRejestracji.getLoginName();
//        String password= formularzRejestracji.getPassword();
//        if (loginName.isEmpty() || password.isEmpty()){
//            model.addAttribute("wypelnijPola", true);
//            return "login";
//        };
//        Users nowyUser = new Users(loginName, password);
//
//        if (!usersDaoService.czyKontoJuzIstnieje(loginName)) {
//            usersDaoService.zachowajNowyUser(nowyUser);
//
//                model.addAttribute("loginName", loginName);
//                model.addAttribute("header", header);
//            return "mojefilmy";
//        }else {
//            model.addAttribute("userIstnieje", true);
//            return "login";
//        }
//    }
}
