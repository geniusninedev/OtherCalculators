package com.nineinfosys.android.otherscalculators.squarefootage;

public class sqrFoot {
double length;
    double width;

   /* public static void main(String[] args) {
        //creates a scanner object
        Scanner scanner = new Scanner(System.in);

        //takes input
        System.out.println("Enter the length : ");
        double length = scanner.nextDouble();

        System.out.println("Enter the width : ");
        double width = scanner.nextDouble();

        //calculates and displays answer
        System.out.println(length*width + " Sqr ft");
        System.out.println("Welcome to the Area Calculator! \n" +
                "Enter 1 to find the area of a Rectangle, \n" +
                "Enter 2 to find the area of a Square,\n " +
                "Enter 3 to find the area of a Triangle or \n " +
                "Enter 4 to find the area of a Circle");
        switch (scanner.nextInt()) {
            case 1:
                rectangle(scanner);
                break;
            case 2:
                square(scanner);
                break;
            case 3:
                triangle(scanner);
                break;
            case 4:
                circle(scanner);
                break;
        }
    }
*/
    public  double ask(double length, double width) {
        return length*width;
    }

    public  double rectangle(double length, double width) {

        return length*width;
    }

   public double square(double length) {
       return length*length;
   }

    public  double triangle(double length, double width) {

        return (0.5 * length * width);
    }

    public double circle(double radius) {

        return (Math.PI * (radius * radius));
    }

}


