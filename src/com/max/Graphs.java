package src.com.max;

import java.util.ArrayList;

public class Graphs {

    String[] nodeList;
    int nodeCount;
    ArrayList<Object[][]> fullGraph = new ArrayList<>();

    public Graphs(int nodeCount){
        nodeList = new String[nodeCount];
    }

    public void addNode(String nodeName, Object[][] childs){
        nodeList[nodeCount] = nodeName;
        fullGraph.add(childs);
        nodeCount++;
    }

    public void graphVisualiser(){
        System.out.println("*****************");
        System.out.println("Graph Visualizer:");

        for (int i = 0; i < nodeList.length; i++){
            System.out.println("Node: " + nodeList[i]);

            boolean childExist = fullGraph.get(i).length > 0;
            
            if (childExist){
                System.out.println("Childs and size:");

                for (int subI = 0; subI < fullGraph.get(i).length; subI++){
                    System.out.println((String)fullGraph.get(i)[subI][0] + " = " + (fullGraph.get(i)[subI][1]).toString());
                }
            } else System.out.println("No Childs.");

        }

    }
}
