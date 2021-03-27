package controllers;

import com.google.gson.Gson;
import models.Tache;
import play.mvc.Controller;

import java.io.InputStreamReader;
import java.util.List;

public class ServiceWeb extends Controller {

    // Ajoute une tâche en base de données (CREATE => POST)
    // Test (curl) : curl --data "nomTache=task-from-curl" localhost:9000/api/tache
    public static void ajouterTache() {
        String contenue = params.get("nomTache");
        //System.out.println("TEST " + contenue);
        Tache tache = new Tache(contenue);
        tache.save();
        renderJSON(tache);
    }

    // Retourne au format JSON la liste des tâches (READ => GET)
    // Test (curl) : curl localhost:9000/api/taches.json
    public static void listTache() {
        List<Tache> taches = Tache.findAll();
        renderJSON(taches);
    }

    // Retourne au format JSON une tâche (READ => GET)
    // Test (curl) : curl localhost:9000/api/tache/1.json
    public static void getTache(Long id) {
        Tache tache = Tache.findById(id);
        renderJSON(tache);
    }

    // Modifie le titre d'une tâche (UPDATE => PUT)
    // Test (curl) : curl -X PUT --data "title=aaabbb" localhost:9000/api/tache/1
    public static void editTitleTache(Long id, String title) {
        Tache tache = Tache.findById(id);
        if(tache != null) {
            tache.contenue = title;
            tache.save();
        }
        renderJSON(tache);
    }

    // Change le statut d'une tâche (UPDATE => PUT)
    // Test (curl) : curl -X PUT localhost:9000/api/tache/1/change-statut
    public static void changeStatutTache(Long id) {
        Tache tache = Tache.findById(id);
        if(tache != null) {
            tache.valider = !tache.valider;
            tache.save();
        }
        renderJSON(tache);
    }

    // Supprime une tâche (DELETE => DELETE)
    // Test (curl) : curl -X DELETE localhost:9000/api/tache/1
    public static void supprimeTache(Long id) {
        Tache tache = Tache.findById(id);
        if(tache != null) {
            tache.delete();
        }
        renderJSON(tache);
    }
    
}
