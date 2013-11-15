package models;

import javax.persistence.Entity;

import play.db.jpa.Model;


@Entity
public class Relations extends Model {
	
	public String start_node;
	public String end_node;
	public int weight;
	
	 
	
}
