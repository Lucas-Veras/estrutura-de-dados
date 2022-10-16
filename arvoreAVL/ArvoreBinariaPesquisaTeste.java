package arvoreAVL;

public class ArvoreBinariaPesquisaTeste {

	public static void main(String[] args) throws NodeException {
		ArvoreBinariaPesquisa arvore = new ArvoreBinariaPesquisa();
		arvore.insert(6);
		arvore.insert(3);
		arvore.insert(2);
		arvore.insert(5);
		arvore.remove(3);
		arvore.insert(4);
		
		arvore.mostraArvore();
		System.out.println();
	}
}
