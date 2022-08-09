package hashTables;

public class Elemento {
	private int chave;
	private Object elemento;
	
	public Elemento(int chave, Object elemento) {
		this.setChave(chave);
		this.setElemento(elemento);
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	
	public int chave() {
		return chave;
	}
	
	public Object elemento() {
		return elemento;
	}
}
