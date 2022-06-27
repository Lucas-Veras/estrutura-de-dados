package sequencia;

public class TestesSequenciaDuplamenteEncadeada {

	public static void main(String[] args) throws SequenciaVaziaException {
		SequenciaDuplamenteEncadeada sequencia0 = new SequenciaDuplamenteEncadeada();
		System.out.println("Metodos de Vetor: ");
		sequencia0.insertAtRank(0, 10);
		sequencia0.insertAtRank(1, 20);
		sequencia0.insertAtRank(2, 30);
		sequencia0.insertAtRank(3, 40);
		sequencia0.insertAtRank(0, 50);
		sequencia0.mostrar();
		System.out.println("------");
		int rank = 1;
		System.out.println("Elemento no rank " + rank + ": " + sequencia0.elemAtRank(rank));
		System.out.println("Subtituído: " + sequencia0.replaceAtRank(rank, 500));
		System.out.println("Retirado: " + sequencia0.removeAtRank(0));
		System.out.println("------");
		sequencia0.mostrar();
		System.out.println("------");
		sequencia0.insertAtRank(2, 60);
		sequencia0.mostrar();
		System.out.println("Tamanho: " + sequencia0.size());
		System.out.println("Está vazio: " + sequencia0.isEmpty());
		System.out.println("----------------------");
		
		
		
		System.out.println("Metodos de Lista: ");
		SequenciaDuplamenteEncadeada sequencia1 = new SequenciaDuplamenteEncadeada();
		System.out.println("Vetor 1:");
		sequencia1.insertFirst(10);
		sequencia1.insertFirst(20);
		sequencia1.insertFirst(30);
		sequencia1.insertFirst(40);
		sequencia1.mostrar();
		System.out.println("Tamanho: " + sequencia1.size());
		System.out.println("Vazio: " + sequencia1.isEmpty());
		System.out.println("Primeiro: " + sequencia1.first());
		System.out.println("Último: " + sequencia1.last());
		
		System.out.println("--------------------");
		System.out.println("Retirado: " + sequencia1.remove(sequencia1.atRank(0)));
		System.out.println("Vetor 1:");
		sequencia1.mostrar();
		System.out.println("Tamanho: " + sequencia1.size());
		
		System.out.println("--------------------");
		SequenciaDuplamenteEncadeada Sequencia3 = new SequenciaDuplamenteEncadeada();
		System.out.println("Vetor 2:");
		Sequencia3.insertLast(10);
		Sequencia3.insertLast(20);
		Sequencia3.insertLast(30);
		Sequencia3.insertLast(40);
		Sequencia3.mostrar();
		System.out.println("Após do índice 2: " + Sequencia3.after(Sequencia3.atRank(2)));
		System.out.println("Antes do índice 2: " + Sequencia3.before(Sequencia3.atRank(2)));
		
		System.out.println("--------------------");
		System.out.println("Vetor 2:");
		Sequencia3.insertBefore(Sequencia3.atRank(0), 50);
		Sequencia3.insertAfter(Sequencia3.atRank(4), 60);
		Sequencia3.mostrar();
		
		System.out.println("--------------------");
		System.out.println("Vetor 2:");
		Sequencia3.swapElements(Sequencia3.atRank(0), Sequencia3.atRank(1));
		Sequencia3.replaceElement(Sequencia3.atRank(2), 100);
		Sequencia3.mostrar();
	}

}
