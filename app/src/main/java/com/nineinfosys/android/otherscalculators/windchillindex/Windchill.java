package com.nineinfosys.android.otherscalculators.windchillindex;

public class Windchill {


    public double calculateNewWindchillIndex(double airTempreture, double windSpeed, String Units, String TempUnits) {
        double result = 0;
        if (Units.equals("m/h") && TempUnits.equals("℉"))
        {

            result = (35.74 + 0.6215 * airTempreture - 35.75 * (Math.pow(windSpeed, 0.16)) + 0.4275 * airTempreture * (Math.pow(windSpeed, 0.16)));
        }
        else if (Units.equals("m/h") && TempUnits.equals("℃"))
        {

            result = (35.74 + 0.6215 * (airTempreture - 32 * 0.555) - 35.75 * (Math.pow(windSpeed, 0.16)) + 0.4275 * (airTempreture - 32 * 0.555) * (Math.pow(windSpeed, 0.16)));

        }
        else if (Units.equals("m/h") && TempUnits.equals("K"))
        {
            result = (35.74 + 0.6215 * (airTempreture + 459.67 * 0.555) - 35.75 * (Math.pow(windSpeed, 0.16)) + 0.4275 * (airTempreture + 459.67 * 0.555) * (Math.pow(windSpeed, 0.16)));
        }

        if (Units.equals("km/h") && TempUnits.equals("℉")) {

            result = (35.74 + 0.6215 * airTempreture - 35.75 * (Math.pow((windSpeed / 1.61), 0.16)) + 0.4275 * airTempreture * (Math.pow((windSpeed / 1.61), 0.16)));


        } else if (Units.equals("km/h") && TempUnits.equals("℃")) {

            result = (35.74 + 0.6215 * (airTempreture - 32 * 0.555) - 35.75 * (Math.pow((windSpeed / 1.61), 0.16)) + 0.4275 * (airTempreture - 32 * 0.555) * (Math.pow((windSpeed / 1.61), 0.16)));

        } else if (Units.equals("km/h") && TempUnits.equals("K"))
        {
            result = (35.74 + 0.6215 * (airTempreture + 459.67 * 0.555) - 35.75 * (Math.pow((windSpeed / 1.61), 0.16)) + 0.4275 * (airTempreture + 459.67 * 0.555) * (Math.pow((windSpeed / 1.61), 0.16)));
        }




        return result;


    }


    public double calculateOldWindchillIndex(double airTempreture, double windSpeed, String oldunit, String TempOldunits) {

        double oldResult = 0;
        if (oldunit.equals("m/h")&&TempOldunits.equals("℉")) {


                oldResult = (0.081 * (3.71 * (Math.pow(windSpeed, 0.5)) + 5.81 - 0.25 * windSpeed) * (airTempreture - 91.4) + 91.4);

            } else if(oldunit.equals("m/h")&&TempOldunits.equals("℃"))
            {
            oldResult = (0.081 * (3.71 * (Math.pow(windSpeed, 0.5)) + 5.81 - 0.25 * windSpeed) * ((airTempreture - 32 * 0.555) - 91.4) + 91.4);
            }

        else if(oldunit.equals("m/h")&&TempOldunits.equals("K"))
        {
            oldResult = (0.081 * (3.71 * (Math.pow(windSpeed, 0.5)) + 5.81 - 0.25 * windSpeed) * ((airTempreture +459.66 * 0.555) - 91.4) + 91.4);
        }


         else if (oldunit.equals("km/h")&&TempOldunits.equals("℉")){

            oldResult = (0.081 * (3.71 * (Math.pow(windSpeed / 1.61, 0.5)) + 5.81 - 0.25 * windSpeed / 1.61) * (airTempreture - 91.4) + 91.4);

            } else if(oldunit.equals("km/h")&&TempOldunits.equals("℃"))
            {
                oldResult = (0.081 * (3.71 * (Math.pow(windSpeed / 1.61, 0.5)) + 5.81 - 0.25 * windSpeed / 1.61) * ((airTempreture - 32 * 0.555) - 91.4) + 91.4);
            }
        else if(oldunit.equals("km/h")&&TempOldunits.equals("K"))
        {
            oldResult = (0.081 * (3.71 * (Math.pow(windSpeed / 1.61, 0.5)) + 5.81 - 0.25 * windSpeed / 1.61) * ((airTempreture + 459.67 * 0.555) - 91.4) + 91.4);
        }

        return oldResult;


    }




	}



	
//Main method
	
	/*public static void main(String args[])
	{
		Windchill Index= new Windchill();
		double result,oldresult;
		
		result=Index.calculateNewWindchillIndex(20,100);
		 System.out.print("\n New Windchill Index is:"+result+"F");
		 
		 oldresult=Index.calculateOldWindchillIndex(20,100);
		 System.out.print("\n Old Windchill Index is:"+oldresult+"F");
		 
		 
		
	}

	*/



