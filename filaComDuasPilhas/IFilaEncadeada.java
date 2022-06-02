package filaComDuasPilhas;

public interface IFilaEncadeada {
	public void enqueue(Object o) throws ListaVaziaException;
	public Object dequeue() throws ListaVaziaException;
	public Object first() throws ListaVaziaException;
	public int size();
	public boolean isEmpty();	
}
