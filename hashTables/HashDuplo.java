package hashTables;

public class HashDuplo {
	private Elemento[] table;
	private int capacidade;
	private int tamanho;
	
	public HashDuplo(int capacidade) {
		table = new Elemento[capacidade];
		this.capacidade = capacidade;
		tamanho = 0;
	}
	
	public void insert(int chave, Object elemento) {
		if(tamanho >= capacidade - 1) {
			int novaCapacidade = capacidadePrima(capacidade);
			Elemento[] novaTable = new Elemento[novaCapacidade];
			for(int i = 0; i < capacidade; i++) {
				if(table[i] != null) {
					int fatormult = 0;
					int hashduplo = funcaoHashDuplo(novaTable[i].chave());
					int indexAux = funcaoHash(table[i].chave(), novaCapacidade, hashduplo, fatormult);
					System.out.println(indexAux);
					System.out.println(novaCapacidade);
					while(novaTable[indexAux] != null) {
						fatormult++;
						indexAux = funcaoHash(table[i].chave(), novaCapacidade, hashduplo, fatormult);
					}
					novaTable[indexAux] = table[i];
				}
			}
			table = novaTable;
			capacidade = novaCapacidade;
			insert(chave, elemento);
		}
		else {
			int fatormult = 0;
			int hashduplo = funcaoHashDuplo(chave);
			int index = funcaoHash(chave, capacidade, hashduplo, fatormult);
			while(table[index] != null && table[index].getElemento() != "AV") {
				fatormult++;
				index = funcaoHash(chave, capacidade, hashduplo, fatormult);
			}
			table[index] = new Elemento(chave, elemento);
			tamanho++;
		}
	}
	
	public Object remove(int chave) {
		int fatormult = 0;
		int hashduplo = funcaoHashDuplo(chave);
		int indice = funcaoHash(chave, capacidade, hashduplo, fatormult);
		while(table[indice] != null) {
			if(table[indice].chave() == chave) {
				Object aux = table[indice].getElemento();
				table[indice].setElemento("AV");;
				tamanho--;
				return aux;
			}
			fatormult++;
			indice = funcaoHash(chave,capacidade,hashduplo,fatormult);
		}
		return null;
	}
	
	public Object find(int chave) {
		int fatormult = 0;
		int hashduplo = funcaoHashDuplo(chave);
		int indice = funcaoHash(chave, capacidade, hashduplo, fatormult);
        while (table[indice] != null){
            if (table[indice].chave() == chave){
                return table[indice].elemento();
            }
            fatormult++;
            indice = funcaoHash(chave,capacidade,hashduplo,fatormult);
        }
        return null;
	}
	
	public int funcaoHash(int chave, int capacidade, int hashduplo, int fatormult) {
		return (chave + (fatormult * hashduplo)) % capacidade;
	}
	
	public int funcaoHashDuplo(int chave) {
		int valor = (3 - chave) % 3;
		if(valor == 0) {
			return 1;
		}
		else {
			return valor;
		}
	}
	
	public int capacidadePrima(int capacidade) {
		int novaCapacidade = capacidade * 2;
		while(ehPrimo(novaCapacidade) == false) {
			novaCapacidade++;
		}
		return novaCapacidade;
	}
	
	private boolean ehPrimo(int numero) {
		for(int i = 2; i < numero; i++) {
			if(numero % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public int size() {
		return tamanho;
	}
	
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	public void printHash() {
		for (int i = 0; i < capacidade; i++){
            if (table[i] != null && table[i].getElemento() != "AV"){
            	System.out.println(i + " : " + table[i].getElemento());
            }
        }
        System.out.println();
	}
}


		