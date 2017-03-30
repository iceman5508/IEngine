package Utils.Math.matrix;




public class Matrix {
	
	private double matrix[][];
	private double vector[];
	private int rows,cols;
	private boolean isVector=false;

	public double[][] getMatrix() {
		return matrix;
	}

	public double[] getVector() {
		return vector;
	}

	public Matrix(int row, int col)
	{
		matrix = new double[row][col];
		this.rows = row;
		this.cols = col;
		for(int i=0; i<matrix.length; i++)
		{

			for(int j=0; j<matrix[i].length; j++)
			{
				matrix[i][j]=0.000;
			}			
		
		}
	}
	
	public Matrix(int length)
	{
		this.cols=length;
		this.rows=1;
		isVector=true;
		
		vector = new double[cols];
		for(int i=0; i<vector.length; i++)
	 	{
	 		vector[i]=0.000;
	 	}
	
	}
	
	public Matrix(double[][] matrix)
	{
		this.matrix=matrix;
		rows = matrix.length;
		cols = matrix[0].length;
		
		
		
	}
	
	public Matrix(double[] vector)
	{
		isVector = true;
		this.vector=vector;
		rows = 1;
		cols = vector.length;		
		
	}

	
	public boolean isZero()
	{
		if(isVector)
		{
			int i=0;
			for(double b: vector)
			{
				if(b==0)
				{
					i++;
				}
			}
			if(i==vector.length)
			{
				return true;
			}else{return false;}
		}else
		{
			int n=0;
			for(int i=0; i<matrix.length; i++ )
			{
				for(int j=0; j<matrix[i].length; j++)
				{
					if(matrix[i][j]==0)
					{
						n++;
					}
				}
			}
			if(n==rows*cols)
			{
				return true;
			}else{return false;}			
		}
			
	}
	
	public void fillVector(double...value)
	{
		if(isZero()&&isVector)
		{
			int i =0;
			for(double v: value)
			{
				if(i<cols)
				{
					vector[i] = v;
					i++;
				}
			}
		}
	}
	
	public void fillMatrix(double[]...value)
	{
		if(isZero()&&!isVector)
		{
			int i =0; 
			for(double[] v: value)
			{
				
				if(i<rows && v.length <= cols)
				{
					
					
						matrix[i] = v;
						i++;
				}
				
			}
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String rt="";
		if(isVector)
		{
			for(int i=0; i<vector.length; i++)	
			{
				rt += vector[i]+" ";
			}
		}else
		{
			for(int i=0; i<matrix.length; i++)	
			{
				for(int j=0; j<matrix[i].length; j++)
				{
					rt += matrix[i][j]+" ";
				}
				rt+="\n";
			}
				
		}
		return rt;
	}
	
	public static void toString(double[] vector) 
	{
		
			for(int i=0; i<vector.length; i++)	
			{
				System.out.print(vector[i]+" ");
			}
					
		
	}
	
	public static void toString(double[][] matrix) 
	{
		
			for(int i=0; i<matrix.length; i++)	
			{
				for(int j=0; j<matrix[i].length; j++)
				{
					System.out.print(matrix[i][j]+" ");
				}
				System.out.println();
			}
					
		
	}
	
	public double[] getColumn(int num)
	{
		if(!isVector)
		{
			double[] column = new double[rows];
			num = num-1;
			for(int i=0; i<rows; i++)
			{
				try
				{
					column[i] = matrix[i][num];
				}
				catch(Exception e)
				{
					
				}
			}
			return column;
		}
		else
		{
			return null;
		}
	}
	
	
	public void addRow(double[]...array)
	{
		int row = array.length+rows;
		Matrix b = new Matrix(row,2);		
		double c[][]=b.newRow(matrix,array);
		rows = row;
		this.matrix = new double[row][cols];		
		this.matrix = c;
	}
	
	private double[][] newRow(double[][] array1,double[][] array) {
		// TODO Auto-generated method stub
		int c=0;
		double[][] temp = new double[array1.length+array.length][cols];
		for(double[] ar: array1)
		{
			
			temp[c] = ar;
			c++;
		}
		for(double[] ar: array)
		{
			temp[c] = ar;
			c++;
			
		}
		return temp;
	}
	
	
	public boolean equals(Matrix m)
	{
		if(this==m)
		{
			return  true;
		}else {return false;}
	}
	
	
	public double sumElements()
	{
		double sum=0;
		if(!isVector)
		{
			
			for(int i=0; i<matrix.length; i++)
			{
				for(int j=0; j<matrix[i].length; j++)
				{
					sum = sum+matrix[i][j];
				}
			}
			return sum;
		}else 
		{
			
			for(int i=0; i<vector.length; i++)
			{
				
					sum = sum+vector[i];
				
			}
			return sum;
		}
		
	}
	
	public int getRowNumber() {
		return rows;
	}


	public int getColNumber() {
		return cols;
	}
	
	public double[] getRow(int row)
	{
		row = row-1;
		return matrix[row];
	}
	
	public double[] toPackedArray()
	{
		int i=0;
		double temp[] = new double[matrix.length*matrix[0].length];
		for(double[] v: matrix)
		{
			for(double w: v)
			{	
				temp[i] = w;
				i++;
			}
		}
		
		return temp;
	}

	
	public boolean isVector()
	{
		return isVector;
	}
}
