package GUI_Section2Problem2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AWTTest extends JFrame implements ActionListener {

	JLabel label = new JLabel("Number");
	JTextField display = new JTextField(2);
	JButton one = new JButton("1");
	JButton two = new JButton("2");
	JButton three = new JButton("3");
	
	AWTTest() {
		setTitle("AWT Test");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GridLayout layout = new GridLayout(2, 1, 10, 10);
		setLayout(layout);
		
		JPanel topRow = new JPanel();
		FlowLayout topLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		topRow.setLayout(topLayout);
		topRow.add(label);
		display.setEnabled(false);
		topRow.add(display);
		add(topRow);
		
		JPanel bottomRow = new JPanel();
		FlowLayout bottomLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		bottomRow.setLayout(bottomLayout);
		one.addActionListener(this);
		bottomRow.add(one);
		two.addActionListener(this);
		bottomRow.add(two);
		three.addActionListener(this);
		bottomRow.add(three);
		add(bottomRow);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == one) {
			display.setText("1");
		}
		else if (source == two) {
			display.setText("2");
		}
		else {
			display.setText("3");
		}
	}
	
	
	public static void main(String[] args) {
		AWTTest frame = new AWTTest();
		frame.setVisible(true);
	}
		
}
