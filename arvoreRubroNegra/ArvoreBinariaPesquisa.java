package arvoreRubroNegra;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinariaPesquisa {
	protected Node root;
	protected List<Node> nos = new ArrayList<Node>();

	public ArvoreBinariaPesquisa() {
		super();
	}
	
	public void insert(Object elemento) throws NodeException {
		if(isEmpty()){
			root = new Node(elemento);
		} else {
			Node aux = find(elemento, root);
			Node novoNode = new Node(elemento);
			if ((int) elemento == (int) aux.getElemento()) {
				throw new NodeException("Elemento " + elemento + " já existe!");
			}
			else if((int) elemento > (int) aux.getElemento()) {
				if (hasRight(aux)){
	                aux.getFilhoDireita().setPai(novoNode);
	                if ((int) aux.getFilhoDireita().getElemento() > (int) elemento){
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
	                if ((int) aux.getFilhoEsquerda().getElemento() <= (int) elemento){
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
		}
	}
	
	public void remove(Object elemento) throws NodeException {
		Node aux = find(elemento, root);
		if(elemento != aux.getElemento()) {
			throw new NodeException("Chave " + elemento + " não existe!");
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
				aux.getPai().setFilhoDireita(aux.getFilhoDireita());
				aux.getFilhoDireita().setPai(aux.getPai());
			}
			else {
				aux.getPai().setFilhoEsquerda(aux.getFilhoDireita());
				aux.getFilhoDireita().setPai(aux.getPai());
			}
		}
		else {
			Node minimo = aux;
			minimo = minimo.getFilhoDireita();
			while(minimo.getFilhoEsquerda() != null) {
				minimo = minimo.getFilhoEsquerda();
			}
			
			remove(minimo.getElemento());
			aux.setElemento(minimo.getElemento());
		}
	}
	
	public Node find(Object elemento, Node no) {
		if(isExternal(no)) {
			return no;
		}
		if((int) elemento < (int) no.getElemento()) {
			if (hasLeft(no)) {
				return find(elemento, no.getFilhoEsquerda());
			}
			return no;
		}
		else if(elemento == no.getElemento()) {
			return no;
		}
		else if((int) elemento > (int) no.getElemento()) {
			if(hasRight(no)) {
				return find(elemento, no.getFilhoDireita());				
			}
			return no;
		}
		return no;
	}
	
	public int size() {
		return sizeNode(root);
	}
	
	public int sizeNode(Node no) {
		int size = 0;
		if(no.getFilhoEsquerda() != null) {
			size = size + sizeNode(no.getFilhoEsquerda());
		}
		if(no.getFilhoDireita() != null) {
			size = size + sizeNode(no.getFilhoDireita());
		}
		return size + 1;
	}
	
	
	public int height() {
		return heightNode(root);
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
	
	public boolean isEmpty() {
		return root() == null;
	}

	public Node root() {
		return root;
	}

	public boolean isRoot(Node no) {
		return no == root();
	}

	public Node parent(Node no) {
		return no.getPai();
	}

	public boolean isInternal(Node no) {
		return no.getFilhoDireita() != null || no.getFilhoEsquerda() != null;
	}

	public boolean isExternal(Node no) {
		return no.getFilhoDireita() == null && no.getFilhoEsquerda() == null;
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
	
	public Node leftChild(Node no) throws NodeException {
		if(hasLeft(no)) {
			return no.getFilhoEsquerda();
		} else {
			throw new NodeException("Não há filho na esquerda!");
		}
	}
	
	public Node rightChild(Node no) throws NodeException {
		if(hasRight(no)) {
			return no.getFilhoDireita();
		} else {
			throw new NodeException("Não há filho na direita");
		}
	}
	
	public boolean hasLeft(Node no) {
		return no.getFilhoEsquerda() != null;
	}
	
	public boolean hasRight(Node no) {
		return no.getFilhoDireita() != null;
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
	
	public void mostraArvore() {
		organizador(root);
		System.out.println("ARVORE BINARIA DE PESQUISA:");
		for(int j = 0; j <= height(); j++) {
			for(int i = 0; i < size(); i++) {
				if(depth(nos.get(i)) == j) {
					System.out.print("\t" + nos.get(i).getElemento());
				} else {
					System.out.print("\t");
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
