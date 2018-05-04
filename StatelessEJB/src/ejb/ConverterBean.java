package ejb;

import javax.ejb.Stateless;

@Stateless
public class ConverterBean implements ConverterInt {

	@Override
	public int addnum(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public double dollarToPeso(double dollar) {
		return dollar * 50;
	}
}
