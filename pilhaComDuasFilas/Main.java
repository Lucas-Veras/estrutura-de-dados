package pilhaComDuasFilas;

public class Main {

	public static void main(String[] args) throws ListaVaziaException {
		FilaEncadeada teste = new FilaEncadeada();
		System.out.println("--------- Fila encadeada ------------");
		teste.enqueue(10);
		teste.enqueue(20);
		teste.mostrar();
		System.out.println("----------------------------------------");
		System.out.println("First: " + teste.first());
		System.out.println("Retirado com dequeue: " + teste.dequeue());
		System.out.println("Vazio: " + teste.isEmpty());
		System.out.println("--------- Pilha com duas filas ------------");
		PilhaComDuasFilas teste1 = new PilhaComDuasFilas();
		teste1.push(10);
		teste1.push(20);
		teste1.mostrar();
		System.out.println("----------------------------------------");
		System.out.println("Top: " + teste1.top());
		System.out.println("Retirado com pop: " + teste1.pop());
		System.out.println("----------------------------------------");
		teste1.push(30);
		teste1.push(40);
		teste1.mostrar();
		System.out.println("----------------------------------------");
		System.out.println("Top: " + teste1.top());
		System.out.println("Tamanho: " + teste1.size());
		System.out.println("Vazio: " + teste1.isEmpty());
	}
}
