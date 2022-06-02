package filaVector;
public interface IFila {
	public abstract void enqueue(Object o);
	public abstract Object dequeue();
	public Object first();
	public abstract int size();
	public abstract boolean isEmpty();
}
