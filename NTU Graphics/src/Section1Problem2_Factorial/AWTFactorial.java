package Section1Problem2_Factorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AWTFactorial extends JFrame implements ActionListener {

	JLabel integerLabel = new JLabel("Enter an integer ");
	JTextField integer = new JTextField("0", 6);
	JLabel factorialLabel = new JLabel("Factorial is ");
	JTextField factorial = new JTextField("1", 14);
	JButton resetButton = new JButton("Reset");
	
	
	AWTFactorial() {
		
		super("AWT Factorial");
		setSize(425, 175);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GridLayout layout = new GridLayout(3, 1, 10, 10);
		setLayout(layout);
		
		JPanel topRow = new JPanel();
		FlowLayout topLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		topRow.setLayout(topLayout);
		topRow.add(integerLabel);
		integer.addActionListener(this);
		topRow.add(integer);
		add(topRow);
		
		JPanel midRow = new JPanel();
		FlowLayout midLayout  = new FlowLayout(FlowLayout.CENTER, 10, 10);
		midRow.setLayout(midLayout);
		midRow.add(factorialLabel);
		/** This text field should be only used for display.  */
		factorial.setEnabled(false);
		midRow.add(factorial);
		add(midRow);
		
		JPanel bottomRow = new JPanel();
		FlowLayout bottomLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		bottomRow.setLayout(bottomLayout);
		resetButton.addActionListener(this);
		bottomRow.add(resetButton);
		add(bottomRow);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		Object source = event.getSource();
		
		if (source == integer) {
			/** n must be converted to integer or it has NumberFormatException.  
			 * n can only be between -16 and 16, any number greater or lesser 
			 * will result in factorial being too big or too small for the 
			 * primitive variable to store, and result will be weird.  */
			try {
				int n = Integer.parseInt(integer.getText());
				int calcFactorial;				
				/** 0! is 1.  */
				if (n == 0) {
					factorial.setText("1");
				}
				/** For positive numbers.  */
				else if (n <= 16 && n >= 1) {
					calcFactorial = 1;
					for (int i = 1; i <= n; i++) {
						calcFactorial = calcFactorial * i;
					}
					factorial.setText(Integer.toString(calcFactorial));
				}
				/** For negative numbers.  */
				else if (n >= -16 && n <= -1) {
					calcFactorial = -1;
					n = Math.abs(n);
					for (int i = 1; i <= n; i++) {
						calcFactorial = calcFactorial * i;
					}
					factorial.setText(Integer.toString(calcFactorial));
				}
				else { // It's for n > 16 or n < -16.  
					/** Throws a custom exception if n is out of range.  */
					throw new OutOfRangeException();
				}
			}
			catch (NumberFormatException e) {
				factorial.setText("Not an integer!");
			}
			/** My own custom exception.  */
			catch (OutOfRangeException e) {
				factorial.setText("Out of range!");
			}
		}
		else { // source is reset.  
			integer.setText("0");
			factorial.setText("1");
		}
		
	}
	
	
	public static void main(String args[]) {
		AWTFactorial frame = new AWTFactorial();
		frame.setVisible(true);
	}

}
