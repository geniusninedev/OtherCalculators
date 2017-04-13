package com.nineinfosys.android.otherscalculators.windchillindex;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class heatIndexCalculator1 {

    private int temperature;
    private double humidity;
    private double heatIndex;
    String spinner;
    //private IncomeTaxResults incomeTaxResults;
    public static final String RESULT_FORMAT = "#.#";

    public double calculateHeatIndex ( double currentTemp, double currentHumidity ,String spinner) {
        double temperature = currentTemp;
        double humidity = currentHumidity;

        final double C1 = -42.379;
        final double C2 = 2.04901523;
        final double C3 = 10.14333127;
        final double C4 = -0.22475541;
        final double C5 = -.00683783;
        final double C6 = -5.481717E-2;
        final double C7 = 1.22874E-3;
        final double C8 = 8.5282E-4;
        final double C9 = -1.99E-6;
        double T = temperature;
        double R = humidity;
        double T2 = temperature * temperature;
        double R2 = humidity * humidity;
        double result=0;
        if (spinner.equals("℉"))

        {
            result = C1 + (C2 * T) + (C3 * R) + (C4 * T * R) + (C5 * T2) + (C6 * R2) + (C7 * T2 * R) + (C8 * T * R2) + (C9 * T2 * R2);

        }
       else if (spinner.equals("℃"))

        {
            result = (C1 + (C2 * T-32*0.555) + (C3 * R) + (C4 * T-32*0.555* R) + (C5 * T2-32*0.555) + (C6 * R2) + (C7 * T2-32*0.555 * R) + (C8 * T-32*0.555 * R2) + (C9 * T2-32*0.555* R2));

        }

        else if (spinner.equals("K"))

        {
            result = (C1 + (C2 * T+459.67*0.555) + (C3 * R) + (C4 * T+459.47*0.555* R) + (C5 * T2+459.67*0.555) + (C6 * R2) + (C7 * T2+459.67*0.555 * R) + (C8 * T+459.67*0.555 * R2) + (C9 * T2+459.67*0.555* R2));

        }


        return  result;
    }

}