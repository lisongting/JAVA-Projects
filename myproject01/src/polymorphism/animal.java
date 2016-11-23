package polymorphism;

public class animal {
	String str;
	public void voice()
	{
		System.out.println("¶¯Îï½Ğ");
	}
}

class dog extends animal{
	public void voice()
	{
		System.out.println("ÍôÍô");
	}
	
}

class cat extends animal{
	public void voice()
	{
		System.out.println("ß÷ß÷");
	}
}

