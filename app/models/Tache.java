package models;

import play.db.jpa.Model;
import javax.persistence.Entity;

@Entity
public class Tache extends Model {
	public String contenue;
    public boolean valider = false;

    public Tache(String contenue) {
        this.contenue = contenue;
    }
}
