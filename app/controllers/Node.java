package controllers;

import java.util.List;

public class Node implements INode{
	private List<IRelation> relations;
	private String node_name;
	
	private int total_weight;
	private INode previous;

	public Node(String node_name) {
		super();
		this.node_name = node_name;
	}
	
	public Node(List<IRelation> relations, String node_name) {
		super();
		this.relations = relations;
		this.node_name = node_name;
	}
	 
	@Override
	public List<IRelation> getRelations() {
		return relations;
		
	}
	@Override
	public String toString() {
		return "Node [relations=" + relations + "]";
	}
	
	@Override
	public String getNode_name() {
		return node_name ;
	}

	@Override
	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}

	@Override
	public void setRelations(List<IRelation> relations) {
		this.relations = relations;
	}

	@Override
	public int getTotal_weight() {
		return total_weight;
	}

	@Override
	public void setTotal_weight(int total_weight) {
		this.total_weight = total_weight;
	}

	@Override
	public INode getPrevious() {
		return previous;
	}

	@Override
	public void setPrevious(INode previous) {
		this.previous = previous;
	}

}
