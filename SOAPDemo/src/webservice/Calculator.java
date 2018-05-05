package webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Calculator {

	@WebMethod
	public double add(double a, double b) {
		return a + b;
	}
	
	@WebMethod
	public double multiply(double a, double b) {
		return a * b;
	}
}
