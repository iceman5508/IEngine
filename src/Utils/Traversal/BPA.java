package Utils.Traversal;

import Utils.Lists.iArrayList;
import Utils.Lists.iList;
import Utils.Math.vector.Vector;
import core.Maps.tileMap;
import core.Objects.Tiles;

public class BPA {
	private double[][] adjency;
	private iArrayList<cell> cells;
	private cell sourceCell;
	private cell currentChild;
	private iArrayList<Double> visited;
	private double source,end;
	private iList<Double> path;
	private tileMap map;
	
	public BPA(tileMap map) {
		// TODO Auto-generated constructor stub
		cells = new iArrayList<>();
		visited = new iArrayList<>();
		adjency = new double[map.getNumRows()][map.getNumCols()];
		this.map = map;
		
		for(int i=0; i<map.getNumRows(); i++)
		{
			for(int y=0; y<map.getNumCols(); y++)
			{
				adjency[i][y] = !map.isTileWalkable(y, i)?map.getTile(i, y).getId():-1;
			}
		}
	}
	
	public BPA() {
		// TODO Auto-generated constructor stub
		cells = new iArrayList<>();
		visited = new iArrayList<>();
		
	}
	
	
	private void run(tileMap map,cell sourceCell)
	{
		while(sourceCell.kids.getCount()>0)
		{
			cell checking = sourceCell.kids.getFirst().Data;
			addGreatGrandKids(map, checking);
			sourceCell.kids.removeFirst();
			visited.add(checking.value, checking.value);
			run(map, checking);
			
		}
	}
	
	
	public void findPathTo(double source, double destination,tileMap map)
	{
		boolean found=false;
		/******************start search*************************/
		if(sourceCell==null)
		{
			sourceCell = new cell(source);
			addKids(map, sourceCell);
			this.source=source;
			this.end=destination;
			cells.add(source, sourceCell);
			visited.add(source, source);
		}
		while(sourceCell.kids.getCount()>0&&!found)
		{
			currentChild = sourceCell.kids.getFirst().Data;
			if(visited.getNodeData1(currentChild.value)==null)
			{
				visited.add(currentChild.value, currentChild.value);
				addGrandKids(map, currentChild);
			}if(currentChild.value==end)
			{
				cells.add(end, currentChild);
				found=true;
				break;
			}
			else
			if(currentChild.kids.getCount()==0)
			{
				cells.add(currentChild.value, currentChild);
				sourceCell.kids.removeFirst();
			}else
			{
				run(map, currentChild);
				
			}
			
			
		}
			
		makePath();
	}
	
	private class cell
	{
		
		public final double value,distance;
		public final cell parent;
		public final int index;
		public final iList<cell> kids;
		
		cell(double value,cell parent)
		{
			
			this.value=value;
			this.parent = parent;
			this.distance = parent.distance+1;
			this.kids= new iList<cell>();
			if(cells.count==0)
			{
				this.index=0;
			}else
			{
				this.index = cells.last.Data2.index+1;
			}
		}	
		
		
		cell(double value)
		{
			
			this.value=value;
			this.parent = null;
			this.distance = 0;
			this.kids= new iList<cell>();
			if(cells.count==0)
			{
				this.index=0;
			}else
			{
				this.index = cells.last.Data2.index+1;
			}
		}	
		
	}

	
	
	private boolean validPoint(int y,int x)
	{
		return !(y<0 || y>=adjency.length || x<0 || x>adjency[y].length );
				
				
	}

	private void addKids(tileMap map,cell parent)
	{
		Vector sourceInfo = map.get_Row_Col_FromId((int) parent.value);
		int row = (int) sourceInfo.x2D();
		int col = (int) sourceInfo.y2D();
		if(validPoint(row+1, col)&&!map.getTile(row+1, col).isSolidTile())
		{
			parent.kids.addItem(new cell((double) map.getTile(row+1, col).getId(),parent));

		}
		
		if(validPoint(row-1, col)&&!map.getTile(row-1,col).isSolidTile())
		{
			parent.kids.addItem(new cell((double)map.getTile(row-1,col).getId(),parent));
			
		}
		
		if(validPoint(row, col+1)&&!map.getTile(row,col+1).isSolidTile())
		{
			parent.kids.addItem(new cell((double)map.getTile(row,col+1).getId(),parent));
			
		}
		
		if(validPoint(row, col-1)&&!map.getTile(row,col-1).isSolidTile())
		{
			parent.kids.addItem(new cell((double)map.getTile(row,col-1).getId(),parent));
			
		}
	}
	
