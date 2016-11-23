package polymorphism;

public class test {
	
	public static void main(String[] args)
	{
	
		String str = new String("hello");
		
		if(str instanceof String){
			System.out.println("yes String");
		}
		if(str instanceof Object){
			System.out.println("yes Object");
			
		}
		Object ob = new Object();
		if(ob instanceof String ){
			System.out.println("yes Object to String ");	
		}
		Object ob2 = new String("ffff");
		if(ob2 instanceof String ){
			System.out.println("yes  String ");	
		}
	}
}
