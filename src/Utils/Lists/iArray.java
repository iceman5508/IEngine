package Utils.Lists;

public class iArray<T> {

	private int elementCount, rows=0,cols=0;
	private iArrayList<iArrayList<T>> Array;
	private int currentIndex = 0;
	

	
	public iArray() {
		// TODO Auto-generated constructor stub
		this.rows=1;
		Array= new iArrayList<>();
		Array.add(currentIndex,new iArrayList<T>() );
		
	}
	
		
	public iArray(int cols) {
		// TODO Auto-generated constructor stub
		this.rows=1;
		if(cols>=1)
		{
			this.cols=cols;
		}else
		{
			this.cols=1;
		}
		
		Array= new iArrayList<>();
		Array.add(currentIndex,new iArrayList<T>() );
		
		
	}
	
	public void add(T data)
	{
		if(rows==1&&cols==1)
		{
			Array.first.Data2.add(currentIndex, data);
			elementCount++;
		}
		else
		{
			if(Array.getNode(currentIndex).Data2.count==cols) //if max cols reached
			{
				Array.add(currentIndex, new iArrayList<T>());
				currentIndex++;
				Array.getNode(currentIndex).Data2.add(currentIndex, data);
				elementCount++;
			}else
			{
				Array.getNode(currentIndex).Data2.add(currentIndex, data);
				elementCount++;
			}
		}
	}
	
	public void add(T data, int row)
	{
	
		if(rows>1 && cols>1)
		{
			if(row<=getSize()-1&&row>=0)
			{
				Array.getNode(row).Data2.add(currentIndex, data);
				elementCount++;
			}
		}
	}
	
	public void add(T data, int row, int col)
	{
	
		if(row>=0 && row<=getSize()-1)
		{
			if(col>=0 && col<=Array.getNode(row).Data2.count-1)
			{
				
				Array.getNode(row).Data2.addAtPos(currentIndex, data, col);
				elementCount++;
			}
		}
	}
	
	public void editElement(T data, int col,int row)
	{
		if(row>=0 && row<=getSize()-1)
		{
			if(col>=0 && col<=Array.getNode(row).Data2.count-1)
			{
				
				Array.getNode(row).Data2.getNode(col).Data2 = data;
				
				
			}
		}
	}
	
	public void editRow(iArrayList<T> newRow, int row)
	{
		if(row>=0 && row<=getSize()-1)
		{
			Array.getNode(row).Data2 = newRow;
		}
	}
	
	public void swapElements(int col1,int row1, int col2,int row2 )
	{
		if(row1>=0 && row1<=getSize()-1)
		{
			if(col1>=0 && col1<=Array.getNode(row1).Data2.count-1)
			{
				if(row2>=0 && row2<=getSize()-1)
				{
					if(col2>=0 && col2<=Array.getNode(row2).Data2.count-1)
					{
						
						T data = Array.getNode(row1).Data2.getNode(col1).Data2;
						T data2 = Array.getNode(row2).Data2.getNode(col2).Data2;
						Array.getNode(row1).Data2.getNode(col1).Data2 = data2;
						data2 = Array.getNode(row2).Data2.getNode(col2).Data2 = data;
					}
				}				
				
			}
		}
	}
	
	
	public void swapRows(int row1,int row2)
	{
		if(row1>=0 && row1<=getSize()-1)
		{
			if(row2>=0 && row2<=getSize()-1)
			{
				iArrayList<T> rowTo = Array.getNode(row1).Data2;
				iArrayList<T> rowToo = Array.getNode(row2).Data2;
				Array.getNode(row1).Data2 = rowToo;
				Array.getNode(row2).Data2 = rowTo;
				
			}
		}
	}
	
	
	public int getSize() {
		return Array.count;
	}
	
	public int getRows() {
		return Array.count;
	}
	
	public int getCols() {
		return cols;
	}
	
	
	/*public void setAddingRow(int row)
	{
		if(row<=getSize()-1&&row>=0)
		{
			this.currentIndex=row;
		}
		
	}*/
	
	public int getElementCount() {
		return elementCount;
	}
	
	
	
	public iArrayList<T> get(int row)
	{
		if(row<=getSize()-1&&row>=0)
			{
				return Array.getNode(row).Data2;
			}else
			{
				return null;
			}
	}
	
	public T get(int row,int col)
	{
		if(row<=getSize()-1&&row>=0)
			{
				if(col<=Array.getNode(row).Data2.count-1 && col>=0)
				{
					return Array.getNode(row).Data2.getNode(col).Data2;
				}else
				{
					return null;
				}
			}else
			{
				return null;
			}
	}
	
	
	public void remove()
	{
		elementCount = elementCount - Array.getNode(0).Data2.count;
		Array.remove(0);
		
	}
	
	public void remove(int row)
	{
		if(row<=getSize()-1&&row>=0)
			{
				elementCount = elementCount - Array.getNode(row).Data2.count;
				Array.remove(row);
				

			}
	}
	
	public void remove(int row,int col)
	{
		
		if(row<=getSize()-1&&row>=0)
			{
				if(Array.getNode(row).Data2.count==0)
				{
					Array.remove(row);
				}else
				if(col<=Array.getNode(row).Data2.count-1 && col>=0)
				{
					Array.getNode(row).Data2.remove(col);
					elementCount--;
				}
			}
	}
	
	public iArrayList<T> getFirst()
	{
		return Array.getNode(0).Data2;
	}
	
	
	public void newRows(int numRows)
	{
		for(int i=0; i<numRows; i++)
		{
			Array.add(getRows()+1, new iArrayList<T>());
		}
		rows = getRows();
	}
	
	
	
}
