/*
    Define the Triangle2D class that contains:"
■ Three points named p1, p2, and p3 of the type MyPoint with getter and setter methods.
    MyPoint is defined in Programming Exercise 10.4."
■ A no-arg constructor that creates a default triangle with the points (0, 0), (1,"1), and (2, 5)."
■ A constructor that creates a triangle with the specified points."
■ A method getArea() that returns the area of the triangle."
■ A method getPerimeter() that returns the perimeter of the triangle."
■ A method contains(MyPoint  p) that returns true if the specified point"
    p is inside this triangle (see Figure 10.22a)."
■ A method contains(Triangle2D  t) that returns true if the specified"
    triangle is inside this triangle (see Figure 10.22b)."
■ A method overlaps(Triangle2D  t) that returns true if the specified triangle overlaps with this triangle
*/
import java.awt.geom.Line2D;
public class HW10_12 {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        Triangle2D r1 = new Triangle2D(new MyPoint(0, 0), new MyPoint(0, 2), new MyPoint(2, 0));

        System.out.println("Area is " + r1.getArea());
        System.out.println("Perimeter is " + r1.getPerimeter());
        System.out.println("Point is inside triangle: " + r1.contains(1, 1));

        System.out.println("Triangle 2 is inside this triangle: " + r1.contains( new Triangle2D(4, 5, 10.5, 3.2, -0.5, -10.5)));
        System.out.println("Triangle 3 is overlaps this triangle: " + r1.overlaps(new Triangle2D(1, 1.7, -1, 1.7, 0,-3)));
    }
}

class Triangle2D {
    private MyPoint p1;
    private MyPoint p2;
    private MyPoint p3;

    public Triangle2D() {
        this(new MyPoint(0,0), new MyPoint(1,1), new MyPoint(2,5));
    }

    public Triangle2D(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.p1 = new MyPoint(x1, y1);
        this.p2 = new MyPoint(x2, y2);
        this.p3 = new MyPoint(x3, y3);
    }

    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public MyPoint getP1() {
        return p1;
    }

    public void setP1(MyPoint p1) {
        this.p1 = p1;
    }

    public MyPoint getP2() {
        return p2;
    }

    public void setP2(MyPoint p2) {
        this.p2 = p2;
    }

    public MyPoint getP3() {
        return p3;
    }

    public void setP3(MyPoint p3) {
        this.p3 = p3;
    }

    public double getPerimeter() {
        double s1 = p1.distance(p2);
        double s2 = p2.distance(p3);
        double s3 = p3.distance(p1);
        return s1 + s2 + s3;
    }

    public double getArea() {
        double s1 = p1.distance(p2);
        double s2 = p2.distance(p3);
        double s3 = p3.distance(p1);
        double s = (s1 + s2 + s3) / 2.0;

        return Math.pow(s * (s - s1) * (s - s2) * (s - s3), 0.5);
    }

    public boolean contains(double x, double y) {
        // Get max X & Y
        double maxX = getMax(p1.x, p2.x, p3.x);
        double maxY = getMax(p1.y, p2.y, p3.y);

        // Get min X & Y
        double minX = getMin(p1.x, p2.x, p3.x);
        double minY = getMin(p1.y, p2.y, p3.y);

        // Outside the bounding rectangle of the triangle
        if (x < minX || x > maxX || y < minY || y > maxY)  return false;

        // Check if point is the border of the triangle
        MyPoint p = new MyPoint(x, y);
        boolean side1 = p.onTheLineSegment(p1, p2);
        boolean side2 = p.onTheLineSegment(p1, p3);
        boolean side3 = p.onTheLineSegment(p2, p3);
        
        return side1 || side2 || side3;
    }

    // returns true if the specified point is inside this triangle
    public boolean contains(MyPoint p) {
        return contains(p.x(), p.y);
    }

    // return true if the Triangle is inside another triangle
    public boolean contains(Triangle2D t) {
        return contains(t.p1) && contains(t.p2) && contains(t.p3);
    }

    // returns true if the specified triangle overlaps with this triangle
    public boolean overlaps(Triangle2D t) {
        MyPoint[] pt1 = getTrianglePoints();
        MyPoint[] pt2 = t.getTrianglePoints();

        // check is triangle side intersect
        for (int i = 0; i < 3; i++) {
            int maxI = (i+1) % 3;

            for (int j = 0; j < 3; j++) {
                int maxJ = (j+1) % 3;
                Line2D line1 = new Line2D.Double(pt2[i].x, pt2[i].y, pt2[maxI].x, pt2[maxI].y);
                Line2D line2 = new Line2D.Double(pt1[i].x, pt1[i].y, pt1[maxJ].x, pt1[maxJ].y);
                if (line1.intersectsLine(line2)) {
                    return true;
                }
            }
        }
        return false;
    }

    // =======================================================================================
    // Helper functions for Constains
    // =======================================================================================
    private double getMax(double... n) {
        double max = n[0];
        for (int i = 1; i < n.length; i++) 
            if (max < n[i]) 
                max = n[i];
        return max;
    }
    private double getMin(double... n) {
        double min = n[0];
        for (int i = 1; i < n.length; i++) {
            if (min > n[i]) {
                min = n[i];
            }
        }
        return min;
    }

    // ==========================================================================================
    // Helper Function for Overlaps
    // ==========================================================================================

    private MyPoint[] getTrianglePoints() {
        MyPoint[] points = new MyPoint[3];
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;

        return points;
    }

    // ==========================================================================================
    // ==========================================================================================
}