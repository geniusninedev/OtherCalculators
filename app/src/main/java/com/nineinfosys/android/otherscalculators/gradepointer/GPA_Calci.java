package com.nineinfosys.android.otherscalculators.gradepointer;

public class GPA_Calci {
	double  total_credit;
	double Score;



	public GPA_Calci(double total_credit, double score) {
		super();
		this.total_credit = total_credit;
		this.Score = score;
	}


	public double getTotal_credit() {
	        return total_credit;
	    }

	    public void setTotal_credit(double total_credit) {
	        this.total_credit = total_credit;
	    }
	    public double getScore() {
			return Score;
		}

		public void setScore(double score) {
			Score = score;
		}


	public double cal_GPA(){

	//	System.out.print(" \nvalue of credit"+credit+" \nvalue of score"+score);
		double grade_point=total_credit*Score;
		//double gpa=grade_point/total_credit;
		return grade_point;
	}

	public double secondgradepoint( double secondcredit, double secondscore){
		double grade_point2=secondcredit*secondscore;

		return grade_point2;
	}


	public double thirdgradepoint( double thirdcredit, double thirdscore){
		double grade_point3=thirdcredit*thirdscore;

		return grade_point3;
	}

	public double fourthgradepoint( double fourthcredit, double fourthscore){
		double grade_point4=fourthcredit*fourthscore;

		return grade_point4;
	}
	public double fifthgradepoint( double fifthcredit, double fifthscore){
		double grade_point5=fifthcredit*fifthscore;

		return grade_point5;
	}


/*

	public double sumOfCredit( ){
		double sum;
		sum=total_credit+secondcredit+thirdcredit+fourthcredit+fifthcredit;
	return sum;

	}
*/


	public static void main(String args[])
	{
		GPA_Calci GPA = new GPA_Calci(5,10);
		double gpa;
		gpa = GPA.cal_GPA();
		
		   System.out.print("\n GPA is:"+gpa);
	}
}
