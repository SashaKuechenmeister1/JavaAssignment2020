package com.Assignment;

public class Control
{
	public static void main(String[] args)
	{
		CovidGUI covidgui = new CovidGUI();
		
		MachineLearning ML = new MachineLearning("MLdata.csv");
		System.out.println("Chance of having covid19: "+ML.predict(new Input("hot",true,true,true,false))+"%");
	}
}

