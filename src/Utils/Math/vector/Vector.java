package Utils.Math.vector;
import java.text.DecimalFormat;
//angle,magnitude
//magnitude = speed
//diagnal is vertical+horizontal vectors
//view vector = unit vector
//backstab = Unit targetToAttacker dotProduct Target unit

import Utils.Math.operations.VectorMath;
import Utils.Math.points.Points;

public class Vector {
	

	private double[] vect;
	
	public Vector() {
		// TODO Auto-generated constructor stub
	}
	
	public void setVector(double[] vector)
	{
		vect = vector;
	
	}
	
	public Vector(int size)
	{
		vect = new double[size];
	
	}
	
	public Vector(double...value)
	{
		
		vect = new double[value.length];
			int i =0;
			for(double v: value)
			{
				if(i<vect.length)
				{
					vect[i] = v;
					i++;
				}
			}
	}
	
	/**
	 * 
	 * @return
	 */
	public int length()
	{
		return vect.length;
	}
	
	/**
	 * 
	 * @return
	 */
	public double[] getVector() {
		return vect;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void fillVector(double...value)
	{
		
			int i =0;
			for(double v: value)
			{
				if(i<vect.length)
				{
					vect[i] = v;
					i++;
				}
			}
	}
	
	/**
	 * 
	 * @return
	 */
	public double sumElements()
	{
		double sum=0;
		for(int i=0; i<vect.length; i++)
		{
			
				sum = sum+vect[i];
			
		}
		return sum;
	}
	
	/**
	 * 
	 * @param element
	 */
	public void addElement(double element)
	{
		double[] temp = new double[vect.length+1] ;
		for(int i=0; i<vect.length; i++)
		{
			temp[i] = vect[i];
		}
		temp[temp.length-1] = element;
		vect = temp;
	}
	
	
	
	public void editElement(double element,int index)
	{
		vect[index] = element;
	}
	
	/**
	 * 
	 * @param index
	 */
	public void removeElement(int index)
	{
		if(index<0 || index>vect.length-1)
		{
			return;
		}else
		{
			double[] temp = new double[vect.length-1] ;
			boolean found=false;
			for(int i=0; i<vect.length; i++)
			{
				if(i==index)
				{
					found=true;
				}
				if(!found)
				{
					temp[i] = vect[i];
				}else
				{
					if(i!=vect.length-1)
					{
						temp[i] = vect[i+1];
					}
				}
			}
			vect=temp;	
		}
				
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String re="";
		for(int i=0; i<vect.length; i++)
		{
			re+=vect[i]+" ";
		}
		return re;
	}
	
	public double x2D()
	{
		if(vect.length==2)
		{
			return vect[0];
		}else
		{
			return -0.0;
		}
	}
	
	public double y2D()
	{
		if(vect.length==2)
		{
			return vect[1];
		}else
		{
			return -0.0;
		}
	}
	
	public double magnitude()
	{
		
		double sum=0;
		for(int i=0; i<vect.length; i++)
		{
			sum+=vect[i]*vect[i];
		}
		
		return Math.round(Math.sqrt(sum));
		
	}
	
	public double direction2D_Radian()
	{
		if(vect.length==2)
		{
			return Double.parseDouble(new DecimalFormat("#0.00").format(Math.atan(y2D()/x2D())));   
		}else
		{
			return -0.0;
		}
	}
	
	public double direction2D_Degree()
	{
		return Math.round(Double.parseDouble(new DecimalFormat("#0.00").format((direction2D_Radian()*(180/Math.PI))))) ;
	}
	
	public double magnitude_Sqr()
	{

		double sum=0;
		for(int i=0; i<vect.length; i++)
		{
			sum+=vect[i]*vect[i];
		}
		return sum;
	}
	
	
	public Vector unitVector()
	{
		
		return VectorMath.multiplyByScalar(this, 1/magnitude());	
		
	}
	
	public double unitCircleDegree()
	{
		Vector uv= unitVector();
		if(uv.getVector()[0]<0)
		{
			return -uv.direction2D_Degree();
		}else
		{
			return uv.direction2D_Degree();
		}
	}
	
	public double unitCircleQuad()
	{
		Vector uv= unitVector();
		if(uv.getVector()[1]<0)
		{
			if(uv.getVector()[0]<0)
			{
				return 3;
			}return 4;
			
		}else
		{
			if(uv.getVector()[0]<0)
			{
				return 2;
			}return 1;
		}
	}
	
	public boolean equals(Vector v2)
	{
		boolean equal = true;
		if(this.length()!=v2.length())
		{
			equal=false;
		}
		if(!equal)
		{
			return equal;
		}
		for(int i=0; i<v2.length(); i++)
		{
			if(getElement(i)!= v2.getElement(i))
			{
				equal = false;
				break;
			}
			
		}
		if(equal && magnitude_Sqr()==v2.magnitude_Sqr())
		{ return true; } return false;
	}
	
	
	public double getElement(int index)
	{
		if(index<0 || index>this.length()-1)
		{
			return -0.000000000000001;
		}
		
		return vect[index];
	}
	
	public Points toPoint()
	{
		return new Points(x2D(), y2D());
	}
	
	
}
