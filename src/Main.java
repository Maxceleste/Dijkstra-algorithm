package src;

import src.com.max.*;

public class Main{

    public static void main(String[] args){

        Graph grafo = new Graph(4);

        Children childInicio = new Children(new String[]{"A", "B"}, new double[]{6.0, 2.0});
        Children childA = new Children(new String[]{"fim"}, new double[]{1.0});
        Children childB = new Children(new String[]{"fim", "A"}, new double[]{5.0, 3.0});
        Children childFim = null;

        grafo.addNode("inicio", childInicio);
        grafo.addNode("A", childA);
        grafo.addNode("B", childB);
        grafo.addNode("fim", childFim);
        
        grafo.graphVisualiser();
    }
    
}