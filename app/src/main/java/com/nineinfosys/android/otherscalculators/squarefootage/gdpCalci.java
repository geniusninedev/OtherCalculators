package com.nineinfosys.android.otherscalculators.squarefootage;

public class gdpCalci {
	 double consumption;
	    double  grossinvestment;
	    double  governmentconsumption;
	    double netexports;
	    double netimports;
	    
	    public gdpCalci(double consumption, double grossinvestment, double governmentconsumption, double netexports, double netimports) {
	        this.consumption = consumption;
	        this.grossinvestment = grossinvestment;
	        this.governmentconsumption = governmentconsumption;
	        this.netexports = netexports;
	        this.netimports=netimports;
	    }
	    
		public double getconsumption() {
			return consumption;
		}
		public void setconsumption(double consumption) {
			this.consumption = consumption;
		}
		public double getgrossinvestment() {
			return grossinvestment;
		}
		public void setgrossinvestment(double grossinvestment) {
			this.grossinvestment = grossinvestment;
		}
		public double getgovernmentconsumption() {
			return governmentconsumption;
		}
		public void setgovernmentconsumption(double governmentconsumption) {
			this.governmentconsumption = governmentconsumption;
		}
		public double getnetexports() {
			return netexports;
		}
		public void setnetexports(double netexports) {
			this.netexports =netexports;
		}
		public double getnetimports() {
			return netimports;
		}
		public void setnetimports(double netimports) {
			this.netimports = netimports;
		}
		
		public double gdpCalculator()
		
		{
			double result=consumption+grossinvestment+governmentconsumption+netexports-netimports;
			return result;
		}
		/*public static class gdpMain {
			
			public static void main(String arg[])
			{
				
				gdpCalci gdpcal=new gdpCalci(1000, 20,30, 40,200);
				double result=gdpcal.gdpCalculator();
	
				System.out.print("gross domestic product Value:"+result);
		
			}
		}
*/
}
