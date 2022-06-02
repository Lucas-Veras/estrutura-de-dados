package pilhaEncadeada;

public interface IPilha {
	public void push(Object o);
	public Object pop() throws PilhaVaziaException;
	public Object top() throws PilhaVaziaException;
	public boolean isEmpty();
	public int size();
}
