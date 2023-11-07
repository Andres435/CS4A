/*
    Write a method that returns a bounding rectangle for a set of points in a two-dimensional plane
*/
import java.util.Scanner;

public class HW10_15 {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        System.out.print("Enter 5 given points: ");
        Scanner input = new Scanner(System.in);
        double[][] points = new double[5][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }

        MyRectangle2D r1 = MyRectangle2D.getRectangle(points);
        System.out.println(r1.toString());

        input.close();
    }
}

class MyRectangle2D{
    public double centerX;
    public double centerY;

    public double width;
    public double height;

    public MyRectangle2D(double centerX, double centerY, double width, double height) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
    }

    public MyRectangle2D() {
        this(0, 0, 1, 1);
    }

    public static MyRectangle2D getRectangle(double[][] points) {
        MyPoint[] myPoints = new MyPoint[points.length];
        for (int i = 0; i < points.length; i++) {
            myPoints[i] = new MyPoint(points[i][0], points[i][1]);
        }

        return getRectangle(myPoints);
    }

    public static MyRectangle2D getRectangle(MyPoint[] points) {
        MyPoint leftMost = getLeftMostPoint(points);
        MyPoint rightMost = getRighMostPoint(points);
        double width = Math.abs(rightMost.x - leftMost.x);

        MyPoint highest = getHighestPoint(points);
        MyPoint lowest = getLowestPoint(points);
        double height = Math.abs(highest.y - lowest.y);

        double centerX = highest.getCenterPoint(lowest).x;
        double centerY = leftMost.getCenterPoint(rightMost).y;

        return new MyRectangle2D(centerX, centerY, width, height);
    }

    private static MyPoint getLeftMostPoint(MyPoint[] points) {
        MyPoint leftMost = points[0];
        for (int i = 0; i < points.length; i++) {
            if (leftMost.x > points[i].x) {
                leftMost = points[i];
            }
        }
        return leftMost;
    }

    private static MyPoint getRighMostPoint(MyPoint[] points) {
        MyPoint rightMost = points[0];
        for (int i = 0; i < points.length; i++) {
            if (rightMost.x < points[i].x) {
                rightMost = points[i];
            }
        }
        return rightMost;
    }

    private static MyPoint getHighestPoint(MyPoint[] points) {
        MyPoint highest = points[0];
        for (int i = 0; i < points.length; i++) {
            if (highest.y < points[i].y) {
                highest = points[i];
            }
        }
        return highest;
    }

    private static MyPoint getLowestPoint(MyPoint[] points) {
        MyPoint lowest = points[0];
        for (int i = 0; i < points.length; i++) {
            if (lowest.y > points[i].y) {
                lowest = points[i];
            }
        }
        return lowest;
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