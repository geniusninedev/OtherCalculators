package com.nineinfosys.android.otherscalculators.horsepower;

public class Horsepower {


	public double calculateHorsepower(double force, double distance,double time,String Force,String Distance,String Time){
		double result=0;
		if (Force.equals("newton")&& Distance.equals("meter")&& Time.equals("second")) {

			result = force * distance / time;
		}


		if (Force.equals("newton")&& Distance.equals("meter")&& Time.equals("minute")) {

			result = (force * distance / time)/60;
		}


		if (Force.equals("newton")&& Distance.equals("kilometer")&& Time.equals("second")) {

			result = (force * distance / time)/0.001;
		}

		else if((Force.equals("newton")&& Distance.equals("kilometer")&& Time.equals("minute")))
		{
			result = ((force * distance / time)/60)/0.001;
		}
		else if (Force.equals("kilonewton")&& Distance.equals("meter")&& Time.equals("second"))
		{
			result = (force * distance / time)/0.001;
		}
		else if (Force.equals("kilonewton")&& Distance.equals("kilometer")&& Time.equals("minute"))
		{
			result = (force * distance / time)/60;
		}

		else if (Force.equals("kilonewton")&& Distance.equals("meter")&& Time.equals("minute"))
		{
			result = (force * distance / time)/0.001;
		}

		else if (Force.equals("kilonewton")&& Distance.equals("kilometer")&& Time.equals("second"))
		{
			result = (force * distance / (time/60))/0.001;
		}

		return  result;
	}

/*	public static void main(String args[])
	{
		Horsepower power= new Horsepower();
		double result;
		result=power.calculateHorsepower(5,10,10);
		 System.out.print("\n Result is:"+result);
		
	}*/

}
