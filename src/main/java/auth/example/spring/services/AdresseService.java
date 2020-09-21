package auth.example.spring.services;


import auth.example.spring.entities.Adresse;
import auth.example.spring.entities.ToDo;
import auth.example.spring.repositories.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseService implements AdresseDetailsService {

    private final AdresseRepository adresseRepository;


    @Autowired
    public AdresseService(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;

    }

    // get all
    @Override
    public List<Adresse> getAll() {
        return adresseRepository.findAll();
    }

    // get by id
    @Override
    public Adresse findById(int idA) {
        return adresseRepository.findById(idA);

    }

    // post ==> create new todo
    @Override
    public Adresse save(Adresse adresse) {
        return adresseRepository.save(adresse);
    }


    // delete a todo by id
    @Override
    public void deleteAdresse(int idA) {
        Adresse adresse = adresseRepository.findById(idA);
        adresseRepository.delete(adresse);
    }


    // put ==> update todo by  id
    @Override
    public Adresse updateAdresse(int idA, Adresse adresse) {
        Adresse updateAdresse = adresseRepository.findById(idA);
        updateAdresse.setAdresse(adresse.getAdresse());
        updateAdresse.setC_poste(adresse.getC_poste());
        updateAdresse.setPays(adresse.getPays());
        updateAdresse.setVille(adresse.getVille());
        // save in database
        return adresseRepository.save(updateAdresse);
    }

}


