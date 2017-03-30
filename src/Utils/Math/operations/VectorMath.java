package Utils.Math.operations;

import Utils.Math.vector.Vector;

public class VectorMath {

	public static Vector addition(Vector v1, Vector v2)
	{
	   
		if(v1.length()==v2.length())
		{
			double[] re = new double[v1.length()]; 
			for(int i=0; i<v1.length(); i++)
			{
				re[i] = v1.getVector()[i]+v2.getVector()[i];
			}
			Vector retu = new Vector(re);
			return retu;
		}
		return null;
	}
	
	
	public static Vector subtraction(Vector v1, Vector v2)
	{
	   
		if(v1.length()==v2.length())
		{
			double[] re = new double[v1.length()]; 
			for(int i=0; i<v1.length(); i++)
			{
				re[i] = v1.getVector()[i]-v2.getVector()[i];
			}
			Vector retu = new Vector(re);
			return retu;
		}
		return null;
	}
	
	public static Vector multiplyByScalar(Vector v, double scalar)
	{
		
		Vector v2 = new Vector(v.length());
		for(int i=0; i<v2.length(); i++)
		{
			v2.getVector()[i] = v.getVector()[i]*scalar;
		}
		return v2;
	}
	
	public static double dotProduct(Vector v1, Vector v2)
	{
	   
		if(v1.length()==v2.length())
		{
			double sum=0;
			for(int i=0; i<v1.length(); i++)
			{
				sum += v1.getVector()[i]*v2.getVector()[i];
			}
			
			return sum;
		}
		return 0.0;
	}
	
	
	public static Vector crossProduct(Vector v1, Vector v2)
	{
	   
		if(v1.length()==v2.length()&&v1.length()==3)
		{
			//0=x 1=y 2=z
			double cx = (v1.getVector()[1]*v2.getVector()[2])-(v1.getVector()[2]*v2.getVector()[1]); 
			double cy=(v1.getVector()[2]*v2.getVector()[0])-(v1.getVector()[0]*v2.getVector()[2]);
			double cz=(v1.getVector()[0]*v2.getVector()[1])-(v1.getVector()[1]*v2.getVector()[0]);
			double[] ar = {cx,cy,cz};
			return new Vector(ar);
		}
		return null;
	}
	
	public static double angleBetweenVectors_Radian(Vector v1, Vector v2)
	{
		return Math.acos((dotProduct(v1, v2))/(v1.magnitude()*v2.magnitude()));
	}
	
	public static double angleBetweenVectors_Degree(Vector v1, Vector v2)
	{
		return Math.acos((dotProduct(v1, v2))/(v1.magnitude()*v2.magnitude()))*(180/Math.PI);
	}
	
	public static double directionComapre(Vector v1, Vector v2)
	{
		return dotProduct(v1.unitVector(), v2.unitVector());
	}
	
	public static Vector vectorTo(Vector v1, Vector v2)
	{
		return VectorMath.subtraction(v2, v1);
	}
	
}
