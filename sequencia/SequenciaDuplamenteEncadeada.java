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
		}// fazer o do primeiro elemento
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
	public Object replaceElement(int n, Object o) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		else if(n > size() - 1 || n < 0) {
			throw new SequenciaVaziaException("A Sequência não possui esse índice");
		}
		Node node = atRank(n);
		Object elemento = node.getValor();
		node.setValor(o);
		return elemento;
	}

	@Override
	public void swapElements(int n, int q) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A Sequência está vazia");
		}
		else if(n > size() - 1 || n < 0 || q > size() - 1 || q < 0) {
			throw new SequenciaVaziaException("A Sequência não possui esse índice");
		}
		Node node1 = atRank(n);
		Node node2 = atRank(q);
		Object aux = node1.getValor();
		node1.setValor(node2.getValor());
		node2.setValor(aux);
	}

	@Override
	public void insertBefore(int n, Object o) throws SequenciaVaziaException {
		if(n > size() - 1 || n < 0) {
			throw new SequenciaVaziaException("A Sequência não possui esse índice");
		}
		Node proximo = atRank(n);
		Node anterior = proximo.getAnterior();
		Node novo = new Node(proximo, anterior, o);
		proximo.setAnterior(novo);
		anterior.setProximo(novo);
		tamanho++;
	}

	@Override
	public void insertAfter(int n, Object o) throws SequenciaVaziaException {
		if(n > size() - 1 || n < 0) {
			throw new SequenciaVaziaException("A Sequência não possui esse índice");
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
	public Object remove(int n) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A Sequência está vazia");
		}
		else if(n > size() - 1 || n < 0) {
			throw new SequenciaVaziaException("A Sequência não possui esse índice");
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
	public Object before(int p) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		Node node = atRank(p);
		return node.getAnterior().getValor();
	}

	@Override
	public Object after(int p) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		Node node = atRank(p);
		return node.getProximo().getValor();
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
	
	public Integer rankOf(Node node) {
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
