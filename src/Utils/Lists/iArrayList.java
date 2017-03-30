package Utils.Lists;

public class iArrayList<T> {


	public iNode<T> first, last;
	public int count=0;
	
				@SuppressWarnings("hiding")
				public class iNode<T> {
					
					public iNode<T> Next;
					public T Data2;
					public double Data1;
					
					
					private iNode(double data, T data2, iNode<T> next) {
						// TODO Auto-generated constructor stub
						this.Data1 = data;
						this.Data2 = data2;
						this.Next = next;
						
						
					}
					
					
					
					
					
					@Override
					public String toString() {
						// TODO Auto-generated method stub
						return this.Data1 +" "+ this.Data2;
					}
					
					

				}
				
			
							
					
							
							
							/**
							 * Add to the list
							 * @param data1 first data to add to node
							 * @param data2 second data to add to node
							 * @return
							 */
							public boolean add(double data1, T data2)
							{
								iNode<T> iNode = new iNode<T>(data1, data2, null);
								if(this.count==0)
								{
									iNode.Next = null;
									this.first= iNode;
									this.last=iNode;
									this.count++;
									return true;
									
								}else
								if(this.count>=1)
								{
									iNode.Next = null;
									this.last.Next = iNode;
									this.last=iNode;
									this.count++;
									return true;
									
								}else
								{
									return false;
								}
									
							}
							
							
							/**
							 * Add node to list at a specific position. 
							 * @param data1 first data for the node
							 * @param data2 second data for the node
							 * @param i position to add node in
							 * @return
							 */
							public boolean addAtPos(double data1, T data2,int i)
							{						
								iNode<T> iNode = new iNode<T>(data1, data2, null);
								if(this.count==0)
								{
									iNode.Next = null;
									this.first=iNode;
									this.last=iNode;
									this.count++;
									return true;
										
								}else
									if(this.count>=1)
									{
										iArrayList<T>.iNode<T> nodeInPos = this.getNode(i);
										if(i==0)
										{
											iNode.Next = nodeInPos;
											this.first=iNode;
											this.count++;
											return true;
										}else if(i==this.count)
										{
											this.last.Next = iNode;
											this.last=iNode;
											this.count++;
											return true;
											
										}else 
										{
											iNode.Next = nodeInPos;
											this.getNode(i-1).Next = iNode;
											this.count++;	return true;
										}
								}else
								{
									return false;
								}
										
							}
							
							
							/**
							 * Get node from a specific index
							 * @param index - position in list to get data from
							 * @return
							 */
							public iNode<T> getNode(int index)
							{
								iArrayList<T>.iNode<T> temp;
								if(index==0)
								{
									temp=this.first;
								}else if(index==this.count-1)
								{
									temp = this.last;
								}else
								if(index<this.count-1 &&  index>0)
								{
									
									temp=this.first;
									for(int i=1; i<this.count; i++)
									{
										
										temp=temp.Next;
										if(i==index)
										{
											
											break;
										}
									}
									
								}else{
										
									temp = null;
								}
								return temp;
							}
							
							
							/**
							 * Remove node from list and dereference it 
							 * @param index position to get node from
							 * @return
							 */
							public boolean remove(int index)
							{
								iArrayList<T>.iNode<T> temp;
							 if(index>=0  && index<this.count)
							 {
								
								if(index==0)
								{
									if(this.count>1)
									{
										temp = this.first.Next;
										this.first=temp;
										this.count--;
										return true;
									}else {
								
										this.first=null;
										this.last=null;
										this.count--;
										return true;
									}
									
								}else
								if(index==this.count-1)//last
								{
									temp = this.getNode(index-1);
									temp.Next=null;
									this.last = temp;
									this.count--;
									return true;
								}else
								if(index>0)
								{
									iArrayList<T>.iNode<T> previous = this.getNode(index-1);
									iArrayList<T>.iNode<T> target = this.getNode(index);	
									previous.Next=target.Next;
									this.count--;
									return true;
									
								}else
								{
									return false;
								}
							
							}else
							{
								return false;
							}
							 
							
						  }
						 		
						
						 	
						 
						 
						 
						 
						 /**
						  * Get Node by the value of first data if first data is a number
						  * @param data value of data
						  * @return
						  */
						 public iNode<T> getNodeData1(double data)
						 { 
						 			iArrayList<T>.iNode<T> temp = this.first;
						 			boolean found = false;
						 			for( int i=0; i<this.count; i++)
						 			{
						 
						 				
						 				if(temp.Data1== data)
						 				{
						 					found=true;	
						 					break;
						 				}else {
						 					temp=temp.Next;
						 				}
						 			} 
						 		if(found==true)
						 		{		
						 			return temp;
						 		}else
						 		{
						 			return null;
						 		}
						 }
						 
						 
						 
						  
						  public void sort()
						  {
						  	
							  	 for( int i=0; i<this.count; i++)
							  	 {
							  	 	iArrayList<T>.iNode<T> temp = this.getNode(i);
							  	
							  	 	
							  	 	for( int  j=0; j<this.count; j++)
							  	 	{
							  	 		if(temp.Data1<this.getNode(j).Data1)
							  	 		{
							  	 			if(temp!=null && this.getNode(j)!=null)
							  	 			{
							  	 				double data1 = temp.Data1;
							  	 				T data2 = temp.Data2; 
							  	 			
							  	 				double nextData1 = this.getNode(j).Data1;
							  	 				T nextData2 = this.getNode(j).Data2;
							  	 			
							  	 				temp.Data1 = nextData1;
							  	 				temp.Data2 = nextData2;
							  	 			
							  	 				this.getNode(j).Data1 = data1;
							  	 				this.getNode(j).Data2 = data2;
							  	 				
							  	 			
							  	 			}
							  	 	   }
							  	 	
							  	 	}
							  	 }
						  }
						  
						  
						  
						  
						  public void sort_reverse()
						  {
						  	 
						  	for( int i=0; i<this.count; i++)
						  	{
						  	iArrayList<T>.iNode<T> temp = this.getNode(i);
						  
						  
						  	for(int j=0; j<this.count; j++)
						  	{
						  	if(temp.Data1>this.getNode(j).Data1)
						  	{
						  	if(temp!=null && this.getNode(j)!=null)
						  		{
						  		double data1 = temp.Data1;
						  		T data2 = temp.Data2;
						  
						  		double nextData1 = this.getNode(j).Data1;
						  		T nextData2 = this.getNode(j).Data2;
						  
						  		temp.Data1 = nextData1;
						  		temp.Data2 = nextData2;
						  
						  		this.getNode(j).Data1 = data1;
						  		this.getNode(j).Data2 = data2;
						  		 
						  
						  		}
						  		}
						  
						  		}
						  		}
						  		}
						  
						  
						  		
						 
				
							 
							 public int getNodeData1Index(double data)
							 { 
							 			iArrayList<T>.iNode<T> temp = this.first;
							 			boolean found = false;
							 			int num=0;
							 			for( int i=0; i<this.count; i++)
							 			{
							 
							 				
							 				if(temp.Data1== data)
							 				{
							 					found=true;	
							 					num=i;
							 					break;
							 				}else {
							 					temp=temp.Next;
							 				}
							 			} 
							 		if(found==true)
							 		{		
							 			return num;
							 		}else
							 		{
							 			return -1;
							 		}
							 }
							 
							 
							 public void removeByData1(double data1)
							 {
								 remove(getNodeData1Index(data1));
							 }
						 

	}

						

				
		
		
		



