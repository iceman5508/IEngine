package core.Objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import core.Abstract.Entity;

public class Tiles extends Entity{
	
	private String value;
	private boolean walkable;
	private BufferedImage Data; 
	private int row,col;
	
	
	public Tiles(boolean block) {
		// TODO Auto-generated constructor stub
		this.setWalkable(walkable);
	}
	
	public Tiles(boolean walkable, String value) {
		// TODO Auto-generated constructor stub
		this.setWalkable(walkable);
		this.value=value;
	}
	
	
	
	public Tiles(double x, double y, int Height, int Width,int Id,String value, boolean Walkable) {
		super(x,y,Height,Width,0,0,Id);
		this.x=x;
		this.y=y;
		this.height=Height;
		this.width=Width;
		this.id=Id;
		this.value=value;
		this.walkable=Walkable;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
		if(Data!=null)
		{
			g2d.drawImage(Data, (int)x, (int)y, width, height,null); 
		}else
		{
			g2d.drawRect((int)x, (int)y, width, height);
		}
		
	}
	
	public void render(Graphics2D g2d, double x, double y) {
		// TODO Auto-generated method stub
		if(Data!=null)
		{
			g2d.drawImage(Data, drawOnMapX(x), drawOnMapY(y), width, height,null); 
		}else
		{
			g2d.drawRect(drawOnMapX(x), drawOnMapY(y), width, height);
		}
		
	}


	public void render(Graphics2D g2d, double x, double y,int width,int height)
	{
		if(Data!=null)
		{
			g2d.drawImage(Data,(int)x, (int)y, width, height,null); 
		}else
		{
			g2d.drawRect((int)x, (int)y, width, height);
		}
	}
	
	
	public BufferedImage getSprite() {
		return Data;
	}



	public void setSprite(BufferedImage data) {
		Data = data;
	}



	public boolean isWalkable() {
		return walkable;
	}



	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean isSolidTile()
	{
		return walkable;
	}
	
	public void setRowCol(int row,int col)
	{
		this.row=row;
		this.col=col;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}

	
}
