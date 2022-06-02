package filaVector;
import java.util.Vector;

public class FilaVector implements IFila {
	private Vector<Object> fila;
	private int capacidade;
	private int inicio, fim;
	
	public FilaVector(int capacidade) {
		this.capacidade = capacidade;
		inicio = fim = 0;
		fila = new Vector<Object>();
	}
	
	@Override
	public void enqueue(Object o) {
		if(size() == capacidade - 1) {
			int capacidadeAntiga = capacidade;
			int sizeAntigo = size();
			int aux = inicio;
			this.capacidade = capacidade * 2;
			Vector<Object> fila2 = new Vector<Object>();
			for(int i = 0; i <= size() - 1; i++) {
				 fila2.add(i,fila.get(aux));
				 aux = (aux + 1) % capacidadeAntiga;
			}
			fila = fila2;
			inicio = 0;
			fim = sizeAntigo;
		}
		fila.add(fim, o);
		fim = (fim + 1) % capacidade;
	}

	@Override
	public Object dequeue() throws FilaVaziaException {
		if(isEmpty()) {
			throw new FilaVaziaException("A Fila está vazia!");
		}
		Object elemento = fila.get(inicio);
		fila.set(inicio, null);
		inicio = (inicio + 1) % capacidade;
		return elemento;
	}

	@Override
	public Object first() throws FilaVaziaException {
		if(isEmpty()) {
			throw new FilaVaziaException("A Fila está vazia!");
		}
		return fila.get(inicio);
	}

	@Override
	public int size() {
		return (capacidade - inicio + fim) % capacidade;
	}

	@Override
	public boolean isEmpty() {
		return inicio == fim;
	}
	
	public void mostrar() {
		int aux = inicio;
		for(int i = 0; i < size(); i++) {
			System.out.println(fila.get(aux));
			aux = (aux + 1) % capacidade;
		}
	}

}
