package pl.edu.wszib.mojefilmy.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    private String userID;
    private String password;

    public Users() {};
    public Users(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
