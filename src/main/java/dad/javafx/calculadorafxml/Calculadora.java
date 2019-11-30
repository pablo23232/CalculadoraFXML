package dad.javafx.calculadorafxml;

/**
 * Implementaci�n de la l�gica de una calculadora.
 * @author Fran Vargas
 */
public class Calculadora {
	
	public static final char IGUAL = '='; 
	public static final char SUMAR = '+'; 
	public static final char RESTAR = '-'; 
	public static final char DIVIDIR = '/'; 
	public static final char MULTIPLICAR = '*';
	
	private static final char COMA = '.'; 
	
	private Double operand;
	private char operator;
	private Boolean newOperand;
	private String screen;
	
	public Calculadora() {
		delete();
	}
	
	
	public String getScreen() {
		return screen;
	}
        public void operate(char operator) {
		newOperand = true;
		double operando2 = Double.parseDouble(screen);
		switch (this.operator) {
			case SUMAR: operand += operando2; break;
			case RESTAR: operand -= operando2; break;
			case MULTIPLICAR: operand *= operando2; break;
			case DIVIDIR: operand /= operando2; break;
			case IGUAL: operand = operando2; break;
		}
		this.operator = operator;
		screen = "" + operand;
	}
	
	public void delete() {
		operand = 0.0;
		operator = '=';
		deleteAll();
	}
	
	
	public void deleteAll() {
		newOperand = true;
		screen = "0.0";
	}
	
	
	
	
        public void insert(char digit) {
		if (digit >= '0' && digit <= '9') {
			if (newOperand) {
				newOperand = false;
				screen = "";
			}
			screen += digit;
		} else if (digit== COMA) {
			insertComa();
		}
	}
	
	public void insertComa() {
		if (!screen.contains("" + COMA)) {
			screen += COMA;
		}
	}
	
	
	
}
