package auth.example.spring.repositories;

import auth.example.spring.entities.Adresse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository  extends JpaRepository<Adresse, String> {

    Adresse findById(int idAd);

}
