package com.mcours.web.controller;

import com.mcours.dao.CourDao;
import com.mcours.model.Cour;
import com.mcours.web.exceptions.ImpossibleAjouterCommandeException;
import com.mcours.web.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourController {

    @Autowired
    CourDao courDao;

    // Affiche la liste de tous les cours disponibles
    @GetMapping(value = "/Cours")
    public List<Cour> listeDesCours() {

        List<Cour> cours = courDao.findAll();

        if (cours.isEmpty()) throw new ProductNotFoundException("Aucun cour n'est disponible à la vente");

        return cours;

    }

    //Récuperer un cour par son id
    @GetMapping(value = "/Cours/{id}")
    public Optional<Cour> recupererUnCour(@PathVariable int id) {

        Optional<Cour> cour = courDao.findById(id);

        if (!cour.isPresent())
            throw new ProductNotFoundException("Le cour correspondant à l'id " + id + " n'existe pas");

        return cour;
    }

    @PostMapping(value = "/ajoutcours")
    public ResponseEntity<Cour> ajouterCour(@RequestBody Cour cour) {

        Cour nouveauCour = courDao.save(cour);

        if (nouveauCour == null) throw new ImpossibleAjouterCommandeException("Impossible d'ajouter cette commande");

        return new ResponseEntity<Cour>(cour, HttpStatus.CREATED);
    }
}

