package pilhaComDuasFilas;

public interface IPilhaEncadeada {
	public void push(Object o) throws ListaVaziaException;
	public Object pop() throws ListaVaziaException;
	public Object top() throws ListaVaziaException;
	public int size();
	public boolean isEmpty();
}
