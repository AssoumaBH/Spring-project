package auth.example.spring.controllers;

import auth.example.spring.entities.Adresse;

import auth.example.spring.services.AdresseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController("/adresse")
public class AdresseController {

    @Autowired
    private AdresseService adresseService;

    @GetMapping("/")
    public List<Adresse> listAdresse(){
        return adresseService.getAll();
    }

    @GetMapping( "/{idA}")
    public Adresse getOne(@PathVariable(value = "idA") int idA){
        return adresseService.findById(idA);
    }


    @PostMapping("/")
    public ResponseEntity<Adresse> createAdresse(@RequestBody Adresse adresse ){
        try {
            Adresse createAdresse = adresseService.save(adresse);
            return new ResponseEntity<Adresse>(createAdresse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    ////
    @PutMapping("/{id}")
    public ResponseEntity<Adresse> updateAdresse(@PathVariable("idA") int idA, @RequestBody Adresse adresse) {
        Adresse updateAdresse= adresseService.updateAdresse(idA, adresse);
        return new ResponseEntity<>(updateAdresse, HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAdresse(@PathVariable("idA") int idA) {
        System.out.println(idA);
        adresseService.deleteAdresse(idA);
        return new ResponseEntity<>(HttpStatus.OK); //"student has been deleted successfully";
    }




}
