/*
    Modify the GeometricObject class to implement the Comparable interface,
    and define a static max method in the GeometricObject class for finding
    the larger of two GeometricObject objects. Draw the UML diagram and implement
    the new GeometricObject class. Write a test program that uses the max method
    to find the larger of two circles and the larger of two rectangles.
*/
public class HW13_5 {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        Circle c1 = new Circle(0, 0, 5);
        Circle c2 = new Circle(0, 0, 2);
        Circle maxCircle =(Circle)GeometricObject.max(c1, c2);
        System.out.println("Circle 1: " + c1);
        System.out.println("Circle 2: " + c2);
        System.out.println("Max circle is: " + maxCircle);

        Rectangle r1 = new Rectangle(0, 0, 10, 5);
        Rectangle r2 = new Rectangle(0, 0, 10, 10);
        Rectangle maxRectangle = (Rectangle) GeometricObject.max(r1, r2);
        System.out.println("Rec 1: " + r1);
        System.out.println("Rec 2: " + r2);
        System.out.println("Max Rec is: " + maxRectangle);
    }

    public static abstract class GeometricObject implements Comparable<GeometricObject> {
        public int compareTo(GeometricObject o) {
            if (getArea() > o.getArea())
                return 1;
            else if (getArea() < o.getArea())
                return -1;
            else
                return 0;
        }

        public static GeometricObject max(GeometricObject o1, GeometricObject o2) {
            return (o1.compareTo(o2) >= 0) ? o1 : o2;
        }

        /** Abstract method getArea */
        public abstract double getArea();

        /** Abstract method getPerimeter */
        public abstract double getPerimeter();

        // ==================================================================
        // FUNCTIONS FOR HW13_7
        // ==================================================================
        private String color;

        public GeometricObject(){
            this("white");
        }

        public GeometricObject(String color){
            setColor(color);
        }

        public String getColor(){
            return color;
        }

        public void setColor(String color){
            this.color = color;
        }
    }

    public static class Circle  extends GeometricObject {
        private double x;
        private double y;
        private double radius;

        public Circle(double x, double y, double radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public Circle() {
            this(0, 0, 1);
        }

        @Override
        public double getArea() {
            return radius * radius * Math.PI;
        }

        @Override
        public double getPerimeter() {
            return 2 * radius * Math.PI;
        }

        @Override
        public String toString() {
            return "Circle{" +
                    "x=" + x +
                    ", y=" + y +
                    ", radius=" + radius +
                    '}';
        }
    }

    public static class Rectangle extends GeometricObject{
        public double centerX;
        public double centerY;
        public double width;
        public double height;

        public Rectangle() {
            this(0, 0, 1, 1);
        }
    
        public Rectangle(double centerX, double centerY, double width, double height) {
            this.centerX = centerX;
            this.centerY = centerY;
            this.width = width;
            this.height = height;
        }

        @Override
        public double getArea() {
            return  width * height;
        }

        @Override
        public double getPerimeter() {
            return (width * 2) + (height * 2);
        }
        
        @Override
        public String toString() {
            return "The bounding rectangle's " +
                    "center (" + centerX +
                    ", " + centerY +
                    "), width=" + width +
                    ", height=" + height;
        }
    }
}
