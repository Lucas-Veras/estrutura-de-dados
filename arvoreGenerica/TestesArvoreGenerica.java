package arvoreGenerica;

import java.util.Iterator;

public class TestesArvoreGenerica {
	public static void main(String[] args) {
		ArvoreSimples simples = new ArvoreSimples(1);
	    simples.addChild(simples.root(),2);
	    simples.addChild(simples.root(),3);
	    simples.addChild(simples.root(),4);
	    simples.addChild(simples.root(),5);
	   
	    Iterator<No> Filhos = simples.children(simples.root());
	    /* Print filhos da raiz */
	    while (Filhos.hasNext()) {
            No x = Filhos.next();
            System.out.println(">" + x.element());
	    }
	    
	    /* Altura da raiz */
	    System.out.println("Altura: " + simples.height(simples.root()));
	    
	    /* Sendo adicionado filhos nos filhos da raiz */
	    No auxNo = null;
	    for (Iterator<No> child = simples.children(simples.root()); child.hasNext();) {
	    	auxNo = child.next();
	    	simples.addChild(auxNo, 20);
	    }
	    
	    /* Raiz */
	    System.out.println("Raiz: " + simples.root().element());
	    
	    System.out.println("Profundidade da raiz: " + simples.depth(simples.root()));
	    System.out.println("");
	    
	    /* Nova altura da raiz após ser adicionado elementos nos filhos */
	    System.out.println("Nova Altura: " + simples.height(simples.root()));
        System.out.println("Profundidade do filho da raiz: " + simples.depth(auxNo));	  
	}
}
