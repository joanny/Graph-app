package controllers;

import java.util.List;

public interface INode {
	
	public List<IRelation> getRelations();
	
	public String getNode_name();

	public void setNode_name(String node_name);

	public void setRelations(List<IRelation> relations);

	public int getTotal_weight();

	public void setTotal_weight(int total_weight);

	public INode getPrevious();

	public void setPrevious(INode previous);

}
