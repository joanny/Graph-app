package controllers;


public interface IRelation {
	public INode  getStartNode();
	public INode  getEndNode();
	public int  getWeight();
}
