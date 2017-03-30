package Utils.Traversal;

import Utils.Lists.iList;
import core.Maps.tileMap;
import core.Objects.Tiles;

public class PathFinder {
	

	private BPA bpa;
	private DKS dks;
	private int start;
	private tileMap map;
	public PathFinder(tileMap map, double startId, double endId) {
		// TODO Auto-generated constructor stub
		start=(int)startId;
		this.map=map;
		dks = new DKS(map);
		dks.run((int) startId);
		dks.pathTo((int) endId);
		if(dks.path()==null)
		{	
			bpa = new BPA(map);	
			bpa.findPathTo(startId, endId, map);	
		}
		
	}
	
	public iList<Double> getPath()
	{
		if(bpa!=null)
		{
			return bpa.getPath();
		}else
		{
			return dks.path();
		}
		
	}
	
	public iList<Double> getPathAdjLeft()
	{
		iList<Double> pa;
		if(bpa!=null)
		{
			pa = bpa.getPath();
			
		}else
		{
			pa= dks.path();
		}
		int cID = map.getRow((int)map.getTileById(start).getY());
		Tiles og = map.getTile(cID, 0);
		
		int dif = start-og.getId();
		
		
		for(int i=0; i<dif; i++)
		{
			
			pa.removeFirst();
		}
		return pa;
		
	}

}
