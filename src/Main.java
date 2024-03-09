package src;

import src.com.max.*;

public class Main{

    public static void main(String[] args){

        Graph grafo = new Graph(6);

        Children childLivro = new Children(new String[]{"poster", "lp raro"},
                                            new double[]{0.0, 5.0});
        Children childPoster = new Children(new String[]{"bateria", "baixo"},
                                            new double[]{35.0, 30.0});
        Children childLpRaro = new Children(new String[]{"bateria", "baixo"},
                                            new double[]{20.0, 15.0});
        Children childBateria = new Children(new String[]{"piano"},
                                            new double[]{10.0});
        Children childBaixo = new Children(new String[]{"piano"},
                                            new double[]{20.0});


        grafo.addNode("livro", childLivro);
        grafo.addNode("poster", childPoster);
        grafo.addNode("lp raro", childLpRaro);
        grafo.addNode("bateria", childBateria);
        grafo.addNode("baixo", childBaixo);
        grafo.addNode("piano", null);

        
        //grafo.graphVisualiser();

        Dijkstra d = new Dijkstra();

        d.runDijkstra(grafo, "piano");
    }
    
}