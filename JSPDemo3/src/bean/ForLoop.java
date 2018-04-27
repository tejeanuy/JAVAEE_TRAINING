package bean;

public class ForLoop {

	public static void main(String[] args) {
		String[] names = {"Tejean","Charlie"};
		
		// for every String name in names
		for(String name : names) {
			System.out.println(name);
		}
		
		for(int i = 0;i<names.length;i++) {
			System.out.println(names[i]);
		}
	}
}
