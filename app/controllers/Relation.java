package controllers;


public class Relation implements IRelation{

	private INode startNode;
	private INode endNode;
	private int weight;
	
	
	
	public Relation(INode startNode, INode endNode, int weight) {
		super();
		this.startNode = startNode;
		this.endNode = endNode;
		this.weight = weight;
	}

	public Relation() {
		super();
	}

	@Override
	public INode getStartNode() {
		return this.startNode;
	}

	@Override
	public INode getEndNode() {
		 return this.endNode;
	}

	@Override
	public int getWeight() {
		 return this.weight;
	}

}
