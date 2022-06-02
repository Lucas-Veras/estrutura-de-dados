package filaEncadeada;

public class Main {

	public static void main(String[] args) throws FilaVaziaException {
		System.out.println("ola");
		FilaEncadeada teste = new FilaEncadeada();
		teste.enqueue(10);
		teste.enqueue(20);
		teste.enqueue(30);
		teste.enqueue(40);
		teste.mostrar();
		System.out.println("-----");
		System.out.println("Retirado: " + teste.dequeue());
		System.out.println("Retirado: " + teste.dequeue());
		teste.mostrar();
		System.out.println("-----");
		teste.enqueue(50);
		teste.enqueue(60);
		teste.mostrar();
	}

}
