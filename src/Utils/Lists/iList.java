 /** IEngine 4.0
 * 10-29-2016
 * Isaac Parker
 * List class able to make a list of data
 */
package Utils.Lists;

public class iList<T> {
	
	private int count=0;
	private item first,last;
	
	public iList() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Add an item to the list
	 * @param item the item being added
	 */
	public void addItem(T item)
	{
		item it = new item();
		it.Data = item;
		
		if(count==0)
		{
			first = it;
			last = it;
		}
		if(count>0)
		{
			last.next = it;
			last = it;
			
		}
		count++;
		
	}
	
	
	/**
	 * remove the first item from the list and dereference it
	 */
	public void removeFirst()
	{
		if(count>1)
		{
			first = first.next;
		}else
		{
			first=null;
			last=null;
		}
		count--;
	}
	
	
	/**
	 * remove the last item from the list and dereference it
	 */
	public void removeLast()
	{
		if(count==1)
		{
			first=null;
			last=null;
		}else
		{
			last=getAtIndex(count-2);			
			last.next=null;
		}
		count--;
	}
	
	
	/**
	 * get a list item at specific location
	 * @param i index to pick from
	 * @return
	 */
	public item getAtIndex(int i)
	{
		if(i>0 && i!=count)
		{
			iList<T>.item temp = first;
			for(int j=0; j<count; j++)
			{
			  if(j!=i)
			  {
				  temp = temp.next;
			  }
			  else
			  {
				  break;
			  }
			}
			return temp;
			
		}
		else if(i==0)
		{
			return first;
		}else if(i==count)
		{
			return last;
		}
		else
		{
			return null;
		}
	}
			
			
	
	
	
	
	
	
	
	public class item
	{
	   private item()
	   {
		   
	   }
	 public item next;
	  
	 public T Data;
	 
	
	}
	
	/**
	 * get first item
	 * @return
	 */
	public item getFirst() {
		return first;
	}
	
	/**
	 * get last item
	 * @return
	 */
	public item getLast() {
		return last;
	}
	
	
	/**
	 * get count of items in the list
	 * @return
	 */
	public int getCount() {
		return count;
	}

}
