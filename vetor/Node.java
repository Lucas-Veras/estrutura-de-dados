package vetor;

public class Node {
	private Node proximo;
	private Node anterior;
	private Object valor;
	
	public Node() {
	}
	
	public Node(Node proximo, Node anterior, Object valor) {
		this.proximo = proximo;
		this.anterior = anterior;
		this.valor = valor;
	}
	
	public Node getProximo() {
		return proximo;
	}
	
	public void setProximo(Node proximo) {
		this.proximo = proximo;
	}
	
	public Object getValor() {
		return valor;
	}
	
	public void setValor(Object valor) {
		this.valor = valor;
	}

	public Node getAnterior() {
		return anterior;
	}

	public void setAnterior(Node anterior) {
		this.anterior = anterior;
	}
}
