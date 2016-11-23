package myproject01;

public class testClass1 {
	private static int[]array = {4,5,6,2,9};
	public static void main(String[] args) {
		
		for(int i=0;i<5;i++){
			System.out.println(array[i]);
		}
		new testClass2().change(array);
		for(int i=0;i<5;i++){
			System.out.println(array[i]);
		}
		new testClass2().change2(array);
		for(int i=0;i<5;i++){
			System.out.println(array[i]);
		}
		
	}

}
