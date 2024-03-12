# Projeto de Grafos com Algoritmo de Dijkstra

Este é um projeto pessoal que implementa uma estrutura de grafo simplificada e o algoritmo de Dijkstra em Java.

## Estrutura do Projeto

- `src/com/max/`: Pacote contendo as classes relacionadas ao grafo e ao algoritmo de Dijkstra.
  - `Graph.java`: Implementação de uma estrutura de grafo ponderado.
  - `Children.java`: Representação da lista de filhos de um nó no grafo.
  - `Dijkstra.java`: Implementação do algoritmo de Dijkstra para encontrar o caminho mais curto em um grafo ponderado.

## Como Usar

### 1. Configuração do Ambiente

Certifique-se de ter o Java instalado em sua máquina. Caso contrário, você pode baixá-lo [aqui](https://www.oracle.com/java/technologies/javase-downloads.html).

### 2. Executando o Projeto

Compile e execute o código Java. Exemplo de uso do algoritmo de Dijkstra:

```java
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

        Dijkstra d = new Dijkstra();
        d.runDijkstra(grafo, "piano");
```
O código acima está no arquivo main.java dentro da pasta `src`, teste sua funcionalidade! O grafo de exemplo foi retirado do livro "Entendendo Algoritmos".

Output:
```
Shorter path: livro - lp raro - bateria - piano
Final cost: 35.0

```

### 3. Estrutura do Grafo

A classe Graph representa um grafo ponderado. Você pode adicionar nós usando addNode e especificar seus filhos por meio da classe Children. O método graphVisualiser fornece uma visualização simples do grafo.
### 4. Algoritmo de Dijkstra

A classe Dijkstra implementa o algoritmo de Dijkstra. Use o método runDijkstra para encontrar o caminho mais curto em seu grafo.
### Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir problemas ou enviar pull requests.
### Licença

Este projeto é licenciado sob a MIT License.
