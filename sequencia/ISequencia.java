package sequencia;

public interface ISequencia {
	public Object elemAtRank(Integer r) throws SequenciaVaziaException;
	public Object replaceAtRank(Integer r, Object o) throws SequenciaVaziaException;
	public void insertAtRank(Integer r, Object o) throws SequenciaVaziaException;
	public Object removeAtRank(Integer r) throws SequenciaVaziaException;
	
	public Object replaceElement(Node n, Object o) throws SequenciaVaziaException;
	public void swapElements(Node n, Node q) throws SequenciaVaziaException;
	public void insertBefore(Node n, Object o) throws SequenciaVaziaException;
	public void insertAfter(Node n, Object o) throws SequenciaVaziaException;
	public void insertFirst(Object o);
	public void insertLast(Object o);
	public Object remove(Node n) throws SequenciaVaziaException;
	
	public Object first() throws SequenciaVaziaException;
	public Object last() throws SequenciaVaziaException;
	public Object before(Node n) throws SequenciaVaziaException;
	public Object after(Node n) throws SequenciaVaziaException;
	
	public boolean isEmpty();
	public int size();
}
