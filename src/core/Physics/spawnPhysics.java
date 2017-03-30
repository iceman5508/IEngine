package core.Physics;
import Utils.Lists.iList;
import core.Objects.GameObject;
import core.Objects.Tiles;

public class spawnPhysics {
	
	
	private GameObject o;
	//private boolean topRight,topLeft,bottomRight,bottomLeft,
	
	private Tiles tile;
	private boolean bottom,falling,right,left,top;
	public spawnPhysics(GameObject o) {
		// TODO Auto-generated constructor stub
		this.o=o;
	}
	/*
	public boolean collisionTopRight(iList<Tiles> t)
	{
		boolean collide=false;
		for(int i=0; i<t.getCount(); i++)
		{
			Tiles tt = t.getAtIndex(i).Data;
			
				if(o.topRightBound().intersects(tt.getBasicRectangle()))
				{
				
					collide=true;
					break;
				}else
				{
					collide=false;
				}
				
			
			if(collide==true)
			{
				break;
			}
		}
		return collide;
		
	}
	
	
	public boolean collisionTopLeft(iList<Tiles> t)
	{
		boolean collide=false;
		for(int i=0; i<t.getCount(); i++)
		{
			Tiles tt = t.getAtIndex(i).Data;
			
				if(o.topLeftBound().intersects(tt.getBasicRectangle()))
				{
					
					collide=true;
					break;
				}else
				{
					collide=false;
				}
				
			
			if(collide==true)
			{
				break;
			}
		}
		return collide;
		
	}
	
	
	public boolean collisionBottomRight(iList<Tiles> t)
	{
		boolean collide=false;
		for(int i=0; i<t.getCount(); i++)
		{
			Tiles tt = t.getAtIndex(i).Data;
			
				if(o.bottomRightBound().intersects(tt.getBasicRectangle()))
				{
					
					collide=true;
					break;
				}else
				{
					collide=false;
				}
				
			
			if(collide==true)
			{
				break;
			}
		}
		return collide;
		
	}

	
	public boolean collisionBottomLeft(iList<Tiles> t)
	{
		boolean collide=false;
		for(int i=0; i<t.getCount(); i++)
		{
			Tiles tt = t.getAtIndex(i).Data;
			
				if(o.bottomLeftBound().intersects(tt.getBasicRectangle()))
				{
					collide=true;
					break;
				}else
				{
					collide=false;
				}
				
			
			if(collide==true)
			{
				break;
			}
		}
		return collide;
		
	}*/
	
	
	
	public boolean collisionRight(iList<Tiles> t)
	{
		boolean collide=false;
		for(int i=0; i<t.getCount(); i++)
		{
			Tiles tt = t.getAtIndex(i).Data;
			
				if(o.rightBound().intersects(tt.getBasicRectangle()))
				{
					collide=true;
					break;
				}else
				{
					collide=false;
				}
				
			
			if(collide==true)
			{
				break;
			}
		}
		return collide;
		
	}
	
	public boolean collisionLeft(iList<Tiles> t)
	{
		boolean collide=false;
		for(int i=0; i<t.getCount(); i++)
		{
			Tiles tt = t.getAtIndex(i).Data;
			
				if(o.leftBound().intersects(tt.getBasicRectangle()))
				{
					collide=true;
					break;
				}else
				{
					collide=false;
				}
				
			
			if(collide==true)
			{
				break;
			}
		}
		return collide;
		
	}
	
	public boolean collisionTop(iList<Tiles> t)
	{
		boolean collide=false;
		
		for(int i=0; i<t.getCount(); i++)
		{
			Tiles tt = t.getAtIndex(i).Data;
			
				if(o.topBound().intersects(tt.getBasicRectangle()))
				{
					collide=true;
					tile = t.getAtIndex(i).Data;
					break;
				}else
				{
					collide=false;
				}
				
			
			if(collide==true)
			{
				break;
			}
		}
		return collide;
		
	}
	
	public boolean collisionBottom(iList<Tiles> t)
	{
		boolean collide=false;
		
		for(int i=0; i<t.getCount(); i++)
		{
			Tiles tt = t.getAtIndex(i).Data;
			
				if(o.bottomBound().intersects(tt.getBasicRectangle()))
				{
					collide=true;
					tile = t.getAtIndex(i).Data;
					break;
				}else
				{
					collide=false;
				}
				
			
			if(collide==true)
			{
				break;
			}
		}
		return collide;
		
	}
	
	public void checkContact(iList<Tiles> t)
	{
		
		
		right=collisionRight(t);
		left=collisionLeft(t);
		top = collisionTop(t);
		bottom=collisionBottom(t);
		
	}
	
	
	public void openWorldPhysics(iList<Tiles> t)
	{
		checkContact(t);
		o.setTopLeft(top);
		o.setTopRight(top);
		o.setBottomLeft(bottom);
		o.setBottomRight(bottom);
		if(top)
		{
			o.setUp(false);
			o.setDy(0);
		}
		
	if(right)
	{
		o.setRight(false);
		o.setDx(0);
	}
		
	if(left)
	{
		
		o.setLeft(false);
		o.setDx(0);
	}
		
		if(bottom)
		{
			o.setDown(false);
			o.setDy(0);
		}
	}
	
	
	public void platFormerPhysics(iList<Tiles> t)
	{
		checkContact(t);
		o.setTopLeft(top);
		o.setTopRight(top);
		o.setBottomLeft(bottom);
		o.setBottomRight(bottom);
		if(top)
		{
			o.setUp(false);
			o.setDy(0);
			o.setFalling(true);
			o.setJumping(false);
			falling=true;
			double y = tile.getY()+tile.getHeight()+3.5;
			o.setY(y);
		}
		
	if(right)
	{
		o.setRight(false);
		o.setDx(0);
	}
		
	if(left)
	{
		
		o.setLeft(false);
		o.setDx(0);
	}
		
		if(bottom)
		{
			
			o.setDown(false);
			o.setDy(0);
			o.setFalling(false);
			falling=false;
			double y = tile.getY()-tile.getHeight();
			o.setY(y);
		}
	}
	
	





public boolean isTop() {
	return top;
}

public boolean isFalling() {
	return falling;
}

public void setFalling(boolean falling) {
	this.falling = falling;
}

public boolean isRight() {
	return right;
}

public boolean isLeft() {
	return left;
}

public boolean isBottom() {
	return bottom;
}
}
