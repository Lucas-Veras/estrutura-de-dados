package grafo;

import java.util.ArrayList;

public class Vertice {
    private Object dado;
    private ArrayList<Aresta> arestasSaida;
    private ArrayList<Aresta> arestasEntrada;

    public Vertice(Object dado) {
        this.dado = dado;
        this.arestasEntrada = new ArrayList<Aresta>();
        this.arestasSaida = new ArrayList<Aresta>();
    }

    public Object getDado() {
        return dado;
    }

    public void setDado(Object dado) {
        this.dado = dado;
    }

    public ArrayList<Aresta> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta> getArestasSaida() {
        return arestasSaida;
    }

    public void addArestaEntrada(Aresta aresta){
        this.arestasEntrada.add(aresta);
    }

    public void addArestaSaida(Aresta aresta){
        this.arestasSaida.add(aresta);
    }

    public void removeArestaEntrada(Aresta aresta) {
        arestasEntrada.remove(aresta);
    }

    public void removeArestaSaida(Aresta aresta) {
        arestasSaida.remove(aresta);
    }


}
