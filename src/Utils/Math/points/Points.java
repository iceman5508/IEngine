package Utils.Math.points;

import java.text.DecimalFormat;

public class Points {

//length/distance = speed
	double x;
    private double y;

    public Points(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    @Override
    public String toString() {
        return ("(" + x + "," + y + ")"); 
    }
    
    public void update(double x, double y)
    {
    	this.x = x;
        this.y = y;
    }
    
    public boolean comparePoint(Points p)
    {
    	if(x==p.getX()&&y==p.getY())
    	{
    		return true;
    	}else
    	{
    		return false;
    	}
    }
    
    public double distance(Points p)
    {
    	/*
    	double x1 = x;
    	double x2 = p.getX();
    	double y1 = y;
    	double y2 = p.getY();
    	double d = ((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1));*/
    	return Math.sqrt(
    			((p.getX()-x)*(p.getX()-x)) + ((p.getY()-y)*(p.getY()-y)
    			));
    }
    
    public double midPointX(Points p)
    {
    	double x1 = x;
    	double x2 = p.getX();
    	return (x1+x2)/2;
    
    	
    }
    
    public double midPointY(Points p)
    {
    	
    	
    	double y1 = y;
    	double y2 = p.getY();
    	return (y1+y2)/2;
    	
    	
    }
    
    public double magnitude(Points p)
    {
    	/*double x1 = x;
    	double x2 = p.getX();
    	double y1 = y;
    	double y2 = p.getY();
    	double d = ((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1));*/
    	return Double.parseDouble(new DecimalFormat("#0.00").format(Math.sqrt(
    			((p.getX()-x)*(p.getX()-x)) + ((p.getY()-y)*(p.getY()-y)
    			))));
    }
    
    public double magnitudeRounded(Points p)
    {
    	/*double x1 = x;
    	double x2 = p.getX();
    	double y1 = y;
    	double y2 = p.getY();
    	double d = ((p.getX()-x)*(p.getX()-x)) + ((p.getY()-y)*(p.getY()-y));*/
    	return Double.parseDouble(new DecimalFormat("#0.00").format(Math.round(Math.sqrt(
    			((p.getX()-x)*(p.getX()-x)) + ((p.getY()-y)*(p.getY()-y)
    			)))));
    }
    
    public double directionRadian(Points p)
    {
    	return Double.parseDouble(new DecimalFormat("#0.00").format(Math.atan(((p.getY()-y)/(p.getX()-x)))));
    }
    
    public double directionRadianRounded(Points p)
    {
    	return Double.parseDouble(new DecimalFormat("#0.00").format(Math.round(Math.atan(((p.getY()-y)/(p.getX()-x))))));
    }
    
    public double directionDegree(Points p)
    {
    	return Double.parseDouble(new DecimalFormat("#0.00").format(
    			(((Math.atan(((p.getY()-y)/(p.getX()-x))))*(180/Math.PI)))))
    	;
    }
    
    public double directionDegreeRounded(Points p)
    {
    	return Double.parseDouble(new DecimalFormat("#0.00").format((((Math.atan(((p.getY()-y)/(p.getX()-x))))*(180/Math.PI)))));
    }
    
    public double length_Sqr(Points p)
    {
    	return ((p.getX()-x)*(p.getX()-x)) + ((p.getY()-y)*(p.getY()-y));
    			
    }
    
}