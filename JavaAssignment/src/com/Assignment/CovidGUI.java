package com.Assignment;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;


public class CovidGUI extends JFrame
{
	//Attributes
	private JTabbedPane   bookmarks;
	private JPanel		  DataLearning;
	private JPanel 	   	  SymptomsLearning;
	private JLabel 		  heading;
	private Font 		  font;

	
	//Constructor
	public CovidGUI()
	{
		super ("CoronaVirus Diagnostic Tool");
		setSize (400,500);
		setLayout (new BorderLayout());
		
		//Creating the GUI components and adding Tabs
		DataLearning 		= new JPanel();
		SymptomsLearning 	= new JPanel();
		bookmarks 			= new JTabbedPane();
		
		bookmarks.addTab ("Data Collection", DataLearning);
		bookmarks.addTab ("Checking Symptoms", SymptomsLearning);
		
		heading = new JLabel ("CoronaVirus Diagnostic Tool");
		
		//Adding aesthetics to the GUI
		Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		heading.setBorder (border);
		
		bookmarks.setBackground (Color.orange);
		heading.setForeground (Color.red);
		
		font = new Font ("Courier", Font.BOLD, 23);
		heading.setFont (font);
		
		//Add the GUI components to the frame
		add (heading,BorderLayout.NORTH);
		add (bookmarks,BorderLayout.CENTER);
		
		setVisible (true);
	}
}