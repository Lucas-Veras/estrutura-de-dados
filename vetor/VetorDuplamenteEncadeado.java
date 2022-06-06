package vetor;

public class VetorDuplamenteEncadeado implements IVetor {
	private Node header;
	private Node trailer;
	private int tamanho;
	
	public VetorDuplamenteEncadeado() {
		header = new Node(null, null, null); //proximo, anterior, elemento
		trailer = new Node(null, header, null);
		header.setProximo(trailer);
		tamanho = 0;
	}

	@Override
	public Object elemAtRank(Integer r) throws VetorVazioException {
		if (isEmpty()) {
			throw new VetorVazioException("Vetor vazio!");
		}
		else if (r > (tamanho - 1) || r < 0) {
			throw new VetorVazioException("O vetor não possui esse rank!");
		}
		return atRank(r).getValor();
	}
	
	@Override
	public Object replaceAtRank(Integer r, Object o) throws VetorVazioException {
		if (isEmpty()) {
			throw new VetorVazioException("Vetor vazio!");
		}
		else if (r > (tamanho - 1) || r < 0) {
			throw new VetorVazioException("O vetor não possui esse rank!");
		}
		Node node = atRank(r);
		Object elemento = node.getValor();
		node.setValor(o);
		return elemento;
	}
	
	@Override
	public void insertAtRank(Integer r, Object o) throws VetorVazioException {
		if (r > size() || r < 0) {
			throw new VetorVazioException("O vetor não possui esse rank!");
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
	public Object removeAtRank(Integer r) throws VetorVazioException {
		if (isEmpty()) {
			throw new VetorVazioException("Vetor vazio!");
		}
		else if (r > (tamanho - 1) || r < 0) {
			throw new VetorVazioException("O vetor não possui esse rank!");
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
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	@Override
	public int size() {
		return tamanho;
	}
	
	public void mostrar() {
		Node aux = header.getProximo();
		for(int i = 0; i < tamanho; i++) {
			System.out.println(aux.getValor());
			aux = aux.getProximo();
		}
	}
	
}
