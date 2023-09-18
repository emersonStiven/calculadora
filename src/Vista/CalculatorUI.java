package Vista;

import Modelo.CalculatorModel;
import javax.swing.*;
import java.awt.*;
import Controlador.CalculatorController;

public class CalculatorUI extends JFrame {
    public JButton[] numbersButtons =  new JButton[10];
    public JTextField showScreen, showScreen2;
    public JButton addButton, minusButton, mulButton, divButton, modButton, percentageButton, factorialButton, clean, equals;
    CalculatorController controller;

    public CalculatorUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setIconImage(new ImageIcon("src/assets/icon.png").getImage());
        setResizable(false);
        setLocationRelativeTo(null);
        initComponents();
        controller = new CalculatorController(this );
        pack();
        setVisible(true);
    }

    private void initComponents(){
        setLayout(new BorderLayout());
        Font buttonFont = new Font("Arial", Font.PLAIN, 18);

        JPanel screens = new JPanel();
        screens.setLayout(new BoxLayout(screens, BoxLayout.Y_AXIS));

        showScreen = new JTextField();
        showScreen.setFont(buttonFont);
        showScreen.setText("0");
        showScreen.setEditable(false);
        showScreen.setHorizontalAlignment(JTextField.RIGHT);

        showScreen2 = new JTextField();
        showScreen2.setFont(buttonFont);
        showScreen2.setEditable(false);
        showScreen2.setHorizontalAlignment(JTextField.RIGHT);
        screens.add(showScreen2);
        screens.add(showScreen);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 3, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));

        numbersButtons = new JButton[10];
        for(int i = 9; i>=0; i--){
            JButton b = new JButton(String.valueOf(i));
            b.setFont(buttonFont);
            numbersButtons[i] = b;
            buttonPanel.add(numbersButtons[i]);
        }
        equals = new JButton("=");
        buttonPanel.add(equals);
        clean = new JButton("Reset");
        buttonPanel.add(clean);

        addButton = new JButton("+");
        addButton.setFont(buttonFont);

        minusButton = new JButton("-");
        minusButton.setFont(buttonFont);

        mulButton = new JButton ("*");
        mulButton.setFont(buttonFont);

        divButton = new JButton("/");
        divButton.setFont(buttonFont);

        modButton = new JButton("mod");
        modButton.setFont(buttonFont);

        factorialButton = new JButton("!");
        factorialButton.setFont(buttonFont);

        percentageButton = new JButton("%");
        percentageButton.setFont(buttonFont);

        JPanel operationsPanel = new JPanel(new GridLayout(4, 3,5,5));
        operationsPanel.add(addButton);
        operationsPanel.add(minusButton);
        operationsPanel.add(mulButton);
        operationsPanel.add(divButton);
        operationsPanel.add(modButton);
        operationsPanel.add(factorialButton);
        operationsPanel.add(percentageButton);


        add(screens, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(operationsPanel, BorderLayout.EAST);


    }


}
