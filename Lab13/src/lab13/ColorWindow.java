package lab13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ColorWindow extends JFrame
{
	private JPanel mainPanel;
	private int numOfChanges = 0;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public ColorWindow() {
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setTitle("The Amazing Color Changing Window!!!");
		
		//Creating 3 buttons, Change, Reset, and Close
		JButton changerButton = new JButton("Change");
		JButton resetButton = new JButton("Reset");
		JButton closeButton = new JButton("Close");
		mainPanel = new JPanel();
		
		//Attach Buttons and Panel to Frame
		mainPanel.add(changerButton);
		mainPanel.add(resetButton);
		mainPanel.add(closeButton);
		add(mainPanel);
		
		//create button actions
		ColorChangeAction changerAction = new ColorChangeAction();
		ResetAction resetAction = new ResetAction();
		CloseAction closeAction = new CloseAction();
		
		//associate actions with buttons
		changerButton.addActionListener(changerAction);
		resetButton.addActionListener(resetAction);
		closeButton.addActionListener(closeAction);	
	}
	
	/* An action listener that sets the panel's background color */
	private class ColorChangeAction implements ActionListener
	{
		private Color[] backgroundColors = {Color.BLACK, Color.GREEN, Color.ORANGE, Color.PINK};
		private int backgroundColorIndex = 0;
		
		public void actionPerformed(ActionEvent event)
		{
			backgroundColorIndex = numOfChanges % 4;
			numOfChanges += 1;
			mainPanel.setBackground(backgroundColors[backgroundColorIndex]);
		}
	}
	
	/* An action listener that resets the number of changes made and returns the to the default color */
	private class ResetAction implements ActionListener
	{
		private Color defaultColor;
		
		public ResetAction()
		{
			defaultColor = mainPanel.getBackground();
		}
		
		public void actionPerformed(ActionEvent event)
		{
			numOfChanges = 0;
			mainPanel.setBackground(defaultColor);
		}
	}
	
	/* An action listener that closes the current window */
	private class CloseAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			dispose();
		}
	}
}
