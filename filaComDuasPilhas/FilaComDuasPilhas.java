package filaComDuasPilhas;

public class FilaComDuasPilhas implements IFilaEncadeada {
	private PilhaEncadeada pilha1 = new PilhaEncadeada();
	private PilhaEncadeada pilha2 = new PilhaEncadeada();
	
	public FilaComDuasPilhas() {
		super();
	}

	@Override
	public void enqueue(Object o) throws ListaVaziaException {
		int tamanho = size();
		for(int i = 0; i < tamanho; i++) {
			pilha2.push(pilha1.pop());
		}
		pilha2.push(o);
		tamanho = pilha2.size();
		for(int i = 0; i < tamanho; i++) {
			pilha1.push(pilha2.pop());
		}
	}

	@Override
	public Object dequeue() throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A fila está vazia");
		}
		return pilha1.pop();
	}
	
	@Override
	public Object first() throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A fila está vazia");
		}
		int tamanho = size();
		for(int i = 0; i < tamanho; i++) {
			pilha2.push(pilha1.pop());
		}
		Object elemento = pilha2.top();
		tamanho = pilha2.size();
		for(int i = 0; i < tamanho; i++) {
			pilha1.push(pilha2.pop());
		}
		return elemento;
	}

	@Override
	public int size() {
		return pilha1.size();
	}

	@Override
	public boolean isEmpty() {
		return pilha1.isEmpty();
	}
	
	public void mostrar() {
		pilha1.mostrar();
	}
}
