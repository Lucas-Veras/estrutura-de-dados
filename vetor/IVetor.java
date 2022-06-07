package vetor;

public interface IVetor {
	public Object elemAtRank(Integer r) throws VetorVazioException;
	public Object replaceAtRank(Integer r, Object o) throws VetorVazioException;
	public void insertAtRank(Integer r, Object o) throws VetorVazioException;
	public Object removeAtRank(Integer r) throws VetorVazioException;
	
	public boolean isEmpty();
	public int size();
}
