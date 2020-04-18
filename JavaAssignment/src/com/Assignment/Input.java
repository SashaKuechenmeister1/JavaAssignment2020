package com.Assignment;

/*
Input CLASS

Function:
- stores the data from the "MLdata.csv" file
- stores the symptoms attributes (temperature, cough, achesPains, soreThroat, travelDanger, coronaVirus)
 */

public class Input {
	
	/// Attributes ///
	
	private String  temperature;
	private boolean cough;
	private boolean achesPains;
	private boolean soreThroat;
	private boolean travelDanger;
	private boolean coronaVirus;
	
	/// Constructor ///
	
	public Input (String temperature, boolean cough, boolean achesPains, boolean soreThroat, boolean travelDanger)
	{
		setTemperature 	(temperature);
		setCough 		(cough);
		setAchesPains 	(achesPains);
		setSoreThroat	(soreThroat);
		setTravelDanger (travelDanger);
	}
	
	public Input (String[] parameters)
	{
		setTemperature	(parameters[0]);
		setCough		(parameters[1]);
		setAchesPains	(parameters[2]);
		setSoreThroat	(parameters[3]);
		setTravelDanger	(parameters[4]);
		setcoronaVirus	(parameters[5]);
	}

	/// Methods ///
	
	public String toString() //Automatically generated toString()
	{
		return "Input [temperature=" + temperature + ", cough=" + cough + ", achesPains=" + achesPains + ", soreThroat="
				+ soreThroat + ", travelDanger=" + travelDanger + ", coronaVirus=" + coronaVirus + "]";
	}

	
	/// Getters & Setters ///

	//temperature
	public String getTemperature()
	{
		return temperature;
	} 
	public void setTemperature (String temperature)
	{
		this.temperature = temperature;
	}

	
	//cough
	public boolean getCough()
	{
		return cough;
	}
	public void setCough (boolean cough)
	{
		this.cough = cough;
	}
	public void setCough (String cough)
	{
		if (cough.equals ("yes")) 
		{
			this.cough = true;
		}
		else
		{
			this.cough = false;
		}
	}

	
	//aches and pains
	public boolean getAchesPains()
	{
		return achesPains;
	}
	public void setAchesPains (boolean achesPains)
	{
		this.achesPains = achesPains;
	}
	public void setAchesPains (String achesPains)
	{
		if (achesPains.equals ("yes"))
		{
			this.achesPains = true;
		}
		else
		{
			this.achesPains = false;
		}
	}
	
	

	//sore throat
	public boolean getSoreThroat()
	{
		return soreThroat;
	}
	public void setSoreThroat (boolean soreThroat)
	{
		this.soreThroat = soreThroat;
	}
	public void setSoreThroat (String soreThroat)
	{
		if(soreThroat.equals ("yes"))
		{
			this.soreThroat =  true;
		}
		else
		{
			this.soreThroat = false;
		}
	}

	
	//travelled to infected area
	public boolean getTravelDanger()
	{
		return travelDanger;
	}
	public void setTravelDanger (boolean travelDanger)
	{
		this.travelDanger = travelDanger;
	}
	
	public void setTravelDanger (String travelDanger)
	{
		if (travelDanger.equals ("yes"))
		{
			this.travelDanger = true;
		}
		else
		{
			this.travelDanger = false;
		}
	}
	
	
	//coronaVirus
	public boolean getCoronaVirus()
	{
		return coronaVirus;
	}
	public void setcoronaVirus (boolean coronaVirus)
	{
		this.coronaVirus = coronaVirus;
	}
	
	public void setcoronaVirus (String coronaVirus)
	{
		if (coronaVirus.equals ("yes"))
		{
			this.coronaVirus = true;
		}
		else
		{
			this.coronaVirus = false;
		}
	}

}
