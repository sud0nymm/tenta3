package practicetentaex3;
import java.util.ArrayList;

public class Calculator {

	public Calculator() {}
	
	public double divide(double a, double b) {
		return a / b;
	}
	
	public double multiply (double a, double b) {
		return a * b;
	}
	
	public double calculate(String arg1) {

		// 	String f = ("10+5+2*5+1-2/2");
		double returner = 0.0;
		String[] numbers = arg1.split("[^\\d]+");
		String[] operators = arg1.split("[^\\D]+");
		
		ArrayList<String> operator = new ArrayList<String>();
		System.out.println(operators.length);
		for (int i = 0; i < operators.length; i++) {
			operator.add(operators[i]);
			System.out.print("\n" + operator.get(i));
		}
		
		operator.remove(0);
		
		ArrayList<Double> calc = new ArrayList<Double>();
		
		for (int i = 0; i < numbers.length; i++) {
			calc.add(Double.parseDouble(numbers[i]));
			System.out.print("\n"+ calc.get(i));
		}
		
		int d = 0;
		for (int i = 0; i < operator.size() - d; i++) {
			if (operator.get(i).equals("*")) {
				double g = multiply(calc.get(i),calc.get(i + 1));
				calc.set(i , g);
				calc.remove(i+1);
				operator.remove(i);
				d++;
			}	
		}
		
		int f = 0;
		for (int i = 0; i < operator.size() - f; i++) {
			if (operator.get(i).equals("/")) {
				double g = divide(calc.get(i),calc.get(i + 1));
				calc.set(i, g);
				calc.remove(i+1);
				operator.remove(i);
				
			}
		}
		

		ArrayList<Double> negative = new ArrayList<Double>();
		
		for (int i = 0; i < operator.size(); i++) {
			if (operator.get(i).equals("-")) {
				negative.add(calc.get(i+1));
				calc.set(i+1, 0.0);
			}
		}
		
		for (int i = 0; i < calc.size(); i++) {
			returner += calc.get(i);	
		}
		System.out.println("return" + returner);
		for (int i = 0; i < negative.size(); i++) {
			returner = returner - negative.get(i);	
		}
		
		
		return returner;
	}
	
}







