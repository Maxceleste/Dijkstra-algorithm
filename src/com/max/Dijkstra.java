package src.com.max;

public class Dijkstra {
    Graph grafo = new Graph(4);

    Child[] childInicio = {new Child("A", 6), new Child("B", 2)};
    Child[] childA = {new Child("fim", 1)};
    Child[] childB = {new Child("fim", 5), new Child("A", 3)};
    Child[] childFim = {};
    
    public void runDijkstra(){
    grafo.addNode("inicio", childInicio);
    grafo.addNode("A", childA);
    grafo.addNode("B", childB);
    grafo.addNode("fim", childFim);

    grafo.graphVisualiser();
    }
}
