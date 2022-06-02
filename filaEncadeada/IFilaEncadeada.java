package filaEncadeada;

public interface IFilaEncadeada {
	public void enqueue(Object o);
	public Object dequeue() throws FilaVaziaException;
	public Object first() throws FilaVaziaException;
	public int size();
	public boolean isEmpty();	
	public void mostrar();
}
