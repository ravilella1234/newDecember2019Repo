package pack2;

import pack1.Class1;

public class Class3 extends Class1
{
	int p=12,q=23,r;

	public Class3(int a, int b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) 
	{
		Class3 c3=new Class3(1000, 2000);
		c3.add();
		c3.sub();
	}

}
