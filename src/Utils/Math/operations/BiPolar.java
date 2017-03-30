package Utils.Math.operations;

public class BiPolar {
	
	public static double binaryToBipolar(final double d)
	{
		double v = (2*(d))-1;
		return v;
	}
	
	public static double[] binaryToBipolar(final double d[])
	{
		double temp[] = new double[d.length];
		for(int i=0; i<d.length; i++)
		{
			temp[i] = binaryToBipolar(d[i]);
		}
		
		return temp;
	}
	
	public static double[][] binaryToBipolar(final double[][] d)
	{
		double temp[][] = new double[d.length][d[0].length];
		for(int i=0; i<d.length; i++)
		{
			for(int j=0; j<d[i].length; j++)
			{
				temp[i][j] = binaryToBipolar(d[i][j]);
			}
		}
		
		return temp;
	}
	
	
	public static double bipolarToBinary(final double d)
	{
		double v = (d+1)/2;
		return v;
	}
	
	public static double[] bipolarToBinary(final double d[])
	{
		double temp[] = new double[d.length];
		for(int i=0; i<d.length; i++)
		{
			temp[i] = bipolarToBinary(d[i]);
		}
		
		return temp;
	}
	
	public static double[][] bipolarToBinary(final double[][] d)
	{
		double temp[][] = new double[d.length][d[0].length];
		for(int i=0; i<d.length; i++)
		{
			for(int j=0; j<d[i].length; j++)
			{
				temp[i][j] = bipolarToBinary(d[i][j]);
			}
		}
		
		return temp;
	}	
	
	
	public static double bipolar2double(final boolean b)
	{
		if(b==true)
		{
			return 1;
		}else {  return -1; }
	}
	
	public static double[] bipolar2double(final boolean b[])
	{
		double temp[] = new double[b.length];
		for(int i=0; i<b.length; i++)
		{
			temp[i] = bipolar2double(b[i]);
		}
		return temp;
	}
	
	public static double[][] bipolar2double(final boolean b[][])
	{
		double[][] temp = new double[b.length][b[0].length];
		for(int i=0; i<b.length; i++)
		{
			for(int j=0; j<b[i].length; j++)
			{
				temp[i][j] = bipolar2double(b[i][j]);
			}
		}
		return temp;
		
	}
	
	public static boolean double2bipolar(final double d)
	{
		if(d==1)
		{
			return true;
		}else {return false;}
	}
	
	public static boolean[] double2bipolar(final double d[])
	{
		boolean temp[] = new boolean[d.length];
		for(int i=0; i<d.length; i++)
		{
			temp[i] = double2bipolar(d[i]);
		}
		return temp;
		
	}
	
	public static boolean[][] double2bipolar(final double d[][])
	{
		boolean[][] temp = new boolean[d.length][d[0].length];
		for(int i=0; i<d.length; i++)
		{
			for(int j=0; j<d[i].length; j++)
			{
				temp[i][j] = double2bipolar(d[i][j]);
			}
		}
		return temp;
	}
	
	
	
	
}