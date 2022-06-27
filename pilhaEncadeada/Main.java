package pilhaEncadeada;

public class Main {

	public static void main(String[] args) throws PilhaVaziaException {
		pilhaEncadeada teste = new pilhaEncadeada();
		teste.push(1);
		teste.push(2);
		teste.push(3);
		teste.push(4);
		teste.push(5);
		teste.push(6);
		teste.mostrar();
		System.out.println("-----------");
		System.out.println("Retirado: " + teste.pop());
		System.out.println("Retirado: " + teste.pop());
		teste.mostrar();
		System.out.println("----------");
		teste.push(50);
		teste.push(60);
		teste.mostrar();
		System.out.println("----------");
		System.out.println("Top:"+teste.top());		
		System.out.println(teste.size());
		System.out.println(teste.isEmpty());
	}

}
