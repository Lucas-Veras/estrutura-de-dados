package hashTables;

public class TestesLinearProbing {

	public static void main(String[] args) {
		LinearProbing table = new LinearProbing(10);
		table.insert(0, 10);
		table.insert(0, 12);
		table.insert(1, 120);
		table.insert(3, 5);
		table.insert(3, 6);
		table.insert(13, 50);
		table.printHash();
		
		System.out.println(table.find(4).getElemento());
		System.out.println(table.remove(13));
		//perguntar sobre remove indice e sobre o find indice
	}

}
