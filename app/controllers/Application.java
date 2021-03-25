package controllers;

import play.mvc.Controller;
import models.Tache;
import java.util.List;

public class Application extends Controller {

    // Affiche toutes les tâches (voir variable taches) dans le template views/listTache.html
    @play.db.jpa.Transactional
    public static void listTache() {

        List<Tache> taches = Tache.findAll();
        long nb = Tache.count();
        /*Query query = JPA.em().createQuery("select * from Tache");
        List<Tache> articles = query.getResultList();*/
		render(taches);
    }

    // Affiche le template views/ajouterTacheForm.html (formulaire d'ajout d'une tâche)
    public static void ajouterTacheForm() {
        // A COMPLETER
        // ...
    }

    // Ajoute une nouvelle tâche en base de données et affiche le template views/ajouterTache.html
    public static void ajouterTache() {
        // A COMPLETER
        // ...
    }

    // Change le statut d'une tâche en base de données
    public static void validerTache(Long id) {
    	// A COMPLETER
        // ...   
    }

    // Supprime une tâche en base de données
    public static void supprimerTache(Long id) {
        // A COMPLETER
        // ...
    }

    // Modifie une tâche en base de données
    public static void editTache(Long id, String title) {
        // A COMPLETER
        // ...
    }

}