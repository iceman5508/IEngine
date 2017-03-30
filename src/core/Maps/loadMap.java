package core.Maps;

import Utils.Images.ImageHandler;
import core.Maps.tileMap;

public class loadMap {

	public static tileMap load(int size,String location)
	{
		tileMap map = new tileMap(size);
		map.loadMap(location);
		return map;
	}
	
	public static tileMap load(int size,ImageHandler location)
	{
		tileMap map = new tileMap(size);
		map.loadMap(location);
		return map;
	}
	
	public static tileMap load(int size,String location, double x,double y)
	{
		tileMap map = new tileMap(size);
		map.loadMap(location);
		map.setX(x);
		map.setY(y);
		return map;
	}
	
	public static tileMap load(int size,ImageHandler location,double x,double y)
	{
		tileMap map = new tileMap(size);
		map.loadMap(location);
		map.setX(x);
		map.setY(y); 
		return map;
	}
}
