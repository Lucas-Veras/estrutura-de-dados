package arvoreBinariaPesquisa;

import java.util.ArrayList;

public class ArvoreBinariaPesquisa {
	private Node raiz;
	private int tamanho;
	
	
	public ArvoreBinariaPesquisa(Object elemento) {
		raiz = new Node(elemento);
		tamanho = 1;
	}
	
	public Node find(Object k, Node v) {
		if(isExternal(v)) {
			return v;
		}
		if((int) k < (int) v.getElemento()) {
			if (hasLeft(v)) {
				return find(k, v.getFilhoEsquerda());
			}
			return v;
		}
		else if(k == v.getElemento()) {
			return v;
		}
		else if((int) k > (int) v.getElemento()) {
			if(hasRight(v)) {
				return find(k, v.getFilhoDireita());				
			}
			return v;
		}
		return v;
	}
	
	public void insert(Object k) {
		Node aux = find(k, raiz);
		Node novoNode = new Node(k);
		if((int) k > (int) aux.getElemento()) {
			if (hasRight(aux)){
                aux.getFilhoDireita().setPai(novoNode);
                if ((int) aux.getFilhoDireita().getElemento() > (int) k){
                    novoNode.setFilhoDireita(aux.getFilhoDireita());
                }
                else {
                    novoNode.setFilhoEsquerda(aux.getFilhoDireita());
                }
            }
            else {
                novoNode.setPai(aux);
            }
            aux.setFilhoDireita(novoNode);
		}
		else {
			if (hasLeft(aux)){
                aux.getFilhoEsquerda().setPai(novoNode);
                if ((int) aux.getFilhoEsquerda().getElemento() <= (int) k){
                    novoNode.setFilhoEsquerda(aux.getFilhoEsquerda());
                }
                else {
                    novoNode.setFilhoDireita(aux.getFilhoEsquerda());
                }
            }
            else {
                novoNode.setPai(aux);
            }
            aux.setFilhoEsquerda(novoNode);
		}
		tamanho++;
	}
	
	public void remove(Object k) throws InvalidNoException {
		Node aux = find(k, raiz);
		if(k != aux.getElemento()) {
			throw new InvalidNoException("Chave " + k + " não existe!");
		}
		if(isExternal(aux)) {
			if(aux.getPai().getFilhoEsquerda() == aux) {
				aux.getPai().setFilhoEsquerda(null);
			}
			else {
				aux.getPai().setFilhoDireita(null);
			}
		}
		else if(aux.getFilhoDireita() == null) {
			if(aux.getPai().getFilhoDireita() == aux) {
				aux.getPai().setFilhoDireita(aux.getFilhoEsquerda());
				aux.getFilhoEsquerda().setPai(aux.getPai());
			}
			else {
				aux.getPai().setFilhoEsquerda(aux.getFilhoDireita());
				aux.getFilhoDireita().setPai(aux.getPai());
			}
		}
		else if(aux.getFilhoEsquerda() == null) {
			if(aux.getPai().getFilhoDireita() == aux) {
				aux.getPai().setFilhoDireita(aux.getFilhoEsquerda());
				aux.getFilhoEsquerda().setPai(aux.getPai());
			}
			else {
				aux.getPai().setFilhoEsquerda(aux.getFilhoDireita());
				aux.getFilhoDireita().setPai(aux.getPai());
			}
		}
		else {
			Node minimo;
			minimo = aux;
			minimo = minimo.getFilhoDireita();
			while(minimo.getFilhoEsquerda() != null) {
				minimo = minimo.getFilhoEsquerda();
			}
			tamanho++;
			remove(minimo.getElemento());
			aux.setElemento(minimo.getElemento());
		}
		tamanho--;
	}
	
	public Node leftChild(Node no) {
		return no.getFilhoEsquerda();
	}
	
	public Node rightChild(Node no) {
		return no.getFilhoDireita();
	}
	
	public Boolean hasLeft(Node no) {
		return no.getFilhoEsquerda() != null;
	}
	
	public Boolean hasRight(Node no) {
		return no.getFilhoDireita() != null;
	}

	public int size() {
		return tamanho;
	}
	
	public int height(Node no) {
		if(isExternal(no)) {
			return 0;
		}
		else {
			int h1 = 0;
            if (hasLeft(no)){
                h1 = 1 + height(no.getFilhoEsquerda());
            }
            int h2 = 0;
            if (hasRight(no)) {
                h2 = 1 + height(no.getFilhoDireita());
            }
            if(h1 > h2) {
            	return h1;
            }
            return h2;
            
		}
	}
	
	public Boolean isEmpty() {
		return false;
	}
	
	public Node root() {
		return raiz;
	}
	
	public Node parent(Node no) {
		return no.getPai();
	}
		
	public Boolean isInternal(Node no) {
		return no.getFilhoDireita() != null || no.getFilhoEsquerda() != null;
	}
	
	public Boolean isExternal(Node no) {
		return (no.getFilhoDireita() == null && no.getFilhoEsquerda() == null);
	}
	
	public Boolean isRoot(Node no) {
		return no == root();
	}
	
	public int depth(Node no) {
		if(isRoot(no)) {
			return 0;
		}
		else {
			return 1 + depth(parent(no));
		}
	}
	
	public Object replace(Node no, Object o) {
		Object elemento = no.getElemento();
		no.setElemento(o);
		return elemento;
	}
	
	public void preOrder(Node no) {
		if(no != null) {
			System.out.println(" " + no.getElemento());
			if(no.getFilhoDireita() != null) {
				preOrder(no.getFilhoDireita());
			}
			if(no.getFilhoEsquerda() != null) {
				preOrder(no.getFilhoEsquerda());
			}
		}
	}
	
	public void inOrder(Node no) {
		if(no != null) {
			if(no.getFilhoDireita() != null) {
				preOrder(no.getFilhoDireita());
			}
			System.out.println(" " + no.getElemento());
			if(no.getFilhoEsquerda() != null) {
				preOrder(no.getFilhoEsquerda());
			}
		}
	}
	
	public void posOrder(Node no) {
		if(no != null) {
			if(no.getFilhoDireita() != null) {
				preOrder(no.getFilhoDireita());
			}
			if(no.getFilhoEsquerda() != null) {
				preOrder(no.getFilhoEsquerda());
			}
			System.out.println(" " + no.getElemento());
		}
	}

    private void organizador(ArrayList<Object> elementos, Node raiz, int profundidade) {
        if (raiz == null && profundidade > 0){
            for (int i = 0; i < profundidade; i++){
                elementos.add("-");
                elementos.add("-");
            }
        }
        if (raiz == null && profundidade == 0){
            elementos.add("-");
        }
        if (raiz == null) {
            return;
        }
        if (profundidade == 0) {
            elementos.add(raiz.getElemento());
        }
        else if (profundidade > 0) {
            organizador(elementos, raiz.getFilhoEsquerda(), profundidade - 1);
            organizador(elementos, raiz.getFilhoDireita(), profundidade - 1);
        }
    }
    
    public void mostrarArvore() {
        int h = height(raiz);
        double nos = Math.pow(2, 4);
        for (int i = 0; i <= h; i++){
            ArrayList<Object> lista = new ArrayList<>();
            organizador(lista, raiz, i);
            for (int j = 0; j < (nos * 3) / (lista.size() + 1); j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < lista.size(); k++) {
                if (lista.get(k) == "-" && i < h){
                    System.out.print("-");
                }
                else if(lista.get(k) != "-"){
                    System.out.print("(" + lista.get(k) + ")");
                }
                for (int j = 0; j < ((nos * 2)/(lista.size() + 1)) + 1; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
