package controllers;

import play.*;
import play.data.validation.Required;
import play.db.jpa.GenericModel.JPAQuery;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	   
			
	 public static void index(){
		 
		   Graph graph = new Graph();  
		 List<Nodes> lesNodes = Nodes.findAll();	
		  render(lesNodes);
    }
	 
	 public static void search(@Required String start,@Required String end){
		 
		  	Graph graph = new Graph();  
			List<Nodes> lesNodes = Nodes.findAll();	
			 
	    	List<Relations> allNodes =  Relations.findAll();
	    	for (Relations relations : allNodes) {
				 graph.addRoute(relations.start_node, relations.end_node, relations.weight);
	    	}    	 
	    	List<String> val = graph.findRoute(start, end);
	    	render(lesNodes,val); 
		 
	 }
}