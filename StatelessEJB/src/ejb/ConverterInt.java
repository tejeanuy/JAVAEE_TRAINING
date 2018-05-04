package ejb;

import javax.ejb.Remote;

@Remote
public interface ConverterInt {
	
	public int addnum(int num1, int num2);
	
	public double dollarToPeso(double dollar);

}