package com.nineinfosys.android.otherscalculators.fuelcostcalculator;

public class Fuel_Cost {


    public double Calculate_Fuel_cost(double typical_Distance, double gas_Price, double vehical_Efficiency, String distance, String effeciency, String price) {
        double result = 0;
        if (distance.equals("miles") && effeciency.equals("miles/gallon") && price.equals("/gallon"))
        {
            result = typical_Distance * gas_Price / vehical_Efficiency;
        }


        else if(distance.equals("kilometers") && effeciency.equals("miles/gallon") && price.equals("/gallon"))
        {
            result = (typical_Distance * gas_Price / vehical_Efficiency) /1.609;
        }

        else if(distance.equals("miles") && effeciency.equals("kilometers/liter") && price.equals("/gallon"))
        {
            result = (typical_Distance * gas_Price / vehical_Efficiency) *0.425144;
        }

        else if(distance.equals("miles") && effeciency.equals("kilometers/liter") && price.equals("/liter"))
        {
            result = (typical_Distance * gas_Price / vehical_Efficiency) *0.425144*3.785;
        }

        else if(distance.equals("kilometers") && effeciency.equals("kilometers/liter") && price.equals("/liter"))
        {
            result = (typical_Distance * gas_Price / vehical_Efficiency);
        }

        else if(distance.equals("kilometers") && effeciency.equals("kilometers/liter") && price.equals("/gallon"))
        {
            result = ((typical_Distance * gas_Price / vehical_Efficiency) *0.425144)/1.609;
        }


        else if(distance.equals("kilometers") && effeciency.equals("kilometers/liter") && price.equals("/liter"))
        {
            result = ((typical_Distance * gas_Price / vehical_Efficiency)*3.785)/1.609;
        }


        else if(distance.equals("miles") && effeciency.equals("miles/gallon") && price.equals("/liter"))
        {
            result = ((typical_Distance * gas_Price / vehical_Efficiency)*3.785);
        }



        else if(distance.equals("kilometers") && effeciency.equals("miles/gallon") && price.equals("/liter"))
        {
            result = ((typical_Distance * gas_Price / vehical_Efficiency)/0.425144);
        }


        return result;

    }
    //Main Method

   /* public static void main(String args[])
	{
    	Fuel_Cost Fuel = new Fuel_Cost(10,200,30);
		double fuel_cost;
		fuel_cost = Fuel.Calculate_Fuel_cost();
		
		   System.out.print("\n Fuel Cost is Per Day:"+fuel_cost);
	}*/


}