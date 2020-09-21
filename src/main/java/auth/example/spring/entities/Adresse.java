package auth.example.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAd;

    private String adresse;
    private int c_poste;
    private String ville;
    private String pays;

    public Adresse() {
    }


    public Adresse(int idAd, String adresse, int c_poste, String ville, String pays) {
        this.idAd = idAd;
        this.adresse = adresse;
        this.c_poste = c_poste;
        this.ville = ville;
        this.pays = pays;
    }


    public int getId() {
        return idAd;
    }
    public void setId(int idAd) {
        this.idAd = idAd;
    }

    public String getVille () {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse () {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public int getC_poste() {
        return c_poste;
    }
    public void setC_poste(int c_poste) {
        this.c_poste = c_poste;
    }
    public String getPays () {
        return pays;
    }
    public void setPays(String pays) {
        this.pays = pays;
    }

}
