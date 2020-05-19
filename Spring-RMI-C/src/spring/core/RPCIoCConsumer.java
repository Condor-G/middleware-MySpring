package spring.core;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

import spring.MathService;

public class RPCIoCConsumer {
	private MathService o;
	private String service;
	private String ip;
	private String port;
	
	public void setServiceInterface(String s) {
		this.service = s;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public void setPort(String port) {
		this.port = port;
	}
	
	public Object start() {
		try {
	        String namePerson = "//" + ip + ":" + port + "/service";
           	o = (MathService)Naming.lookup(namePerson);
	        System.out.println("Client start...");
	        System.out.println(namePerson);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
        return o;
	}
}
