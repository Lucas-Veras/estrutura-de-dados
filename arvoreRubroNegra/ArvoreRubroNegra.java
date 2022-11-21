package arvoreRubroNegra;

public class ArvoreRubroNegra extends ArvoreBinariaPesquisa {
	public ArvoreRubroNegra() {
		super();
	}
	
	public void insert(Object elemento) throws NodeException {
		if (isEmpty()) {
			root = new Node(elemento);
			root.setNegro(true);
		} else {
			Node aux = find(elemento, root);
			Node novoNode = new Node(elemento);
			if ((int) aux.getElemento() == (int) elemento) {
				throw new NodeException("Esse elemento já existe!");
			} else if ((int) aux.getElemento() < (int) elemento) {
				aux.setFilhoDireita(novoNode);
			} else if ((int) aux.getElemento() > (int) elemento) {
				aux.setFilhoEsquerda(novoNode);
			}
			novoNode.setPai(aux);
			insertCases(novoNode);
		}
	}
	
	public void remove(Object elemento) throws NodeException {
		Node aux = find(elemento, root);
		int count = 0;
		if (elemento != aux.getElemento()) {
			throw new NodeException("A chave " + elemento + " não existe!");
		} else {
			String corRemovido = null;
			String corSucessor = null;
			Boolean removidoIsLeft = null;
			Node noPai = null;
			Node noSucessor = null;

			if (isExternal(aux)) {
				if (isRoot(aux) == true) {
					root = null;
				} else {
					if (aux == aux.getPai().getFilhoEsquerda()) {
						corRemovido = (aux.isNegro() == true ? "NEGRO" : "RUBRO");
						removidoIsLeft = true;
						noPai = aux.getPai();
						
						aux.getPai().setFilhoEsquerda(null);
						aux.setPai(null);
					} else {
						corRemovido = (aux.isNegro() == true ? "NEGRO" : "RUBRO");
						removidoIsLeft = false;
						noPai = aux.getPai();
						
						aux.getPai().setFilhoDireita(null);
						aux.setPai(null);
					}
				}
			} else if (aux.getFilhoDireita() == null) {
				if (isRoot(aux) == true) {
					aux.getFilhoEsquerda().setPai(null);
					root = aux.getFilhoEsquerda();
					aux.setFilhoEsquerda(null);
				} else {
					corRemovido = (aux.isNegro() == true ? "NEGRO" : "RUBRO");
					corSucessor = (aux.getFilhoEsquerda().isNegro() == true ? "NEGRO" : "RUBRO");
					noPai = aux.getPai();
					noSucessor = aux.getFilhoEsquerda();
					if (aux == aux.getPai().getFilhoEsquerda()) {
						removidoIsLeft = true;	
						aux.getPai().setFilhoEsquerda(aux.getFilhoEsquerda());
						aux.getFilhoEsquerda().setPai(aux.getPai());
					} else {
						removidoIsLeft = false;
						aux.getPai().setFilhoDireita(aux.getFilhoEsquerda());
						aux.getFilhoEsquerda().setPai(aux.getPai());
					}
				}
			} else {
				corRemovido = (aux.isNegro() == true ? "NEGRO" : "RUBRO");
				Node aux2 = aux.getFilhoDireita();
				while (aux2.getFilhoEsquerda() != null) {
					aux2 = aux2.getFilhoEsquerda();
					count++;
				}
				corSucessor = (aux2.isNegro() == true ? "NEGRO" : "RUBRO");
				aux.setElemento(aux2.getElemento());
				aux.setNegro(aux2.isNegro());
				noSucessor = aux;
				if (count > 0) {
					noPai = aux2.getPai();
					removidoIsLeft = true;
					
					aux2.getPai().setFilhoEsquerda(aux2.getFilhoDireita());
					if (aux2.getFilhoDireita() != null) {
						aux2.getFilhoDireita().setPai(aux);
					}
				} else {
					noPai = aux;
					removidoIsLeft = false;
					aux.setFilhoDireita(aux2.getFilhoDireita());
					if (aux2.getFilhoDireita() != null) {
						aux2.getFilhoDireita().setPai(aux);
					}
				}
			}
			root.setNegro(true);
			removeCases(corRemovido, corSucessor, noPai, noSucessor, removidoIsLeft);
		}
		System.out.println("Chave " + elemento + " removida com sucesso!");
	}
	
