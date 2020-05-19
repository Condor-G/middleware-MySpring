package spring.test;

import spring.core.IoCApplicationContex;
import spring.core.RPCIoCProvider;

public class Server {
	public static void main(String[] args) throws Exception{
		IoCApplicationContex appCon = new IoCApplicationContex("spring/conf/bean_s.xml");
		RPCIoCProvider rpc = (RPCIoCProvider) appCon.getBean("server");
		rpc.start();
	}
}
