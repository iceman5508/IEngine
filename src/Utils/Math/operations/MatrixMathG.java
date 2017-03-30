package Utils.Math.operations;







public class MatrixMathG <T>{
	
	/*
	private T[][] tanspose2(T[][] array)
	{
		int width = array.length;
		  int height = array[0].length;

		  T[][] array_new = (T[][]) new Object[height][width];

		  for (int x = 0; x < width; x++) {
		    for (int y = 0; y < height; y++) {
		      array_new[y][x] = array[x][y];
		    }
		  }
		  return array_new;
	}*/
	
	public T[][] transpose(T[][] m) {
        for (int i = 0; i < m.length; i++) {
        	
            for (int j = i; j < m[0].length; j++) {
                T x = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = x;
            }
        }
        return m;
    }


    public T[][] rotateLeft(T[][] m) {
        // transpose
       m = transpose(m);

        //  swap rows
        for (int  i = 0; i < m.length/2; i++) {
            for (int j = 0; j < m[0].length; j++) {
                T x = m[i][j];
                m[i][j] = m[m.length -1 -i][j]; 
                m[m.length -1 -i][j] = x;
            }
        }
        return m;
    }


    public T[][] rotateRight(T[][] m) {
        // transpose
        transpose(m);

        // swap columns
        for (int  j = 0; j < m[0].length/2; j++) {
            for (int i = 0; i < m.length; i++) {
                T x = m[i][j];
                m[i][j] = m[i][m[0].length -1 -j]; 
                m[i][m[0].length -1 -j] = x;
            }
        }
        
        return m;
    }	
	
	
	
	
	
	
	
	
	
	
	
	
}
