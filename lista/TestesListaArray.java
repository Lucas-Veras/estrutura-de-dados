package lista;

public class TestesListaArray {

	public static void main(String[] args) throws ListaVaziaException {
		ListaArray lista1 = new ListaArray(2);
		System.out.println("Vetor 1:");
		lista1.insertFirst(10);
		lista1.insertFirst(20);
		lista1.insertFirst(30);
		lista1.insertFirst(40);
		lista1.mostrar();
		System.out.println("Tamanho: " + lista1.size());
		System.out.println("Vazio: " + lista1.isEmpty());
		System.out.println("Primeiro: " + lista1.first());
		System.out.println("Último: " + lista1.last());
		System.out.println("O número 40 é o primeiro: " + lista1.isFirst(40));
		System.out.println("O número 40 é o último: " + lista1.isLast(40));
		
		System.out.println("--------------------");
		System.out.println("Retirado: " + lista1.remove(0));
		System.out.println("Vetor 1:");
		lista1.mostrar();
		System.out.println("Tamanho: " + lista1.size());
		
		System.out.println("--------------------");
		ListaArray lista2 = new ListaArray(2);
		System.out.println("Vetor 2:");
		lista2.insertLast(10);
		lista2.insertLast(20);
		lista2.insertLast(30);
		lista2.insertLast(40);
		lista2.mostrar();
		System.out.println("Após do índice 2: " + lista2.after(2));
		System.out.println("Antes do índice 2: " + lista2.before(2));
		lista2.insertAfter(2, 50);
		lista2.mostrar();
	}

}
