package dad.javafx.calculadorafxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CalculadoraController implements Initializable{
	
	Calculadora calculadora = new Calculadora();
	
	DoubleProperty resultado = new SimpleDoubleProperty(0.0);
	
	@FXML
	GridPane root;
	@FXML
	Label resultadoLabel;
	@FXML
	Button sieteButton;
	@FXML
	Button ochoButton;
	@FXML
	Button nueveButton;
	@FXML
	Button ceButton;
	@FXML
	Button cButton;
	@FXML
	Button cuatroButton;
	@FXML
	Button cincoButton;
	@FXML
	Button seisButton;
	@FXML
	Button multiplicaButton;
	@FXML
	Button divideButton;
	@FXML
	Button unoButton;
	@FXML
	Button dosButton;
	@FXML
	Button tresButton;
	@FXML
	Button restaButton;
	@FXML
	Button igualButton;
	@FXML
	Button ceroButton;
	@FXML
	Button comaButton;
	@FXML
	Button sumaButton;
	
	
	public CalculadoraController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/CalculadoraFXML.fxml"));
 		loader.setController(this);
		loader.load();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ceroButton.setOnAction(e -> onButtonAction('0'));
		unoButton.setOnAction(e -> onButtonAction('1'));
		dosButton.setOnAction(e -> onButtonAction('2'));
		tresButton.setOnAction(e -> onButtonAction('3'));
		cuatroButton.setOnAction(e -> onButtonAction('4'));
		cincoButton.setOnAction(e -> onButtonAction('5'));
		seisButton.setOnAction(e -> onButtonAction('6'));
		sieteButton.setOnAction(e -> onButtonAction('7'));
		ochoButton.setOnAction(e -> onButtonAction('8'));
		nueveButton.setOnAction(e -> onButtonAction('9'));
		
		
		multiplicaButton.setOnAction(e -> onButtonAction('*'));
                comaButton.setOnAction(e -> onButtonAction(','));
		sumaButton.setOnAction(e -> onButtonAction('+'));
		restaButton.setOnAction(e -> onButtonAction('-'));
		divideButton.setOnAction(e -> onButtonAction('/'));
		igualButton.setOnAction(e -> onButtonAction('='));
		cButton.setOnAction(e -> onButtonAction('c'));
		ceButton.setOnAction(e -> onButtonAction('C'));
		
	}
	private void onButtonAction(char c) {
		// TODO Auto-generated method stub
		if (Character.isDigit(c)) {
			calculadora.insert(c);
		}else {
			if(c == ',') {
				calculadora.insertComa();
			}else {
				switch (c) {
				case '+':
					calculadora.operate(Calculadora.SUMAR);
					break;
				case '-':
					calculadora.operate(Calculadora.RESTAR);
					break;
				case '*':
					calculadora.operate(Calculadora.MULTIPLICAR);
					break;
				case '/':
					calculadora.operate(Calculadora.DIVIDIR);
					break;
				case '=':
					calculadora.operate(Calculadora.IGUAL);
					break;
				case 'c':
					calculadora.delete();
					break;
				case 'C':
					calculadora.deleteAll();
					break;
				}
			}
		}
		resultadoLabel.setText(calculadora.getScreen());
	}
	
	public GridPane getRoot() {
		return root;
	}
}
