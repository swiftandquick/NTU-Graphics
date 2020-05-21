package Section1Problem1_Factorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AWTFactorial extends JFrame implements ActionListener {

	JLabel nLabel = new JLabel("n");
	JTextField n = new JTextField("1", 3);
	JLabel factorialLabel = new JLabel("factorial(n)");
	JTextField factorial = new JTextField("1", 12);
	JButton calculateButton = new JButton("Calculate");
	JButton previousButton = new JButton("Previous");
	JButton nextButton = new JButton("Next");
	JButton resetButton = new JButton("Reset");
	
	AWTFactorial() {
		
		setTitle("AWT Factorial");
		setSize(400, 130);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GridLayout layout = new GridLayout(2, 1, 10, 10);
		setLayout(layout);
		
		JPanel topRow = new JPanel();
		FlowLayout topLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		topRow.setLayout(topLayout);
		topRow.add(nLabel);
		n.addActionListener(this);
		topRow.add(n);
		topRow.add(factorialLabel);
		/** Since I am finding factorial, this field should be uneditable.  */
		factorial.setEnabled(false);
		topRow.add(factorial);
		add(topRow);
		
		JPanel bottomRow = new JPanel();
		FlowLayout bottomLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);		
		bottomRow.setLayout(bottomLayout);
		calculateButton.addActionListener(this);
		bottomRow.add(calculateButton);
		previousButton.addActionListener(this);
		bottomRow.add(previousButton);
		nextButton.addActionListener(this);
		bottomRow.add(nextButton);
		resetButton.addActionListener(this);
		bottomRow.add(resetButton);
		add(bottomRow);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		Object source = event.getSource();
		
		int currentN = 0;
		
		/** currentN remains as 0 if I don't have a valid input.  */
		try {
			currentN = Integer.parseInt(n.getText());
		}
		catch (Exception e) {
			// Do nothing.  
		}
		
		if (source == calculateButton) {
			setTextField(currentN);
		}
		else if (source == previousButton) {
			currentN--;
			setTextField(currentN);
		}
		else if (source == nextButton) {
			currentN++;
			setTextField(currentN);
		}
		/** Resets everything.  */
		else { // for resetButton
			n.setText("1");
			factorial.setText("1");
			previousButton.setEnabled(true);
			nextButton.setEnabled(true);
		}
		
	}
	
	
	public void setTextField(int rCurrentN) {

		int currentFactorial;
		
		/** Primitive type can only support to display factorial of a number 
		 * between -16 and 16.  */
		if (rCurrentN >= -16 && rCurrentN <= 16) {
			n.setText(Integer.toString(rCurrentN));
			currentFactorial = findFactorial(rCurrentN);
			factorial.setText(Integer.toString(currentFactorial));
			previousButton.setEnabled(true);
			nextButton.setEnabled(true);
		}
		/** If n! is out of positive range, I can only go back.  */
		else if (rCurrentN == 17) {
			n.setText(Integer.toString(rCurrentN));
			factorial.setText("Out of range!");
			nextButton.setEnabled(false);
		}
		/** If n! is out of positive range, I can only go forward.  */
		else if (rCurrentN == -17) {
			n.setText(Integer.toString(rCurrentN));
			factorial.setText("Out of range!");
			previousButton.setEnabled(false);	
		}
		/** If a enter a number that is > 17 or < -17, even if I go 
		 * back or go forward, I cannot find a result that is within 
		 * the primitive type int's range.  So I must disable both 
		 * previous and next buttons.  */
		else {
			factorial.setText("Out of range!");
			previousButton.setEnabled(false);	
			nextButton.setEnabled(false);
		}
		
	}
	
	
	private int findFactorial(int rCurrentN) {
		
		int calcFactorial; 
		
		if (rCurrentN == 0) {
			return 1;
		}
		else if (rCurrentN > 0) {
			calcFactorial = 1;
			for (int i = 1; i <= rCurrentN; i++) {
				calcFactorial = calcFactorial * i;
			}
		}
		else { // if rCurrentN < 0
			calcFactorial = -1;
			rCurrentN = Math.abs(rCurrentN);
			for (int i = 1; i <= rCurrentN; i++) {
				calcFactorial = calcFactorial * i;
			}
		}
		return calcFactorial;
		
	}


	public static void main(String args[]) {
		AWTFactorial frame = new AWTFactorial();
		frame.setVisible(true);
	}
	
}
