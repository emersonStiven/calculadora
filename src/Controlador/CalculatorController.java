package Controlador;

import Modelo.CalculatorModel;
import Vista.CalculatorUI;
import javax.swing.*;

public class CalculatorController {
    CalculatorUI calculatorUI;
    CalculatorModel calculatorModel;
    private int result = 0, tempValue =0;
    private String operation = "";
    public CalculatorController(CalculatorUI view ) {
        calculatorUI = view;
        calculatorModel = new CalculatorModel();
        initControllers();
        initEqualsController();
    }

    public void initControllers(){

        calculatorUI.addButton.addActionListener( (event) -> {
            tempValue = convertDoubleToInt(calculatorUI.showScreen.getText());
            calculatorUI.showScreen2.setText(String.valueOf(tempValue));
            operation = "+";
            calculatorUI.showScreen.setText("");
        } );

        calculatorUI.minusButton.addActionListener( (event) -> {
            tempValue = convertDoubleToInt(calculatorUI.showScreen.getText());
            calculatorUI.showScreen2.setText(String.valueOf(tempValue));
            operation = "-";
            calculatorUI.showScreen.setText("");
        } );

        calculatorUI.mulButton.addActionListener( (event) -> {
            tempValue = convertDoubleToInt(calculatorUI.showScreen.getText());
            calculatorUI.showScreen2.setText(String.valueOf(tempValue));
            operation = "*";
            calculatorUI.showScreen.setText("");
        } );

        calculatorUI.divButton.addActionListener( (event) -> {
            tempValue = convertDoubleToInt(calculatorUI.showScreen.getText());
            calculatorUI.showScreen2.setText(String.valueOf(tempValue));
            operation = "/";
            calculatorUI.showScreen.setText("");
        } );

        calculatorUI.modButton.addActionListener( (event) -> {
            tempValue = convertDoubleToInt(calculatorUI.showScreen.getText());
            calculatorUI.showScreen2.setText(String.valueOf(tempValue));
            operation = "mod";
            calculatorUI.showScreen.setText("");
        } );

        calculatorUI.percentageButton.addActionListener( (event) -> {
            tempValue = convertDoubleToInt(calculatorUI.showScreen.getText());
            calculatorUI.showScreen2.setText(String.valueOf(tempValue));
            operation = "%";
            calculatorUI.showScreen.setText("");
        } );

        calculatorUI.factorialButton.addActionListener( (event) -> {
            int calculate = convertDoubleToInt(calculatorUI.showScreen.getText());
            try{
                calculatorUI.showScreen.setText(String.valueOf(calculatorModel.calculateFactorial(calculate)));
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        } );

        for(JButton button : calculatorUI.numbersButtons){
            button.addActionListener((event) ->{
                String val = event.getActionCommand();
                if(calculatorUI.showScreen.getText().equals("0")){
                    calculatorUI.showScreen.setText(val);
                }else{
                    calculatorUI.showScreen.setText(calculatorUI.showScreen.getText() +  val);
                }
            });
        }

        calculatorUI.clean.addActionListener((event) -> {
            calculatorUI.showScreen.setText("0");
            calculatorUI.showScreen2.setText("");
        });

    }
    public void initEqualsController (){
        calculatorUI.equals.addActionListener((event) ->{
            int val = 0, val2 =0;
            switch (operation){
                case "+":
                    val = Integer.parseInt(calculatorUI.showScreen2.getText());
                    val2 = Integer.parseInt(calculatorUI.showScreen.getText());
                    calculatorUI.showScreen2.setText(convertDoubleToInt(calculatorUI.showScreen2.getText()) + " + " + val2);
                    calculatorUI.showScreen.setText(String.valueOf(calculatorModel.sum(val, val2)));
                    break;
                case "-":{
                    val = Integer.parseInt(calculatorUI.showScreen2.getText());
                    val2 = Integer.parseInt(calculatorUI.showScreen.getText());
                    calculatorUI.showScreen2.setText(convertDoubleToInt(calculatorUI.showScreen2.getText()) + " - " + val2);
                    calculatorUI.showScreen.setText(String.valueOf(calculatorModel.subtract(val, val2)));
                    break;}
                case "*":
                    val = Integer.parseInt(calculatorUI.showScreen2.getText());
                    val2 = Integer.parseInt(calculatorUI.showScreen.getText());
                    calculatorUI.showScreen2.setText(convertDoubleToInt(calculatorUI.showScreen2.getText()) + " * " + val2);
                    calculatorUI.showScreen.setText(String.valueOf(calculatorModel.multiply(val, val2)));
                    break;
                case "/":
                    val = Integer.parseInt(calculatorUI.showScreen2.getText());
                    val2 = Integer.parseInt(calculatorUI.showScreen.getText());
                    calculatorUI.showScreen2.setText(convertDoubleToInt(calculatorUI.showScreen2.getText()) + " / " + val2);
                    try{
                        calculatorUI.showScreen.setText(String.valueOf(calculatorModel.divide(val, val2)));
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        calculatorUI.showScreen2.setText("");
                        calculatorUI.showScreen.setText("0");
                    }

                    break;
                case "mod":
                    val = Integer.parseInt(calculatorUI.showScreen2.getText());
                    val2 = Integer.parseInt(calculatorUI.showScreen.getText());
                    calculatorUI.showScreen2.setText(convertDoubleToInt(calculatorUI.showScreen2.getText()) + " mod " + val2);
                    calculatorUI.showScreen.setText(String.valueOf(calculatorModel.mod(val, val2)));
                    break;
                case "%":
                    val = Integer.parseInt(calculatorUI.showScreen2.getText());
                    val2 = Integer.parseInt(calculatorUI.showScreen.getText());
                    calculatorUI.showScreen.setText(String.valueOf(calculatorModel.calculatePercentage(val, val2)));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Unknown Operation");

            }
        });
    }
    public int convertDoubleToInt(String value){
        StringBuilder s = new StringBuilder(value);
        StringBuilder returnString = new StringBuilder();
        outer: for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '.'){
                break outer;
            }else{
                returnString.append(s.charAt(i));
            }
        }
        return Integer.parseInt(returnString.toString());
    }
}
