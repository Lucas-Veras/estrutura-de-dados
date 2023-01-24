package arvoreRubroNegra;

public class ArvoreRubroNegraTeste {

	public static void main(String[] args) throws NodeException {
		ArvoreRubroNegra arvore = new ArvoreRubroNegra();
		for(int i = 1; i <= 12; i++) {
			arvore.insert(i);
		}
		arvore.mostraArvore();
		//System.out.println("Elemento 0: " + arvore.find(0, arvore.root).getElemento());
		arvore.remove(2);
		arvore.mostraArvore();
	}

}