	public void removeCases(String corRemovido, String corSucessor, Node noPai, Node noSucessor , Boolean isLeft) {
		// CASO 1
		if (corRemovido == "RUBRO" && corSucessor == "RUBRO") {
			return;
		}
		// CASO 2 
		if (corRemovido == "NEGRO" && corSucessor == "RUBRO") {
			noSucessor.setNegro(true);
		}
		// CASO 3 
		if (corRemovido == "NEGRO" && corSucessor == "NEGRO") {
			caso3Remocao(noPai, isLeft);
		}
		// CASO 4
		if (corRemovido == "RUBRO" && corSucessor == "NEGRO") {
			noSucessor.setNegro(false);
			caso3Remocao(noPai, isLeft);
		}
		if (corRemovido == "NEGRO" && corSucessor == null) {
			caso3Remocao(noPai, isLeft);
		}
	}

	public void caso3Remocao(Node no, Boolean isLeft) {
		if (no == root) {
			no.setNegro(true);
		} else {
			// CASO 3_1 esquerda
			if (isLeft == true && no.isNegro() == true && no.getFilhoDireita() != null) {
				if (no.getFilhoDireita().isNegro() == false) {
					no.getFilhoDireita().setNegro(true);
					no.setNegro(false);
					simpleRotationLeft(no);
				}
			}
			// CASO 3_1 direita
			if (isLeft == false && no.isNegro() == true && no.getFilhoEsquerda() != null) {
				if (no.getFilhoEsquerda().isNegro() == false) {
					no.getFilhoEsquerda().setNegro(true);
					no.setNegro(false);
					simpleRotationRight(no);
				}
			}
			// CASO 3_2A esquerda
			if (isLeft == true && no.isNegro() == true && no.getFilhoDireita() != null) {
				if (no.getFilhoDireita().isNegro() == true) {
					Node irmao = no.getFilhoDireita();
					if (irmao.getFilhoEsquerda() != null && irmao.getFilhoDireita() != null) {
						if (irmao.getFilhoEsquerda().isNegro() == true && irmao.getFilhoDireita().isNegro() == true) {
							irmao.setNegro(false);
						}
					}
					if (irmao.getFilhoEsquerda() != null) {
						if (irmao.getFilhoEsquerda().isNegro() == true && irmao.getFilhoDireita() == null) {
							irmao.setNegro(false);
						}
					}
					if (irmao.getFilhoDireita() != null) {
						if (irmao.getFilhoDireita().isNegro() == true && irmao.getFilhoEsquerda() == null) {
							irmao.setNegro(false);
						}
					}
					if (irmao.getFilhoEsquerda() == null && irmao.getFilhoDireita() == null) {
						irmao.setNegro(false);
					}
				}	
			}
			// CASO 3_2A direita
			if (isLeft == false && no.isNegro() == true && no.getFilhoEsquerda() != null) {
				if (no.getFilhoEsquerda().isNegro() == true) {
					Node irmao = no.getFilhoEsquerda();
					if (irmao.getFilhoEsquerda() != null && irmao.getFilhoDireita() != null) {
						if (irmao.getFilhoEsquerda().isNegro() == true && irmao.getFilhoDireita().isNegro() == true) {
							irmao.setNegro(false);
						}
					}
					if (irmao.getFilhoEsquerda() != null) {
						if (irmao.getFilhoEsquerda().isNegro() == true && irmao.getFilhoDireita() == null) {
							irmao.setNegro(false);
						}
					}
					if (irmao.getFilhoDireita() != null) {
						if (irmao.getFilhoDireita().isNegro() == true && irmao.getFilhoEsquerda() == null) {
							irmao.setNegro(false);
						}
					}
					if (irmao.getFilhoEsquerda() == null && irmao.getFilhoDireita() == null) {
						irmao.setNegro(false);
					}
				}
			}
			
			// CASO 3_2B esquerda
			if (isLeft == true && no.isNegro() == false && no.getFilhoDireita() != null) {
				if (no.getFilhoDireita().isNegro() == true) {
					Node irmao = no.getFilhoDireita();
					if (irmao.getFilhoEsquerda() != null && irmao.getFilhoDireita() != null) {
						if (irmao.getFilhoEsquerda().isNegro() == true && irmao.getFilhoDireita().isNegro() == true) {
							irmao.setNegro(false);
							no.setNegro(true);
						}
					}
					if (irmao.getFilhoEsquerda() != null) {
						if (irmao.getFilhoEsquerda().isNegro() == true && irmao.getFilhoDireita() == null) {
							irmao.setNegro(false);
							no.setNegro(true);
						}
					}	
					if (irmao.getFilhoDireita() != null) {
						if (irmao.getFilhoDireita().isNegro() == true && irmao.getFilhoEsquerda() == null) {
							irmao.setNegro(false);
							no.setNegro(true);
						}
					}	
					if (irmao.getFilhoEsquerda() == null && irmao.getFilhoDireita() == null) {
						irmao.setNegro(false);
						no.setNegro(true);
					}
				}
			}
			// CASO 3_2B direita
			if (isLeft == false && no.isNegro() == false && no.getFilhoEsquerda() != null) {
				if (no.getFilhoEsquerda().isNegro() == true) {
					Node irmao = no.getFilhoEsquerda();
					if (irmao.getFilhoEsquerda() != null && irmao.getFilhoDireita() != null) {
						if (irmao.getFilhoEsquerda().isNegro() == true && irmao.getFilhoDireita().isNegro() == true) {
							irmao.setNegro(false);
							no.setNegro(true);
						}
					}
					if (irmao.getFilhoEsquerda() != null) {
						if (irmao.getFilhoEsquerda().isNegro() == true && irmao.getFilhoDireita() == null) {
							irmao.setNegro(false);
							no.setNegro(true);
						}
					}
					if (irmao.getFilhoDireita() != null) {
						if (irmao.getFilhoDireita().isNegro() == true && irmao.getFilhoEsquerda() == null) {
							irmao.setNegro(false);
							no.setNegro(true);
						}
					}
					if (irmao.getFilhoEsquerda() == null && irmao.getFilhoDireita() == null) {
						irmao.setNegro(false);
						no.setNegro(true);
					}
				}
			}
			// CASO 3_3 esquerda
			if (isLeft == true && no.getFilhoDireita() != null) {
				if (no.getFilhoDireita().isNegro() == true) {
					Node irmao = no.getFilhoDireita();
					if (irmao.getFilhoEsquerda() != null && irmao.getFilhoDireita() != null) {
						if (irmao.getFilhoEsquerda().isNegro() == false && irmao.getFilhoDireita().isNegro() == true) {
							irmao.getFilhoEsquerda().setNegro(true);
							irmao.setNegro(false);
							simpleRotationRight(irmao);
						}
					}
					if (irmao.getFilhoEsquerda() != null && irmao.getFilhoDireita() == null) {
						if (irmao.getFilhoEsquerda().isNegro() == false) {
							irmao.getFilhoEsquerda().setNegro(true);
							irmao.setNegro(false);
							simpleRotationRight(irmao);
						}
					}
				}
			}
			// CASO 3_3 direita
			if (isLeft == false && no.getFilhoEsquerda() != null) {
				if (no.getFilhoEsquerda().isNegro() == true) {
					Node irmao = no.getFilhoEsquerda();
					if (irmao.getFilhoEsquerda() != null && irmao.getFilhoDireita() != null) {
						if (irmao.getFilhoEsquerda().isNegro() == true && irmao.getFilhoDireita().isNegro() == false) {
							irmao.getFilhoDireita().setNegro(true);
							irmao.setNegro(false);
							simpleRotationLeft(irmao);
						}
					}
					if (irmao.getFilhoDireita() != null) {
						if (irmao.getFilhoEsquerda() == null && irmao.getFilhoDireita().isNegro() == false) {
							irmao.getFilhoDireita().setNegro(true);
							irmao.setNegro(false);
							simpleRotationLeft(irmao);
						}
					}
				}
			}
			// CASO 3_4 esquerda
			if (isLeft == true && no.getFilhoDireita() != null) {
				if (no.getFilhoDireita().isNegro() == true) {
					Node irmao = no.getFilhoDireita();
					if (irmao.getFilhoEsquerda() != null && irmao.getFilhoDireita() != null) {
						if (irmao.getFilhoDireita().isNegro() == false) {
							if (no.isNegro() == true) {
								irmao.setNegro(true);
							} else {
								irmao.setNegro(false);
							}
							no.setNegro(true);
							irmao.getFilhoDireita().setNegro(true);
							simpleRotationLeft(no);
						}
					}
				}
			}
			// CASO 3_4 direita
			if (isLeft == false && no.getFilhoEsquerda() != null) {
				if (no.getFilhoEsquerda().isNegro() == true) {
					Node irmao = no.getFilhoEsquerda();
					if (irmao.getFilhoEsquerda() != null && irmao.getFilhoDireita() != null) {
						if (irmao.getFilhoEsquerda().isNegro() == false) {
							if (no.isNegro() == true) {
								irmao.setNegro(true);
							} else {
								irmao.setNegro(false);
							}
							no.setNegro(true);
							irmao.getFilhoEsquerda().setNegro(true);
							simpleRotationRight(no);
						}
					}
				}
			}
		}
	}
	
