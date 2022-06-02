package filaVector;

public class Main {

	public static void main(String[] args) {
		FilaVector fila = new FilaVector(2);
		System.out.println("Size: " + fila.size());
		System.out.println("Vazio: " + fila.isEmpty());
		System.out.println("------------------");
		fila.enqueue(10);
		fila.enqueue(20);
		fila.enqueue(30);
		fila.enqueue(40);
		fila.mostrar();
		System.out.println("First: " + fila.first());
		System.out.println("Retirado: " + fila.dequeue());
		System.out.println("------------------");
		fila.mostrar();
		System.out.println("First: " + fila.first());
		System.out.println("Retirado: " + fila.dequeue());
		System.out.println("------------------");
		fila.enqueue(50);
		fila.enqueue(60);
		fila.mostrar();
		System.out.println("Size: " + fila.size());
		System.out.println("Vazio: " + fila.isEmpty());
	}
}
