package database;

public class Person {

	//class variable
	static String name = "Lee";
	
	static void method() {}
	
	public static void main(String[] args) {
		
		Person p = new Person();
		Person.name = "Tejean";
		
		Person p2 = new Person();
		//p.name = "John";
		
		Person.method();
		
		System.out.println(p.name);
	}
}
