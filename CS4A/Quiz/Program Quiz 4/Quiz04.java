/**
 * Quintana, Andres
 * 22/10/2020
 * Student ID: 1074306
 * 
 *  This program calculates the perimeter and area of 
 *  circles, squares, and rectangles.
 * 
 *                      UML
 *  -----------------Rectangle--------------------
 *  - -xSide: double
 *  - -ySide: double
 *  ----------------------------------------------
 *  - +Rectangle() 
 *  - +Rectangle(xSide: double, ySide: double)
 *  - +getX()
 *  - +setX(xSide: double)
 *  - +getY()
 *  - +setY(ySide: double)
 *  - +getArea()
 *  - +getPerimeter()
 *  ----------------------------------------------
 *  ------------------Square----------------------
 *  - -side: double
 *  ----------------------------------------------
 *  - +Square()
 *  - +Square(side: double) 
 *  - +getSide()
 *  - +setSide()
 *  - +getArea()
 *  - +getPerimeter()
 *  ----------------------------------------------
 *  ------------------Circule---------------------
 *  - -radious: double
 *  ----------------------------------------------
 *  - +Circle()
 *  - +Circle(radious: double)
 *  - +getRadious()
 *  - +setRadious()
 *  - +getArea()
 *  - +getPerimeter()
 *  ----------------------------------------------
 */
import java.util.Scanner;
import java.lang.Math;

public class Quiz04 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a SINGLE number. This will be used for the circle radius, the square's side, and one side of the rectangle: ");
        double num1 = input.nextDouble();
        System.out.println("Enter the other side of the rectangle: ");
        double num2 = input.nextDouble();

        // Construct Shapes
        Circle c = new Circle(num1);
        Square s = new Square(num1);
        Rectangle r = new Rectangle(num1, num2);

        // Print Area
        System.out.println("Circle area: " + c.getArea());
        System.out.println("Square area: " + s.getArea());
        System.out.println("Recntangle area: " + r.getArea());

        // Print Perimeter
        System.out.println("Circle Perimeter: " + c.getPerimeter());
        System.out.println("Square Perimeter: " + s.getPerimeter());
        System.out.println("Recntangle Perimeter: " + r.getPerimeter());

        input.close();
    }
}

class Rectangle{
    private double xSide;
    private double ySide;

    public Rectangle(){
        xSide = 1;
        ySide = 1;
    }

    public Rectangle(double xSide, double ySide){
        this.xSide = xSide;
        this.ySide = ySide;
    }

    public double getX(){
        return xSide;
    }

    public double getY(){
        return ySide;
    }

    // Return Area
    public double getArea(){
        return (xSide * ySide);
    }

    // Return Perimeter
    public double getPerimeter(){
        return ((xSide * 2) + (ySide * 2));
    }
}

class Square{
    private double side;

    public Square(){
        side = 1;
    }

    public Square(double side){
        this.side = side;
    }

    public double getX(){
        return side;
    }

    // Return Area
    public double getArea(){
        return (side * side);
    }

    // Return Perimeter
    public double getPerimeter(){
        return (side * 4);
    }
}

class Circle{
    private double radious;

    public Circle(){
        radious = 1;
    }

    public Circle(double radious){
        this.radious = radious;
    }

    public double getX(){
        return radious;
    }

    // Return Area
    public double getArea(){
        return (radious * radious * Math.PI);
    }

    // Return Perimeter
    public double getPerimeter(){
        return (Math.PI * (2 * radious));
    }
}