package src.com.max;

import java.util.HashMap;

public class Dijkstra {

    private double infinity = 1.0 / 0.0;
   
    static void runDijkstra(Graph graph){

        final int COST_SIZE = graph.getLength() - 1;
        
        HashMap<String, Float> cost = new HashMap<String, Float>(COST_SIZE); // Cost table
        
        for (int i = 1; i < COST_SIZE + 1; i++){
            //cost.put(graph.getNodesNames()[i], graph.getChilds()[])
        }
    }
}
