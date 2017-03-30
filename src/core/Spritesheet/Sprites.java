package core.Spritesheet;
import java.awt.image.BufferedImage;

import Utils.Lists.iNodeList;

public class Sprites {
	
	private static iNodeList<String> sp;
	
	
	public static void init()
	{
		if(sp==null)
		{
			sp = new iNodeList<>();
			spriteManager.init();
		}
	}
	
	public static void addSheet(String name,String location)
	{
		sp.add(name, location);
	}
	
	public static spriteSheet getSheet(String name)
	{
		if(sp.getNodeData1_String(name)!=null)
		{
			return new spriteSheet(sp.getNodeData1_String(name).Data2);

		}else
		{
			return null;
		}
	}
	
	public static void addSprite(String sheetname,String spritename,
		int row,int col,int width,int height)
	{
		
		BufferedImage sprite = 
	    getSheet(sheetname).getSprite(row, col, height, width);
		
		spriteManager.addSprite(spritename, sprite);
	}
	
	public static BufferedImage getSprite(String spriteName)
	{
		return spriteManager.getSprite(spriteName);
	}
	
	public static void removeSprite(String spriteName)
	{
		spriteManager.removeSprite(spriteName);
	}
	
	public static void clearAllSprites()
	{
		spriteManager.clearAll();
	}
	
	public static void removeSheet(String sheetName)
	{
		sp.removeByData1_String(sheetName);
	}
	
	public static void clearAllSheets()
	{
		for(int i=0; i<sp.count; i++)
		{
			sp.remove(i);
		}
	}
}
