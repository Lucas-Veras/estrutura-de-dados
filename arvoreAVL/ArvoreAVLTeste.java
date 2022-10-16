package arvoreAVL;

public class ArvoreAVLTeste {

	public static void main(String[] args) throws NodeException {
		ArvoreAVL arvore = new ArvoreAVL();
		
		arvore.insert(9);
		arvore.insert(10);
		arvore.insert(11);
		arvore.insert(12);
		arvore.insert(8);
		arvore.mostraArvore();
		arvore.insert(13);
		arvore.mostraArvore();

		/*arvore.insert(15);
		arvore.insert(8);*/
		/*arvore.insert(7);
		arvore.remove(8);
		arvore.mostraArvore();*/

		
		System.out.println("FATOR DE BALANCEAMENTO: " + arvore.root().getFb());
	}
}
