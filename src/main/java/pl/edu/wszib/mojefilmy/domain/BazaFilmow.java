package pl.edu.wszib.mojefilmy.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BazaFilmow {
    @Id
    private String tytul;
    private String typ;
    private String krajProdukcji;
    private Integer rokProdukcji;


    public BazaFilmow(){};
    public BazaFilmow(String tytul, String typ, String krajProdukcji, Integer rokProdukcji) {
        this.tytul = tytul;
        this.typ = typ;
        this.krajProdukcji = krajProdukcji;
        this.rokProdukcji = rokProdukcji;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getKrajProdukcji() {
        return krajProdukcji;
    }

    public void setKrajProdukcji(String krajProdukcji) {
        this.krajProdukcji = krajProdukcji;
    }

    public Integer getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(Integer rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }
}
