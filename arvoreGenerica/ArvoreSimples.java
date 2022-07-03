package arvoreGenerica;

import java.util.ArrayList;
import java.util.Iterator;

public class ArvoreSimples {
	No raiz;
	int tamanho;

	public ArvoreSimples(Object o) {
		raiz = new No(null, o);
		tamanho = 1;
	}
	
	/* Retorna a raiz da árvore */
	public No root() {
		return raiz;
	}
	
	/* Retorna o No pai de um No */
	public No parent(No v) {
		return (v.parent());
	}

	/* retorna os filhos de um No */
	public Iterator<No> children(No v) {
		return v.children();
	}
	
	/* Testa se um No é interno */
	public boolean isInternal(No v) {
		return (v.childrenNumber() > 0);
	}
	
	/* Testa se um No é externo*/
	public boolean isExternal(No v) {
		return (v.childrenNumber() == 0);
	}
	
	/* Testa se um No é a raiz */
	public boolean isRoot(No v) {
		return v == raiz;
	}
	
	/* Adiciona um filho a um No */
	public void addChild(No v, Object o) {
		No novo = new No(v, o);
		v.addChild(novo);
		tamanho++;
	}
	
	/* Remove um No, Só pode remover 
	   Nos externos e que tenham um pai (não seja raiz) */
	public Object remove(No v) throws InvalidNoException {
		No pai = v.parent();
		if (pai != null || isExternal(v))
			pai.removeChild(v);
		else
			throw new InvalidNoException("No inválido!");
		Object o = v.element();
		tamanho--;
		return o;
	}
	
	/* Troca dois elementos de posição */
	public void swapElements(No v, No w) {
		Object aux = v.element();
		v.setElement(w.element());
		w.setElement(aux);
	}
		
	/* Retorna a profundidade de um No */
	public int depth(No v) {
		int profundidade = profundidade(v);
		return profundidade;
	}
	
	private int profundidade(No v) {
		if (v == raiz)
			return 0;
		else
			return 1 + profundidade(v.parent());
	}
	
	/* Retorna a altura da árvore */
	public int height(No v) {
		if(isExternal(v)) {
			return 0;
		}
		else {
			int altura = 0;
			for(Iterator<No> child = v.children(); child.hasNext(); ) {
				No w = child.next();
				if (altura < height(w)) {
					altura = height(w);					
	            }
			}
			return 1 + altura;
		}
	}
	
	/* Retorna um iterator com os elementos armazenados na árvore */
	public Iterator<Object> elements() {
		return ListElements(raiz);
	}
	
	/* Função auxiliar de elements */
    private Iterator<Object> ListElements(No v) {
        ArrayList<Object> elements = new ArrayList<>();
        if (isRoot(v)){
        	elements.add(v.element());
        }
        for (Iterator<No> child = v.children(); child.hasNext(); ) {
            No w = child.next();
            elements.add(w.element());
            ListElements(w);
        }
        return elements.iterator();
    }
	
	/* Retorna um iterator com as posições (Nos) da árvore */
	public Iterator<Object> Nos() {
		return ListNos(raiz);
	}

    private Iterator<Object> ListNos(No v) {
        ArrayList<Object> nos = new ArrayList<>();
        if (isRoot(v)){
            nos.add(v);
        }
        for (Iterator<No> child = v.children(); child.hasNext(); ) {
            No w = child.next();
            nos.add(w);
            ListNos(w);
        }
        return nos.iterator();
    }
	 
	/* Retorna o número de Nos da árvore */
	public int size() {
		return tamanho;		
	}
	
	/* Retorna se a ávore está vazia. Sempre vai ser falso, 
	   pois não permitimos remover a raiz */
	public boolean isEmpty() {
		return false;
	}
	
	/* Altera o Objeto armazenado em um No */
	public Object replace(No v, Object o) {
		Object elemento = v.element();
		v.setElement(o);
		return elemento;
	}	
}
