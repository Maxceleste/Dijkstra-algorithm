package src.com.max;

public class Dijkstra {
    Graphs grafo = new Graphs(4);

    Object[][] childInicio = {{"A", (Integer)6},{"B", (Integer)2}};
    Object[][] childA = {{"fim", (Integer)1}};
    Object[][] childB = {{"A", (Integer)3},{"fim", (Integer)5}};
    Object[][] childFim = {};

    public void runDijkstra(){
    grafo.addNode("início", childInicio);
    grafo.addNode("A", childA);
    grafo.addNode("B", childB);
    grafo.addNode("fim", childFim);

    grafo.graphVisualiser();
    }
}
