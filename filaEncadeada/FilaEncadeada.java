package filaEncadeada;

public class FilaEncadeada implements IFilaEncadeada {
	private Node primeiro;
	private Node ultimo;
	private int tamanho;
	
	public FilaEncadeada() {
		primeiro = null;
		tamanho = 0;
		ultimo = primeiro;
	}
	
	@Override
	public void enqueue(Object o) {
		Node novo = new Node();
		novo.setProximo(null);
		novo.setValor(o);
		if (isEmpty()) {
			primeiro = novo;
			ultimo = primeiro;		
		}
		else {
			ultimo.setProximo(novo);
			ultimo = novo;
		}
		tamanho++;
	}

	@Override
	public Object dequeue() throws FilaVaziaException {
		if(isEmpty()) {
			throw new FilaVaziaException("A fila est� vazia");
		}
		Node aux = primeiro;
		primeiro = aux.getProximo();
		tamanho--;
		return aux.getValor();
	}

	@Override
	public Object first() throws FilaVaziaException {
		if(isEmpty()) {
			throw new FilaVaziaException("A fila est� vazia");
		}
		return primeiro.getValor();
	}

	@Override
	public int size() {
		return tamanho + 1;
	}
	
	@Override
	public boolean isEmpty() {
		return primeiro == null;
	}
	
	public void mostrar() {
		Node percorre = primeiro;

		for (int i = 0; i < tamanho; i++) {
			System.out.println(percorre.getValor());
			percorre = percorre.getProximo();
		}
	}
}
