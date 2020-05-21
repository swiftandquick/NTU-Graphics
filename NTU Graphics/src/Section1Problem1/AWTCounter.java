package Section1Problem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AWTCounter extends JFrame implements ActionListener {

	JLabel counterLabel = new JLabel("Counter");
	JTextField counter = new JTextField("0", 13);
	JButton countButton = new JButton("Count");
	
	AWTCounter() {
		
		super("AWT Counter");
		setSize(375, 125);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		setLayout(layout);
		
		add(counterLabel);
		
		/** That text field shouldn't be editable.  */
		counter.setEnabled(false);
		add(counter);
		
		countButton.addActionListener(this);
		add(countButton);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		Object source = event.getSource();
		
		if (source == countButton) {
			int currentCount = Integer.parseInt(counter.getText());
			currentCount++;
			counter.setText(Integer.toString(currentCount));
		}
				
	}
	
	
	public static void main(String args[]) {
		AWTCounter frame = new AWTCounter();
		frame.setVisible(true);
	}
	
}
