package com.Assignment;

/*
 CovidGUI CLASS
 
 Function:
 - creates a Graphical User Interface
 - allows user to select their symptoms and calculate their chance of having the Coronavirus
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CovidGUI extends JFrame implements ActionListener
{	
	 
	/// Attributes ///
	
	JButton 			calChance;
	JCheckBox 			cough, achesPains, soreThroat, travelDanger;
	JPanel 				menu, select, symptoms;
	JLabel 				temperature, title;
	JComboBox<String>	selectTemp;
	int vgap;
	
	/// Constructor ///
	
	public CovidGUI()
	{
		super 		("CoronaVirus Diagnostic Tool");
		setSize 	(330,330); //size of GUI
		setLayout 	(new BorderLayout()); //for changing component positions
		setResizable(false); //stops user from changing the size of the GUI
		
		select = new JPanel();
		vgap = 5;
		select.setLayout(new GridLayout(7, 0, 0, vgap)); //used to make the GUI look neat and create better spacing
		
		//Title
		title = new JLabel("CoronaVirus Diagnostic Tool");
		title.setFont(new Font("Arial Black", Font.PLAIN, 20));
		title.setForeground(Color.red);
		
		//Main Menu Panel
		menu = new JPanel();	
	
		//add menu and title to GUI
		add(title, BorderLayout.NORTH);
		add(menu, BorderLayout.CENTER);

		//Symptoms Panel
		symptoms = new JPanel();
		symptoms.setLayout(new BorderLayout());
		symptoms.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Please select your symptoms: ")); //sub title
		menu.add(symptoms);
		
		//Temperature selection
		temperature = new JLabel("Temperature:");
		selectTemp = new JComboBox<>(new String[] {"Normal","Hot","Cold","Cool"}); // allow user to select one of 4 options in regards to their temperature
		selectTemp.setSelectedIndex(0); //automatically sets the selected temperature to "normal"
				
		//Symptoms Check Boxes
		cough = new JCheckBox("Cough");
		achesPains = new JCheckBox("Aches and Pains");
		soreThroat = new JCheckBox("Sore throat");
		travelDanger = new JCheckBox("Have you recently travelled to an infected area?");
		
		//added GUI aesthetics
		cough.setBackground(Color.orange);
		achesPains.setBackground(Color.orange);
		soreThroat.setBackground(Color.orange);
		travelDanger.setBackground(Color.orange);
		select.setBackground(Color.orange);
		temperature.setBackground(Color.orange);
		symptoms.setBackground(Color.orange);
		selectTemp.setBackground(Color.white);

		
		//adds everything else to the GUI
		select.add(cough);
		select.add(achesPains);
		select.add(soreThroat);
		select.add(travelDanger);
		select.add(temperature);
		select.add(selectTemp);
		symptoms.add(select, BorderLayout.NORTH);
	
		calChance = new JButton("Calculate Chance of having CoronaVirus"); //button to display calculations
		calChance.addActionListener(this);
		
		//adds the calChance button to the GUI
		select.add(calChance, BorderLayout.SOUTH);
		
		//makes the GUI visible
		setVisible (true);
		
	}
	/*	
	 	NOTE: I was unable to figure out how to calculate the chance of getting the virus using the GUI. In order to see if the
	 	calculations/machine learning part works, please change the symptoms values manually in the actionPerformed below and
	 	then click the "Calculate Chance of having CoronaVirus" button to see the result in the console. 
	 */
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == calChance)
		{
			//calls the predict method from the Machine Learning class to calculate the percentage of having the coronaVirus
			MachineLearning ML = new MachineLearning("MLdata.csv");
			//manually change the 1 string and 4 boolean values and then click the calculation button on the GUI to see result in console
			System.out.println("Chance of having the CoronaVirus: "+ML.predict(new Input("normal",false,true,false,true))+"%"); //temperature,cough,achesPains,soreThroat,travelDanger
		}

	}
	
}
	
	


