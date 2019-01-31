package org.htw.fiw.vs;

import java.io.IOException;
import java.net.URI;
import java.rmi.RemoteException;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.htw.fiw.FrontendServer;
import org.htw.fiw.FrontendServerImpl;

public class RestServer {
	
	public RestServer() throws RemoteException {
		
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		FrontendServer frontend = new FrontendServerImpl();
		frontend.startRmi();
		
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:8080"),
				new ResourceConfig(Frontend.class));

		System.out.println("Press any key to close");
		System.in.read();
		server.stop();
	}
}