	public void insertCases(Node no) {
		if (no == root) {
			no.setNegro(true);
		} else {
			Node pai = no.getPai();
			Node avo = null;
			if (pai != root) {
				avo = pai.getPai();
			}
			// CASO 1 - Pai do No é negro então não faz nada
			if (pai.isNegro() == false && pai != root) {
				if (avo.isNegro() == true) {
					// CASO 2 Esquerda - pai do No inserido é filho esquerdo
					if (isLeftChild(pai) && avo.getFilhoDireita() != null) {
						if (avo.getFilhoDireita().isNegro() == false) {
							casoInsercao2(no);
							if (avo != root) {
								if (avo.getPai().isNegro() == false) {
									insertCases(avo);
								}
							}
							root.setNegro(true);
							return;
						}
						// CASO 3 - pai do No inserido é filho esquerda e possui irmão negro
						else {
							casoInsercao3A_3D(no);
						}
					}
					// CASO 2 Direita - pai do No inserido é filho direito
					if (isRightChild(pai) && avo.getFilhoEsquerda() != null) {
						if (avo.getFilhoEsquerda().isNegro() == false) {
							casoInsercao2(no);
							if (avo != root) {
								if (avo.getPai().isNegro() == false) {
									insertCases(avo);
								}
							}
							root.setNegro(true);
							return;
						}
						// CASO 3 - pai do No inserido é filho direita e possui irmão negro
						else {
							casoInsercao3B_3C(no);
						}
					}
					// CASO 3 - No inserido é filho esquerda e não possui irmão			
					if (isLeftChild(pai) && avo.getFilhoDireita() == null) {
						casoInsercao3A_3D(no);
					}
					// CASO 3 - No inserido é filho direita e não possui irmão
					if (isRightChild(pai) && avo.getFilhoEsquerda() == null) {
						casoInsercao3B_3C(no);
					}
				}
			}
		}
		root.setNegro(true);
	}
	
