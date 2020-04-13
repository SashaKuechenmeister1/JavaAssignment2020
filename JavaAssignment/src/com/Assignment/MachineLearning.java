package com.Assignment;

import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;


public class MachineLearning
{
	ArrayList <Input> inputs = new ArrayList <Input>();
	double resultPositive;
	double resultNegative;
	float sum;
	Scanner myScanner;
	
	HashMap <String,Integer> 	temperature 	= new HashMap <String,Integer>();
	HashMap <Boolean,Integer> 	cough 			= new HashMap <Boolean,Integer>();
	HashMap <Boolean,Integer> 	achesPains 		= new HashMap <Boolean,Integer>();
	HashMap <Boolean,Integer> 	soreThroat 		= new HashMap <Boolean,Integer>();
	HashMap <Boolean,Integer> 	travelDanger 	= new HashMap <Boolean,Integer>();
	HashMap <Boolean,Integer> 	covid19 		= new HashMap <Boolean,Integer>();
	
	HashMap <String,Integer> 	temperatureGivenCovid19 	= new HashMap <String,Integer>();
	HashMap <Boolean,Integer> 	coughGivenCovid19 			= new HashMap <Boolean,Integer>();
	HashMap <Boolean,Integer> 	achesPainsGivenCovid19 		= new HashMap <Boolean,Integer>();
	HashMap <Boolean,Integer> 	soreThroatGivenCovid19		= new HashMap <Boolean,Integer>();
	HashMap <Boolean,Integer> 	travelDangerGivenCovid19 	= new HashMap <Boolean,Integer>();
	
	
	/// Constructor ///
	
	public MachineLearning(String filename)
	{
		fileReader("MLdata.csv");
		setupFrequency();
	}
	
	
	/// Methods ///
	
	public boolean fileReader(String filename)
	{
		try
		{
			File file = new File("MLdata.csv");
			myScanner = new Scanner(file);
		}
		catch (Exception e)
		{
			System.out.println("This file is invalid");
			return false;
		}
		myScanner.nextLine();
		while (myScanner.hasNextLine()) inputs.add(new Input(myScanner.nextLine().split(",")));
		return true;
	}
	
	public void setupFrequency()
	{
		for (Input e : inputs)
		{
			increaseFrequency(temperature,e.getTemperature());
			increaseFrequency(cough,e.getCough());
			increaseFrequency(achesPains,e.getAchesPains());
			increaseFrequency(soreThroat,e.getSoreThroat());
			increaseFrequency(travelDanger,e.getTravelDanger());
			increaseFrequency(covid19,e.getCovid19());
			
			if (e.getCovid19())
			{
				increaseFrequency(temperatureGivenCovid19,e.getTemperature());
				increaseFrequency(coughGivenCovid19,e.getCough());
				increaseFrequency(achesPainsGivenCovid19,e.getAchesPains());
				increaseFrequency(soreThroatGivenCovid19,e.getSoreThroat());
				increaseFrequency(travelDangerGivenCovid19,e.getTravelDanger());
			}
		}
	}
	
	//Calculates the chance of getting the virus based on data given
	public double predict(Input testCase)
	{
		sum 			= covid19.get(true);
		resultPositive 	= temperatureGivenCovid19.get(testCase.getTemperature()) / sum;
		resultPositive 	= resultPositive * coughGivenCovid19.get(testCase.getCough()) / sum;
		resultPositive 	= resultPositive * achesPainsGivenCovid19.get(testCase.getAchesPains()) / sum;
		resultPositive 	= resultPositive * soreThroatGivenCovid19.get(testCase.getSoreThroat()) / sum;
		resultPositive 	= resultPositive * travelDangerGivenCovid19.get(testCase.getTravelDanger()) / sum;
		resultPositive 	= resultPositive * (float) covid19.get(true) / inputs.size();
		
		sum 			= covid19.get(false);
		resultNegative 	= (temperature.get(testCase.getTemperature()) - temperatureGivenCovid19.get(testCase.getTemperature())) / sum;
		resultNegative 	= resultNegative * (cough.get(testCase.getCough()) -coughGivenCovid19.get(testCase.getCough())) / sum;
		resultNegative 	= resultNegative * (achesPains.get(testCase.getAchesPains()) - achesPainsGivenCovid19.get(testCase.getAchesPains())) / sum;
		resultNegative 	= resultNegative * (soreThroat.get(testCase.getSoreThroat()) - soreThroatGivenCovid19.get(testCase.getSoreThroat())) / sum;
		resultNegative 	= resultNegative * (travelDanger.get(testCase.getTravelDanger()) - travelDangerGivenCovid19.get(testCase.getTravelDanger())) / sum;
		resultNegative 	= resultNegative * (float) covid19.get(false) / inputs.size();

		return resultPositive / (resultPositive+resultNegative) * 100;
	
	}
	
	public void increaseFrequency (HashMap <String,Integer> map, String k)
	{
		if (map.get(k) != null)
		{
			map.put(k,map.get(k)+1);
		}
		else
		{
			map.put(k,1);
		}
	}
	
	public void increaseFrequency (HashMap <Boolean,Integer> map, boolean k)
	{
		if (map.get(k) != null)
		{
			map.put(k,map.get(k)+1);
		}
		else
		{
			map.put(k,1);
		}
	}
}