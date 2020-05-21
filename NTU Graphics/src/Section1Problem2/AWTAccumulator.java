package Section1Problem2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AWTAccumulator extends JFrame implements ActionListener {

	JLabel row1Label = new JLabel("Enter an integer ");
	JTextField integer = new JTextField("0", 13);
	JLabel row2Label = new JLabel("Accumulated sum is ");
	JTextField sum = new JTextField("0", 13);
	JButton resetButton = new JButton("Reset");
	
	
	AWTAccumulator() {
		
		setTitle("AWT Accumulator");
		setSize(425, 175);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GridLayout layout = new GridLayout(3, 1, 10, 10);
		setLayout(layout);
		
		JPanel topRow = new JPanel();
		FlowLayout topLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		topRow.setLayout(topLayout);
		topRow.add(row1Label);
		integer.addActionListener(this);
		topRow.add(integer);
		add(topRow);
		
		JPanel midRow = new JPanel();
		FlowLayout midLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		midRow.setLayout(midLayout);
		midRow.add(row2Label);
		/** Sum should not be editable.  */
		sum.setEnabled(false);
		midRow.add(sum);
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
		
		String integerT = integer.getText();
		String sumT = sum.getText();
		
		/** For text fields, pressing Enter key should trigger this method.  */
		if (source == integer) {
			setTextField(integerT, sumT);
		}
		/** Resets both integer and sum to 0.  Re-enable integer text field if it's disabled.  */
		else { // source == resetButton
			integer.setEnabled(true);
			integer.setText("0");
			sum.setText("0");
		}
		
	}
	
	
	public void setTextField(String rIntegerT, String rSumT) {
		
		try {
			/** Sometimes when the program convert String to int, it may 
			 * have error, so if the input isn't an integer, throw error.  */
			int rInteger = Integer.parseInt(rIntegerT);
			int rSum = Integer.parseInt(rSumT);
			rSum = rSum + rInteger;
			/** Primitive type int cannot support number out of range.  
			 * So I have to throw an exception.  */
			if (rSum <= -2_147_483_648 || rSum >= 2_147_483_647) {
				throw new Exception();
			}
			sum.setText(Integer.toString(rSum));
		}
		catch (Exception e) {
			integer.setEnabled(false);
			sum.setText("ERROR");
		}
		
	}
	
	
	public static void main(String args[]) {
		AWTAccumulator frame = new AWTAccumulator();
		frame.setVisible(true);
	}
	
}
