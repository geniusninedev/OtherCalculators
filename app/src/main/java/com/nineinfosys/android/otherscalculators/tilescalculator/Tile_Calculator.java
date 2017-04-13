package com.nineinfosys.android.otherscalculators.tilescalculator;

public class Tile_Calculator {

	public double area (double Width,double length)
	{
		double area=0;
		area=length*Width;
		return area;
	}

	public double calculateTilearea(double Width, double length,String tilespinner){
		double result=0;


		if(tilespinner.equals("12x12 inch"))  {
			result=length*Width;

		}


		else if((tilespinner.equals("6x6 inch")))
		{
		result=length*Width/0.25;
		}

		else if((tilespinner.equals("4x4 inch")))
		{
			result=length*Width*9;
		}




		return result;
				
	}
	
	/*public static void main(String args[])
	{
		Tile_Calculator power= new Tile_Calculator();
		double result;
		result=power.calculateTilearea(10,20);
		 System.out.print("\n Total Tile area in sq.ft:"+result);
		
	}
*/
}
