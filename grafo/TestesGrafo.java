package grafo;

import java.util.ArrayList;

public class TestesGrafo {

    public static void main(String[] args) {
        Grafo grafoNaoDirigido = new Grafo();

        grafoNaoDirigido.addVertice("V1");
        grafoNaoDirigido.addVertice("V2");
        Vertice v3aoDirigido =grafoNaoDirigido.addVertice("V3");
        grafoNaoDirigido.addVertice("V4");

        grafoNaoDirigido.addArestaNaoDirigida("V1", "V3", "A1");
        grafoNaoDirigido.addArestaNaoDirigida("V1", "V4", "A4");
        grafoNaoDirigido.addArestaNaoDirigida("V3", "V4", "A2");
        grafoNaoDirigido.addArestaNaoDirigida("V2", "V4", "A3");
 
        grafoNaoDirigido.matrizIncidenciaNaoDirigida();
        
        grafoNaoDirigido.removeVertice(v3aoDirigido);
        System.out.println("V3foi removido!");
        grafoNaoDirigido.matrizIncidenciaNaoDirigida();
        
        System.out.println("Todos os vertices do grafo:");
        ArrayList<Vertice> todosVertices1 = grafoNaoDirigido.vertices();
        for (Vertice dado: todosVertices1) {
            System.out.println(dado.getDado());
        }

        System.out.println("\nTodas as arestas do grafo: ");
        ArrayList<Aresta> todasArestas1 = grafoNaoDirigido.arestas();
        for (Aresta aresta: todasArestas1) {
            System.out.println(aresta.getPeso());
        }

        ArrayList<Aresta> todasArestasDoVertice1 = grafoNaoDirigido.arestasIncidentes(grafoNaoDirigido.getVertice("V1"));
        System.out.println("\nTodas as arestas do vertice: "+ grafoNaoDirigido.getVertice("V1").getDado());
        for (Aresta aresta: todasArestasDoVertice1) {
            System.out.println(aresta.getPeso());
        }
        todasArestasDoVertice1 = grafoNaoDirigido.arestasIncidentes(grafoNaoDirigido.getVertice("V2"));
        System.out.println("\nTodas as arestas do vertice: "+ grafoNaoDirigido.getVertice("V2").getDado());
        for (Aresta aresta: todasArestasDoVertice1) {
            System.out.println(aresta.getPeso());
        }

        System.out.println("-------------------------------------");
        
        Grafo grafo = new Grafo();
        grafo.addVertice("V1");
        Vertice v2 = grafo.addVertice("V2");
        grafo.addVertice("V3");
        grafo.addVertice("V4");

        grafo.addArestaDirigida("V2", "V1", "A1");
        grafo.addArestaDirigida("V1", "V3", "A2");
        grafo.addArestaDirigida("V4", "V3", "A3");
        grafo.addArestaDirigida("V4", "V2", "A4");
        
        grafo.matrizIncidenciaDirigida();
        
        grafo.removeVertice(v2);
        System.out.println("V2 foi removido!");
        grafo.matrizIncidenciaDirigida();

        System.out.println("Todos os vertices do grafo:");
        ArrayList<Vertice> todosVertices2 = grafo.vertices();
        for (Vertice aresta: todosVertices2) {
            System.out.println(aresta.getDado());
        }

        System.out.println("\nTodas as arestas do grafo: ");
        ArrayList<Aresta> todasArestas2 = grafo.arestas();
        for (Aresta aresta: todasArestas2) {
            System.out.println(aresta.getPeso());
        }

        ArrayList<Aresta> arestasSaida2 = grafo.getVertice("V1").getArestasSaida();
        System.out.println("\nTodas as arestas de saída de: " + grafo.getVertice("V1").getDado());
        for (Aresta aresta: arestasSaida2) {
            System.out.println(aresta.getPeso());
        }

        ArrayList<Aresta> arestasEntrada2 = grafo.getVertice("V1").getArestasEntrada();
        System.out.println("\nTodas as arestas de entrada de: " + grafo.getVertice("V1").getDado());
        for (Aresta aresta: arestasEntrada2) {
            System.out.println(aresta.getPeso());
        }

        ArrayList<Aresta> todasArestasDoVertice2 = grafo.arestasIncidentes(grafo.getVertice("V1"));
        System.out.println("\nTodas as arestas do vertice: "+ grafo.getVertice("V1").getDado());
        for (Aresta aresta: todasArestasDoVertice2) {
            System.out.println(aresta.getPeso());
        }
    }

}
