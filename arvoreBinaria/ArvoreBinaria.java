package arvoreBinaria;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria {
	
	protected Node raiz;
	private List<Node> nos = new ArrayList<Node>();

	public ArvoreBinaria() {

	}

	public void insert (int o, Node no) {
		if(no == null) {
			System.out.print(" " + o);
			raiz = new Node(o);
		} 
		else if (o < (int) no.getElemento()){
			if (no.getFilhoEsquerda() ==  null) {
				System.out.print(" " + o);
				Node aux = new Node(o);
				aux.setPai(no);
				no.setFilhoEsquerda(aux);
			} 
			else {
				insert(o, no.getFilhoEsquerda());
			}
		} 
		else if (o > (int) no.getElemento()){
			if (no.getFilhoDireita() ==  null) {
				System.out.print(" " + o);
				Node aux = new Node(o);
				aux.setPai(no);
				no.setFilhoDireita(aux);
			} 
			else {
				insert(o, no.getFilhoDireita());
			}
		}	
	}
	
	public int height() {
		return heightNode(raiz);
	}

	public int heightNode(Node no) {
		if(no == null || isExternal(no)) {
			return 0;
		} else {
			int h = 0;
			if(heightNode(no.getFilhoDireita()) >= heightNode(no.getFilhoEsquerda())) {
				h = h + heightNode(no.getFilhoDireita());
			} else {
				h = h + heightNode(no.getFilhoEsquerda());
			}
		return 1 + h;
		}
	}

	public int depth(Node no) {
		if(isRoot(no)) {
			return 0;
		} else {
			return 1 + depth(parent(no));
		}
	}

	public Object replace(Node no, Object o) {
		Object aux = no.getElemento();
		no.setElemento(o);
		return aux;
	}
	
	public boolean isInternal(Node no) {
		return no.getFilhoDireita() != null || no.getFilhoEsquerda() != null;
	}

	public boolean isExternal(Node no) {
		return no.getFilhoDireita() == null && no.getFilhoEsquerda() == null;

	}
	
	public Node root() {
		return raiz;
	}

	public boolean isRoot(Node no) {
		return no == raiz;
	}
	
	public Node parent(Node no) {
		return no.getPai();
	}
	
	public Node leftChild(Node no) throws ArvoreException {
		if(hasLeft(no)) {
			return no.getFilhoEsquerda();
		} else {
			throw new ArvoreException("Não há filho na esquerda!");
		}
	}
	
	public Node rightChild(Node no) throws ArvoreException {
		if(hasRight(no)) {
			return no.getFilhoDireita();
		} else {
			throw new ArvoreException("Não há filho na direita");
		}
	}
	
	public boolean hasLeft(Node no) {
		return no.getFilhoEsquerda() != null;
	}
	
	public boolean hasRight(Node no) {
		return no.getFilhoDireita() != null;
	}
	
	public boolean isLeftChild(Node no) {
		if (isRoot(no)) {
			return false;
		} 
		else if (no == no.getPai().getFilhoEsquerda()){
			return true;
		} 
		else {
			return false;
		}
	}
	
	public boolean isRightChild(Node no) {
		if (isRoot(no)) {
			return false;
		} 
		else if (no == no.getPai().getFilhoDireita()){
			return true;
		} 
		else {
			return false;
		}
	}
	
	public int size() {
		return sizeNode(raiz);
	}
	
	public int sizeNode(Node no) {
		int aux = 0;
		if(no.getFilhoEsquerda() != null) {
			aux = aux + sizeNode(no.getFilhoEsquerda());
		}
		if(no.getFilhoDireita() != null) {
			aux = aux + sizeNode(no.getFilhoDireita());
		}
		return aux+1;
	}
	
	public boolean isEmpty() {
		return raiz == null;
	}
	
	public void preOrder(Node no) {
		System.out.print(" " + no.getElemento() );
		if(no.getFilhoEsquerda() != null) {
			preOrder(no.getFilhoEsquerda());
		}
		if(no.getFilhoDireita() != null) {
			preOrder(no.getFilhoDireita());
		}
	}
	
	public void inOrder(Node no) {
		if(no.getFilhoEsquerda() != null) {
			inOrder(no.getFilhoEsquerda());
		}
		System.out.print(" " + no.getElemento() );
		if(no.getFilhoDireita() != null) {
			inOrder(no.getFilhoDireita());
		}
	}
	
	public void posOrder(Node no) {
		if(no.getFilhoEsquerda() != null) {
			posOrder(no.getFilhoEsquerda());
		}
		if(no.getFilhoDireita() != null) {
			posOrder(no.getFilhoDireita());
		}
		System.out.print(" " + no.getElemento() );

	}
	
	public void printHeap() throws ArvoreException {
		if(isEmpty()) {
			throw new ArvoreException("Heap vazio!");
		}
		organizador(raiz);
		System.out.println("HeapNode (Fila de Prioridade):");
		for(int j = 0; j <= height(); j++) {
			for(int i = 0; i < size(); i++) {
				if(depth(nos.get(i)) == j) {
					System.out.print("(" + nos.get(i).getElemento() + ")");
				} else {
					System.out.print("( " + ")");
				}	
			}
		System.out.println();
		}
	nos.clear();
	}
	
	public void organizador(Node no) {
		if(no.getFilhoEsquerda() != null) {
			organizador(no.getFilhoEsquerda());
		}
		nos.add(no);
		if(no.getFilhoDireita() != null) {
			organizador(no.getFilhoDireita());
		}
	}
	
}

