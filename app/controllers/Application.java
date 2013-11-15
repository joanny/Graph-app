package controllers;

import play.*;
import play.db.jpa.GenericModel.JPAQuery;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	 public static void index(){
		 Graph graph = new Graph();
    	 List<Relations> allNodes =  Relations.findAll();
    	 for (Relations relations : allNodes) {
			 graph.addRoute(relations.start_node, relations.end_node, relations.weight);
    	 }
    	 List<String> val = graph.findRoute("Paris", "Biarritz");
    	 render(val);
    }
}