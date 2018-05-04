package client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.ConverterInt;

public class EJBClient {

	public EJBClient() throws NamingException {
		final Properties prop = new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY, 
				org.jboss.naming.remote.client.InitialContextFactory.class.getName());
		prop.put("jboss.naming.client.ejb.context", true);
		prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8082");
		InitialContext remoteContext = new InitialContext(prop);
		
		ConverterInt converter = (ConverterInt) remoteContext.lookup("StatelessEJB/ConverterBean!ejb.ConverterInt");
		System.out.println(converter.addnum(10, 20));
		System.out.println(converter.dollarToPeso(10));
	}
	
	public static void main(String[] args) throws NamingException {
		new  EJBClient();
	}
}
