package pl.edu.wszib.mojefilmy.logowanie;

public class FormularzRejestracji {
    private String loginName;
    private String password;


    public FormularzRejestracji() {  super();}

    public FormularzRejestracji(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
