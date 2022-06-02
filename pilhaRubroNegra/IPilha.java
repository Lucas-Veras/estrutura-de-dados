package pilhaRubroNegra;

public interface IPilha {
	public void pushVermelho(Object o);
	public void pushPreto(Object o);

	public Object popVermelho() throws PilhaVaziaException;
	public Object popPreto() throws PilhaVaziaException;

	public Object topVermelho() throws PilhaVaziaException;
	public Object topPreto() throws PilhaVaziaException;

	public boolean isEmptyAll();
	public boolean isEmptyVermelho();
	public boolean isEmptyPreto();

	public int sizeAll();
	public int sizeVermelho();
	public int sizePreto();

	public void mostrarAll();
	public void mostrarVermelho();
	public void mostrarPreto();
}
