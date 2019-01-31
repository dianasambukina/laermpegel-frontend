package org.htw.fiw.vs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.File;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.FileInputStream;
import java.net.MalformedURLException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.htw.fiw.FrontendServer;

@Path("/FrontendServer")
public class Frontend extends UnicastRemoteObject {

	FrontendServer frontend;
	
	public Frontend() throws RemoteException {
		super();
	}
		
	@GET
	public String showMap() {
		String content = null;
		String path = new File("./index.html").getAbsolutePath();
		try {
			 File file = new File(path);
			 FileInputStream fis = null;
			 fis = new FileInputStream(file);
			 byte[] data = new byte[(int) file.length()];
			 fis.read(data);
			 fis.close();
			 content = new String(data, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

	@GET
	@Path("/{data}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response FrontendServer() {
		try { 
		frontend = (FrontendServer)Naming.lookup("rmi://localhost:9876/FrontendServer");
		} catch (Exception e) {
			e.printStackTrace();
		} 		
		return Response.status(201).entity(frontend).header("Access-Control-Allow-Origin", "*").build();
	}
}

