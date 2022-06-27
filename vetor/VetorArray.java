package vetor;

public class VetorArray implements IVetor {
	private Object[] array;
	private int capacidade;
	private int tamanho;
	
	public VetorArray(int capacidade) {
		this.capacidade = capacidade;
		tamanho = 0;
		array = new Object[capacidade];
	}
	
	@Override
	public Object elemAtRank(Integer r) throws VetorVazioException {
		if(isEmpty()) {
			throw new VetorVazioException("Vetor vazio!");
		}
		else if (r > size() || r < 0) {
			throw new VetorVazioException("O vetor não possui esse rank!");
		}
		return array[r];
	}
	
	@Override
	public Object replaceAtRank(Integer r, Object o) throws VetorVazioException {
		if(isEmpty()) {
			throw new VetorVazioException("Vetor vazio!");
		}
		else if (r > size() || r < 0) {
			throw new VetorVazioException("O vetor não possui esse rank!");
		}
		Object elemento = array[r];
		array[r] = o;
		return elemento;
	}

	@Override
	public void insertAtRank(Integer r, Object o) throws VetorVazioException {
		if (r > size() || r < 0) {
			throw new VetorVazioException("O vetor não possui esse rank!");
		}
		else if (size() >= capacidade - 1) {
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
		tamanho++;
		array[r] = o;
	}
	
	@Override
	public Object removeAtRank(Integer r) throws VetorVazioException {
		if(isEmpty()) {
			throw new VetorVazioException("Vetor vazio!");
		}
		else if (r > size() || r < 0) {
			throw new VetorVazioException("O vetor não possui esse rank!");
		}
		Object elemento = array[r];
		for(int i = r; i < size(); i++) {
			array[i] = array[i + 1];
		}
		tamanho--;
		return elemento;
	}
	
	@Override
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	@Override
	public int size() {
		return tamanho;
	}
	
	public void mostrar() {
		for(int i = 0; i < size(); i++) {
			System.out.println(array[i]);
		}
	}
	
}
