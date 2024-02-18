package src.com.max;

import java.util.ArrayList;

/**
 * Simplified version of an Weighted graph.
 */
public class Graph {

    private String[] nodeNames;
    private ArrayList<Child[]> graphChildren = new ArrayList<>();

    private int nodeCount;

    /** 
    * @param nodeCount Total of nodes in this Graph. 
    */
    public Graph(int nodeCount){
        nodeNames = new String[nodeCount];
    }

    /**
     * Add a node to the Graph, and the Children of this node. If this node doesn't have a child, is an empty array.
     * @param nodeName Name of this node
     * @param children Array of Child to represent the edges.
     */
    public void addNode(String nodeName, Child[] children){
        nodeNames[nodeCount++] = nodeName;
        graphChildren.add(children);
    }

    public String[] getNodesNames(){
        return nodeNames;
    }

    public ArrayList<Child[]> getChilds(){
        return graphChildren;
    }

    /**
     * Show the visual form of the graph.
     */
    protected void graphVisualiser(){
        System.out.println("*****************");
        System.out.println("Graph Visualizer:");

        for (int i = 0; i < nodeNames.length; i++){
            System.out.println("Node: " + nodeNames[i]);

            boolean childExist = graphChildren.get(i).length > 0;
            
            if (childExist){
                System.out.println("Childs and size:");

                for (int subI = 0; subI < graphChildren.get(i).length; subI++){
                    System.out.println(graphChildren.get(i)[subI].getName() + " = " + graphChildren.get(i)[subI].getWeight());
                }
            } else System.out.println("No Childs.");

        }

    }
}