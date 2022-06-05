package vetor;

public class TestesVetorArray {

	public static void main(String[] args) throws VetorVazioException {
		VetorArray vetor = new VetorArray(2);
		vetor.insertAtRank(0, 10);
		vetor.insertAtRank(1, 20);
		vetor.insertAtRank(2, 30);
		vetor.insertAtRank(3, 40);
		vetor.mostrar();
		System.out.println("------");
		int rank = 1;
		System.out.println("Elemento no rank " + rank + ": " + vetor.elemAtRank(rank));
		System.out.println("Subtituído: " + vetor.replaceAtRank(rank, 50));
		System.out.println("Retirado: " + vetor.removeAtRank(0));
		System.out.println("------");
		vetor.mostrar();
		System.out.println("------");
		vetor.insertAtRank(2, 60);
		vetor.mostrar();
		System.out.println("Tamanho: " + vetor.size());
		System.out.println("Está vazio: " + vetor.isEmpty());
	}
}
