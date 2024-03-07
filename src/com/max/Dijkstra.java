package src.com.max;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dijkstra {

    private final double INFINITY = 1.0 / 0.0;
    HashMap<String, Double> cost;
    HashMap<String, String> parents;
   
    public void runDijkstra(Graph graph, String lastNode){

        buildCost(graph); // building Cost table
        buildParents(graph); // building Parents table 

        String[] processedNodes = new String[graph.getLength()];
        processedNodes[0] = graph.getNodesNames()[0]; // insert the begining of the graph.
        int processedCount = 1;

        while (processedCount < processedNodes.length){
            String cheapNode = nextNode(processedNodes, graph);
            updateGeneral(graph, cheapNode);
            processedNodes[processedCount++] = cheapNode;
        }

        //System.out.println(shortPath(lastNode));
    }

    private void updateGeneral(Graph graph, String nodeName){

        Double parentCost = 0.0;
        if (cost.containsKey(nodeName)) parentCost = cost.get(nodeName);

        Children children = graph.getChildren(nodeName);
        if (children == null) return;

        for (String childName : children.getNames()){

            Double newCost = children.getWeight(childName) + parentCost;
            Double oldCost = cost.get(childName);

            if (newCost < oldCost){
                cost.replace(childName, newCost);
                parents.replace(childName, nodeName);
            }
        }
    }

    private String nextNode (String[] processedNodes, Graph graph){
        String cheapNode = null;
        List processed = Arrays.asList(processedNodes);

        for (String node : graph.getNodesNames()){

            boolean isCheaper = cheapNode == null || cost.get(cheapNode) > cost.get(node);
            boolean notProcessed = !processed.contains(node);

            if (isCheaper && notProcessed){
                cheapNode = node;
            }
        }
        return cheapNode;
    }

    private void buildCost(Graph graph){

        String[] nodes = graph.getNodesNames();
        Children children = graph.getChildren(nodes[0]);

        cost = new HashMap<>(graph.getLength() - 1);

        for (int i = 1; i < graph.getLength(); i++){
            cost.put(nodes[i], INFINITY);
        }
    
        for (String childName : children.getNames()){

            Double newCost = children.getWeight(childName);
            cost.replace(childName, newCost);

        }
    }

    private void buildParents(Graph graph){

        parents = new HashMap<>(graph.getLength() - 1);
        String[] nodes = graph.getNodesNames();

        for (int i = 1; i < graph.getLength(); i++){
            parents.put(nodes[i], null);
        }
        // Two "for-loops" for legibility
        Children children = graph.getChildren(nodes[0]);

        for (String child : children.getNames()){
            parents.replace(child, nodes[0]);
        }
    }
}
