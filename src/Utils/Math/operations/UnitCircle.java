package Utils.Math.operations;

public class UnitCircle {

	public static final double PI = Math.PI;
	public static double toRadian(double degree)
	{
		return degree*(Math.PI/180);
	}
	
	public static double toDegree(double radian)
	{
		return radian*(180/Math.PI); 
	}
	
	public static double cos(double degree)
	{
		return Math.cos(degree);
	}
	
	public static double sin(double degree)
	{
		return Math.sin(degree);
	}
	
	public static double tan(double degree)
	{
		return Math.tan(degree);
	}
	
	
	
}
