package hashTables;

public class TestesLinearProbing {

	public static void main(String[] args) {
		LinearProbing table = new LinearProbing(10);
		System.out.println("qtd elementos: " + table.size());
		table.insert(0,10);
		table.printHash();
		System.out.println("-----------------------");
		table.insert(10,14);
		table.printHash();
		System.out.println("-----------------------");
		table.insert(2,18);
		table.printHash();
		System.out.println("-----------------------");
		System.out.println(table.find(0).elemento());
		table.insert(12,5);
		table.printHash();
		System.out.println("-----------------------");
		System.out.println("Qtd elementos: " + table.size());
		System.out.println(table.find(12).elemento());
		System.out.println("Remove elemento: " + table.remove(0));
		System.out.println("Qtd elementos: " + table.size());
		table.printHash();
		System.out.println("-----------------------");
		table.insert(0,100);
		table.printHash();
	}

}
