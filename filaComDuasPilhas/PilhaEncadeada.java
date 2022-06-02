package filaComDuasPilhas;

public class PilhaEncadeada implements IPilhaEncadeada{
	private Node primeiro;
	private Node ultimo;
	private int tamanho;
	
	public PilhaEncadeada() {
		primeiro = null;
		primeiro = ultimo;
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
	public Object pop() throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		Object elemento = primeiro.getValor();
		primeiro = primeiro.getProximo();
		tamanho--;
		return elemento;
	}

	@Override
	public Object top() throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		return ultimo.getValor();
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
	
	

	
