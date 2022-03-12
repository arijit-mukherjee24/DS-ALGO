package walmart;

import java.util.Random;

// 478. Generate Random Point in a Circle
public class Q10_GenerateRandomPointCircle {

	public static void main(String[] args) {
		
	}
	
	 	double a; // x-coordinate of the center
	    double b; // y-coordinate of the center
	    double r; // radius of the circle
	    
	    Random rand = null;
	    
	    // parameterized constructor
	    public Q10_GenerateRandomPointCircle(double radius, double x_center, double y_center) {
	        this.a = x_center;
	        this.b = y_center;
	        this.r = radius;
	        rand = new Random();
	    }
	    
	    // driver fnc
	    public double[] randPoint() {
	        double x = getRandomCoordinate(r, a);
	        double y = getRandomCoordinate(r, b);
	        
	        while(getDistance(x,y) >= r*r){
	            x = getRandomCoordinate(r, a);
	            y = getRandomCoordinate(r, b);
	        }

	        return new double[]{x,y};
	    }
	    
	    // helper func
	    private double getRandomCoordinate(double r, double c) {
	        return c-r + Math.random()*(2*r);
	        // a -r + radom(2r);
	        // random() is used to return a pseudorandom double type number 
	        // greater than or equal to 0.0 and less than 1.0. 
	    }
	    
	    // helper func
	    private double getDistance(double x, double y){
	        return (x-a)*(x-a) + (y-b)*(y-b);
	    }

}
