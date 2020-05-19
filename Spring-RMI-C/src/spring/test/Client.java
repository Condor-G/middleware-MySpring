package spring.test;

import spring.MathService;
import spring.core.IoCApplicationContex;
import spring.core.RPCIoCConsumer;

public class Client {
	public static void main(String[] args) throws Exception{
		IoCApplicationContex appCon = new IoCApplicationContex("spring/conf/bean_c.xml");
		RPCIoCConsumer rpc = (RPCIoCConsumer) appCon.getBean("client");
		MathService math = (MathService) rpc.start();
		
		int a = 10;
		int b = 20;
		int c = math.add(a,b);
		int d = math.substract(a,b);
		System.out.println(String.format("%d + %d = %d",a,b,c));
		System.out.println(String.format("%d - %d = %d",a,b,d));
	}
}
