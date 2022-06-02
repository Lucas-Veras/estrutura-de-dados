package fila;

public class Fila implements IFila {
	private Object a[];
	private int capacidade;
	private int inicio, fim;
	
	public Fila(int capacidade) {
		this.capacidade = capacidade;
		inicio = fim = 0;
		a = new Object[capacidade];
	}
	
	@Override
	public void enqueue(Object o) {
		if(size() == capacidade - 1) {
			int capacidadeAntiga = capacidade;
			int sizeAntigo = size();
			int aux = inicio;
			this.capacidade = capacidade * 2;
			Object[] b = new Object[capacidade];
			for(int i = 0; i <= size() - 1; i++) {
				 b[i] = a[aux];
				 aux = (aux + 1) % capacidadeAntiga;
			}
			a = b;
			inicio = 0;
			fim = sizeAntigo;
		}
		a[fim] = o;
		fim = (fim + 1) % capacidade;
	}
	
	@Override
	public Object dequeue() throws FilaVaziaException {
		if(isEmpty()) {
			throw new FilaVaziaException("A Fila está vazia!");
		}
		Object elemento = a[inicio];
		a[inicio] = null;
		inicio = (inicio + 1) % capacidade;
		return elemento;
	}

	@Override
	public Object first() throws FilaVaziaException {
		if(isEmpty()) {
			throw new FilaVaziaException("A Fila está vazia!");
		}
		return a[inicio];
	}

	@Override
	public int size() {
		return  (capacidade - inicio + fim) % capacidade;
	}

	@Override
	public boolean isEmpty() {
		return inicio == fim;
	}
	
	public void mostrar() {
		System.out.println("###### FILA ######");
		System.out.printf("%s%10s\n", " _______"," ________ ");
		System.out.printf("%s%10s\n", "|Indice " ,"|Valores |");
		System.out.printf("%s%10s\n", "|-------","|--------|");
		int aux = inicio;
		for(int i = 0; i < size(); i++) {
			System.out.printf("|%5d%3s%8d|\n", i," |" ,a[aux]);
			aux = (aux + 1) % capacidade;
		}
		System.out.printf("%s%10s\n", "|-------","|--------|");
		System.out.println("##################");
	}
}


