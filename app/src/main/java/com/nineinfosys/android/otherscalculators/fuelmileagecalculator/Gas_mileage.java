package com.nineinfosys.android.otherscalculators.fuelmileagecalculator;

public class Gas_mileage {
	double mileageatStart;
	double mileageatEnd;
	double gallonUsed;
	
	public Gas_mileage(double mileageatStart, double mileageatEnd, double gallonUsed) {
		super();
		this.mileageatStart = mileageatStart;
		this.mileageatEnd = mileageatEnd;
		this.gallonUsed = gallonUsed;
	}
	public double getMileageatStart() {
		return mileageatStart;
	}
	public void setMileageatStart(double mileageatStart) {
		this.mileageatStart = mileageatStart;
	}
	public double getMileageatEnd() {
		return mileageatEnd;
	}
	public void setMileageatEnd(double mileageatEnd) {
		this.mileageatEnd = mileageatEnd;
	}
	public double getGallonUsed() {
		return gallonUsed;
	}
	public void setGallonUsed(double gallonUsed) {
		this.gallonUsed = gallonUsed;
	}

	
	public double calculateGasmileage()
	{
		
		double result;
		result=(mileageatStart-mileageatEnd)/gallonUsed;
		return result;
	}
	
	
	public static void main(String args[])
	{
		Gas_mileage Mileage= new Gas_mileage(10,20,20);
		double result;
		result=Mileage.calculateGasmileage();
		 System.out.print("\n Gas Mileage per Gallon is:"+result);
		
	}
	
	
	
}
