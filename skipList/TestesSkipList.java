package skipList;

public class TestesSkipList {

	public static void main(String[] args) {
		SkipList skipList = new SkipList();
		
		skipList.insert(10);
        skipList.insert(20);
        skipList.insert(30);
        skipList.insert(40);
        skipList.printSkipList();
        System.out.println("Remover 50: "+ skipList.remove(50));
        System.out.println("Remover 10: " + skipList.remove(10));
        System.out.println("---------------------------------");
        skipList.printSkipList();
        skipList.insert(70);
        skipList.printSkipList();
        System.out.println("Remover 90: " + skipList.remove(90));
        System.out.println("Remover 20: "+ skipList.remove(20));
        System.out.println("---------------------------------");
        System.out.println("Buscar 35: " + skipList.busca(35));
        System.out.println("Buscar 70: " + skipList.busca(70));
	}

}
