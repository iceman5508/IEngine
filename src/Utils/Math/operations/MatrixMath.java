package Utils.Math.operations;

import Utils.Math.matrix.Matrix;

public class MatrixMath {
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static Matrix add(Matrix a, Matrix b)
	{
		Matrix c = new Matrix(a.getRowNumber(),a.getColNumber());
		
		if(b.isVector()!=a.isVector())
		{
			return c;
		}else
		{
			if(!a.isVector())
			{
				if(a.getRowNumber() == b.getRowNumber() && a.getColNumber()==b.getColNumber())
				{
					for(int i=0; i<a.getMatrix().length; i++)
					{
						for(int j=0; j<a.getMatrix()[i].length; j++)
						{
							c.getMatrix()[i][j]=a.getMatrix()[i][j]+b.getMatrix()[i][j];
						}
					}
					return c;
				}else { return c; }
			}else
			{
				for(int i=0; i<a.getVector().length; i++)
				{
					c.getVector()[i]=a.getVector()[i]+b.getVector()[i];
				}
				return c;
			}
		}
	}

	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static Matrix subtract(Matrix a, Matrix b)
	{
		Matrix c = new Matrix(a.getRowNumber(),a.getColNumber());
		if(b.isVector() != a.isVector())
		{
			return c;
		}else
		{
			if(!a.isVector())
			{
				if(a.getRowNumber() == b.getRowNumber() && a.getColNumber()==b.getColNumber())
				{
					for(int i=0; i<a.getMatrix().length; i++)
					{
						for(int j=0; j<a.getMatrix()[i].length; j++)
						{
							c.getMatrix()[i][j]=a.getMatrix()[i][j]-b.getMatrix()[i][j];
						}
					}
					return c;
				}else { return c; }
			}else
			{
				for(int i=0; i<a.getVector().length; i++)
				{
					c.getVector()[i]=a.getVector()[i]-b.getVector()[i];
				}
				return c;
			}
		}
		
		
	}
	
	public static Matrix identity( int size)
	{
		Matrix m = new Matrix(size,size);
		for(int i=0; i<m.getMatrix().length; i++)
		{
			for(int j=0; j<m.getMatrix()[i].length; j++)
			{
				if(j==i)
				{
					m.getMatrix()[i][j] = 1;
				}
				else { m.getMatrix()[i][j] = 0;  }
			}			
		}
		return m;
	}
	
	
	public static Matrix multiply(Matrix a, double b)
	{
		
		if(!a.isVector())
		{
			Matrix m = new Matrix(a.getRowNumber(),a.getColNumber());
			for(int i=0; i<a.getMatrix().length; i++)
			{
				for(int j=0; j<a.getMatrix()[i].length; j++)
				{
					m.getMatrix()[i][j] = b*a.getMatrix()[i][j] ;
					
				}			
			}
			return m;
			
		}else
		{
			Matrix m = new Matrix(a.getRowNumber());
			for(int i=0; i<a.getVector().length; i++)
			{
				m.getVector()[i]= b*a.getVector()[i] ;
				
			}	
			return m;
		}
	}
	
	
	
	public static Matrix multiply(Matrix a, Matrix b)
	{
		Matrix result = new Matrix(a.getMatrix().length,b.getMatrix()[0].length);

		/* Loop through each and get product, then sum up and store the value */
		for (int i = 0; i < a.getMatrix().length; i++) { 
		    for (int j = 0; j < b.getMatrix()[0].length; j++) { 
		        for (int k = 0; k < a.getMatrix()[0].length; k++) { 
		            result.getMatrix()[i][j] += a.getMatrix()[i][k] * b.getMatrix()[k][j];
		        }
		    }
		}
		/* Show the result */
		return result;
	}
	
	

	
	public static double dotProduct(Matrix a, Matrix b)
	{
	
	        if (a.getRowNumber() != b.getRowNumber()) throw new RuntimeException("Dimensions don't agree");
	        double sum = 0.0;
	        for (int i = 0; i < a.getColNumber(); i++)
	        {
	            sum = sum + (a.getVector()[i] * b.getVector()[i]);
	        }
	        return sum;
	    
	}
	
	
	
	
	
	public static Matrix divide(Matrix a, double b)
	{
		b = 1/b;
		return multiply( a,  b);
	}
	
	
	public static Matrix transpose(Matrix a)
	{
			Matrix c = new Matrix(0,0);
			for(int i=0; i<a.getRowNumber(); i++)
			{
				c.addRow(a.getColumn(i+1));
			}
			return c;
		
	}
	
	public static Matrix diagonalZeroIdentity(Matrix m)
	{
		Matrix i = identity(m.getRowNumber());
		return subtract(m, i);
	}
	
	
	
	
	
	private static double[][] swapRows(double[][] m) {
	    for (int  i = 0, k = m.length - 1; i < k; ++i, --k) {
	        double[] x = m[i];
	        m[i] = m[k];
	        m[k] = x;
	    }
	    return m;
	}

	public static Matrix rotateByNinetyToLeft(Matrix m) {
		
		
	    double[][] d = swapRows(transpose(m).getMatrix());
	   return new Matrix(d);
	    
	}

	public static Matrix rotateByNinetyToRight(Matrix m) {
	    double[][] d = swapRows(m.getMatrix());
	    return transpose(new Matrix(d));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
