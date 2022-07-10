package arvoreBinariaPesquisa;

public class Node {
	private Object elemento;
	private Node pai;
	private Node filhoDireita;
	private Node filhoEsquerda;
	
	public Node(Object elemento) {
		this.elemento = elemento;
		filhoEsquerda = null;
		filhoDireita = null;
		pai = null;
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
	
	public void setPai(Node pai) {
		this.pai = pai;
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
}
