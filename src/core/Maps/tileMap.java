package core.Maps;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import Utils.Color.CustomColor;
import Utils.Images.ImageHandler;
import Utils.Lists.iList;
import Utils.Math.operations.MatrixMathG;
import Utils.Math.vector.Vector;
import core.Abstract.mapBuilder;
import core.Engine.Screen;
import core.Objects.Tiles;



public class tileMap extends mapBuilder{
	
	private Tiles[][] map;
	
	

	public tileMap(int size)
	{
		this.blockHeight=size;
		this.blockWidth=size;
	
		
	}
	
	public tileMap(int size, double scroll)
	{
		this.blockHeight=size;
		this.blockWidth=size;
		this.scroll=scroll;
	}
	
	
	public Vector get_Row_Col_FromId(int id)
	{
		Tiles t = getTileById(id);
		return new Vector(getRow((int)t.getY()),getCol((int)t.getX()));
	}
	
	
	public boolean isTileWalkable(int col, int row)
	{
		return map[row][col].isWalkable();
	}
	
	
	@Override
	public void renderWithValue(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.white);
		blocksRendering=0;
		for(int row = rowOffset; row < rowOffset + numRowsToDraw; row++) {
			
			if(row >= numRows) break;
			
			for(int col = colOffset; col < colOffset + numColsToDraw; col++) {
				
				if(col >= numCols) break;
				if(!map[row][col].isWalkable()) continue;
				
				if(map[row][col].isWalkable())
				{
					map[row][col].render(g2d,x + col * blockHeight,
					y + row * blockHeight,blockHeight,blockHeight);
					g2d.setColor(Color.white);
					g2d.drawString(map[row][col].getValue(),(int)(x + col * blockHeight)+2, (int)(y + row * blockHeight)+blockHeight);
					blocksRendering++;
					g2d.setColor(Color.white);
					
				}
				
			}
			
		}
		
	}

	@Override
	public void renderWithId(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.white);
		blocksRendering=0;
		for(int row = rowOffset; row < rowOffset + numRowsToDraw; row++) {
			
			if(row >= numRows) break;
			
			for(int col = colOffset; col < colOffset + numColsToDraw; col++) {
				
				if(col >= numCols) break;
				if(!map[row][col].isWalkable()) continue;
				
				if(map[row][col].isWalkable())
				{
					map[row][col].render(g2d,x + col * blockHeight,
					y + row * blockHeight,blockHeight,blockHeight);
					g2d.setColor(Color.white);
					g2d.drawString(""+map[row][col].getId(),(int)(x + col * blockHeight)+2, (int)(y + row * blockHeight)+blockHeight);
					blocksRendering++;
					g2d.setColor(Color.white);
					
				}
				
			}
			
		}
		
		
	}

	@Override
	public void setSprite(String value, BufferedImage sprite) {
		// TODO Auto-generated method stub
		for(int i=0; i<map.length; i++)
		{
			for(int j=0; j<map[i].length; j++)
			{
				Tiles tl = map[i][j];
			
				if(tl.getValue().equalsIgnoreCase(value))
				{
					tl.setSprite(sprite);
				}
			}
		}

	}

	@Override
	public void setSprite(float r, float g, float b, BufferedImage sprite, boolean hex) {
		
		Color c = CustomColor.Color(r, g, b);
		
		for(int i=0; i<map.length; i++)
		{
			for(int j=0; j<map[i].length; j++)
			{
				Tiles tl = map[i][j];
				if(hex==true)
				{
					if(tl.getValue().equalsIgnoreCase(CustomColor.rgbToHex(c)))
					{
						tl.setSprite(sprite);
					}
				}else
				{
					if(tl.getValue().equalsIgnoreCase(""+c.getRGB()))
					{
						tl.setSprite(sprite);
					}
				}
			}
		}


		
	}

	@Override
	public void setSprite(Color c, BufferedImage sprite, boolean hex) {
		// TODO Auto-generated method stub
		for(int i=0; i<map.length; i++)
		{
			for(int j=0; j<map[i].length; j++)
			{
				Tiles tl = map[i][j];
				if(hex==true)
				{
					
					if(tl.getValue().equalsIgnoreCase(CustomColor.rgbToHex(c)))
					{
						tl.setSprite(sprite);
					}
				}else
				{
					
					if(tl.getValue().equalsIgnoreCase(""+c.getRGB()))
					{
						tl.setSprite(sprite);
					}
				}
		    }	
		}
		
	}

	public void render(Graphics2D g2d)
	{
		blocksRendering=0;
		
		for(int row = rowOffset; row < rowOffset + numRowsToDraw; row++) {
		
			if(row >= numRows) break;
			
			
			for(int col = colOffset; col < colOffset + numColsToDraw; col++) {
				
				if(col >= numCols) break;
				if(!map[row][col].isWalkable()) continue;
				
				if(map[row][col].isWalkable())
				{
					if((map[row][col].seenOnMap(this)))
							{
					map[row][col].render(g2d,x + col * blockHeight,
					y + row * blockHeight,blockHeight,blockHeight);
					blocksRendering++;
							}
					
					
				}
				
			}
			
		}
		
	}
	@Override
	public void setXY(double x, double y) {
		// TODO Auto-generated method stub
		this.x +=(x-this.x)*scroll;
		this.y +=(y-this.y)*scroll;
		
	}

	
	public int getIndex(int x) {
		// TODO Auto-generated method stub
		return x/blockHeight;
	}
	
	public Tiles getTile(int row, int col)
	{
		return map[row][col];
	}
	

	public Tiles getTileById(int id)
	{
		
		if(id>numberOfBlocks-1)
		{
			return null;
		}else
		{
			int i=0;
			for(int j=0; j<numRows; j++)
			{
				if(map[j][numCols-1].getId()>=id && map[j][0].getId()<=id)
				{
					i=j;
					break;
				}
				
			}
			int x;
			if(i>0)
			{
				x= id-(i*numCols);
			}else
			{
				x=id;
			}
			return map[i][x];
		}
	}
	
	public Tiles[][] getMap() {
		return map;
	}
	
	
	public Tiles[] getTilesInRow(int n)
	{
		return map[n];
	}
	
    public Tiles[] partition(Tiles[] map,int start, int end)
    {
    	int size;
    	if(start<end)
    	{
    		
    		if(start==0)
    		{
    			size = (end-start)+1;
    		}else
    		{
    			size = (end-start);
    		}
    	}else
    	{
    		size=end;
    		end=start;
    		start=end;
    		if(start==0)
    		{
    			size = (end-start)+1;
    		}else
    		{
    			size = (end-start);
    		}
    	}
    	Tiles[] re = new Tiles[size];
    	for(int i=0; start<end; i++,start++)
    	{
    		re[i] = map[start];
    	}
    	return re;
    }
    
    
    public Tiles[] getTilesInCol(int n)
    {
    	Tiles[] cols = new Tiles[numRows];
    	for(int i=0; i<numRows; i++)
    	{
    		cols[i] = map[i][n];
    	}
    	return cols;
    }
    
    public  int getCol(int x)
    {
    	return x/this.blockHeight;
    }
    
    public  int getRow(int y)
    {
    	return y/this.blockHeight;
    }
    
    
    /*************************loading*****************************************/
    public void loadMap(String s)
	{
		solids = new iList<Integer>();
		noSolids = new iList<Integer>();
		try
		{
			InputStream in = getClass().getResourceAsStream("/"+s);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			numCols = Integer.parseInt(br.readLine());
			numRows = Integer.parseInt(br.readLine());
			map = new Tiles[numRows][numCols];
			
			width = numCols*blockHeight;
			height=numRows*blockHeight;
			
			xmin = Screen.Engine.getWidth() - width;
			xmax = 0;
			ymin = Screen.Engine.getHeight() - height;
			ymax = 0;
			numRowsToDraw = Screen.Engine.getHeight() / blockHeight + 2;
			numColsToDraw = Screen.Engine.getWidth() / blockHeight + 2;
			/*
			xmin = 0;
			xmax=-(Screen.Engine.getWidth()-width);
			ymin = 0;
			ymax=-(Screen.Engine.getHeight()-height);*/
			
			
			String deli = "\\s+"; //white space
			
			for(int row=0; row<numRows; row++)
			{
				
				String line = br.readLine();
				String[] token = line.split(deli);
				for(int col=0; col<numCols; col++)
				{
					
							
					Tiles temp;		
							
					
					if(token[col].equals("0"))
					{
						 temp = 
						new Tiles((int)x+col*blockHeight, (int)y+row*blockHeight, blockHeight, blockHeight, numberOfBlocks, token[col], false);
							noSolids.addItem(temp.getId());
						
					}else
					{
						
						temp = 
								new Tiles((int)x+col*blockHeight, (int)y+row*blockHeight, blockHeight, blockHeight, numberOfBlocks, token[col], true);
					
						solids.addItem(temp.getId());
					
					}
					temp.setRowCol(row, col);
					map[row][col] = temp;
					numberOfBlocks++;
					
					
				}
			}
			
			br.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

    
    
    public void loadMap(ImageHandler image)
	{
    	solids = new iList<Integer>();
		noSolids = new iList<Integer>();
		try
		{
			
			numCols = image.getImage().getWidth();
			numRows = image.getImage().getHeight();
			
			
			map = new Tiles[numRows][numCols];
			
			width = numCols*blockHeight;
			height=numRows*blockHeight;
			
			
			
			
			
			for(int xx=0; xx<numRows; xx++)
			{
				
				for(int yy=0; yy<numCols; yy++)
				{
					int pixel = image.getImage().getRGB(yy, xx);
					String hex = CustomColor.rgbToHex(pixel);
					Tiles temp;
					 						
					
					

					if(!CustomColor.hexToColor(hex).equals(Color.black))
					{
						
						temp = 
								new Tiles((int)x+yy*blockHeight, (int)y+xx*blockHeight, blockHeight, blockHeight, numberOfBlocks, hex, true);
						solids.addItem(temp.getId());
					}else
					{
						
						temp = 
								new Tiles((int)x+yy*blockHeight, (int)y+xx*blockHeight, blockHeight, blockHeight, numberOfBlocks, hex, false);
						noSolids.addItem(temp.getId());
					}
					
					temp.setRowCol(xx, yy);
					map[xx][yy] = temp;
					numberOfBlocks++;
					
					
				}
				
			}
			
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		xmin = Screen.Engine.getWidth() - width;
		xmax = 0;
		ymin = Screen.Engine.getHeight() - height;
		ymax = 0;
		
		/*
		xmin = 0;
		xmax=-(Screen.Engine.getWidth()-width);
		ymin = 0;
		ymax=-(Screen.Engine.getHeight()-height);*/
		
		numRowsToDraw = Screen.Engine.getHeight() / blockHeight + 2;
		numColsToDraw = Screen.Engine.getWidth() / blockHeight + 2;
		
	}

    
    public String getValue(int row, int col)
	{
		return map[row][col].getValue();
	}
    
    public void setValue(int row, int col,String value)
   	{
   		map[row][col].setValue(value);
   	}
    
   
    
    public void rotateMapRight()
	{
		MatrixMathG<Tiles> ro = new MatrixMathG<Tiles>();
		map = ro.rotateRight(map);
		rotated=true;
	}
	
	public void rotateMapLeft()
	{
		rotated=true;
		MatrixMathG<Tiles> ro = new MatrixMathG<Tiles>();
		map = ro.rotateLeft(map);
	}
	
	public int getSize()
	{
		return this.blockHeight;
	}
	
	public boolean isWalkable(int row,int col)
	{
		return map[row][col].isWalkable();
	}
	
	public void makeTileSolid(int id)
	{
		Tiles t  = getTileById(id);
		t.setWalkable(true);
	}
	
	public void makeTileUnsolid(int id)
	{
		Tiles t  = getTileById(id);
		t.setWalkable(false);
	}
	
	public void setTileValue(int id, String value)
	{
		Tiles t  = getTileById(id);
		t.setValue(value);
	}
	
	public void setTileSprite(int id, BufferedImage sprite)
	{

		Tiles t  = getTileById(id);
		t.setSprite(sprite);
	}
	
	public void editTile(int id, boolean solid, String value,BufferedImage sprite )
	{
		if(solid==true)
		{
			setTileSprite(id, sprite);
			setTileValue(id, value);
			makeTileSolid(id);
		}else
		{
			
				setTileSprite(id, sprite);
				setTileValue(id, value);
				makeTileUnsolid(id);
			
		}
	}
	
	
	public void editTile(int id, boolean solid, String value )
	{
		if(solid==true)
		{
			
			setTileValue(id, value);
			makeTileSolid(id);
		}else
		{
			
				
				setTileValue(id, value);
				makeTileUnsolid(id);
			
		}
	}
	
	
	
}
