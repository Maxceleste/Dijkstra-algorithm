package src.com.max;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Dijkstra Algorithm for the Graph class. Use the method runDijkstra to find the short path.
 */
public class Dijkstra {

    private final double INFINITY = 1.0 / 0.0;
    private HashMap<String, Double> cost;
    private HashMap<String, String> parents;

    /**
     * Run Dijkstra algorithm and show in the console the result
     * @param graph The graph to find the shorter path
     * @param lastNode The destination to find the shorter path
     */
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

        printResult(lastNode);
    }

    /**
     * 
     * @param graph 
     * @param nodeName Node to look and update the cost and parents of the children
     */
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

    /**
     * Return the next node to look in the loop of the algorithm. The next node will be the cheaper and not precessed node
     * @param processedNodes array of processed nodes
     * @param graph 
     * @return The next node to process
     */
    private String nextNode (String[] processedNodes, Graph graph){
        String cheapNode = null;

        for (String node : graph.getNodesNames()){

            boolean isCheaper = cheapNode == null || cost.get(cheapNode) > cost.get(node);
            boolean notProcessed = !Arrays.asList(processedNodes).contains(node);

            if (isCheaper && notProcessed){
                cheapNode = node;
            }
        }
        return cheapNode;
    }
    /**
     * Initializing the cost HashMap.
     * @param graph
     */
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

    /**
     * Initializing the parents HashMap.
     * @param graph
     */
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

    /**
     * Show the final results of the algorithm.
     * @param lastNode The last node of the path.
     */
    private void printResult(String lastNode){

        String last = lastNode;
        String path = last;
        boolean notTheFirstNode = parents.containsKey(last);
        
        while (notTheFirstNode){
            String parent = parents.get(last);
            path = parent + " - " + path;
            last = parent;
            notTheFirstNode = parents.containsKey(last);
        }

        System.out.println("Shorter path: " + path);
        System.out.println("Final cost: " + cost.get(lastNode));
    }
}