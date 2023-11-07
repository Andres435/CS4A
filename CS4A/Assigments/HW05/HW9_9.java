/*
    In an n-sided regular polygon, all sides
    have the same length and all angles have the same degree (i.e., the polygon is
    both equilateral and equiangular). Design a class named RegularPolygon that
    contains:
    A private int data field named n that defines the number of sides in the poly-
    gon with default value 3 .
    A private double data field named side that stores the length of the side with
    default value 1 .
    A private double data field named x that defines the x-coordinate of the poly-
    gon’s center with default value 0 .
    A private double data field named y that defines the y-coordinate of the poly-
    gon’s center with default value 0 .
    A no-arg constructor that creates a regular polygon with default values.
    A constructor that creates a regular polygon with the specified number of sides
    and length of side, centered at ( 0 , 0 ).
    A constructor that creates a regular polygon with the specified number of sides,
    length of side, and x- and y-coordinates.
    The accessor and mutator methods for all data fields.
    The method getPerimeter() that returns the perimeter of the polygon.
    The method getArea() that returns the area of the polygon. The formula for
    computing the area of a regular polygon is Area = (n x s^2) / (4 x tan(π / n)
*/
public class HW9_9 {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        // Create three RegularPolygon objects
        RegularPolygon regularPolygon1 = new RegularPolygon();
        RegularPolygon regularPolygon2 = new RegularPolygon(6, 4);
        RegularPolygon regularPolygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

        // Display perimeter and area of each object
        System.out.println("\n--------------------------------------------------");
        System.out.println("| Regular Polygon Objects |  Perimeter  |  Area  |");
        System.out.println("--------------------------------------------------");
        System.out.printf( "|       Object# 1         |%8.2f     |%6.2f  |\n", 
        regularPolygon1.getPerimeter(), regularPolygon1.getArea());
        System.out.printf( "|       Object# 2         |%8.2f     |%6.2f  |\n", 
        regularPolygon2.getPerimeter(), regularPolygon2.getArea());
        System.out.printf( "|       Object# 3         |%8.2f     |%6.2f  |\n", 
        regularPolygon3.getPerimeter(), regularPolygon3.getArea());
        System.out.println("--------------------------------------------------");
    }
}

class RegularPolygon {

    private int numberOfSides;
    private double sideLength;
    private double centerX;
    private double centerY;

    public RegularPolygon() {
        numberOfSides = 3;
        sideLength = 1;
        centerX = 0;
        centerY = 0;
    }

    public RegularPolygon(int numberOfSides, double sideLength) {
        this();
        this.sideLength = sideLength;
        this.numberOfSides = numberOfSides;
    }

    public RegularPolygon(int numberOfSides, double sideLength, double x, double y) {
        this(numberOfSides, sideLength);
        this.centerX = x;
        this.centerY = y;
    }

    public int getNumberOfSides() {
        return this.numberOfSides;
    }

    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public double getSideLength() {
        return this.sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getCenterY() {
        return this.centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public double getCenterX() {
        return this.centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getPerimeter(){
        return numberOfSides * sideLength;
    }

    public double getArea() {
        return (numberOfSides * sideLength * sideLength) / (4.0 * Math.tan(Math.PI / numberOfSides));
    }

}

