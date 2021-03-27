package controllers;

import play.mvc.Controller;
import models.Tache;
import java.util.List;

public class Application extends Controller {

    // Affiche toutes les tâches (voir variable taches) dans le template views/listTache.htm
    public static void listTache() {
        List<Tache> taches = Tache.findAll();
		render(taches);
    }

    // Affiche le template views/ajouterTacheForm.html (formulaire d'ajout d'une tâche)
    public static void ajouterTacheForm() {
        render();
    }

    // Ajoute une nouvelle tâche en base de données et affiche le template views/ajouterTache.html
    public static void ajouterTache(String title) {
        Tache tache = new Tache(title);
        tache.save();
        render();
    }

    // Change le statut d'une tâche en base de données
    public static void validerTache() {
        long id = params.get("id", Long.class);
        Tache tache = Tache.findById(id);
        tache.valider = true;
        tache.save();
    }

    // Supprime une tâche en base de données
    public static void supprimerTache(Long id) {
        Tache tache = Tache.findById(id);
        if(tache != null) {
            tache.delete();
        }
        renderJSON(tache);
    }

    // Modifie une tâche en base de données
    public static void editTache(Long id, String title) {
        Tache tache = Tache.findById(id);
        if(tache != null) {
            tache.contenue = title;
            tache.save();
        }
        renderJSON(tache);
    }

}