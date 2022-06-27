package pilhaEncadeada;

public class pilhaEncadeada implements IPilha {
	private Node primeiro;
	private Node ultimo;
	private int tamanho;
	
	public pilhaEncadeada() {
		primeiro = null;
		ultimo = primeiro;
		tamanho = 0;
	}
	
	public void push(Object o) {
		Node novo = new Node();
		novo.setValor(o);
		if(isEmpty()) {
			primeiro = novo;
			ultimo = primeiro;
		}
		else {
			novo.setProximo(primeiro);
			primeiro = novo;
		}
		tamanho++;
	}
	
	@Override
	public Object pop() throws PilhaVaziaException {
		if(isEmpty()) {
			throw new PilhaVaziaException("A pilha está vazia");
		}
		Object elemento = primeiro.getValor();
		primeiro = primeiro.getProximo();
		tamanho--;
		return elemento;
	}

	@Override
	public Object top() throws PilhaVaziaException {
		return primeiro.getValor();
	}

	@Override
	public boolean isEmpty() {
		return tamanho == 0;
	}

	@Override
	public int size() {
		return tamanho;
	}	
	
	public void mostrar() {
		Node percorre = primeiro;
		
		for(int i = 0; i < tamanho; i++) {
			System.out.println(percorre.getValor());
			percorre = percorre.getProximo();
		}
	}
}
