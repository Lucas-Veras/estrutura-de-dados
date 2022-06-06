package lista;

public class ListaArray implements ILista {
	private Object[] lista;
	private int capacidade;
	private int inicio;
	private int fim;
	
	public ListaArray(int capacidade) {
		inicio = 0;
		fim = -1;
		this.capacidade = capacidade;
		lista = new Object[capacidade];
	}
	
	@Override
	public Object replaceElement(int n, Object o) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		else if (n > (capacidade - 1) || n < 0) {
			throw new ListaVaziaException("A lista não possui esse índice");
		}
		Object elemento = lista[n];
		lista[n] = o;
		return elemento;
	}

	@Override
	public void swapElements(int n, int q) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		else if(n > fim || n < 0) {
			throw new ListaVaziaException("A lista não possui esse índice");
		}
		Object aux = lista[n];
		lista[n] = lista[q];
		lista[q] = aux;
	}

	@Override
	public void insertBefore(int n, Object o) throws ListaVaziaException {
		if(n > fim || n < 0) {
			throw new ListaVaziaException("A lista não possui esse índice");
		}
		else if(size() <= capacidade - 1) {
			this.capacidade = capacidade * 2;
			Object[] novo = new Object[capacidade];
			for (int i = 0; i <= n - 1; i++) {
				novo[i] = lista[i];
			}			
			for (int i = n; i < size() + 1; i++) {
				novo[i + 1] = lista[i];
			}
			lista = novo;
		}
		else {
			for(int i = n - 1; i < size(); i++) {
				lista[i + 1] = lista[i];
			}
		}
		fim++;
		lista[n] = o;
	}

	@Override
	public void insertAfter(int n, Object o) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		else if(n > fim || n < 0) {
			throw new ListaVaziaException("A lista não possui esse índice");
		}
		else if(size() <= capacidade - 1) {
			this.capacidade = capacidade * 2;
			Object[] novo = new Object[capacidade];
			for (int i = 0 ; i <= n ; i++) {
				novo[i] = lista[i];
			}
			for (int i = n + 1; i < size() ; i++) {
				novo[i + 1] = lista[i];
			}
			lista = novo;
		}
		else {
			for(int i = size(); i > n; i++) {
				lista[i] = lista[i - 1];
			}
		}
		fim++;
		lista[n + 1] = o;
	}

	@Override
	public void insertFirst(Object o) {
		if(size() <= capacidade - 1) {
			this.capacidade = capacidade * 2;
			Object[] novo = new Object[capacidade];
			for(int i = 0; i < size(); i++) {
				novo[i + 1] = lista[i];
			}
			lista = novo;
		}
		else {
			for(int i = 0; i < size(); i++) {
				lista[i + 1] = lista[i];
			}
		}
		fim++;
		lista[inicio] = o;
	}

	@Override
	public void insertLast(Object o) {
		if(size() <= capacidade - 1) {
			this.capacidade = capacidade * 2;
			Object[] novo = new Object[capacidade];
			for(int i = 0; i < size(); i++) {
				novo[i] = lista[i];
			}
			lista = novo;
		}
		lista[++fim] = o;
	}

	@Override
	public Object remove(int n) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		else if(n > fim || n < 0) {
			throw new ListaVaziaException("A lista não possui esse índice");
		}
		Object elemento = lista[n];
		for(int i = n; i < size() - 1; i++) {
			lista[i] = lista[i + 1];
		}
		fim--;
		return elemento;
	}

	@Override
	public Object first() throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		return lista[inicio];
	}

	@Override
	public Object last() throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		return lista[fim];
	}

	@Override
	public Object before(int p) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		else if(p > fim || p < 0) {
			throw new ListaVaziaException("A lista não possui esse índice");
		}
		return lista[p - 1];
	}

	@Override
	public Object after(int p) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		else if(p > fim || p < 0) {
			throw new ListaVaziaException("A lista não possui esse índice");
		}
		return lista[p + 1];
	}

	@Override
	public boolean isFirst(Object n) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		return n == lista[inicio];
	}

	@Override
	public boolean isLast(Object n) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A lista está vazia");
		}
		return n == lista[fim];
	}

	@Override
	public int size() {
		return fim + 1;
	}

	@Override
	public boolean isEmpty() {
		return fim == -1;
	}
	
	public void mostrar() {
		for(int i = 0; i < size(); i++) {
			System.out.println(lista[i]);
		}
	}
}
