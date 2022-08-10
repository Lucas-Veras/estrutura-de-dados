package hashTables;

public class TestesHashDuplo {

	public static void main(String[] args) {
		HashDuplo table = new HashDuplo(10);
		System.out.println("Qtd elementos: " + table.size());
		table.insert(0,10);
		table.printHash();
		System.out.println("-----------------------");
		table.insert(10,14);
		table.printHash();
		System.out.println("-----------------------");
		table.insert(2,18);
		table.printHash();
		System.out.println("-----------------------");
		System.out.println("Elemento na chave 0: " + table.find(0));
		table.insert(12,5);
		table.printHash();
		System.out.println("-----------------------");
		System.out.println("Qtd elementos: " + table.size());
		System.out.println("Elemento na chave 12: " + table.find(12));
		System.out.println("Remove elemento da chave 0: " + table.remove(0));
		System.out.println("Qtd elementos: " + table.size());
		table.printHash();
		System.out.println("-----------------------");
		table.insert(0,100);
		table.printHash();
		System.out.println("Qtd elementos: " + table.size());
		System.out.println("Está vazio: " + table.isEmpty());
	}

}
