// Filename: JResort.java
// Written by: Luigi Pisano
// Written on: September 4 2020

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// CLASS header
public class JResort extends JFrame implements ItemListener
{
	
		// VARIABLE(s) and CONSTANT(s)
	final int BASE_PRICE = 200;
	final int WEEKEND_PREMIUM = 100;
	final int BREAKFAST_PREMIUM = 20;
	final int GOLF_PREMIUM = 75;
	int totalPrice = BASE_PRICE;

	// INPUT(s)
	// Create 3 JCheckBox objects
	JCheckBox weekendBox = new JCheckBox("Weekend Premium: $" + WEEKEND_PREMIUM, false);
	JCheckBox breakfastBox = new JCheckBox("Breakfast: $" + BREAKFAST_PREMIUM, false);
	JCheckBox golfBox = new JCheckBox("Golf: $" + GOLF_PREMIUM, false);

	// Create four JLabel objects
	JLabel resortLabel = new JLabel("Resort Price Calculator");
	JLabel optionExplainLabel = new JLabel("Base price for a room is: $" + BASE_PRICE + ".");
	JLabel optionExplainLabel2 = new JLabel("Please, place a check for any of the options that you would like to add.");
	JLabel priceLabel = new JLabel("The price of your stay is: $");

	// Create one Jtext field object
	JTextField priceField = new JTextField(4);

	// CALCULATION
	// Constructor method for this class
	public JResort()
	{
		super("Long Island Paradise Resort & Golf");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new FlowLayout());

		// add the various GUI components to the frame
		add(resortLabel);
		add(optionExplainLabel);
		add(optionExplainLabel2);
		add(weekendBox);
		add(breakfastBox);
		add(golfBox);
		add(priceLabel);
		add(priceField);

		// set the priceField value when the GUI loads
		priceField.setText("$" + totalPrice);

		// add the event listeners for the JCheckbox objects
		weekendBox.addItemListener(this);		
		breakfastBox.addItemListener(this);		
		golfBox.addItemListener(this);
	} // End of JResort constructor

	// event handling method for this GUI
	@Override
	public void itemStateChanged(ItemEvent event)
	{
		Object source = event.getSource();
		int select = event.getStateChange();

		// Decide which component triggered this event and adjust the price accordingly
		if(source == weekendBox)
		{
			//if the box is checked, add the premium
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += WEEKEND_PREMIUM;
			} // End of select IF statement
			else
			{
				totalPrice -= WEEKEND_PREMIUM;
			} // End of select ELSE statement
		} // End of weekendBox IF statement
		else if(source == breakfastBox)
		{
			//if the box is checked, add the premium
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += BREAKFAST_PREMIUM;
			} // End of select IF statement
			else
			{
				totalPrice -= BREAKFAST_PREMIUM;
			}  // End of select ELSE statement
		} // End of breakfastBox IF statement
		else // We're really saying the (source == golfBox) here because its the only possible option that's not defined
		{
			//if the box is checked, add the premium
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += GOLF_PREMIUM;
			} //End of select IF statement
			else
			{
				totalPrice -= GOLF_PREMIUM;
			} // End of select ELSE statement
		} // End of golfBox IF statement
		priceField.setText("$" + totalPrice);
	} // End of itemStateChanged method

	// MAIN method header
	public static void main(String[] args)
	{

		// VARIABLE(s) and CONSTANT(s)
		JResort aFrame = new JResort();

		// INPUT(s)
		aFrame.setSize(500, 200);
		aFrame.setVisible(true);
		// CALCULATION

		// OUTPUT(s)

	} // End of main(String[] args)
} // End of JResort