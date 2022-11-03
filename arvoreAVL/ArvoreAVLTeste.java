package arvoreAVL;

public class ArvoreAVLTeste {

	public static void main(String[] args) throws NodeException {
		ArvoreAVL arvore = new ArvoreAVL();
		
		arvore.insert(1);
		arvore.insert(2);
		arvore.insert(3);
		arvore.insert(4);
		arvore.insert(5);
		arvore.insert(6);
		arvore.insert(7);
		arvore.insert(8);
		arvore.insert(9);
		arvore.insert(10);
		arvore.mostraArvore();
		arvore.remove(1);
		arvore.mostraArvore();
		arvore.remove(3);
		arvore.mostraArvore();
		
	}
}
