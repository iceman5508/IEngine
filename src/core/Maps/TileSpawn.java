package core.Maps;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import Utils.Color.CustomColor;
import Utils.Lists.iList;
import core.Engine.Screen;
import core.Objects.Tiles;


public class TileSpawn {
	
	private iList<Tiles> blockL;
	private iList<Tiles> rendering;
	
	
	
	private boolean seenOnScreen(double mapx,double mapy,int w, int h,double x,double y) {
		boolean seen =  x + mapx + w < 0 ||
			x + mapx - w > Screen.Engine.getWidth() ||
			y + mapy + h < 0 ||
			y + mapy - h > Screen.Engine.getHeight();
			
			return !seen;
	}
	
	public TileSpawn() {
		// TODO Auto-generated constructor stub
		if(blockL==null)
		{
			blockL = new iList<Tiles>();
			rendering = new iList<>();
		}
	}
	
	public void spawn(int id, tileMap map)
	{
			
		Tiles block = map.getTileById(id);
		Tiles replacement = new Tiles(true);
		replacement.setX(block.getX());
		replacement.setY(block.getY());
		replacement.setHeight(block.getHeight());
		replacement.setWidth(block.getHeight());
		replacement.setSprite(block.getSprite());
		replacement.setValue(block.getValue());
		blockL.addItem(replacement);
	}
	
	public void spawn(double x, double y, int size,String value)
	{
		Tiles tile = new Tiles(x, y, size, size, blockL.getCount(), value, true);	
		blockL.addItem(tile);		
	}
	
	public void spawn(double x, double y, int size)
	{
		Tiles tile = new Tiles(x, y, size, size, blockL.getCount(), "1", true);	
		blockL.addItem(tile);		
	}
	


	
	
	public void replaceCol( int colIndex, tileMap map)
	{
		Tiles[] row = map.getTilesInCol(colIndex);
		for(Tiles tile: row)
		{
			if(tile.isWalkable())
			{
				spawn(tile.getId(), map);
				tile.setWalkable(false);
			}
		}
	}
	
		
	public void spawnCol(int size,int numBlock,double x,double startingY)
	{
		for(int i=0; i<numBlock; i++)
		{
			spawn(x,startingY+size*i,size);
			
		}
	}
	
	
	public void spawnCol(int size, int colIndex, tileMap map)
	{
		Tiles[] row = map.getTilesInCol(colIndex);
		for(Tiles tile: row)
		{
				spawn(tile.getId(), map);
				
		}
	}
	
	public void replaceRow(int id, tileMap map)
	{
		Tiles[] row = map.getTilesInRow(id);
		for(Tiles tile: row)
		{
			if(tile.isWalkable())
			{
				spawn(tile.getId(), map);
				tile.setWalkable(false);
			}
		}
	}
	
	public void spawnRow(int size,int numBlock,double startX,double y)
	{
		for(int i=0; i<numBlock; i++)
		{
			spawn(startX+size*i,y,size);
		}
	}
	
	
	public void spawnRow(int size, int rowIndex, tileMap map)
	{
		Tiles[] row = map.getTilesInRow(rowIndex);
		for(Tiles tile: row)
		{
				spawn(tile.getId(), map);
				
		}
	}
	
	public void replaceTile(int id, boolean walkable, tileMap map)
	{
		Tiles replace = map.getTileById(id);
		Tiles newB = new Tiles(replace.getX(), replace.getY(), replace.getHeight(), replace.getWidth(), replace.getId(), replace.getValue(),walkable);
		newB.setSprite(replace.getSprite());
		newB.setValue(replace.getValue());
		blockL.addItem(newB);		
		replace.setWalkable(false);
	}
	
	
	public void replaceTile(int index, boolean walkable)
	{	
		
		Tiles replace = blockL.getAtIndex(index).Data;
		Tiles newB = new Tiles(replace.getX(), replace.getY(), replace.getHeight(), replace.getWidth(), replace.getId(), replace.getValue(),walkable);
		newB.setValue(replace.getValue());
		newB.setSprite(replace.getSprite());
		blockL.addItem(newB);
		replace.setWalkable(false);
	}
	
	
	public void setImage(BufferedImage im, int id)
	{
		for(int i=0; i<blockL.getCount(); i++)
		{
			Tiles b = blockL.getAtIndex(i).Data;
			if(b.getId()==id)
			{
				b.setSprite(im); 
			}
		}
	}
	
	public void setImageValue(BufferedImage im,String value)
	{
		for(int i=0; i<blockL.getCount(); i++)
		{
			Tiles b = blockL.getAtIndex(i).Data;
			if(b.getValue().equalsIgnoreCase(value))
			{
				b.setSprite(im); 
			}
		}
	}
	
	
	public void render(Graphics2D g2d,double xoffset, double yoffset)
	{
		rendering = new iList<Tiles>();
		for(int i=0; i<blockL.getCount(); i++)
		{
			
			
			Tiles b = blockL.getAtIndex(i).Data;
		if(seenOnScreen(xoffset, yoffset, b.getWidth(), b.getHeight(), b.getX(), b.getY()))
		{
			b.render(g2d,xoffset,yoffset);
			rendering.addItem(b);
			
		}
		}
	}
	
	public void setColor(Color c, String value)
	{
		for(int i=0; i<blockL.getCount(); i++)
		{
			Tiles b = blockL.getAtIndex(i).Data;
			if(b.getValue().equalsIgnoreCase(value))
			{
				String hex = CustomColor.rgbToHex(c.getRGB());
				b.setValue(hex);
			}
		}
	}
	
	
	public void setColorAlt(Color c1,Color c2)
	{
		for(int i=0; i<blockL.getCount(); i++)
		{
			Tiles b = blockL.getAtIndex(i).Data;
			if(i%2==0)
			{
					b.setValue(CustomColor.rgbToHex(c1.getRGB()));
			}else
			{
				b.setValue(CustomColor.rgbToHex(c2.getRGB()));
			}
			
		}
	}
	
	
	
	public void clear()
	{
		blockL = new iList<Tiles>();
	}

	
	/*public int getBlockId(int row, int col, int numRows)
	{
		return (((numRows-1)*col)+row)+col;
	}*/
	
	
	public void renderColor(Graphics2D g2d,double xoffset,double yoffset)
	{
		
		//note check if block on map
		rendering = new iList<Tiles>();
		for(int i=0; i<blockL.getCount(); i++)
		{
			
			Tiles b = blockL.getAtIndex(i).Data;			
			g2d.setColor(CustomColor.hexToColor(b.getValue()));
			if(seenOnScreen(xoffset, yoffset, b.getWidth(), b.getHeight(), b.getX(), b.getY()))
			{
				g2d.fillRect(b.drawOnMapX(),b.drawOnMapY(), b.getWidth(), b.getHeight());
				rendering.addItem(b);
			}
			
			}
	}
	
	
	public iList<Tiles> getTiles()
	{
		return blockL;
	}
	
	public iList<Tiles> getTilesRendering()
	{
		return rendering;
	}
	
	
	public int getNumberRendering() {
		return rendering.getCount();
	}
	
	public int getNumberofTiles() {
		return blockL.getCount();
	}
	
	
}
