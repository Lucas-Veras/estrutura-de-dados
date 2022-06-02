package filaEncadeada;

public class Node {
	private Node proximo;
	private Object valor;
	
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
}
