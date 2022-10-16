package fila;

public class teste {

	public static void main(String[] args) {
		int x = 1;
		for( int i = 1; i <= 128; i += i) {
			x += x;
		}
		System.out.println(x);

	}

}
