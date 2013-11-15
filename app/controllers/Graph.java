package controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import antlr.HTMLCodeGenerator;

import play.utils.HTML;
import play.utils.HTML.HtmlCharacterEntityReferences;

public class Graph implements IGraphe{
	private Map<String,INode> lesNoeuds;
	public List<String> nodesString;
	public Graph() {
		super();
		this.lesNoeuds = new HashMap<>();
		this.nodesString = new ArrayList<String>();
	}

	@Override
	public void addRoute(String n1, String n2, int weigth) {
		INode node1 = null;
		INode node2 = null;
		
		if ( lesNoeuds.get(n1) == null) {
			List<IRelation> r = new ArrayList<>();
			node1 = new Node(r,n1);
			lesNoeuds.put(n1, node1);
		}
		else {
			node1 = lesNoeuds.get(n1);
		}
		
		if ( lesNoeuds.get(n2) == null) {			 
			List<IRelation> r = new ArrayList<>();
			node2 = new Node(r,n2);
			lesNoeuds.put(n2, node2);
		}
		else {
			node2 = lesNoeuds.get(n2);
		}
		
		lesNoeuds.get(n1).getRelations().add(new Relation(node1, node2, weigth));
		lesNoeuds.get(n2).getRelations().add(new Relation(node2, node1, weigth));
	       
	}
	
	
	public void printroute(){
		for (Entry<String,INode> entry : lesNoeuds.entrySet()){
			List<IRelation> relation = entry.getValue().getRelations();
			for (int i=0;i < relation.size(); i++){
			// System.out.println(entry.getKey() + relation.get(i).getStartNode().toString());
			}
			
		}
	}

	

	@Override
	public List<String> findRoute(String start, String end) {
			
		initialize();
		
		INode node_start = lesNoeuds.get(start);
		INode node_end = lesNoeuds.get(end);
		node_start.setTotal_weight(0);
		INode node_min = lesNoeuds.get(minimum_positive(lesNoeuds));
		
		if (node_min == null)
			return null ;
		
		while(node_min != null && node_min != node_end && !lesNoeuds.isEmpty()) {
			lesNoeuds.remove(node_min.getNode_name());
			
			for(IRelation path : node_min.getRelations()){
				INode path_end = path.getEndNode();
				if (path_end.getTotal_weight() < 0
						|| path_end.getTotal_weight() > node_min.getTotal_weight() + path.getWeight()) {
					path_end.setTotal_weight(node_min.getTotal_weight() + path.getWeight());
					path_end.setPrevious(node_min);
					lesNoeuds.put(path_end.getNode_name(), path_end);
				}
			}
			node_min = lesNoeuds.get(minimum_positive(lesNoeuds));
		}
		
		if (node_min.getNode_name().equals(node_end.getNode_name())){
			return this.nodesString;
		}
		return null;
		 	 
	}
	
	private void initialize(){
		for (Map.Entry<String, INode> entry : lesNoeuds.entrySet()) {
			((Node) entry.getValue()).setTotal_weight(-1);
			((Node) entry.getValue()).setPrevious(null);
		}
	}
	
	private String minimum_positive(Map<String,INode> list_noeuds) {
		String res = null;
		int min_weight=-1;
		for (Map.Entry<String, INode> entry : lesNoeuds.entrySet()) {
			int entry_weight = entry.getValue().getTotal_weight();
			if (entry_weight > -1 && (min_weight == -1 || entry_weight < min_weight)){
				res = entry.getValue().getNode_name();
				this.nodesString.add(res);
				min_weight = entry_weight;
			}
		}
		return res;
	}
	
	private String create_path(INode end){
		String val;
		if (end != null){
			val= create_path( end.getPrevious()) + "   |   "  + end.getNode_name();
			nodesString(val);
			return val;
			
		}
		else{
			 val =  "Chemin:";
			 nodesString(val);
			 return val ;
		}
	}
	public void nodesString(String name){
		 this.nodesString.add(name);
	}

}
