package spring.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import spring.MathService;

public class MathServiceImpl extends UnicastRemoteObject implements MathService{

	public MathServiceImpl() throws RemoteException {super();}

	@Override
	public int add(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int substract(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a - b;
	}
	
}
