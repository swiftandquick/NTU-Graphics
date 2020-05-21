package Section1Problem1_Countdown;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AWTCounter extends JFrame implements ActionListener {

	JLabel counterLabel = new JLabel("Counter");
	JTextField countdown = new JTextField("88", 13);
	JButton countButton = new JButton();
	
	
	AWTCounter() {
		
		setTitle("AWT Counter");
		setSize(375, 125);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		
		add(counterLabel);
		
		/** Countdown starts from 88.  */
		countdown.setEnabled(false);
		add(countdown);
		
		countButton.setText("Count Down");
		countButton.addActionListener(this);
		add(countButton);
		
	}
	
	
	@Override
	public void actionPerformed (ActionEvent event) {
		
		String cmd = event.getActionCommand();
		
		/** Gets currentCount in integer format.  */
		int currentCount = Integer.parseInt(countdown.getText());
		
		if (cmd.equals("Count Down")) {
			currentCount--;
			countdown.setText(Integer.toString(currentCount));
			if (currentCount == 0) {
				countButton.setText("Reset");
			}
		}
		else { // if cmd is "Reset".  
			currentCount = 88;
			countdown.setText(Integer.toString(currentCount));
			countButton.setText("Count Down");
		}
		
		
	}
	
	
	public static void main(String args[]) {
		AWTCounter frame = new AWTCounter();
		frame.setVisible(true);
	}
	
}
