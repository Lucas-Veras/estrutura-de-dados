package sequencia;

public class SequenciaArray implements ISequencia{
	private Object[] array;
	private int inicio;
	private int fim;
	private int capacidade;
	
	public SequenciaArray(int capacidade) {
		array = new Object[capacidade];
		this.capacidade = capacidade;
		inicio = 0;
		fim = -1;
	}

	@Override
	public Object elemAtRank(Integer r) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		else if(r > fim || r < 0) {
			throw new SequenciaVaziaException("A sequência não possui esse índice");
		}
		return array[r];
	}

	@Override
	public Object replaceAtRank(Integer r, Object o) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		else if(r > fim || r < 0) {
			throw new SequenciaVaziaException("A sequência não possui esse índice");
		}
		Object elemento = array[r];
		array[r] = o;
		return elemento;
	}
	
	@Override
	public void insertAtRank(Integer r, Object o) throws SequenciaVaziaException {
		if(r > (capacidade - 1) || r < 0) {
			throw new SequenciaVaziaException("A sequência não possui esse índice");
		}
		else if(size() >= capacidade - 1) {
			this.capacidade = capacidade * 2;
			Object[] novo = new Object[capacidade];
			for(int i = 0; i < size(); i++) {
				novo[i] = array[i];
			}
			array = novo;
		}
		for(int i = size(); i > r; i--) {
			array[i] = array[i - 1];
		}
		fim++;
		array[r] = o;
	}

	@Override
	public Object removeAtRank(Integer r) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		else if(r > fim || r < 0) {
			throw new SequenciaVaziaException("A sequência não possui esse índice");
		}
		Object elemento = array[r];
		for(int i = r; i < size() - 1; i++) {
			array[i] = array[i + 1];
		}
		fim--;
		return elemento;
	}

	@Override
	public Object replaceElement(int n, Object o) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		else if(n > fim || n < 0) {
			throw new SequenciaVaziaException("A sequência não possui esse índice");
		}
		Object elemento = array[n];
		array[n] = o;
		return elemento;
	}

	@Override
	public void swapElements(int n, int q) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		else if(n > fim || n < 0) {
			throw new SequenciaVaziaException("A sequência não possui esse índice");
		}
		Object aux = array[n];
		array[n] = array[q];
		array[q] = aux;
	}

	@Override
	public void insertBefore(int n, Object o) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		else if(n > fim || n < 0) {
			throw new SequenciaVaziaException("A sequência não possui esse índice");
		}
		else if(size() >= capacidade) {
			this.capacidade = capacidade * 2;
			Object[] novo = new Object[capacidade];
			for(int i = 0; i < n; i++) {
				novo[i] = array[i];
			}
			for(int i = size(); i > n; i--) {
				novo[i] = array[i - 1];
			}
			array = novo;
		}
		else {
			for(int i = size(); i > n; i--) {
				array[i] = array[i - 1];
			}
		}
		fim++;
		array[n] = o;
	}

	@Override
	public void insertAfter(int n, Object o) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		else if(n > fim || n < 0) {
			throw new SequenciaVaziaException("A sequência não possui esse índice");
		}
		else if(size() >= capacidade) {
			this.capacidade = capacidade * 2;
			Object[] novo = new Object[capacidade];
			for(int i = 0; i <= n; i++) {
				novo[i] = array[i];
			}
			for(int i = size(); i > n + 1; i--) {
				novo[i] = array[i - 1];
			}
			array = novo;
		}
		else {
			for(int i = size(); i > n + 1; i--) {
				array[i] = array[i - 1];
			}
		}
		fim++;
		array[n + 1] = o;
	}
	
	@Override
	public void insertFirst(Object o) {
		if(size() >= capacidade) {
			this.capacidade = capacidade * 2;
			Object[] novo = new Object[capacidade];
			for(int i = size(); i > inicio; i--) {
				novo[i] = array[i - 1];
			}
			array = novo;
		}
		else {
			for(int i = size(); i > inicio; i--) {
				array[i] = array[i - 1];
			}
		}
		fim++;
		array[inicio] = o;
	}

	@Override
	public void insertLast(Object o) {
		if(size() >= capacidade) {
			this.capacidade = capacidade * 2;
			Object[] novo = new Object[capacidade];
			for(int i = 0; i < size(); i++) {
				novo[i] =  array[i]; 
			}
			array = novo;
		}
		array[++fim] = o;
	}

	@Override
	public Object remove(int n) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		else if(n > fim || n < 0) {
			throw new SequenciaVaziaException("A sequência não possui esse índice");
		}
		Object elemento = array[n];
		for(int i = n; i < size() - 1; i++) {
			array[i] = array[i + 1];
		}
		fim--;
		return elemento;
	}

	@Override
	public Object first() throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		return array[inicio];
	}

	@Override
	public Object last() throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		return array[fim];
	}

	@Override
	public Object before(int p) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		else if(p > fim || p < 0) {
			throw new SequenciaVaziaException("A sequência não possui esse índice");
		}
		return array[p - 1];
	}

	@Override
	public Object after(int p) throws SequenciaVaziaException {
		if(isEmpty()) {
			throw new SequenciaVaziaException("A sequência está vazia");
		}
		else if(p > fim || p < 0) {
			throw new SequenciaVaziaException("A sequência não possui esse índice");
		}
		return array[p + 1];
	}

	@Override
	public boolean isEmpty() {
		return fim == -1;
	}

	@Override
	public int size() {
		return fim + 1;
	}
	
	public void mostrar() {
		for(int i = 0; i < size(); i++) {
			System.out.println(array[i]);
		}
	}
}
