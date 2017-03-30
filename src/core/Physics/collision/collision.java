package core.Physics.collision;

import core.Engine.Screen;
import core.Maps.tileMap;
import core.Objects.GameObject;

public class collision {
	
	private GameObject o;
	private tileMap tmap;
	
	
	public collision(GameObject o)
	{
		this.o = o;
		tmap = o.getTileMap();
	}
	
	public void platFormerPhysics()
	{
		double x = o.getX();
		double y = o.getY();
		double dx = o.getDx();
		double dy = o.getDy();
		double ch = o.getCollisionHeight();
		double cw = o.getCollisionWidth();
		/***************Check Collision****************************/
		int curCol = tmap.getCol((int)x);
		int curRow = tmap.getRow((int)y);
		
		double toX = x+dx;
		double toY = y+dy;
		
		double tempX=x; double tempY = y;
		
		o.tmapCheckContact(x,toY);
		
		if(dy<0)
		{
			if(o.isTopLeft() || o.isTopRight())
			{
				dy=0;
				o.setDy(dy);
				tempY=curRow * tmap.getSize()+ch/2;
			}else
			{
				tempY += dy;
			}
		}
		if(dy>0)
		{
			if(o.isBottomLeft() || o.isBottomRight())
			{
				dy=0; 
				o.setDy(dy);
				o.setFalling(false);
				tempY = (curRow +1)* tmap.getSize()-ch/2;
			}
			else
			{
				tempY += dy;
			}
		}
		
		o.tmapCheckContact(toX,y);
		if(dx<0)
		{
			if(o.isTopLeft() || o.isBottomLeft())
			{
				dx=0;
				o.setDx(dx);
				tempX=curCol * tmap.getSize()+cw/2;
			}else
			{
				tempX += dx;
			}
		}
		if(dx>0)
		{
			if(o.isTopRight() || o.isBottomRight())
			{
				dx=0; 
				o.setDx(dx);
				tempX = (curCol +1)* tmap.getSize()-cw/2;
			}
			else
			{
				tempX += dx;
			}
		}
		//////////////falling check///////////////////////
		
		if(!o.isFalling())
		{
			o.tmapCheckContact(x,y+1);
			if(!o.isBottomLeft() && !o.isBottomRight())
			{
				o.setFalling(true);
			}
		}

	
		o.setPosition(tempX, tempY);
		
		///moveMap
		o.getTileMap().setX((int)(Screen.Engine.getWidth()/2-x));
		o.getTileMap().setY((int)(Screen.Engine.getHeight()/2-y));
	}
	
	
	public void openWorldPhysics()
	{
		double x = o.getX();
		double y = o.getY();
		double dx = o.getDx();
		double dy = o.getDy();
		double ch = o.getCollisionHeight();
		double cw = o.getCollisionWidth();
		/***************Check Collision****************************/
		int curCol = tmap.getCol((int)x);
		int curRow = tmap.getRow((int)y);
		
		double toX = x+dx;
		double toY = y+dy;
		
		double tempX=x; double tempY = y;
		
		o.tmapCheckContact(x,toY);
		
		if(dy<0)
		{
			if(o.isTopLeft() || o.isTopRight())
			{
				dy=0;
				o.setDy(dy);
				tempY=curRow * tmap.getSize()+ch/2;
			}else
			{
				tempY += dy;
			}
		}
		if(dy>0)
		{
			if(o.isBottomLeft() || o.isBottomRight())
			{
				dy=0; 
				o.setDy(dy);
				tempY = (curRow +1)* tmap.getSize()-ch/2;
			}
			else
			{
				tempY += dy;
			}
		}
		
		o.tmapCheckContact(toX,y);
		if(dx<0)
		{
			if(o.isTopLeft() || o.isBottomLeft())
			{
				dx=0;
				o.setDx(dx);
				tempX=curCol * tmap.getSize()+cw/2;
			}else
			{
				tempX += dx;
			}
		}
		if(dx>0)
		{
			if(o.isTopRight() || o.isBottomRight())
			{
				dx=0; 
				o.setDx(dx);
				tempX = (curCol +1)* tmap.getSize()-cw/2;
			}
			else
			{
				tempX += dx;
			}
		}
	

	
		o.setPosition(tempX, tempY);
		o.getTileMap().setX((int)(Screen.Engine.getWidth()/2-x));
		o.getTileMap().setY((int)(Screen.Engine.getHeight()/2-y));
	}
	
	
	public void openWorldPhysics_Ai()
	{
		double x = o.getX();
		double y = o.getY();
		double dx = o.getDx();
		double dy = o.getDy();
		double ch = o.getCollisionHeight();
		double cw = o.getCollisionWidth();
		/***************Check Collision****************************/
		int curCol = tmap.getCol((int)x);
		int curRow = tmap.getRow((int)y);
		
		double toX = x+dx;
		double toY = y+dy;
		
		double tempX=x; double tempY = y;
		
		o.tmapCheckContact(x,toY);
		
		if(dy<0)
		{
			if(o.isTopLeft() || o.isTopRight())
			{
				dy=0;
				o.setDy(dy);
				tempY=curRow * tmap.getSize()+ch/2;
			}else
			{
				tempY += dy;
			}
		}
		if(dy>0)
		{
			if(o.isBottomLeft() || o.isBottomRight())
			{
				dy=0; 
				o.setDy(dy);
				tempY = (curRow +1)* tmap.getSize()-ch/2;
			}
			else
			{
				tempY += dy;
			}
		}
		
		o.tmapCheckContact(toX,y);
		if(dx<0)
		{
			if(o.isTopLeft() || o.isBottomLeft())
			{
				dx=0;
				o.setDx(dx);
				tempX=curCol * tmap.getSize()+cw/2;
			}else
			{
				tempX += dx;
			}
		}
		if(dx>0)
		{
			if(o.isTopRight() || o.isBottomRight())
			{
				dx=0; 
				o.setDx(dx);
				tempX = (curCol +1)* tmap.getSize()-cw/2;
			}
			else
			{
				tempX += dx;
			}
		}
	

	
		o.setPosition(tempX, tempY);
		
	}
	
