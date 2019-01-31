package org.htw.fiw;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.htw.fiw.FrontendServer;


public class FrontendServerImpl extends java.rmi.server.UnicastRemoteObject implements FrontendServer {

    private Double x;
    private Double y;
    private Double value;
    private int id;
    public static FrontendServer frontend;
    
    public FrontendServerImpl() throws RemoteException {
    	super();
    }
     
	public void receiveSensor(int id, Double x, Double y) throws RemoteException {
		this.setId(id);
		this.setX(x);
		this.setY(y);		
	}
	
	public void receiveValue(Double value) throws RemoteException {
		this.setValue(value);
	}
	
	public void receiveNewValue(int id, Double value) throws RemoteException {
		this.setValue(value);
	}
	
	public void startRmi() throws RemoteException {
	       try {
			    LocateRegistry.createRegistry(9876);
			   
			    frontend = new FrontendServerImpl();
			    Naming.rebind("rmi://localhost:9876/FrontendServer", frontend);
	 }	
	    catch (Exception e) {
	    System.err.println("Server exception: " + e.toString());
	    e.printStackTrace();
	}
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Double getX() throws RemoteException {
		return this.x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY()throws RemoteException {
		return this.y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getValue()throws RemoteException {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	}