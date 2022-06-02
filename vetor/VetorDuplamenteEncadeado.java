package vetor;

public class VetorDuplamenteEncadeado implements IVetor {
	private Node header;
	private Node trailer;
	private int tamanho;
	
	public VetorDuplamenteEncadeado() {
		header = null;
		trailer = header;
		tamanho = 0;
	}
	
	@Override
	public Object elemAtRank(Integer r) throws VetorVazioException {
		if (isEmpty()) {
			throw new VetorVazioException("Vetor vazio!");
		}
		else if(r > (tamanho - 1) || r < 0) {
			throw new VetorVazioException("O vetor não possui esse rank!");
		}
		
		return null;
	}
	
	@Override
	public Object replaceAtRank(Integer r, Object o) throws VetorVazioException {
		return null;
	}
	
	@Override
	public void insertAtRank(Integer r, Object o) throws VetorVazioException {
		
	}
	
	@Override
	public Object removeAtRank(Integer r) throws VetorVazioException {
		return null;
	}
	
	public Node AtRank(Integer r) {
		Node node = new Node();
		if(r <= size()/2) {
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
	
	@Override
	public boolean isEmpty() {
		return header == null;
	}
	
	@Override
	public int size() {
		return tamanho;
	}
	
	
}
