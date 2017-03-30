
 /** IEngine 4.0
 * 10-29-2016
 * Isaac Parker
 * iNodeList class acts as a collection class to 
 * connect datas of the same type
 * **/
package Utils.Lists;

public class iNodeList<T> {

			@SuppressWarnings("hiding")
			public class iNode<T> {
				
				public iNode<T> Next;
				public T Data1,Data2;
				
				
				private iNode(T data, T data2, iNode<T> next) {
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
			
		
						
					public iNode<T> first, last;
					public int count=0;
						
						
						/**
						 * Add to the list
						 * @param data1 first data to add to node
						 * @param data2 second data to add to node
						 * @return
						 */
						public boolean add(T data1, T data2)
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
						public boolean addAtPos(T data1, T data2,int i)
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
									iNodeList<T>.iNode<T> nodeInPos = this.getNode(i);
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
							iNodeList<T>.iNode<T> temp;
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
							iNodeList<T>.iNode<T> temp;
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
								iNodeList<T>.iNode<T> previous = this.getNode(index-1);
								iNodeList<T>.iNode<T> target = this.getNode(index);	
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
					  
					  
					  
				
					 
						
					@Override
					public String toString() 
					{
					
						String string ="";
						for(int i=0; i<this.count; i++)
					 	{
					 		if(this.getNode(i)!=null || this.getNode(i).Data1!=null)
					 		{
					 			string+=this.getNode(i).Data1+ " "+this.getNode(i).Data2+"\n";
					 		}
					 	}
					 	return string;
					}

					
					
					 	
					 
					 
					 
					 
					 /**
					  * Get Node by the value of first data if first data is a number
					  * @param data value of data
					  * @return
					  */
					 public iNode<T> getNodeData1_Num(T data)
					 { 
					 			iNodeList<T>.iNode<T> temp = this.first;
					 			boolean found = false;
					 			for(int i=0; i<this.count; i++)
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
					 
					 /**
					  * Get Node by the value of first data if first data is a string
					  * @param data value of data
					  * @return
					  */
					 public iNode<T> getNodeData1_String(T data)
					 { 
					 			iNodeList<T>.iNode<T> temp = this.first;
					 			boolean found = false;
					 			for(int i=0; i<this.count; i++)
					 			{
					 
					 				
					 				if(temp.Data1.equals(data))
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
					 
					 
					
					 public int getNodeData1Index_Num(T data)
					 { 
					 			iNodeList<T>.iNode<T> temp = this.first;
					 			boolean found = false;
					 			int num=0;
					 			for(int i=0; i<this.count; i++)
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
					 
					
					 
					 public int getNodeData1Index_String(T data)
					 { 
					 			iNodeList<T>.iNode<T> temp = this.first;
					 			boolean found = false;
					 			int num=0;
					 			for(int i=0; i<this.count; i++)
					 			{
					 
					 				
					 				if(temp.Data1.equals(data))
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
					 
					 
					 
					 
					 public void removeByData1_num(T data1)
					 {
						 remove(getNodeData1Index_Num(data1));
					 }
					 
					 public void removeByData1_String(T data1)
					 {
						 remove(getNodeData1Index_String(data1));
					 }
					 

		}

					

			
	
	
	

