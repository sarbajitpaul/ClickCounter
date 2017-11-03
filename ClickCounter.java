package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClickCounter{
	private JFrame mainFrame;
	private JLabel clickLabel;
	private JPanel controlPanel;
	private JButton clickButton;
	private JButton endButton;
	private int counter;

	public ClickCounter(){
		mainFrame = new JFrame("Click Counter");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));

		clickLabel = new JLabel("0" , JLabel.CENTER);

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		clickButton = new JButton("Click");
		endButton = new JButton("End");

		controlPanel.add(clickButton);
		controlPanel.add(endButton);
		mainFrame.add(controlPanel);
		mainFrame.add(clickLabel);

		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});

		clickButton.addActionListener(new ButtonClickListener());
		endButton.addActionListener(new ButtonClickListener());

		clickButton.setActionCommand("CLICK");
		endButton.setActionCommand("END");

		mainFrame.setVisible(true);
	}

	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String command = e.getActionCommand();

			if(command == "CLICK"){
				counter++;
			}
			else if(command == "END"){
				String name = JOptionPane.showInputDialog(mainFrame , "Enter Name");
				System.out.println(name + " " + counter);
				counter = 0;
			}

			clickLabel.setText(counter + "");
		}
	}

	public static void main(String[] args){
		ClickCounter cc = new ClickCounter();
	}
}
