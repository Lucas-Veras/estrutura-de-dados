package filaComDuasPilhas;

public interface IPilhaEncadeada {
	public void push(Object o);
	public Object pop() throws ListaVaziaException;
	public Object top() throws ListaVaziaException;
	public int size();
	public boolean isEmpty();
}