	private void addGrandKids(tileMap map,cell parent)
	{
		Vector sourceInfo = map.get_Row_Col_FromId((int) parent.value);
		int row = (int) sourceInfo.x2D();
		int col = (int) sourceInfo.y2D();
		if(validPoint(row+1, col)&&!map.getTile(row+1, col).isSolidTile())
		{
			if(visited.getNodeData1(map.getTile(row+1, col).getId()) == null)
			{
				parent.kids.addItem(new cell((double) map.getTile(row+1, col).getId(),parent));
			}
		}
		
		if(validPoint(row-1, col)&&!map.getTile(row-1,col).isSolidTile())
		{
			if(visited.getNodeData1(map.getTile(row-1,col).getId())==null)
			{
				parent.kids.addItem(new cell((double)map.getTile(row-1,col).getId(),parent));
			
			}
		}
		
		if(validPoint(row, col+1)&&!map.getTile(row,col+1).isSolidTile())
		{
			if(visited.getNodeData1(map.getTile(row,col+1).getId())==null)
			{
				parent.kids.addItem(new cell((double)map.getTile(row,col+1).getId(),parent));
			}
		
		}
		
		if(validPoint(row, col-1)&&!map.getTile(row,col-1).isSolidTile())
		{
			if(visited.getNodeData1(map.getTile(row,col-1).getId())==null)
			{
				parent.kids.addItem(new cell((double)map.getTile(row,col-1).getId(),parent));
			}
			
		}
	}
	
	
	private void addGreatGrandKids(tileMap map,cell parent)
	{
		Vector sourceInfo = map.get_Row_Col_FromId((int) parent.value);
		int row = (int) sourceInfo.x2D();
		int col = (int) sourceInfo.y2D();
		if(validPoint(row+1, col)&&!map.getTile(row+1, col).isSolidTile())
		{
			if(visited.getNodeData1(map.getTile(row+1, col).getId()) == null)
			{
				parent.kids.addItem(new cell((double) map.getTile(row+1, col).getId(),parent));
				cells.add((double) map.getTile(row+1, col).getId(), 
				 new cell((double) map.getTile(row+1, col).getId(), parent));
			}
		}
		
		if(validPoint(row-1, col)&&!map.getTile(row-1,col).isSolidTile())
		{
			if(visited.getNodeData1(map.getTile(row-1,col).getId())==null)
			{
				parent.kids.addItem(new cell((double)map.getTile(row-1,col).getId(),parent));
				cells.add((double)map.getTile(row-1,col).getId(), 
						 new cell((double) map.getTile(row-1,col).getId(), parent));
			}
		}
		
		if(validPoint(row, col+1)&&!map.getTile(row,col+1).isSolidTile())
		{
			if(visited.getNodeData1(map.getTile(row,col+1).getId())==null)
			{
				parent.kids.addItem(new cell((double)map.getTile(row,col+1).getId(),parent));
				cells.add((double)map.getTile(row,col+1).getId(), 
						 new cell((double)map.getTile(row,col+1).getId(), parent));
			
			}
		
		}
		
		if(validPoint(row, col-1)&&!map.getTile(row,col-1).isSolidTile())
		{
			if(visited.getNodeData1(map.getTile(row,col-1).getId())==null)
			{
				parent.kids.addItem(new cell((double)map.getTile(row,col-1).getId(),parent));
				cells.add((double)map.getTile(row,col-1).getId(), 
						 new cell((double)map.getTile(row,col-1).getId(), parent));
			}
			
		}
	}
	
	private cell lowestOfValue(double sourceValue )
	{
		cell lowest=null;
		for(int i=0; i<cells.count; i++)
		{
			if(cells.getNode(i).Data1==sourceValue)
			{
				if(lowest==null)
				{
					lowest = cells.getNode(i).Data2;
				}else
				{
					if(cells.getNode(i).Data2.distance<lowest.distance)
					{
						lowest = cells.getNode(i).Data2;
					}
				}
			}
		}
		return lowest;
	}
	
	
	private void makePath()
	{
		path = new iList<>();
		cell low = lowestOfValue(end);
		iList<Double> temp = new iList<>();
		if(low!=null)
		{
		temp.addItem(low.value);
		while(low.value!=source)
		{
			low = low.parent;
			temp.addItem(low.value);
		}
		
		while(temp.getCount()>0)
		{
			path.addItem(temp.getLast().Data);
			temp.removeLast();
		}
		}else
		{
			basicPath();
		}
		
	}
	
	
	public iList<Double> getPath()
	{
		return path;
	}
	
	
	public void basicPath()
	{
		
		
		int dif = map.getTile(1, 0).getId()-map.getTile(0, 0).getId();
		if(!map.getTileById((int)this.source+1).isSolidTile())
		{
			path.addItem((double)map.getTileById((int)this.source+1).getId());
		}else
			if(!map.getTileById((int)this.source-2).isSolidTile())
			{
				path.addItem((double)map.getTileById((int)this.source-2).getId());
			}else if(!map.getTileById((int)this.source+dif).isSolidTile())
			{
				path.addItem((double)map.getTileById((int)this.source+dif).getId());
			}else
			{
				 
				path.addItem((double)map.getTileById((int)this.source-dif).getId());
					
			}
		
		
	}
}