	public void platFormerPhysics_Ai()
	{
		double x = o.getX();
		double y = o.getY();
		double dx = o.getDx();
		double dy = o.getDy();
		double ch = o.getCollisionHeight();
		double cw = o.getCollisionWidth();
		/***************Check Collision****************************/
		int curCol = tmap.getCol((int)x);
		int curRow = tmap.getRow((int)y);
		
		double toX = x+dx;
		double toY = y+dy;
		
		double tempX=x; double tempY = y;
		
		o.tmapCheckContact(x,toY);
		
		if(dy<0)
		{
			if(o.isTopLeft() || o.isTopRight())
			{
				dy=0;
				o.setDy(dy);
				tempY=curRow * tmap.getSize()+ch/2;
			}else
			{
				tempY += dy;
			}
		}
		if(dy>0)
		{
			if(o.isBottomLeft() || o.isBottomRight())
			{
				dy=0; 
				o.setDy(dy);
				o.setFalling(false);
				tempY = (curRow +1)* tmap.getSize()-ch/2;
			}
			else
			{
				tempY += dy;
			}
		}
		
		o.tmapCheckContact(toX,y);
		if(dx<0)
		{
			if(o.isTopLeft() || o.isBottomLeft())
			{
				dx=0;
				o.setDx(dx);
				tempX=curCol * tmap.getSize()+cw/2;
			}else
			{
				tempX += dx;
			}
		}
		if(dx>0)
		{
			if(o.isTopRight() || o.isBottomRight())
			{
				dx=0; 
				o.setDx(dx);
				tempX = (curCol +1)* tmap.getSize()-cw/2;
			}
			else
			{
				tempX += dx;
			}
		}
		//////////////falling check///////////////////////
		
		if(!o.isFalling())
		{
			o.tmapCheckContact(x,y+1);
			if(!o.isBottomLeft() && !o.isBottomRight())
			{
				o.setFalling(true);
			}
		}

	
		o.setPosition(tempX, tempY);
		
		
	}
	


}
