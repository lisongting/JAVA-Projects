package polymorphism;

public class animal {
	String str;
	public void voice()
	{
		System.out.println("�����");
	}
}

class dog extends animal{
	public void voice()
	{
		System.out.println("����");
	}
	
}

class cat extends animal{
	public void voice()
	{
		System.out.println("����");
	}
}

