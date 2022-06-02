package pilhaEncadeada;

@SuppressWarnings("serial")
public class PilhaVaziaException extends Exception {
	public PilhaVaziaException(String err) {
		super(err);
	}
}