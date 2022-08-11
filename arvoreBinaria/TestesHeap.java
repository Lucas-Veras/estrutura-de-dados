package arvoreBinaria;

public class TestesHeap {
	public static void main(String[] args) throws ArvoreException {
		heap heap = new heap();
		heap.insert(10);
		heap.insert(1);
		heap.insert(4);
		heap.printHeap();
		System.out.println("Qtd elementos: " + heap.size());
		System.out.println("Elemento removido: " + heap.removeMin());
		System.out.println("--------------------");
		heap.printHeap();
		System.out.println("Qtd elementos: " + heap.size());
		System.out.println("Elemento removido: " + heap.removeMin());
		System.out.println("--------------------");
		heap.printHeap();
		System.out.println("Qtd elementos: " + heap.size());
		System.out.println("--------------------");
		heap.insert(6);
		heap.insert(1);
		heap.insert(5);
		heap.printHeap();
		System.out.println("Qtd elementos: " + heap.size());
		System.out.println("Min: " + heap.min());
		System.out.println("Está vazio: " + heap.isEmpty());
	}
}
