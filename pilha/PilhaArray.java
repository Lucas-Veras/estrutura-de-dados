package pilha;

public class PilhaArray implements IPilha {
	private Object[] a;
	private int capacidade;
	private int tamanho;
	
	public PilhaArray(int capacidade) {
		this.capacidade = capacidade;
		tamanho = -1;
		a = new Object[capacidade];
	}

	@Override
	public void push(Object o) {
		if(tamanho >= capacidade - 1) {
			this.capacidade = capacidade * 2;
			Object[] b = new Object[capacidade];
			for (int i = 0; i < a.length; i++) {
				b[i] = a[i];
			}
			a = b;
		}
		a[++tamanho] = o;
	}

	@Override
	public Object pop() throws PilhaVaziaException {
		if(isEmpty()) {
			throw new PilhaVaziaException("Pilha vazia");
		}
		return a[tamanho--];
	}

	@Override
	public Object top() throws PilhaVaziaException {
		if(isEmpty()) {
			throw new PilhaVaziaException("Pilha vazia");
		}
		return a[tamanho];
	}

	@Override
	public int size() {
		return tamanho + 1;
	}
	
	@Override
	public boolean isEmpty() {
		return tamanho == -1;
	}

	@Override
	public void mostrar() {
		for(int i = 0; i < size(); i++) {
			System.out.println(a[i]);
		}
	}
	
	
}
