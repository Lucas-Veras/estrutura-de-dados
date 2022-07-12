package arvoreBinariaPesquisa;

public class TestesArvoreBinaria {

	public static void main(String[] args) throws InvalidNoException {
		ArvoreBinariaPesquisa arvore = new ArvoreBinariaPesquisa(10);
		arvore.insert(5);
        arvore.insert(15);
        arvore.insert(2);
        arvore.insert(8);
        arvore.insert(22);
		
        System.out.println("Teste 1 / Árvore:");
        arvore.mostrarArvore();
        System.out.println("Tamanho: " + arvore.size());
        System.out.println("Raiz: " + arvore.root().getElemento());
		
        System.out.println("-------------------------------------");
        
        System.out.println("Teste 2 / Árvore (Elemento 25 inserido):");
        arvore.insert(25);
        arvore.mostrarArvore();
        System.out.println("Tamanho: " + arvore.size());
        System.out.println("Raiz: " + arvore.root().getElemento());
        
        System.out.println("-------------------------------------");
        
        System.out.println("Teste 3 / Árvore (Elemento 5 removido):");
        arvore.remove(5);
        arvore.mostrarArvore();
        System.out.println("Tamanho: " + arvore.size());
        System.out.println("Raiz: " + arvore.root().getElemento());
	}
}
