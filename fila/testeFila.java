package fila;

public class testeFila {

	public static void main(String[] args) {
		Fila f = new Fila(2); //Método de duplicação
		f.enqueue(1);
		f.enqueue(2);
		f.enqueue(3);
		f.mostrar();
		f.enqueue(4);
		f.enqueue(5);
		f.mostrar();
		System.out.println("Retirado: " + f.dequeue());
		System.out.println("Retirado: " + f.dequeue());
		f.mostrar();
		f.enqueue(6);
		f.enqueue(7);
		f.mostrar();
		System.out.println("Retirado: " + f.dequeue());
		f.enqueue(8);
		f.enqueue(9);
		f.enqueue(10);
		f.enqueue(11);
		f.mostrar();
		try{
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			f.dequeue();
			f.mostrar();
		}catch(FilaVaziaException erro){
			System.out.println(erro.getMessage());
			
		}
	}

}
