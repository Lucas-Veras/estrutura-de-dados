package sequencia;

public class SequenciaDuplamenteEncadeada implements ISequencia{
	private Node header;
	private Node trailer;
	private int tamanho;
	
	public SequenciaDuplamenteEncadeada() {
		header = new Node(null, null, null); //proximo, anterior, elemento
		trailer = new Node(null, header, null);
		header.setProximo(trailer);
		tamanho = 0;
	}

	@Override
	public Object elemAtRank(Integer r) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		else if (r > (tamanho - 1) || r < 0) {
			throw new SequenciaVaziaException("A Sequência não possui esse índice");
		}
		return atRank(r).getValor();
	}

	@Override
	public Object replaceAtRank(Integer r, Object o) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		else if (r > (tamanho - 1) || r < 0) {
			throw new SequenciaVaziaException("A Sequência não possui esse índice");
		}
		Node node = atRank(r);
		Object elemento = node.getValor();
		node.setValor(o);
		return elemento;
	}

	@Override
	public void insertAtRank(Integer r, Object o) throws SequenciaVaziaException {
		if (r > size() || r < 0) {
			throw new SequenciaVaziaException("A Sequência não possui esse índice");
		}
		else if (tamanho != 0 && r == tamanho){
	        Node anterior = atRank(r);
	        Node proximo = trailer;
	        Node novo = new Node(proximo, anterior, o);
	        proximo.setAnterior(novo);
	        anterior.setProximo(novo);
	    }
	    else {
	        Node proximo = atRank(r);
	        Node anterior = proximo.getAnterior();
	        Node novo = new Node(proximo, anterior, o);
	        proximo.setAnterior(novo);
	        anterior.setProximo(novo);
	    }
		tamanho++;
	}

	@Override
	public Object removeAtRank(Integer r) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		else if (r > (tamanho - 1) || r < 0) {
			throw new SequenciaVaziaException("A Sequência não possui esse índice");
		}
		Node node = atRank(r);
		Node anterior = node.getAnterior();
		Node proximo = node.getProximo();
		anterior.setProximo(proximo);
		proximo.setAnterior(anterior);
		// Opcional ------------
		node.setAnterior(null);
		node.setProximo(null);
		//----------------------
		tamanho--;
		return node.getValor();
	}

	@Override
	public Object replaceElement(Node n, Object o) throws SequenciaVaziaException {
		if(n == null) {
			throw new SequenciaVaziaException("Nó inexistente!");
		}
		Object elemento = n.getValor();
		n.setValor(o);
		return elemento;
	}

	@Override
	public void swapElements(Node n, Node q) throws SequenciaVaziaException {
		if(n == null || q == null) {
			throw new SequenciaVaziaException("Nó inexistente!");
		}
		Object aux = n.getValor();
		n.setValor(q.getValor());
		q.setValor(aux);
	}

	@Override
	public void insertBefore(Node n, Object o) throws SequenciaVaziaException {
		if(n == null) {
			throw new SequenciaVaziaException("Nó inexistente!");
		}
		Node novo = new Node(n, n.getAnterior(), o);
		n.getAnterior().setProximo(novo);
		n.setAnterior(novo);
		tamanho++;
	}

	@Override
	public void insertAfter(Node n, Object o) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("A Sequencia está vazia!");
		}
		Node novo = new Node(n.getProximo(), n, o);
		n.getProximo().setAnterior(novo);;
		n.setProximo(novo);
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
	public Object remove(Node n) throws SequenciaVaziaException {
		if(n == null) {
			throw new SequenciaVaziaException("Nó inexistente!");
		}
		if (isEmpty()) {
			throw new SequenciaVaziaException("A Sequencia está vazia!");
		}
		n.getAnterior().setProximo(n.getProximo());
		n.getProximo().setAnterior(n.getAnterior());
		// Opcional
		n.setAnterior(null);
		n.setProximo(null);
		//---------
		tamanho--;
		return n.getValor();
	}

	@Override
	public Object first() throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		return header.getProximo().getValor();
	}

	@Override
	public Object last() throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		return trailer.getAnterior().getValor();
	}

	@Override
	public Object before(Node n) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		return n.getAnterior().getValor();
	}

	@Override
	public Object after(Node n) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia!");
		}
		return n.getProximo().getValor();
	}

	@Override
	public boolean isEmpty() {
		return tamanho == 0;
	}

	@Override
	public int size() {
		return tamanho;
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
	
	public Integer rankOf(Node node) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("A Sequencia está vazia!");
		}
		Node aux = header.getProximo();
		int r = 0;
		while (aux != node && aux != trailer) {
			aux = aux.getProximo();
			r++;
		}
		return r;
	}
	
	public void mostrar() {
		Node aux = header.getProximo();
		for(int i = 0; i < tamanho; i++) {
			System.out.println(aux.getValor());
			aux = aux.getProximo();
		}
	}
}
