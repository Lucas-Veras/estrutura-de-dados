package vetor;

public class TestesVetorDuplamenteEncadeado {

	public static void main(String[] args) throws VetorVazioException {
		VetorDuplamenteEncadeado vetor = new VetorDuplamenteEncadeado();
		vetor.insertAtRank(0, 10);
//		vetor.insertAtRank(1, 20);
//		vetor.insertAtRank(2, 30);
//		vetor.insertAtRank(3, 40);
//		vetor.mostrar();
//		int rank = 1;
//		System.out.println("Elemento no rank " + rank + ": " + vetor.elemAtRank(rank));
//		System.out.println("------");
//		vetor.replaceAtRank(rank, 50);
//		vetor.mostrar();
//		System.out.println("------");
//		vetor.insertAtRank(2, 60);
//		vetor.removeAtRank(0);
//		vetor.mostrar();
		System.out.println("Tamanho: " + vetor.size());
		System.out.println("Está vazio: " + vetor.isEmpty());
	}
}
