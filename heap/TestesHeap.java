package heap;

public class TestesHeap {

	public static void main(String[] args) {
		Heap filaPrioridade = new Heap(10);
        filaPrioridade.insert(1);
        filaPrioridade.insert(2);
        filaPrioridade.insert(3);
        filaPrioridade.insert(4);
        filaPrioridade.insert(5);
        filaPrioridade.insert(6);
        filaPrioridade.insert(7);
        filaPrioridade.insert(20);

        filaPrioridade.print();
        System.out.println("Altura: " + filaPrioridade.height());
        System.out.println("Min: " + filaPrioridade.min());
        System.out.println("Removido: " + filaPrioridade.removeMin());
        System.out.println();
        
        filaPrioridade.print();
        System.out.println("Altura: " + filaPrioridade.height());
        System.out.println("Min: " + filaPrioridade.min());
        System.out.println("Removido: " + filaPrioridade.removeMin());
	}
}
