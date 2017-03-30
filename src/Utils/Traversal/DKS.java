package Utils.Traversal;
import Utils.Lists.iArrayList;
import Utils.Lists.iList;
import Utils.Math.vector.Vector;
import core.Maps.tileMap;

public class DKS {
	private tileMap map = null;
	/*private int [][] mapp=null;
	private boolean[][] mappp=null;*/
	private iArrayList<Integer> visited;
	private int [][] adjency;
	private iArrayList<Vector> paths;
	private int start;
	private iArrayList<Integer> road;
	private int breakk; 
	private int lock;
	
	
	
	public DKS(tileMap map) {
	
		this.map=map;		
		adjency = new int[map.getNumRows()][map.getNumCols()];
		setCheckers();
		for(int i=0; i<adjency.length; i++)
		{
			for(int y=0; y<adjency[i].length; y++)
			{
				adjency[i][y] = !map.isTileWalkable(y, i)?map.getTile(i, y).getId():-1;
			}
		}
		
		breakk= adjency.length*adjency[0].length;
		lock=0;
	
	}
	
	public DKS(boolean[][] map) {
		
		//this.mappp=map;
		adjency = new int[map.length][map[0].length];
		setCheckers();
		int count=0;
		for(int i=0; i<adjency.length; i++)
		{
			for(int y=0; y<adjency[i].length; y++)
			{
				adjency[i][y] = map[i][y]?count:-1;
				count++;
				
			}
		}
	
	}
	
	public DKS(int[][] map) {
		//this.mapp = map;
		adjency = new int[map.length][map[0].length];
		setCheckers();
		int count=0;
		for(int i=0; i<adjency.length; i++)
		{
			for(int y=0; y<adjency[i].length; y++)
			{
				adjency[i][y] = count;
				count++;
			}
		}
		
	}
	
	
	public DKS() {
	
	}
	
	
	public void setAdjency(int[][] adjency) {
		this.adjency = adjency;
	}
	
	
	public iArrayList<Integer> run(int sourceId)
	{
		if(map!=null)
		{
			//get source
			if(paths==null)
			{
				start = sourceId;
				paths = new iArrayList<>();
				Vector source = map.get_Row_Col_FromId(sourceId);
				paths.add(sourceId, new Vector(0,sourceId));
				addNeighbors((int)source.x2D(),(int)source.y2D());
				visited.add(sourceId, sourceId);
				
				//System.out.println(visited.getNodeData1(sourceId)+" "+visited.last.Data1);
				//System.exit(0);
				
				paths.removeByData1(sourceId);
				adjency[(int)source.x2D()][(int)source.y2D()] = -1;
				int distance=1000000000;
				
				//get lowest value between 2values
				int next=-1;
				for(int i=0; i<paths.count; i++)
				{
					if(next==-1)
					{
						next = (int) paths.getNode(i).Data1;
						distance = (int) paths.getNode(i).Data2.x2D();
					}else
					{
						int checkD = (int) paths.getNode(i).Data2.x2D();
						if(checkD<distance || checkD==distance)
						{
							distance=checkD;
							next = (int) paths.getNode(i).Data1;
						}
					}
					
				}//handles picking smallest value
				run(next);
				
			}
			
			while(paths.count>0)
			{
				
				Vector source = map.get_Row_Col_FromId(sourceId);
				addNeighbors2((int)source.x2D(), (int)source.y2D());
							
				visited.add(sourceId, (int)visited.last.Data1);
				paths.removeByData1(sourceId);
				adjency[(int)source.x2D()][(int)source.y2D()] = -1;
				int distance=1000000000;
				
				//get lowest value between 2values
				int next=-1;
				for(int i=0; i<paths.count; i++)
				{
					if(next==-1)
					{
						next = (int) paths.getNode(i).Data1;
						distance = (int) paths.getNode(i).Data2.x2D();
					}else
					{
						int checkD = (int) paths.getNode(i).Data2.x2D();
						if(checkD<distance || checkD==distance)
						{
							distance=checkD;
							next = (int) paths.getNode(i).Data1;
						}
					}
					
				}//handles picking smallest value
				run(next);
				
				
			}
			
		
			
		}
		return visited;
	}
	
	
	public void run(int row, int col)
	{
		
	}
	
	private double distance(double source, double destination)
	{
		return Math.abs(destination-source);
	}
	
	private boolean validPoint(int y,int x)
	{
		return !(y<0 || y>=adjency.length || x<0 || x>adjency[0].length );
				
				
	}

	

	private void setCheckers()
	{
		this.visited=new iArrayList<Integer>();
		/*this.unvisited = new iNodeList<Integer>();
		for(int i=0; i<adjency.length; i++)
		{
			for(int y=0; y<adjency[i].length; y++)
			{
				if(adjency[i][y]>=0)
				{
					unvisited.add(adjency[i][y], adjency[i][y]);
				}
			}
		}*/
	}
	

