package com.nineinfosys.android.otherscalculators.squarefootage;

public class BodySurfaceAreaCalculator {
	 	private double weight;
	 	private double  height;



	
		
        public double bsaCalculator(double weight, double height, String weightunit, String HeightUnit)

		{
           double result=0;
			//if (weightunit.equals("kg") && HeightUnit.equals("cm")) {
				 result = (float) Math.pow(height * weight / 3600, 0.5);


			return result;
		}
		/*public static class bodySurfaceAreaMain {
			
			public static void main(String arg[])
			{
				BodySurfaceAreaCalculator bsacal=new BodySurfaceAreaCalculator(152,78);
				double result=bsacal.bsaCalculator();
				System.out.print("body surface area Value:"+result);
		
			}
		}*/

}
