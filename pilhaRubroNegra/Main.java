package pilhaRubroNegra;

public class Main {

	public static void main(String[] args) throws PilhaVaziaException {
		PilhaArray p1 = new PilhaArray(3);
		System.out.println("Está vazio? " + p1.isEmptyAll());
		p1.pushPreto(30);
		System.out.println("Está vazio? " + p1.isEmptyAll());
		System.out.println("Está vazio o vermelho? " + p1.isEmptyVermelho());
		System.out.println("Está vazio o preto? " + p1.isEmptyPreto());
		System.out.println("----------------------");
		p1.mostrarAll();
		p1.pushVermelho(5);
		System.out.println("Está vazio o vermelho? " + p1.isEmptyVermelho());
		p1.pushPreto(20);
		p1.pushVermelho(6);
		p1.pushPreto(10);
		p1.mostrarAll();
		System.out.println(p1.popPreto() + " foi retirado");
		p1.mostrarVermelho();
		p1.mostrarPreto();
		p1.pushVermelho(18);
		p1.pushPreto(200);
		p1.mostrarAll();
		p1.mostrarVermelho();
		p1.mostrarPreto();
	}
}
