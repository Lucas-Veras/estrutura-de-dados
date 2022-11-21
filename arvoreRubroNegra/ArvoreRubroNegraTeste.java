package arvoreRubroNegra;

public class ArvoreRubroNegraTeste {

	public static void main(String[] args) throws NodeException {
		ArvoreRubroNegra arvore = new ArvoreRubroNegra();
		for(int i = 0; i < 13; i++) {
			arvore.insert(i);
		}
		arvore.mostraArvore();
		//System.out.println("Elemento 0: " + arvore.find(0, arvore.root).getElemento());
	//	arvore.remove(10);
		//arvore.mostraArvore();
	}

}
