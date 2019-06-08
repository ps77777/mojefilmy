package pl.edu.wszib.mojefilmy.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    private String userID;
    private String password;
}
