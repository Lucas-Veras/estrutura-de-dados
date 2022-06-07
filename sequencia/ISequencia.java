package sequencia;

public interface ISequencia {
	public Object elemAtRank(Integer r) throws SequenciaVaziaException;
	public Object replaceAtRank(Integer r, Object o) throws SequenciaVaziaException;
	public void insertAtRank(Integer r, Object o) throws SequenciaVaziaException;
	public Object removeAtRank(Integer r) throws SequenciaVaziaException;
	
	public Object replaceElement(int n, Object o) throws SequenciaVaziaException;
	public void swapElements(int n, int q) throws SequenciaVaziaException;
	public void insertBefore(int n, Object o) throws SequenciaVaziaException;
	public void insertAfter(int n, Object o) throws SequenciaVaziaException;
	public void insertFirst(Object o);
	public void insertLast(Object o);
	public Object remove(int n) throws SequenciaVaziaException;
	
	public Object first() throws SequenciaVaziaException;
	public Object last() throws SequenciaVaziaException;
	public Object before(int p) throws SequenciaVaziaException;
	public Object after(int p) throws SequenciaVaziaException;
	
	public boolean isEmpty();
	public int size();
}
