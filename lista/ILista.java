package lista;

public interface ILista {
	public Object replaceElement(int n, Object o) throws ListaVaziaException;
	public void swapElements(int n, int q) throws ListaVaziaException;
	public void insertBefore(int n, Object o) throws ListaVaziaException;
	public void insertAfter(int n, Object o) throws ListaVaziaException;
	public void insertFirst(Object o);
	public void insertLast(Object o);
	public Object remove(int n) throws ListaVaziaException;
	
	public Object first() throws ListaVaziaException;
	public Object last() throws ListaVaziaException;
	public Object before(int p) throws ListaVaziaException;
	public Object after(int p) throws ListaVaziaException;
	
	public boolean isFirst(Object n) throws ListaVaziaException;
	public boolean isLast(Object n) throws ListaVaziaException;
	
	public int size();
	public boolean isEmpty();
}
