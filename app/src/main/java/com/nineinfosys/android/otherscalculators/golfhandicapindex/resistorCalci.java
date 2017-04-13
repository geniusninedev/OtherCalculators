package com.nineinfosys.android.otherscalculators.golfhandicapindex;

/**
 * Created by Dev on 09-03-2017.
 */

public class resistorCalci {
    double lenght;
    double diameter;
    double conductivity;
     double result;
    double mileresult;
    double mileresult1;

    public double resistorCalci(double lenght, double diameter, double conductivity, String lengthUnit) {



        if (lengthUnit.equals("mile")) {

            double mileresult = 0.62137 * lenght;
            return mileresult;
        } else if (lengthUnit.equals("km")) {

            mileresult = 1.60934 * lenght;
            return mileresult;
        }

        else if (lengthUnit.equals("cm")) {

            mileresult = lenght / 160934;

            return mileresult;
        } else if (lengthUnit.equals("cm")) {

            mileresult = lenght / 160934;
            return mileresult;

        } else if (lengthUnit.equals("mm")) {
            mileresult = lenght * 1609340;

            return mileresult;
        } else if (lengthUnit.equals("inch")) {

            mileresult = 63360 * lenght;
            return mileresult;

        } else if (lengthUnit.equals("ft")) {

            mileresult = 5280 * lenght;
            return mileresult;

        }
        else if(lengthUnit.equals("mile")) {

            double mileresult1 = 0.62137 * diameter;
            return mileresult1;
        }
        else if (lengthUnit.equals("km")) {

            mileresult1 = 5280 * diameter;
            return mileresult1;


        } else if (lengthUnit.equals("cm")) {

            mileresult1 = diameter / 160934;
            return mileresult1;

        } else if (lengthUnit.equals("cm")) {

            mileresult1 = diameter / 160934;
            return mileresult1;

        } else if (lengthUnit.equals("mm")) {
            mileresult1 = diameter * 1609340;
            return mileresult1;

        } else if (lengthUnit.equals("inch")) {

            mileresult1 = 63360 * diameter;

            return mileresult1;
        } else if (lengthUnit.equals("ft")) {

            mileresult1 = 5280 * diameter;

            return mileresult1;
        }
     else{

        }

        result=mileresult/(mileresult1*conductivity);
        return result;

    }

  /*  public double resistorCalci1(double lenght, double diameter, double conductivity, String lengthUnit, String dimeterUnit) {

        if(dimeterUnit.equals("mile")) {

            double mileresult = 0.62137 * diameter;
            return mileresult;
        }
        else if (dimeterUnit.equals("km")) {

            mileresult = 5280 * diameter;
            return mileresult;
        }else if (dimeterUnit.equals("m")) {

            mileresult = 1609.34 * diameter;
            return mileresult;

        } else if (dimeterUnit.equals("cm")) {

            mileresult = diameter / 160934;
            return mileresult;

        } else if (dimeterUnit.equals("cm")) {

            mileresult = diameter / 160934;
            return mileresult;

        } else if (dimeterUnit.equals("mm")) {
            mileresult = diameter * 1609340;
            return mileresult;

        } else if (dimeterUnit.equals("inch")) {

            mileresult = 63360 * diameter;

            return mileresult;
        } else if (dimeterUnit.equals("ft")) {

            mileresult = 5280 * diameter;

            return mileresult;
        }

        result=lenght/(mileresult*conductivity);
        return result;

    }

*/
  /*  public double resistorCalci(double lenght,double diameter,double conductivity){
        this.lenght=lenght;
        this.diameter=diameter;
        this.conductivity=conductivity;
        //R = L/(A*C)
         result=lenght/(diameter*conductivity);
        return result;
    }
*/
}

