package src.com.max;

import java.util.ArrayList;

/**
 * Simplified version of an Weighted graph.
 */
public class Graph {

    private String[] nodeNames;
    private ArrayList<Children> graphChildren = new ArrayList<>();

    private int nodeCount;

    /** 
    * @param nodeCount Total of nodes in this Graph. 
    */
    public Graph(int nodeCount){
        nodeNames = new String[nodeCount];
    }

    /**
     * Add a node to the Graph, and the Children of this node. If this node doesn't have a child, is an empty array.
     * Always consider that the first node added is the beginning of the graph.
     * @param nodeName Name of this node
     * @param children Array of Child to represent the edges.
     */
    public void addNode(String nodeName, Children children){
        nodeNames[nodeCount++] = nodeName;
        graphChildren.add(children);
    }

    public String[] getNodesNames(){
        return nodeNames;
    }

    public Children[] getChildrenArray(){
        return graphChildren.toArray(new Children[0]);
    }

    public int getLength(){
        return nodeNames.length;
    }


    public Children getChildren(String node){
        int index = 0;

        for (String name : nodeNames){
            if (name == node) break;
            index++;
        }

        if (index + 1 > nodeNames.length) throw new IllegalArgumentException("This node name doesn't exist.");

        return graphChildren.get(index);
    }
    public Children getChildren(int index){
        return graphChildren.get(index);
    }


    /**
     * Show the visual form of the graph.
     */
    public void graphVisualiser(){
        System.out.println("*****************");
        System.out.println("Graph Visualizer:");

        for (int i = 0; i < nodeNames.length; i++){
            System.out.println("Node: " + nodeNames[i]);

            boolean childExist = graphChildren.get(i) != null;
            
            if (childExist){
                System.out.println("Childs and size:");

                for (int subI = 0; subI < graphChildren.get(i).getSize(); subI++){
                    System.out.println(graphChildren.get(i).getName(subI)+ " = " + graphChildren.get(i).getWeight(subI));
                }
            } else System.out.println("No Childs.");

        }

    }
}