package spring;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface MathService extends Remote {
	int add(int a,int b) throws RemoteException;
	int substract(int a,int b) throws RemoteException;
}
