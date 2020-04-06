package com.Assignment;

public class Main {
	
	//// Attributes ////
	
	private String  temperature;
	private boolean cough;
	private boolean achesPains;
	private boolean soreThroat;
	private boolean travelDanger;
	private boolean covid19;
	
	//// Constructor ////
	
	public Main (String temperature, boolean cough, boolean travelDanger, boolean covid19)
	{
		setTemperature 	(temperature);
		setCough 		(cough);
		setTravelDanger (travelDanger);
		setCovid19 		(covid19);
	}
	
	public Main (String temperature, boolean cough, boolean achesPains, boolean soreThroat, boolean travelDanger, boolean covid19)
	{
		setTemperature 	(temperature);
		setCough 		(cough);
		setAchesPains 	(achesPains);
		setSoreThroat	(soreThroat);
		setTravelDanger (travelDanger);
		setCovid19 		(covid19);
	}
	
	//// Methods ////
	
	public String toString()
	{
		return 
		"Temperature: 		"+getTemperature()+
		"\nCough: 			"+getCough()+
		"\nAches n Pains: 	"+getAchesPains()+
		"\nSore Throat: 	"+getSoreThroat()+
		"\nTravelDanger: 	"+getTravelDanger()+
		"\nCovid19: 		"+getCovid19();
	}

	
	//// Getters & Setters ////

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
	public boolean isCough()
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
	public boolean isAchesPains()
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
	public boolean isSoreThroat()
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

	
	//travelled to dangerous area
	public boolean isTravelDanger()
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
	
	
	//covid19
	public boolean isCovid19()
	{
		return covid19;
	}
	public void setCovid19 (boolean covid19)
	{
		this.covid19 = covid19;
	}
	public void setCovid19 (String covid19)
	{
		if (covid19.equals ("yes"))
		{
			this.covid19 = true;
		}
		else
		{
			this.covid19 = false;
		}
	}

}
