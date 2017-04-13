package com.nineinfosys.android.otherscalculators.ohmcalculator;

public class Ohm {
	
	double Voltage;
	double Resistance;
	double power;
	double current;
	
	public double calculateCurrentFromVoltageResistance(double voltage, double resistance){
		double result;
		result=voltage/resistance;
		return result;
				
	}
	public double calculateCurrentFromVoltagePower(double power, double voltage){
		
		return power/voltage;		
				
	}
	public double calculateCurrentFromPowerResistance(double power, double resistance){
		double cur;
		 cur=(Math.sqrt(power/resistance));
		return cur;
	}
	
	
	public double calculateVoltageFromCurrentResistance(double current,double resistance)
	{
		double result;
		 result=(current*resistance);
		return result;
	}
	
	public double calculateVoltageFromCurrentpower(double current,double power)
	{ double vtg;
		vtg= (power/current);
		return vtg;
	}

	public double calculateVoltageFromResistancepower(double resistance,double power)
	{
		return (Math.sqrt(power/resistance));
		
	}

	
	public double calculateResistanceFromVoltagecurrent(double voltage,double current)
	{
		return (voltage/current);
	}


	public double calculateResistanceFromVoltagepower(double voltage,double power)
	{
		return (Math.pow(voltage, 2)/power);
	}

	public double calculateResistanceFromCurrentpower(double current,double power)
	{

		double res;
		res= (power/Math.pow(current, 2));
		return res;
	}

	
	public double calculatePowerFromVoltageresistance(double voltage,double resistance)
	{double pow;
		pow=(Math.pow(voltage, 2)/resistance);
		return pow;
	}
	
	public double calculatePowerFromVoltagecurrent(double voltage,double current)
	{
		 return (voltage*current);
	}
	public double calculatePowerFromResistancecurrent(double resistance,double current)
	{
		return (Math.pow(current, 2)*resistance);
	}





/*

	public static void main(String args[])
	{
		Ohm ohm= new Ohm();
		double result,current,voltage;
		result=ohm.calculateCurrentFromVoltageResistance(5,10);
		 System.out.print("\n Result is:"+result);
		current=ohm.calculateCurrentFromPowerResistance(10,20);
		System.out.print("\n current is:"+current);
		voltage=ohm.calculateVoltageFromCurrentResistance(10,20);
		 System.out.print("\n voltage is:"+voltage);
	}

*/

}
