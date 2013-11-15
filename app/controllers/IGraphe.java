package controllers;

import java.util.List;

public interface IGraphe {
	public void addRoute(String n1	, String n2, int weigth);
	public List<String>  findRoute(String start, String end);	
}