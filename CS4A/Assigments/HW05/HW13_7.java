/*
    Design an interface named Colorable with a void method named howToColor().
    Every class of a colorable object must imple- ment the Colorable interface.
    Design a class named Square that extends GeometricObject and implements Colorable.
    Implement howToColor to display the message Color all four sides.
*/
public class HW13_7 {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        GeoObject[] geoShapes = new GeoObject[5];
        geoShapes[0] = new Square();
        geoShapes[1] = new Square();
        geoShapes[2] = new Square(0,0,10);
        geoShapes[3] = new Square(0,0,2);
        geoShapes[4] = new Square(0,0,25);

        for (int i = 0; i < geoShapes.length; i++) {

            System.out.println("shape #" + (i + 1) + " area = " + geoShapes[i].getArea());
            if (geoShapes[i] instanceof Colorable) {
                System.out.println("How to color: "+((Colorable)geoShapes[i]).howToColor());
            }
        }
    }

    public static abstract class GeoObject {
        private String color;

        public GeoObject(){
            this("white");
        }

        public GeoObject(String color){
            setColor(color);
        }

        public String getColor(){
            return color;
        }

        public void setColor(String color){
            this.color = color;
        }

        public abstract double getArea();
    }

    public static class Square extends GeoObject implements Colorable {
        private double x;
        private double y;
        private double side;
    
        Square() {
            this(0,0,1);
        }
    
        Square(double x, double y, double side) {
            this.x = x;
            this.y = y;
            this.side = side;
        }
    
        @Override
        public String howToColor() {
            return "Color all four sides.";
        }
    
        public double getX() {
            return x;
        }
    
        public void setX(double x) {
            this.x = x;
        }
    
        public double getY() {
            return y;
        }
    
        public void setY(double y) {
            this.y = y;
        }
    
        public double getSide() {
            return side;
        }
    
        public void setSide(double side) {
            this.side = side;
        }

        @Override
        public double getArea() {
            return side * side;
        }
    }
    
    interface Colorable {
        String howToColor();
    }
}