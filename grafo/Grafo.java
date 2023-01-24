package grafo;

import java.util.ArrayList;

public class Grafo {

	private ArrayList<Aresta> arestas;
    private ArrayList<Vertice> vertices;

    public Grafo() {
    	this.arestas = new ArrayList<Aresta>();
        this.vertices = new ArrayList<Vertice>();
    }
    
    public Vertice getVertice(Object dado) {
    	Vertice vertice = null;
    	for(int i = 0; i < this.vertices.size(); i++) {
    		if (this.vertices.get(i).getDado() == dado) {
    			return this.vertices.get(i);
    		}
    	}
    	return vertice;
    }

    public Vertice addVertice(Object dado) {
        Vertice newVertice = new Vertice(dado);
        this.vertices.add(newVertice);
        return newVertice;
    }

    public Aresta addArestaNaoDirigida(Object dado1, Object dado2, Object peso) {
    	Vertice v1 = this.getVertice(dado1);
    	Vertice v2 = this.getVertice(dado2);
    	if (v1 == null || v2 == null) {
    		throw new GrafoException("Algum dos vertices não existe!");
    	}
        Aresta newAresta = new Aresta(peso, v1, v2, false);
        v1.addArestaSaida(newAresta);
        v2.addArestaEntrada(newAresta);
        this.arestas.add(newAresta);
        return newAresta;
    }

    public Aresta addArestaDirigida(Object dadoInicio, Object dadoFim, Object peso) {
    	Vertice inicio = this.getVertice(dadoInicio);
    	Vertice fim = this.getVertice(dadoFim);
    	if (inicio == null || fim == null) {
    		throw new GrafoException("Algum dos vertices não existe!");
    	}
        Aresta newAresta = new Aresta(peso, inicio, fim, true);
        inicio.addArestaSaida(newAresta);
        fim.addArestaEntrada(newAresta);
        this.arestas.add(newAresta);
        return newAresta;
    }
    
    public Object removeVertice(Vertice vertice) {
        Object dado = vertice.getDado();
        Vertice verticeOposto;
        
        for (Aresta aresta: vertice.getArestasEntrada()) {
            verticeOposto = aresta.getInicio();
            verticeOposto.removeArestaSaida(aresta);
            this.arestas.remove(aresta);
        }

        for (Aresta aresta: vertice.getArestasSaida()) {
             verticeOposto = aresta.getFim();
             verticeOposto.removeArestaEntrada(aresta);
             this.arestas.remove(aresta);
        }

        this.vertices.remove(vertice);
        return dado;
    }

    public Object removeAresta(Aresta aresta) {
        Object peso = aresta.getPeso();

        Vertice inicio = aresta.getInicio();
        inicio.removeArestaSaida(aresta);
        Vertice fim = aresta.getFim();
        fim.removeArestaEntrada(aresta);
        this.arestas.remove(aresta);
        
        return peso;
    }
    
    public ArrayList<Aresta> arestasIncidentes(Vertice vertice) {
        ArrayList<Aresta> todasArestas = new ArrayList<>(vertice.getArestasSaida());
        todasArestas.addAll(vertice.getArestasEntrada());
        return todasArestas;
    }
    
    public ArrayList<Vertice> vertices() { 
    	return vertices;
    }

    public ArrayList<Aresta> arestas(){
        return arestas;
    }
    
    public boolean isDirigida(Aresta aresta) {
        return aresta.isDirigida();
    }

    public ArrayList<Vertice> finalVertices(Aresta aresta) {
        ArrayList<Vertice> vertices = new ArrayList<>();
        vertices.add(aresta.getInicio());
        vertices.add(aresta.getFim());
        return vertices;
    }

    public Vertice oposto(Vertice vertice, Aresta aresta) {
        if (vertice != aresta.getFim() && vertice != aresta.getInicio()) {
            throw new GrafoException("O Vertice com "+ vertice.getDado() + " não existe nessa aresta!");
        }
        Vertice aux = aresta.getInicio();
        if (aux == vertice) {
            aux = aresta.getFim();
        }
        return aux;
    }

    public boolean isAdjacente(Vertice v1, Vertice v2) {
        for (Aresta aresta: v1.getArestasSaida()) {
            if (aresta.getFim() == v2) {
                return true;
            }
        }
        for (Aresta aresta: v1.getArestasEntrada()) {
            if (aresta.getInicio() == v2) {
                return true;
            }
        }
        return false;
    }

    public void substituirDadoVertice(Vertice vertice, Object dado) {
        vertice.setDado(dado);
    }

    public void substituirPesoAresta(Aresta aresta, Object peso) {
        aresta.setPeso(peso);
    }
    
    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }

    public void matrizIncidenciaNaoDirigida(){
        ArrayList<Vertice> auxVertices = vertices();
        ArrayList<Aresta> auxArestas = arestas();
        System.out.println("--- Matriz não dirigida ---");
        for (Aresta aresta: auxArestas) {
            System.out.print("   " + aresta.getPeso());
        }
        System.out.println();
        for (Vertice verticeLinha: auxVertices) {
            System.out.print(verticeLinha.getDado() + "  ");
            ArrayList<Aresta> arestasIncidentes = arestasIncidentes(verticeLinha);
            for (Aresta aresta: auxArestas) {
                if (arestasIncidentes.contains(aresta)) {
                    System.out.print("1    ");
                } 
                else {
                    System.out.print("0    ");
                }
            }
            System.out.println();
        }
    }

    public void matrizIncidenciaDirigida(){
        ArrayList<Vertice> auxVertices = vertices();
        ArrayList<Aresta> auxArestas = arestas();
        System.out.println("--- Matriz dirigida ---");
        for (Aresta aresta: auxArestas) {
            System.out.print("    " + aresta.getPeso());
        }
        System.out.println();
        for (Vertice verticeLinha: auxVertices) {
            System.out.print(verticeLinha.getDado() + "  ");
            ArrayList<Aresta> arestasIncidentes = arestasIncidentes(verticeLinha);
            for (Aresta aresta: auxArestas) {
                if (arestasIncidentes.contains(aresta)) {
                    if (aresta.getInicio() == verticeLinha) {
                        System.out.print("-1    ");
                    } 
                    else {
                        System.out.print("+1    ");
                    }
                } else {
                    System.out.print(" 0    ");
                }
            }
            System.out.println();
        }
    }
}
