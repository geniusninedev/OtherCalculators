package com.nineinfosys.android.otherscalculators.lovecalculator;

public class Love_Calculator {
    private String BoyName;
    private String GirlName;
   
	
    public String getBoyName() {
        return BoyName;
    }

    public Love_Calculator(String boyName, String girlName) {
        BoyName = boyName;
        GirlName = girlName;
    }

    public void setBoyName(String boyName) {
        BoyName = boyName;
    }

    public String getGirlName() {
        return GirlName;
    }

    public void setGirlName(String girlName) {
        GirlName = girlName;
    }
    

public int CalculateLove()
{



    int sum=0,sum2=0;
    for(int i=0;i<BoyName.length();i++)
    {
        char ch=BoyName.charAt(i);
        int ascii=ch;
        sum=sum+ascii;
    }

    for(int i=0;i<GirlName.length();i++)
    {
        char ch=GirlName.charAt(i);
        int ascii=ch;
        sum2=sum2+ascii;
    }


    int total=sum+sum2;
    int lovepercentage=total%100;

    return  lovepercentage;


}
	
			
}




