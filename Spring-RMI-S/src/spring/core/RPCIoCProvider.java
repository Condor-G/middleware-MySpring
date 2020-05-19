package spring.core;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

import spring.MathService;

public class RPCIoCProvider {
	private MathService o;
	private String service;
	private String ip;
	private String port;
	
	public void setServiceInterface(String s) {
		this.service = s;
	}
	
	public void setTarget(MathService o) {
		this.o = o;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public void setPort(String port) {
		this.port = port;
	}
	
	public Object start() {
		try {
			LocateRegistry.createRegistry(Integer.parseInt(this.port)); 
	        String namePerson = "//" + ip + ":" + port + "/service";

	        //bind this instance to localhost port with name database
	        Naming.bind(namePerson, (Remote) o);
	        System.out.println("Server start...");
	        System.out.println(namePerson);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
        return o;
	}
}
