package myproject01;

public class testClass2 {
	private int[] array;
	public testClass2(){};
	public void change(int[] array_p){
		for(int i=0;i<5;i++)
			array_p[i] = i;
		System.out.println(array_p.hashCode());
		array = array_p;
		System.out.println(array.hashCode());
		
	}
	public void change2(int[] array_p){
		for(int i=0;i<5;i++)
			array_p[i] = 5;
	}
}
