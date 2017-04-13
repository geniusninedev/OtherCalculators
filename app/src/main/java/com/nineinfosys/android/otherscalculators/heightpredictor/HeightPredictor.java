package com.nineinfosys.android.otherscalculators.heightpredictor;

public class HeightPredictor {
	double MotherHeight;
	double FatherHeight;
	double childHeight;
	double childWeight;
	String age;
	String unitHeight;
	String MotherheightUnit;



	public double CalculateboyHeight(double fatherHeight, double childHeight, double childWeight, double motherHeight,  String unitHeight)

	{
		double result=0;

		if (unitHeight.equals("cm"))


			result = (motherHeight + fatherHeight + 12.70) / 2;

		else if (unitHeight.equals("ft"))
		{
			result= ((motherHeight*30.4) + (fatherHeight*30.4) + 12.70) / 2;
		}
		return result;
		
	}
	
	
	
	public double CalculategirlHeight(double fatherHeight, double childHeight, double childWeight, double motherHeight, String unitHeight)
	{
		double girlheight=0;
		if (unitHeight.equals("cm")) {

			girlheight = ((fatherHeight + motherHeight) - 13) / 2;
		}
		else if (unitHeight.equals("ft"))
		{
			girlheight = (((fatherHeight*30.4) + (motherHeight*30.4)) - 13) / 2;
		}
		return girlheight;
		
	}
	

	/*public static void main(String args[])
	{
		HeightPredictor height =new HeightPredictor(160,170,100,10);
		double result,girlheight;
		result=height.CalculateboyHeight();
		girlheight=height.CalculategirlHeight();
		System.out.print("\n boy height is" +result+ "\n"+girlheight);
	}*/

}
