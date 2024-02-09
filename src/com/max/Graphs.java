package src.com.max;

import java.util.HashMap;

public class Graphs {
    
    HashMap<String, Object[][]> graph = new HashMap<String, Object[][]>();


    public void addNode(String nodeName, Object[][] childs) throws Exception{
        
        //To-Do: Fazer uma verificação melhor dos childs.
        if (graph.get(nodeName) != null) throw new Exception("Node already exist");
        
        graph.put(nodeName, childs);
    }

    public void graphVisualiser(){
        System.out.println("*****************");
        System.out.println("Graph Visualizer:");

        for (String node : graph.keySet()){
            
            System.out.println("Node name: " + node);
            System.out.println("Childs and size:");

            for (Object[] child : graph.get(node)){
                System.out.println((String)child[0] + " = " + (String)child[1]);
            }

            System.out.println("*****************");
        }
    }

}
