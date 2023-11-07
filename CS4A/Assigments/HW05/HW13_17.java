/*
    Program that prompts the user to enter two complex numbers and displays the
    result of their addition, subtraction, multiplication, division, and absolute value.
*/
import java.util.Scanner;

public class HW13_17 {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first complex number: ");
        Complex first = new Complex(input.nextDouble(), input.nextDouble());
        System.out.print("Enter the second complex number: ");
        Complex second = new Complex(input.nextDouble(), input.nextDouble());

        System.out.println(first.add(second));
        System.out.println(first.subtract(second));
        System.out.println(first.multiply(second));
        System.out.println(first.divide(second));
        System.out.println(first.abs());

        input.close();
    }


    public static class Complex {
        private double a;
        private double b;
    
        public Complex(double a, double b) {
            this.a = a;
            this.b = b;
        }
    
        public Complex(double a) {
            this(a, 0);
        }
    
        public Complex() {
            this(0);
        }

        public double getRealPart() {
            return a;
        }
    
        public double getImaginaryPart(){
            return b;
        }
    
        public Complex add(Complex complex) {
            // a + bi + c + di = (a + c) + (b + d)i
            System.out.print("(" + a + " + " + b + "i) + (" + complex.getRealPart() + " + " + complex.getImaginaryPart()+ "i) = ");
            return new Complex((a + complex.a), (b + complex.b));
        }

        public Complex subtract(Complex complex) {
            // a + bi - (c + di) = (a - c) + (b - d)i
            System.out.print("(" + a + " + " + b + "i) - (" + complex.getRealPart() + " + " + complex.getImaginaryPart()+ "i) = ");
            return new Complex((a - complex.a), (b - complex.b));
        }

        public Complex multiply(Complex complex) {
            // (a + bi)*(c + di) = (ac - bd) + (bc + ad)i
            System.out.print("(" + a + " + " + b + "i) + (" + complex.getRealPart() + " * " + complex.getImaginaryPart()+ "i) = ");
            return new Complex((a * complex.a - b * complex.b), (b * complex.a + a * complex.b));
        }

        public Complex divide(Complex complex) {
            // (a+bi)/(c+di)=(ac+bd)/(c^2 +d^2)+(bc-ad)i/(c^2 +d^2)
            System.out.print("(" + a + " + " + b + "i) / (" + complex.getRealPart() + " + " + complex.getImaginaryPart()+ "i) = ");
            return new Complex( (a*complex.a+b*complex.b) / ((Math.pow(complex.a, 2) + Math.pow(complex.b, 2))),
                                (b * complex.a - a * complex.b) / ((Math.pow(complex.a, 2) + Math.pow(complex.b, 2))));
        }
    
        public double abs() {
            System.out.print("|(" + a + " + " + ")| = ");
            return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        }

        @Override
        public String toString() {
            if (b == 0) 
                return a + "";
            return a + " + " + b + "i";
        }
    }
}