	private void addNeighbors(int row, int col)
	{
		double source = adjency[row][col];
		if(validPoint(row+1, col)&&adjency[row+1][col]>=0)
		{
			double distance = distance(source, adjency[row+1][col]);
			paths.add(adjency[row+1][col], new Vector(distance,source));
		}
		
		if(validPoint(row-1, col)&&adjency[row-1][col]>=0)
		{
			double distance = distance(source, adjency[row-1][col]);
			paths.add(adjency[row-1][col], new Vector(distance,source));
		}
		
		if(validPoint(row, col+1)&&adjency[row][col+1]>=0)
		{
			double distance = distance(source, adjency[row][col+1]);
			paths.add(adjency[row][col+1], new Vector(distance,source));
		}
		
		if(validPoint(row, col-1)&&adjency[row][col-1]>=0)
		{
			double distance = distance(source, adjency[row][col-1]);
			paths.add(adjency[row][col-1], new Vector(distance,source));
		}
	}
	
	
	private void addNeighbors2(int row, int col)
	{
		double source = adjency[row][col];
		if(validPoint(row+1, col)&&adjency[row+1][col]>=0)
		{
			double distance = distance(source, adjency[row+1][col]);
			if(paths.getNodeData1(adjency[row+1][col])!=null&&
			  visited.getNodeData1(adjency[row+1][col])!=null)
			{
				distance = distance+paths.getNodeData1(source).Data2.x2D();
				if(distance<paths.getNodeData1(adjency[row+1][col]).Data2.x2D())
				{
					paths.getNodeData1(adjency[row+1][col]).Data2.editElement(distance, 0);
					paths.getNodeData1(adjency[row+1][col]).Data2.editElement(source, 1);
				}
			}else
			{
				if(paths.getNodeData1(adjency[row+1][col])==null)
				{
					paths.add(adjency[row+1][col], new Vector(distance,source));
				}
			}
			
		}
		
		if(validPoint(row-1, col)&&adjency[row-1][col]>=0)
		{
			double distance = distance(source, adjency[row-1][col]);
			if(paths.getNodeData1(adjency[row-1][col])!=null&&
			  visited.getNodeData1(adjency[row-1][col])!=null)
			{
				distance = distance+paths.getNodeData1(source).Data2.x2D();
				if(distance<paths.getNodeData1(adjency[row-1][col]).Data2.x2D())
				{
					paths.getNodeData1(adjency[row-1][col]).Data2.editElement(distance, 0);
					paths.getNodeData1(adjency[row-1][col]).Data2.editElement(source, 1);
				}
			}else
			{
				if(paths.getNodeData1(adjency[row-1][col])==null)
				{
					paths.add(adjency[row-1][col], new Vector(distance,source));
				}
			}
		}
		
		if(validPoint(row, col+1)&&adjency[row][col+1]>=0)
		{
			double distance = distance(source, adjency[row][col+1]);
			if(paths.getNodeData1(adjency[row][col+1])!=null&&
			  visited.getNodeData1(adjency[row][col+1])!=null)
			{
				distance = distance+paths.getNodeData1(source).Data2.x2D();
				if(distance<paths.getNodeData1(adjency[row][col+1]).Data2.x2D())
				{
					paths.getNodeData1(adjency[row][col+1]).Data2.editElement(distance, 0);
					paths.getNodeData1(adjency[row][col+1]).Data2.editElement(source, 1);
				}
			}else
			{
				if(paths.getNodeData1(adjency[row][col+1])==null)
				{
					paths.add(adjency[row][col+1], new Vector(distance,source));
				}
			}
		}
		
		if(validPoint(row, col-1)&&adjency[row][col-1]>=0)
		{
			double distance = distance(source, adjency[row][col-1]);
			if(paths.getNodeData1(adjency[row][col-1])!=null&&
			  visited.getNodeData1(adjency[row][col-1])!=null)
			{
				distance = distance+paths.getNodeData1(source).Data2.x2D();
				if(distance<paths.getNodeData1(adjency[row][col-1]).Data2.x2D())
				{
					paths.getNodeData1(adjency[row][col-1]).Data2.editElement(distance, 0);
					paths.getNodeData1(adjency[row][col-1]).Data2.editElement(source, 1);
				}
			}else
			{
				if(paths.getNodeData1(adjency[row][col-1])==null)
				{
					paths.add(adjency[row][col-1], new Vector(distance,source));
				}
			}
		}
	}
	
	
	
	public void pathTo(int endMark)
	{
		
		//System.out.println(visited.getNodeData1(endMark).Data1+" "+endMark);
		//System.exit(0);
		if(visited.getNodeData1(endMark)!=null)
		{
			
			if(road==null)
			{
				road = new iArrayList<>();
				iArrayList<Integer>.iNode<Integer> firstStop = visited.getNodeData1(endMark);
				road.add(firstStop.Data1, (int)firstStop.Data1);
				endMark = firstStop.Data2;
				pathTo(endMark);
				
			}else
			{
				while(endMark!=start&&lock!=breakk)
			{
				iArrayList<Integer>.iNode<Integer> firstStop = visited.getNodeData1(endMark);
				if(road.getNodeData1(firstStop.Data1)==null)
				{
					road.addAtPos(firstStop.Data1, (int)firstStop.Data1,0);
					
				}
				endMark = firstStop.Data2;
				
				if(road.count>=(adjency.length*4))
				{
					lock=breakk;
				}
				pathTo(endMark);
				
			}
			}
			if(lock==breakk)
			{
				road = null;
			}else
			{
			//return road;
			}
		}else
		{	
			//return road;
		}
	}
	
	
	public iList<Double> path()
	{
		
		if(road==null)
		{
			return null;
		}else
		{
			iList<Double> returnPath = new iList<>();
			for(int i=0; i<road.count; i++)
			{
				returnPath.addItem((double)road.getNode(i).Data2);
			}
			return returnPath;
		}
		
	}
}
