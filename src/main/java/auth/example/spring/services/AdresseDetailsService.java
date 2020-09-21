package auth.example.spring.services;

import auth.example.spring.entities.Adresse;


import java.util.List;

public interface AdresseDetailsService {

    public List<Adresse> getAll();
    public Adresse findById(int idA);
    public Adresse save(Adresse adresse);
    public void deleteAdresse(int idA);
    public Adresse updateAdresse(int idA, Adresse adresse);





}
