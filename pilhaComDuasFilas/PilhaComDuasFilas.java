package pilhaComDuasFilas;

public class PilhaComDuasFilas implements IPilhaEncadeada {
	private FilaEncadeada fila1 = new FilaEncadeada();
	private FilaEncadeada fila2 = new FilaEncadeada(); 
	
	public PilhaComDuasFilas() {
		super();
	}

	@Override
	public void push(Object o) throws ListaVaziaException {
		fila1.enqueue(o);
	}

	@Override
	public Object pop() throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A Pila está vazia");
		}
		int tamanho = size();
		for (int i = 0; i < tamanho; i++) {
			fila2.enqueue(fila1.dequeue());
		}
		Object aux = null;
		tamanho = fila2.size();
		for (int i = 0; i < tamanho; i++) {
			if(i == tamanho - 1) {
				aux = fila2.dequeue();
			} else {
				fila1.enqueue(fila2.dequeue());
			}
		}
		return aux;
	}
	

	@Override
	public Object top() throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A Pilha está vazia");
		}
		int tamanho = size();
		for (int i = 0; i < tamanho; i++) {
			fila2.enqueue(fila1.dequeue());
		}
		Object elemento = null;
		tamanho = fila2.size();
		for (int i = 0; i < tamanho; i++) {
			if(i == tamanho - 1) {
				elemento = fila2.first();
				fila1.enqueue(fila2.dequeue());
			} else {
				fila1.enqueue(fila2.dequeue());
			}
		}
		return elemento;
	}
	

	@Override
	public int size() {
		return fila1.size();
	}

	@Override
	public boolean isEmpty() {
		return fila1.isEmpty();
	}
	
	public void mostrar() {
		fila1.mostrar();
	}
}
