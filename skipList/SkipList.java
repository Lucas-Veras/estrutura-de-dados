package skipList;

import java.util.ArrayList;
import java.util.Random;

public class SkipList {
	private QuadNode inicio;
    private QuadNode fim;
    private int altura;
    private int qtdElementos;
    
    private final Object menosInfinito = Integer.MIN_VALUE;
    private final Object maisInfinito = Integer.MAX_VALUE;
    
    public SkipList() {
    	this.inicio = new QuadNode(menosInfinito);
        this.fim = new QuadNode(maisInfinito);
        inicio.setNext(fim);
        fim.setPrev(inicio);
        this.altura = 0;
    }
    
    public void insert(Object key) {
    	QuadNode nodeAbaixo = null;
    	QuadNode nodeMaisProximo = buscaPosicaoProx(key);
    	int level = funcRandom();
    	for (int i = 0; i <= level; i++) {
    		QuadNode proximo = nodeMaisProximo.getNext();
    		QuadNode novoNode = new QuadNode(key);
    		nodeMaisProximo.setNext(novoNode);
    		proximo.setPrev(novoNode);
    		novoNode.setPrev(nodeMaisProximo);
    		novoNode.setNext(proximo);
    		if(nodeAbaixo != null) {
    			nodeAbaixo.setUp(novoNode);
    			novoNode.setDown(nodeAbaixo);
    		}
    		while (nodeMaisProximo.getUp() == null) {
    			nodeMaisProximo = nodeMaisProximo.getPrev();
	        }
	        nodeMaisProximo = nodeMaisProximo.getUp();
	
	        while ((int) key >= (int) nodeMaisProximo.getNext().getKey()) {
	        	nodeMaisProximo = nodeMaisProximo.getNext();
	        }
    		nodeAbaixo = novoNode;
    	}
    	qtdElementos++;
    }
    
    public Object remove(Object key) {
    	QuadNode aux = buscaPosicaoProx(key);
    	if(aux.getKey() != key) {
    		return null;
    	}
    	do {
    		aux.getNext().setPrev(aux.getPrev());
    		aux.getPrev().setNext(aux.getNext());
    		aux = aux.getUp();
    	} while(aux != null);
    	qtdElementos--;
    	return key;
    }    
    
    public Object busca(Object key) {
    	QuadNode elemento = inicio;
        while (elemento.getDown() != null){
            elemento = elemento.getDown();
            while ((int) key >= (int) elemento.getNext().getKey()){
                if(key == elemento.getKey()){
                    return elemento.getKey();
                }
                elemento = elemento.getNext();
            }
        }
        if (elemento.getKey() == key){
            return elemento.getKey();
        }
        return null;
    }
    
    private QuadNode buscaPosicaoProx(Object key){ 
        QuadNode noInicial = inicio;
        while (noInicial.getDown() != null){
        	noInicial = noInicial.getDown();
            while ((int)noInicial.getNext().getKey() <= (int)key){
            	noInicial = noInicial.getNext();
            }
        }
        return noInicial;
    }
    
    private void newLevel(int level){
        if (level >= altura){
            QuadNode novoInicio = new QuadNode(menosInfinito);
            QuadNode novoFim = new QuadNode(maisInfinito);

            novoInicio.setNext(novoFim);
            novoInicio.setDown(inicio);
            inicio.setUp(novoInicio);
            novoFim.setPrev(novoInicio);
            novoFim.setDown(fim);
            fim.setUp(novoFim);

            inicio = novoInicio;
            fim = novoFim;
            altura++;
        }
    }
    
    private int funcRandom(){
        Random random = new Random();
        int level = -1;
        do {
            level++;
            newLevel(level);
        } while (random.nextInt(2) == 0);
        return level;
    }
    
    public int size() {
    	return qtdElementos;
    }
    
    public boolean isEmpty() {
    	return qtdElementos == 0;
    }
    
    public void printSkipList(){
        ArrayList<Object> arrayPrint = new ArrayList<>();
        ArrayList<Object> arrayAuxPrint = new ArrayList<>();
        
        QuadNode aux = inicio;
        while (aux.getDown() != null){
            aux = aux.getDown();
        }
        while (aux != null){
            arrayPrint.add(aux.getKey());
            aux = aux.getNext();
        }        
        QuadNode auxInicio = inicio;
        QuadNode auxH = auxInicio;
        int nivel = altura;
        System.out.println("SkipList:");
        while(auxInicio != null){
            System.out.print("Nvl " + nivel + " --> ");
            arrayAuxPrint.clear();
            while (auxH != null) {
                arrayAuxPrint.add(auxH.getKey());
                auxH = auxH.getNext();
            }
            int x = 0;
            for (int i = 0; i < arrayAuxPrint.size(); i++) {
                for (int k = x; k < arrayPrint.size(); k++){
                    if (arrayPrint.get(k) == arrayAuxPrint.get(i)){
                    	if(arrayAuxPrint.get(i) == maisInfinito){
                    		System.out.print(" (+)");
                    	}
                    	else if (arrayAuxPrint.get(i) == menosInfinito){
                            System.out.print("(-) ");
                        }
                        else {
                            System.out.print("| " + arrayPrint.get(k) + " |");
                        }
                        k = arrayPrint.size();
                        x++;
                    }
                    else if(arrayPrint.get(k) != arrayAuxPrint.get(i)){
                        System.out.print("      ");
                        x++;
                    }
                }
            }
            nivel--;
            auxInicio = auxInicio.getDown();
            auxH = auxInicio;
            System.out.println();
        }
        System.out.println("Altura: " + altura);
        System.out.println("Size: " + size());
        System.out.println("Vazio: " + isEmpty());
        System.out.println();
    }
}
