package auth.example.spring.services;

import auth.example.spring.entities.Adresse;


import java.util.List;

public interface AdresseDetailsService {

    public List<Adresse> getAll();
    public Adresse findById(int idAd);
    public Adresse save(Adresse adresse);
    public void deleteAdresse(int idAd);
    public Adresse updateAdresse(int idAd, Adresse adresse);





}
