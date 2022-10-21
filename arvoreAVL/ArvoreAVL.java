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
	            atualizaFb(novoNode.getPai(), false, 1);
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
	            atualizaFb(novoNode.getPai(), true, 1);
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
			atualizaFb(nodePai, IsLeftChild, 2);
		}
		else if(aux.getFilhoDireita() == null) {
			if(aux.getPai().getFilhoDireita() == aux) {
				aux.getPai().setFilhoDireita(aux.getFilhoEsquerda());
				aux.getFilhoEsquerda().setPai(aux.getPai());
				atualizaFb(nodePai, IsLeftChild, 2);
			}
			else {
				aux.getPai().setFilhoEsquerda(aux.getFilhoDireita());
				aux.getFilhoDireita().setPai(aux.getPai());
				atualizaFb(nodePai, IsLeftChild, 2);
			}
		}
		else if(aux.getFilhoEsquerda() == null) {
			if(aux.getPai().getFilhoDireita() == aux) {
				aux.getPai().setFilhoDireita(aux.getFilhoDireita());
				aux.getFilhoDireita().setPai(aux.getPai());
				atualizaFb(nodePai, IsLeftChild, 2);
			}
			else {
				aux.getPai().setFilhoEsquerda(aux.getFilhoDireita());
				aux.getFilhoDireita().setPai(aux.getPai());
				atualizaFb(nodePai, IsLeftChild, 2);
			}
		}
		else {
			Node minimo = aux;
			minimo = minimo.getFilhoDireita();
			nodePai = minimo.getPai();
			IsLeftChild = isLeftChild(minimo);
			
			while(minimo.getFilhoEsquerda() != null) {
				minimo = minimo.getFilhoEsquerda();
			}
			
			remove(minimo.getElemento());
			aux.setElemento(minimo.getElemento());
			atualizaFb(nodePai, IsLeftChild, 2);
		}
	}
	
	public void atualizaFb(Node no, Boolean leftchild, int operacao) {
		if (operacao == 1) { //insert
			if (leftchild == true) {
				no.setFb(no.getFb() + 1);
			} else {
				no.setFb(no.getFb() - 1);
			}
		} 
		else if (operacao == 2 ) { //remove
			if (leftchild == true) {
				no.setFb(no.getFb() - 1);
			} else {
				no.setFb(no.getFb() + 1);
			}
		}
		// rotação para esquerda
		if (no.getFb() <= -2) {
			Node subarvoreDireita = no.getFilhoDireita();
			// simples
			if (subarvoreDireita.getFb() <= 0) {
				simpleRotationLeft(no);
			// dupla
			} else {
				simpleRotationRight(subarvoreDireita);
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
		else if (no != root && no.getFb() != 0 && operacao == 1) {
			atualizaFb(no.getPai(), isLeftChild(no), 1);
		}
		else if (no != root && no.getFb() == 0 && operacao == 2) {
			atualizaFb(no.getPai(), isLeftChild(no.getPai()), 2);
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
		no.setFb((no.getFb() + 1) - min(novoNode.getFb(), 0));
		novoNode.setFb((novoNode.getFb() + 1) + max(no.getFb(), 0));
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
		no.setFb((no.getFb() - 1) - max(novoNode.getFb(), 0));
		novoNode.setFb((novoNode.getFb() - 1) + min(no.getFb(), 0));
		if (isRoot(no)) {
			root = novoNode;
		}
	}
	
	public int min(int valor1, int valor2) {
		if (valor1 >= valor2) {
			return valor2;
		} 
		else {
			return valor1;
		}
	}

	public int max(int valor1, int valor2) {
		if (valor1 >= valor2) {
			return valor1;
		} 
		else {
			return valor2;
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
		for (int j = 0; j <= height(); j++) {
			for (int i = 0; i < size(); i++) {
				if (depth(nos.get(i)) == j) {
					System.out.print("\t" + nos.get(i).getElemento() + "[" + nos.get(i).getFb() + "]");
				} else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
		nos.clear();
	}
}
