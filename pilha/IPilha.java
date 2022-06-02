package pilha;

public interface IPilha {
	public void push(Object o);
	public boolean isEmpty();
	public Object pop() throws PilhaVaziaException;
	public Object top() throws PilhaVaziaException;
	public int size();
	public void mostrar();
}
