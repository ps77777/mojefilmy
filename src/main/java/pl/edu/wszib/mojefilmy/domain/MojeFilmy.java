package pl.edu.wszib.mojefilmy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MojeFilmy {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String pk;
    private String login;
    private String tytul;
    private String ocena;

    public MojeFilmy(){};

    public MojeFilmy(String login, String tytul, String ocena) {
        this.login = login;
        this.tytul = tytul;
        this.ocena = ocena;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getOcena() {
        return ocena;
    }

    public void setOcena(String ocena) {
        this.ocena = ocena;
    }
}
