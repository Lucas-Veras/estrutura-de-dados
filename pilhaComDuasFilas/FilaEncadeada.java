package pilhaComDuasFilas;

public class FilaEncadeada implements IFilaEncadeada {
	private Node primeiro;
	private Node ultimo;
	private int tamanho;
	
	public FilaEncadeada() {
		primeiro = null;
		primeiro = ultimo;
		tamanho = 0;
	}
	
	@Override
	public void enqueue(Object o) {
		Node novo = new Node();
		novo.setProximo(null);
		novo.setValor(o);
		if(isEmpty()) {
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
	public Object dequeue() throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		Object elemento = primeiro.getValor();
		primeiro = primeiro.getProximo();
		tamanho--;
		return elemento;
	}
	
	@Override
	public Object first() throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		return primeiro.getValor();
	}

	@Override
	public int size() {
		return tamanho;
	}

	@Override
	public boolean isEmpty() {
		return primeiro == null;
	}
	
	public void mostrar() {
		Node percorre = primeiro;
		
		for(int i = 0; i < tamanho; i++) {
			System.out.println(percorre.getValor());
			percorre = percorre.getProximo();
		}
	}
}
