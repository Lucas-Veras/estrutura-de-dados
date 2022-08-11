package arvoreBinaria;

public class heap extends ArvoreBinaria {
	
	private Node ultimo;
	
	public heap() {
		super();
	}
	
	public void insert(Object elemento) {
		if(isEmpty()) {
			raiz = new Node(elemento);
			ultimo = raiz;
		} else {
			Node novoNode = atualizarUltimo();
			novoNode.setElemento(elemento);
			upheap(novoNode);
		}
	}
	
	public Object removeMin() throws ArvoreException {
		if(isEmpty()) {
			throw new ArvoreException("Arvore heap vazia!");
		}
		if(size() == 1) {
			Object aux = raiz.getElemento();
			raiz = null;
			return aux;
		} else {
			Object aux = raiz.getElemento();
			raiz.setElemento(ultimo.getElemento());
			atualizarUltimoRemove();
			downheap(raiz);
			return aux;
		}
	}
	
	public Node atualizarUltimoRemove(){
		Node aux = ultimo;
		if(isRightChild(aux)) {
			ultimo.getPai().setFilhoDireita(null);
			ultimo = ultimo.getPai().getFilhoEsquerda();
			return ultimo;
		} else {
			if(isRoot(ultimo.getPai())) {
				ultimo = raiz;
				raiz.setFilhoEsquerda(null);
				return ultimo;
			} else {
				aux = aux.getPai();
				aux.setFilhoEsquerda(null);
				while(isRightChild(aux) == false) {
					if(isRoot(aux)) {
						ultimo = aux.getFilhoDireita();
						return ultimo;
					} else {
						aux = aux.getPai();
					}
				}
				aux = aux.getPai().getFilhoEsquerda();
				while(aux.getFilhoDireita() != null) {
					aux = aux.getFilhoDireita();
				}
				ultimo = aux;
				return ultimo;
			}
		}
	}
	
	public Node atualizarUltimo() {
		Node aux = ultimo;
		while( aux != raiz && isLeftChild(aux) == false) {
			aux = aux.getPai();
		}
		if(isRoot(aux)) {
			while(aux.getFilhoEsquerda() != null) {
				aux = aux.getFilhoEsquerda();
			}
			Node novoUltimo = new Node();
			novoUltimo.setPai(aux);
			aux.setFilhoEsquerda(novoUltimo);
			ultimo = novoUltimo;
			return ultimo;
		} else {
			aux = aux.getPai();
			if(aux.getFilhoDireita() == null) {
				Node novoUltimo = new Node();
				novoUltimo.setPai(aux);
				aux.setFilhoDireita(novoUltimo);
				ultimo = novoUltimo;
				return ultimo;
			} else {
				aux = aux.getFilhoDireita();
				while(aux.getFilhoEsquerda() != null) {
					aux = aux.getFilhoEsquerda();
				}
				Node novo_ultimo = new Node();
				novo_ultimo.setPai(aux);
				aux.setFilhoEsquerda(novo_ultimo);
				ultimo = novo_ultimo;
				return ultimo;
			}	
		}
	}
	
	public Object min() {
		return raiz.getElemento();
	}
	
	public void upheap(Node no) {
		if(isRoot(no) == false) {
			while((int)no.getElemento() < (int)no.getPai().getElemento()) {
				Object aux = no.getElemento();
				no.setElemento(no.getPai().getElemento());
				no.getPai().setElemento(aux);
				upheap(no.getPai());
			}
		}
		
	}
	
	public void downheap(Node no) {
		if(isInternal(no)) {
			if(hasRight(no)) {
				if((int)no.getElemento() > (int)no.getFilhoDireita().getElemento() || (int)no.getElemento() > (int)no.getFilhoEsquerda().getElemento() ) {
					if((int)no.getFilhoDireita().getElemento() >= (int)no.getFilhoEsquerda().getElemento()) {
						Object aux = no.getElemento();
						no.setElemento(no.getFilhoEsquerda().getElemento());
						no.getFilhoEsquerda().setElemento(aux);
						downheap(no.getFilhoEsquerda());
					} else {
						Object aux = no.getElemento();
						no.setElemento(no.getFilhoDireita().getElemento());
						no.getFilhoDireita().setElemento(aux);
						downheap(no.getFilhoDireita());
					}
				}
			} else if ((int)no.getElemento() > (int)no.getFilhoEsquerda().getElemento()) {
				Object aux = no.getElemento();
				no.setElemento(no.getFilhoEsquerda().getElemento());
				no.getFilhoEsquerda().setElemento(aux);
				downheap(no.getFilhoEsquerda());
			} else {
				downheap(no.getFilhoEsquerda());
			}
		}
	}
}
	

