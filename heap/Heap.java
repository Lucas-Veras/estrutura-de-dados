package heap;

public class Heap {
	private Object[] heap;
	private int capacidade;
	private int tamanho;
	
	public Heap(int capacidade) {
		heap = new Object[capacidade];
		this.capacidade = capacidade;
		tamanho = 0;
	}
	
	public void insert(int elemento) {
		if(tamanho >= capacidade - 1) {
			this.capacidade = capacidade * 2;
			Object[] novoHeap = new Object[capacidade];
			for(int i = 1; i <= tamanho; i++) {
				novoHeap[i] = heap[i];
			}
			heap = novoHeap;
		}
		heap[++tamanho] = elemento;
		upHeap(tamanho);
	}
	
	public Object removeMin() {
		if(isEmpty()) {
			throw new HeapException("Heap vazio!");
		}
		Object aux = min();
		heap[1] = heap[tamanho--];
		downHeap(1);
		return aux;
	}
	
	public void upHeap(int index) {
		if(index == 1 || (int) heap[parent(index)] <= (int) heap[index]) {
			return;
		}
		Object aux = heap[index];
        heap[index] = heap[parent(index)];
        heap[parent(index)] = aux;
        upHeap(parent(index));
	}
	
	public void downHeap(int index) {
		if(isExternal(index) || size() == 0) {
			return;
		}
		else if((int) heap[index] > (int) leftChild(index) || (int) heap[index] > (int) rightChild(index)) {
			Object aux = heap[index];
			if((int) leftChild(index) < (int) rightChild(index)) {
				heap[index] = leftChild(index);
				heap[left(index)] = aux;
				downHeap(left(index));
			}
			else {
				heap[index] = rightChild(index);
				heap[right(index)] = aux;
				downHeap(right(index));
			}
		}
	}
	
	public Object min() {
		return heap[1];
	}
	
	public int parent(int index) {
		return index / 2;
	}
	
	public int left(int index) {
		return index * 2;
	}
	
	public int right(int index) {
		return (index * 2) + 1;
	}	
	
	public Object leftChild(int index) {
		return heap[index * 2];
	}
	
	public Object rightChild(int index) {
		return heap[(index * 2) + 1];
	}
	
	public boolean isExternal(int index) {
		return index <= tamanho && index > parent(tamanho);
	}
	
	public int height() {
		int altura = 1;
		if (tamanho == 0) {
			altura = 0;
		}
		for (int i = 2; i <= tamanho; i = i * 2) {
			altura++;
		}
		return altura;
	}	
	
	public int size() {
		return tamanho;
	}
	
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	public void print() {
		int aux = 1;
		System.out.println("Fila de prioridade:");
        for(int i = 0; i <= height(); i++){
            for(int k = 0; k < Math.pow(2, i) && k + Math.pow(2, i) <= tamanho; k++) {
                for(int x = 0; x < tamanho / (Math.pow(2, i) + aux); x++) {
                    System.out.print("    ");
                }
                System.out.print(heap[k + (int) Math.pow(2, i)]);
                aux++;
            }
            System.out.println();
        }
	}
}
