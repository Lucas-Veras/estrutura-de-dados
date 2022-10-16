package arvoreAVL;

public class Node {

	private Object elemento;
	private Node pai;
	private Node filhoDireita;
	private Node filhoEsquerda;
	private int fb;
	
	public Node() {}
	
	public Node(Object elemento) {
		this.elemento = elemento;
		this.filhoDireita = null;
		this.filhoEsquerda = null;
		this.fb = 0;
	}
	
	public Object getElemento() {
		return elemento;
	}
	
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	
	public Node getPai() {
		return pai;
	}
	
	public void setPai(Node aux) {
		this.pai = aux;
	}
	
	public Node getFilhoDireita() {
		return filhoDireita;
	}
	
	public void setFilhoDireita(Node filhoDireita) {
		this.filhoDireita = filhoDireita;
	}
	
	public Node getFilhoEsquerda() {
		return filhoEsquerda;
	}
	
	public void setFilhoEsquerda(Node filhoEsquerda) {
		this.filhoEsquerda = filhoEsquerda;
	}
	
	public int getFb() {
		return fb;
	}

	public void setFb(int fb) {
		this.fb = fb;
	}
}
