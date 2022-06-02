package pilha;

public class Main {

	public static void main(String[] args) throws PilhaVaziaException {
		PilhaArray P1 = new PilhaArray(1);
		//PilhaVector P1=new PilhaVector();
		P1.push(1);
		P1.push(2);
		P1.push(3);
		P1.mostrar();
		//P1.empty();
		P1.push(4);
		P1.push(5);
		P1.mostrar();
		System.out.println(P1.top());
	}

}