	public void casoInsercao2(Node no) {
		Node pai = no.getPai();
		Node avo = no.getPai().getPai();
		pai.setNegro(true);
		avo.setNegro(false);
		if (isLeftChild(pai)) {
			avo.getFilhoDireita().setNegro(true);
		} else {
			avo.getFilhoEsquerda().setNegro(true);
		}
	}	
	
	public void casoInsercao3A_3D(Node no) {
		Node pai = no.getPai();
		Node avo = no.getPai().getPai();
		avo.setNegro(false);
		// 3A - Rotação simples direita
		if (isLeftChild(no)) {
			pai.setNegro(true);
			simpleRotationRight(avo);
		}
		// 3D - Rotação dupla direita
		else {
			no.setNegro(true);
			simpleRotationLeft(pai);
			simpleRotationRight(avo);
		}
	}

	public void casoInsercao3B_3C(Node no) {
		Node pai = no.getPai();
		Node avo = no.getPai().getPai();
		avo.setNegro(false);
		// 3B - Rotação simples esquerda
		if (isRightChild(no)) {
			pai.setNegro(true);
			simpleRotationLeft(avo);
		}
		// 3C - Rotação dupla esquerda
		else {
			no.setNegro(true);
			simpleRotationRight(pai);
			simpleRotationLeft(avo);
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
		if (isRoot(no)) {
			root = novoNode;
			root.setNegro(true);
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
		if (isRoot(no)) {
			root = novoNode;
			root.setNegro(true);
		}
	}
	
	public boolean isLeftChild(Node no) {
		return (no.getPai().getFilhoEsquerda() == no) ? true : false;
	}

	public boolean isRightChild(Node no) {
		return (no.getPai().getFilhoDireita() == no) ? true : false;
	}
	
	public void mostraArvore() {
		if (root == null) {
			System.out.println("Árvore sem elementos!");
		} else {
			organizador(root);
			System.out.println("Árvore Rubro Negra:");
			for (int j = 0; j <= height(); j++) {
				for (int i = 0; i < size(); i++) {
					if (depth(nos.get(i)) == j) {
						if (nos.get(i).isNegro() == false) {
							System.out.print("\t[r]" + nos.get(i).getElemento());
						} else {
							System.out.print("\t" + nos.get(i).getElemento());
						}
					} else {
						System.out.print("\t");
					}
				}
				System.out.println();
			}
			nos.clear();
		}
	}
}
