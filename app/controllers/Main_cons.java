package controllers;
 


  
public class Main_cons {

	/**
	 * @param args
	*/
	public static void main(String[] args) {
		Graph graph = new Graph();
		 
		//Node.all();
		 
		 graph.addRoute("Paris", "Mulhouse", 200);
		 graph.addRoute("Paris", "Nantes", 50);
		 graph.addRoute("Nantes", "Bordeaux", 10);
		 graph.addRoute("Mulhouse", "Bordeaux", 10);
		 graph.addRoute("Bordeaux", "Biarritz", 200);
		 graph.addRoute("Mulhouse", "Biarritz", 2);
		 
		 graph.findRoute("Paris", "Biarritz");
	//	 System.out.println("fini");
	}

}
