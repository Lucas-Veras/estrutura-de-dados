package lista;

public class ListaDuplamenteEncadeada implements ILista{
	private Node header;
	private Node trailer;
	private int tamanho;
	
	public ListaDuplamenteEncadeada() {
		header = new Node(null, null, null); //proximo, anterior, elemento
		trailer = new Node(null, header, null);
		header.setProximo(trailer);
		tamanho = 0;
	}
	
	@Override
	public Object replaceElement(int n, Object o) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		else if(n > size() - 1 || n < 0) {
			throw new ListaVaziaException("A lista não possui esse índice");
		}
		Node node = atRank(n);
		Object elemento = node.getValor();
		node.setValor(o);
		return elemento;
	}
	
	@Override
	public void swapElements(int n, int q) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		else if(n > size() - 1 || n < 0 || q > size() - 1 || q < 0) {
			throw new ListaVaziaException("A lista não possui esse índice");
		}
		Node node1 = atRank(n);
		Node node2 = atRank(q);
		Object aux = node1.getValor();
		node1.setValor(node2.getValor());
		node2.setValor(aux);
		
	}
	@Override
	public void insertBefore(int n, Object o) throws ListaVaziaException {
		if(n > size() - 1 || n < 0) {
			throw new ListaVaziaException("A lista não possui esse índice");
		}
		Node proximo = atRank(n);
		Node anterior = proximo.getAnterior();
		Node novo = new Node(proximo, anterior, o);
		proximo.setAnterior(novo);
		anterior.setProximo(novo);
		tamanho++;
				
	}
	@Override
	public void insertAfter(int n, Object o) throws ListaVaziaException {
		if(n > size() - 1 || n < 0) {
			throw new ListaVaziaException("A lista não possui esse índice");
		}
		Node anterior = atRank(n);
		Node proximo = anterior.getProximo();
		Node novo = new Node(proximo, anterior, o);
		anterior.setProximo(novo);
		proximo.setAnterior(novo);
		tamanho++;
	}
	@Override
	public void insertFirst(Object o) {
		Node anterior = header;
		Node proximo = header.getProximo();
		Node novo = new Node(proximo, anterior, o);
		anterior.setProximo(novo);
		proximo.setAnterior(novo);
		tamanho++;
	}
	@Override
	public void insertLast(Object o) {
		Node proximo = trailer;
		Node anterior = trailer.getAnterior();
		Node novo = new Node(proximo, anterior, o);
		proximo.setAnterior(novo);
		anterior.setProximo(novo);
		tamanho++;
	}
	
	@Override
	public Object remove(int n) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		else if(n > size() - 1 || n < 0) {
			throw new ListaVaziaException("A lista não possui esse índice");
		}
		Node node = atRank(n);
		Node anterior = node.getAnterior();
		Node proximo = node.getProximo();
		anterior.setProximo(proximo);
		proximo.setAnterior(anterior);
		// Opcional
		node.setAnterior(null);
		node.setProximo(null);
		//---------
		tamanho--;
		return node.getValor();
	}
	
	@Override
	public Object first() throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		return header.getProximo().getValor();
	}
	
	@Override
	public Object last() throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		return trailer.getAnterior().getValor();
	}
	
	@Override
	public Object before(int p) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		Node node = atRank(p);
		return node.getAnterior().getValor();
	}
	
	@Override
	public Object after(int p) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		Node node = atRank(p);
		return node.getProximo().getValor();
	}
	
	@Override
	public boolean isFirst(Object n) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		return n == header.getProximo().getValor();
	}
	
	@Override
	public boolean isLast(Object n) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		return n == trailer.getAnterior().getValor();
	}
	
	public Node atRank(Integer r) {
		Node node = new Node();
		if (r <= size()/2) {
			node = header.getProximo();
			for(int i = 0; i < r; i++) {
				node = node.getProximo();
			}
		}
		else {
			node = trailer.getAnterior();
			for(int i = 0; i < (size() - r - 1); i++) {
				node = node.getAnterior();
			}
		}
		return node;
	}
	
	public Integer rankOf(Node node) {
		Node aux = header.getProximo();
		int r = 0;
		while (aux != node && aux != trailer) {
			aux = aux.getProximo();
			r++;
		}
		return r;
	}
	
	@Override
	public int size() {
		return tamanho;
	}
	
	@Override
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	public void mostrar() {
		Node aux = header.getProximo();
		for(int i = 0; i < tamanho; i++) {
			System.out.println(aux.getValor());
			aux = aux.getProximo();
		}
	}
}
