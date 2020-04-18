package com.Assignment;

 /*
MachineLearning CLASS

Function:
- HashMaps store data for each feature
- fileReader() reads in the data from "MLdata.csv" file and stores them in an ArrayList
- Frequency() goes through each of the inputs and increments the correct frequency HashMap which
 the predict() then makes use of to calculate the chance of having the virus.
*/

import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;


public class MachineLearning
{
	ArrayList <Input> 	inputs = new ArrayList <Input>(); 
	double 				resultPositive;
	double 				resultNegative;
	float 				sum;
	Scanner 			myScanner;
	
	HashMap <String,Integer> 	temperature 	= new HashMap <String,Integer>();
	HashMap <Boolean,Integer> 	cough 			= new HashMap <Boolean,Integer>();
	HashMap <Boolean,Integer> 	achesPains 		= new HashMap <Boolean,Integer>();
	HashMap <Boolean,Integer> 	soreThroat 		= new HashMap <Boolean,Integer>();
	HashMap <Boolean,Integer> 	travelDanger 	= new HashMap <Boolean,Integer>();
	HashMap <Boolean,Integer> 	coronaVirus 	= new HashMap <Boolean,Integer>();
	
	HashMap <String,Integer> 	temperatureGivenCoronaVirus 	= new HashMap <String,Integer>();
	HashMap <Boolean,Integer> 	coughGivenCoronaVirus 			= new HashMap <Boolean,Integer>();
	HashMap <Boolean,Integer> 	achesPainsGivenCoronaVirus 		= new HashMap <Boolean,Integer>();
	HashMap <Boolean,Integer> 	soreThroatGivenCoronaVirus		= new HashMap <Boolean,Integer>();
	HashMap <Boolean,Integer> 	travelDangerGivenCoronaVirus 	= new HashMap <Boolean,Integer>();
	
	
	/// Constructor ///
	
	public MachineLearning(String filename)
	{
		fileReader("MLdata.csv");
		Frequency();
	}
	
	
	/// Methods ///

	//reads in the "MLdata.csv" file
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
	
	public void Frequency()
	{
		for (Input e : inputs)
		{
			increaseFrequency(temperature,e.getTemperature());
			increaseFrequency(cough,e.getCough());
			increaseFrequency(achesPains,e.getAchesPains());
			increaseFrequency(soreThroat,e.getSoreThroat());
			increaseFrequency(travelDanger,e.getTravelDanger());
			increaseFrequency(coronaVirus,e.getCoronaVirus());
			
			if (e.getCoronaVirus())
			{
				increaseFrequency(temperatureGivenCoronaVirus,e.getTemperature());
				increaseFrequency(coughGivenCoronaVirus,e.getCough());
				increaseFrequency(achesPainsGivenCoronaVirus,e.getAchesPains());
				increaseFrequency(soreThroatGivenCoronaVirus,e.getSoreThroat());
				increaseFrequency(travelDangerGivenCoronaVirus,e.getTravelDanger());
			}
		}
		return;
	}
	
	//Calculates the chance of getting the virus based on data given
	public double predict(Input testing)
	{
		sum 			= coronaVirus.get(true);
		resultPositive 	= temperatureGivenCoronaVirus.get(testing.getTemperature()) / sum;
		resultPositive 	= resultPositive * coughGivenCoronaVirus.get(testing.getCough()) / sum;
		resultPositive 	= resultPositive * achesPainsGivenCoronaVirus.get(testing.getAchesPains()) / sum;
		resultPositive 	= resultPositive * soreThroatGivenCoronaVirus.get(testing.getSoreThroat()) / sum;
		resultPositive 	= resultPositive * travelDangerGivenCoronaVirus.get(testing.getTravelDanger()) / sum;
		resultPositive 	= resultPositive * (float) coronaVirus.get(true) / inputs.size();
		
		sum 			= coronaVirus.get(false);
		resultNegative 	= (temperature.get(testing.getTemperature()) - temperatureGivenCoronaVirus.get(testing.getTemperature())) / sum;
		resultNegative 	= resultNegative * (cough.get(testing.getCough()) -coughGivenCoronaVirus.get(testing.getCough())) / sum;
		resultNegative 	= resultNegative * (achesPains.get(testing.getAchesPains()) - achesPainsGivenCoronaVirus.get(testing.getAchesPains())) / sum;
		resultNegative 	= resultNegative * (soreThroat.get(testing.getSoreThroat()) - soreThroatGivenCoronaVirus.get(testing.getSoreThroat())) / sum;
		resultNegative 	= resultNegative * (travelDanger.get(testing.getTravelDanger()) - travelDangerGivenCoronaVirus.get(testing.getTravelDanger())) / sum;
		resultNegative 	= resultNegative * (float) coronaVirus.get(false) / inputs.size();

		
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


