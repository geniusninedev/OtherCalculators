package com.nineinfosys.android.otherscalculators.golfhandicapindex;

public class golf_Handicap {

	 double score;
	    double course_Rating;
	    double slpoe_Rating;


	    public golf_Handicap(double score, double course_Rating, double slpoe_Rating) {
	        this.score = score;
	        this.course_Rating = course_Rating;
	        this.slpoe_Rating = slpoe_Rating;
	    }

	    public double getScore() {
	        return score;
	    }

	    public void setScore(double score) {
	        this.score = score;
	    }

	    public double getCourse_Rating() {
	        return course_Rating;
	    }

	    public void setCourse_Rating(double course_Rating) {
	        this.course_Rating = course_Rating;
	    }

	    public double getSlpoe_Rating() {
	        return slpoe_Rating;
	    }

	    public void setSlpoe_Rating(double slpoe_Rating) {
	        this.slpoe_Rating = slpoe_Rating;
	    }

		public double Calculate_Handicap_Golf()
		{
			
			double result=(score-course_Rating)*113/slpoe_Rating;
			
			return result;
			
		}
	public double Calculate_Handicap_Golf1(double score1,double course_Rating1,double slpoe_Rating1)
	{

		double result1=(score1-course_Rating1)*113/slpoe_Rating1;

		return result1;

	}

	public double Calculate_Handicap_Golf2(double score2 ,double course_Rating2,double slpoe_Rating2)
	{

		double result2=(score2-course_Rating2)*113/slpoe_Rating2;

		return result2;

	}
	public double Calculate_Handicap_Golf3(double score3 ,double course_Rating3,double slpoe_Rating3)
	{

		double result3=(score3-course_Rating3)*113/slpoe_Rating3;

		return result3;

	}
	public double Calculate_Handicap_Golf4(double score4 ,double course_Rating4,double slpoe_Rating4)
	{

		double result4=(score4-course_Rating4)*113/slpoe_Rating4;

		return result4;

	}

	public static void main(String args[])
		{
			golf_Handicap golf = new golf_Handicap(110,80,131);
			double result;
			result = golf.Calculate_Handicap_Golf();
			
			   System.out.print("\n Golf Handicap Index is:"+result);
		}
	
	
	
}
