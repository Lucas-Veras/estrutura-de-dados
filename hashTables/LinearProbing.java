package hashTables;

public class LinearProbing {
	private Elemento[] table;
	private int capacidade;
	private int tamanho;
	
	public LinearProbing(int capacidade) {
		table = new Elemento[capacidade];
		this.capacidade = capacidade;
		tamanho = 0;
	}
	
	public void insert(int chave, Object elemento) {
		if(tamanho >= capacidade - 1) {
			int novaCapacidade = capacidade * 2;
			Elemento[] novaTable = new Elemento[novaCapacidade];
			for(int i = 0; i < capacidade; i++) {
				if(table[i] != null) {
					int novoIndex = funcaoHash(i,novaCapacidade);
					while(novaTable[novoIndex] != null) {
						novoIndex = (novoIndex + 1) % capacidade;
					}
					novaTable[novoIndex] = table[i];
				}
			}
			table = novaTable;
			capacidade = novaCapacidade;
			insert(chave, elemento);
		}
		else {
			int index = funcaoHash(chave, capacidade);
			while(table[index] != null && table[index].getElemento() != "AV") {
				index = (index + 1) % capacidade;
			}
			table[index] = new Elemento(chave, elemento);
			tamanho++;
		}
	}
	
	public Object remove(int chave) {
		int index = funcaoHash(chave, capacidade);
		Elemento aux = find(chave);
		Object elemento = aux.elemento();
		if(aux.chave() == chave) {
			table[index] = new Elemento(chave, "AV"); 
			tamanho--;
			return elemento;
		}
		return elemento;
	}
	
	public Elemento find(int chave) {
		int index = funcaoHash(chave, capacidade);
		int p = 0;
		while(p != capacidade) {
			Elemento c = table[index];
			if(c == null) {
				return null;
			} 
			else if(c.chave() == chave) {
				return c;
			} 
			else {
				index = (index + 1) % capacidade;
				p++;
			}
		}
		return null;
	}
	
	public int funcaoHash(int c, int capacidade) {
		return c % capacidade;
	}
	
	public int size() {
		return tamanho;
	}
	
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	public void printHash() {
		for(int i = 0; i < capacidade; i++) {
			if(table[i] != null && table[i].getElemento() != "AV") {
				System.out.println(i + " : " + table[i].getElemento());
			}
		}
	}
}
