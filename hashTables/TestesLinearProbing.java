package hashTables;

public class TestesLinearProbing {

	public static void main(String[] args) {
		LinearProbing table = new LinearProbing(7);
		System.out.println("Qtd elementos: " + table.size());
		table.insert(3,3);
		table.printHash();
		System.out.println("-----------------------");
		table.insert(10,10);
		table.printHash();
		System.out.println("-----------------------");
		table.insert(17,17);
		table.printHash();
		System.out.println("Remove elemento: " + table.remove(17));
		System.out.println("-----------------------");
		table.printHash();
//		System.out.println("-----------------------");
//		System.out.println(table.find(0).elemento());
//		table.insert(12,5);
//		table.printHash();
//		System.out.println("-----------------------");
//		System.out.println("Qtd elementos: " + table.size());
//		System.out.println(table.find(12).elemento());
//		System.out.println("Remove elemento: " + table.remove(0));
//		System.out.println("Qtd elementos: " + table.size());
//		table.printHash();
//		System.out.println("-----------------------");
//		table.insert(0,100);
//		table.printHash();
	}

}
