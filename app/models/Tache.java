package models;

import play.db.jpa.Model;
import javax.persistence.Entity;

@Entity
public class Tache extends Model {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;*/

	public String contenue;
}
