package arvoreAVL;

public class ArvoreAVL extends ArvoreBinariaPesquisa {
	public ArvoreAVL() {
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
	            updateFb(novoNode.getPai(), false, 1);
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
	            updateFb(novoNode.getPai(), true, 1);
			}
		}
	}
	
	public void remove(Object elemento) throws NodeException {
		Node aux = find(elemento, root);
		Node nodePai = aux.getPai();
		Boolean IsLeftChild = isLeftChild(aux);
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
			updateFb(nodePai, IsLeftChild, 2);
		}
		else if(aux.getFilhoDireita() == null) {
			if(aux.getPai().getFilhoDireita() == aux) {
				aux.getPai().setFilhoDireita(aux.getFilhoEsquerda());
				aux.getFilhoEsquerda().setPai(aux.getPai());
				updateFb(nodePai, IsLeftChild, 2);
			}
			else {
				aux.getPai().setFilhoEsquerda(aux.getFilhoDireita());
				aux.getFilhoDireita().setPai(aux.getPai());
				updateFb(nodePai, IsLeftChild, 2);
			}
		}
		else if(aux.getFilhoEsquerda() == null) {
			if(aux.getPai().getFilhoDireita() == aux) {
				aux.getPai().setFilhoDireita(aux.getFilhoDireita());
				aux.getFilhoDireita().setPai(aux.getPai());
				updateFb(nodePai, IsLeftChild, 2);
			}
			else {
				aux.getPai().setFilhoEsquerda(aux.getFilhoDireita());
				aux.getFilhoDireita().setPai(aux.getPai());
				updateFb(nodePai, IsLeftChild, 2);
			}
		}
		else {
			Node min = aux;
			min = min.getFilhoDireita();
			nodePai = min.getPai();
			IsLeftChild = isLeftChild(min);
			
			while(min.getFilhoEsquerda() != null) {
				min = min.getFilhoEsquerda();
			}
			
			remove(min.getElemento());
			aux.setElemento(min.getElemento());
			updateFb(nodePai, IsLeftChild, 2);
		}
	}
	
	public void updateFb(Node no, Boolean isLeftchild, int action) {
		if (action == 1) { //insert
			if (isLeftchild == true) {
				no.setFb(no.getFb() + 1);
			} else {
				no.setFb(no.getFb() - 1);
			}
		} 
		else if (action == 2 ) { //remove
			if (isLeftchild == true || isRoot(no)) {
				no.setFb(no.getFb() - 1);
			} else {
				no.setFb(no.getFb() + 1);
			}
		}
		// rotação para esquerda
		if (no.getFb() <= -2) {
			Node subTreeRight = no.getFilhoDireita();
			// simples
			if (subTreeRight.getFb() <= 0) {
				simpleRotationLeft(no);
			// dupla
			} else {
				simpleRotationRight(subTreeRight);
				simpleRotationLeft(no);
			}
		} 
		// rotação para direita
		else if (no.getFb() >= 2) {
			Node subarvoreEsquerda = no.getFilhoEsquerda();
			// simples
			if (subarvoreEsquerda.getFb() >= 0) {
				simpleRotationRight(no);
			// dupla
			} 
			else {
				simpleRotationLeft(subarvoreEsquerda);
				simpleRotationRight(no);
			}
		} 
		// sem rotação
		else if (no.getFb() != 0 && no != root && action == 1) {
			updateFb(no.getPai(), isLeftChild(no), 1);
		}
		else if (no.getFb() == 0 && no != root && action == 2) {
			updateFb(no.getPai(), isLeftChild(no.getPai()), 2);
		}
	}

	public void simpleRotationLeft(Node no) {
		Node novoNode = no.getFilhoDireita();
		if (hasLeft(novoNode)) {
			no.setFilhoDireita(novoNode.getFilhoEsquerda());
			novoNode.getFilhoEsquerda().setPai(no);
			novoNode.setFilhoEsquerda(no);
			if (no != root) {
				if (no == no.getPai().getFilhoEsquerda()) {
					no.getPai().setFilhoEsquerda(novoNode);
				} 
				else {
					no.getPai().setFilhoDireita(novoNode);
				}
				novoNode.setPai(no.getPai());
			}
			no.setPai(novoNode);
		} else {
			novoNode.setFilhoEsquerda(no);
			if (no != root) {
				if (no == no.getPai().getFilhoEsquerda()) {
					no.getPai().setFilhoEsquerda(novoNode);
				} 
				else {
					no.getPai().setFilhoDireita(novoNode);
				}
				novoNode.setPai(no.getPai());
			}
			no.setPai(novoNode);
			no.setFilhoDireita(null);
		}
		// atualização do FB
		no.setFb((no.getFb() + 1) - Math.min(novoNode.getFb(), 0));
		novoNode.setFb((novoNode.getFb() + 1) + Math.max(no.getFb(), 0));
		if (isRoot(no)) {
			root = novoNode;
		}
	}	

	public void simpleRotationRight(Node no) {
		Node novoNode = no.getFilhoEsquerda();
		if (hasRight(novoNode)) {
			no.setFilhoEsquerda(novoNode.getFilhoDireita());
			novoNode.getFilhoDireita().setPai(no);
			novoNode.setFilhoDireita(no);
			if (no != root) {
				if (no == no.getPai().getFilhoEsquerda()) {
					no.getPai().setFilhoEsquerda(novoNode);
				} else {
					no.getPai().setFilhoDireita(novoNode);
				}
				novoNode.setPai(no.getPai());
			}
			no.setPai(novoNode);
		} 
		else {
			novoNode.setFilhoDireita(no);
			if (no != root) {
				if (no == no.getPai().getFilhoEsquerda()) {
					no.getPai().setFilhoEsquerda(novoNode);
				} 
				else {
					no.getPai().setFilhoDireita(novoNode);
				}
				novoNode.setPai(no.getPai());
			}
			no.setPai(novoNode);
			no.setFilhoEsquerda(null);
		}
		// atualização do FB
		no.setFb((no.getFb() - 1) - Math.max(novoNode.getFb(), 0));
		novoNode.setFb((novoNode.getFb() - 1) + Math.min(no.getFb(), 0));
		if (isRoot(no)) {
			root = novoNode;
		}
	}

	public boolean isLeftChild(Node no) {
		return no.getPai().getFilhoEsquerda() == no;
	}

	public boolean isRightChild(Node no) {
		return no.getPai().getFilhoDireita() == no;
	}

	public void mostraArvore() {
		organizador(root);
		System.out.println("Árvore Binária de Pesquisa:");
		for (int i = 0; i <= height(); i++) {
			for (int j = 0; j < size(); j++) {
				if (depth(nos.get(j)) == i) {
					System.out.print("\t" + nos.get(j).getElemento() + "[" + nos.get(j).getFb() + "]");
				} 
				else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
		nos.clear();
	}
}
