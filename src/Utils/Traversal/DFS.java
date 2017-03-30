package Utils.Traversal;
import java.util.Arrays;

import Utils.Lists.iList;
import core.Maps.tileMap;

public class DFS {
	
	private static int [][] adjency;
	private static DFS instance;
	private iList<Integer> ids = new iList<>();
	private iList<Integer> Resultids = new iList<>();

	
	
	
	
	
	private DFS() {
		// TODO Auto-generated constructor stub
	}


	public static void init(tileMap map)
	{
		if(instance==null)
		{
			instance = new DFS();
		}
		
		adjency = new int[map.getNumRows()][map.getNumCols()];
		for(int i=0; i<adjency.length; i++)
		{
			for(int y=0; y<adjency[i].length; y++)
			{
				adjency[i][y] = map.isTileWalkable(y, i)?0:1;
			}
		}
		
		
		
	}
	
	
	public static DFS getInstance()
	{
		return instance;
	}
	
	public static DFS getInstance2()
	{
		if(instance==null)
		{
			instance = new DFS();
		}
		return instance;
	}
	
	
	public iList<Integer> findPath(int startingRow)
	{
		ids.addItem(startingRow);
		boolean[] visited = new boolean[adjency.length];
		Arrays.fill(visited, false);
		visited[startingRow] = true;
		Resultids.addItem(startingRow);
		
		while(ids.getCount()>0)
		{
			int i=ids.getLast().Data;
			
			for(int j=0; j<adjency.length; j++)
			{
				if(visited[j]==false && adjency[i][j]==1)
				{
					ids.addItem(j);
					visited[j]=true;
					i=ids.getLast().Data;
					j=-1;
					Resultids.addItem(i);
				}
				
				
			}
			
			ids.removeLast();
			
		}
		return Resultids;
		
	}
	
	
	
	
	/*
	private boolean validPoint(int y,int x)
	{
		return !(y<0 || y>=adjency.length || x<0 || x>adjency[0].length );
				
				
	}*/

	
	
	

	
	public static int[][] getAdjency() {
		return adjency;
	}
	
	public static void setAdjency(int[][] adjency) {
		DFS.adjency = adjency;
	}
}
