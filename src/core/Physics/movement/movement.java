package core.Physics.movement;

import java.awt.event.KeyEvent;

import core.Engine.Screen;
import core.Objects.GameObject;
import core.Physics.Gravity.gravity;

public class movement {
	
	private double movespeed,maxspeed,stopspeed;
	private GameObject o;
	private gravity g;
	
	public movement(GameObject o)
	{
		this.o = o;
		
		
	}
	
	public void intiMovement(double movespeed, double maxspeed,double stopspeed)
	{
		this.movespeed = movespeed;
		this.maxspeed=maxspeed;
		this.stopspeed=stopspeed;
	}
	
	public void intiMovement(double movespeed, double maxspeed)
	{
		this.movespeed = movespeed;
		this.maxspeed=maxspeed;
		this.stopspeed=0.30;
	}
	
	public void intiMovement(double movespeed)
	{
		this.movespeed = movespeed;
		this.maxspeed=4.2;
		this.stopspeed=0.30;
	}
	
	public void intiMovement()
	{
		this.movespeed = 0.6;
		this.maxspeed=4.2;
		this.stopspeed=0.30;
	}
	
	public double getMaxspeed() {
		return maxspeed;
	}
	
	public double getMovespeed() {
		return movespeed;
	}
	
	public double getStopspeed() {
		return stopspeed;
	}
	
	public void left_right_movement()
	{
		double dx= o.getDx();
		if(o.isLeft())
		{
			dx -= movespeed;
			if(dx < -maxspeed)
			{
				dx = -maxspeed;
			}
		}
		else if(o.isRight())
		{
			dx += movespeed;
			if(dx > maxspeed)
			{
				dx = maxspeed;
			}
		}else
		{
			if(dx>0)
			{
				dx -= stopspeed;
				if(dx<0)
				{
					dx=0;
				}
			}
			else if(dx<0)
			{

				dx += stopspeed;
				if(dx>0)
				{
					dx=0;
				}
			}
		}
		
		o.setDx(dx);
	}

	public void leftMovement()
	{
		double dx= o.getDx();
		if(o.isLeft())
		{
			dx -= movespeed;
			if(dx < -maxspeed)
			{
				dx = -maxspeed;
			}
		}else if(dx<0)
		{

			dx += stopspeed;
			if(dx>0)
			{
				dx=0;
			}
		}
		
		o.setDx(dx);
	}
	
	public void rightMovement()
	{
		double dx= o.getDx();
		if(o.isRight())
		{
			dx += movespeed;
			if(dx > maxspeed)
			{
				dx = maxspeed;
			}
		}else 
			if(dx>0)
			{
				dx -= stopspeed;
				if(dx<0)
				{
					dx=0;
				}
			}
		o.setDx(dx);
		
	}
	
	public void up_down_movement()
	{
		double dy= o.getDy();
		if(o.isUp())
		{
			dy -= movespeed;
			if(dy < -maxspeed)
			{
				dy = -maxspeed;
			}
		}
		else if(o.isDown())
		{
			dy += movespeed;
			if(dy > maxspeed)
			{
				dy = maxspeed;
			}
		}else
		{
			if(dy>0)
			{
				dy -= stopspeed;
				if(dy<0)
				{
					dy=0;
				}
			}
			else if(dy<0)
			{

				dy += stopspeed;
				if(dy>0)
				{
					dy=0;
				}
			}
		}
		
		o.setDy(dy);
	}

	public void upMovement()
	{
		double dy = o.getDy();
		if(o.isUp())
		{
			dy -= movespeed;
			if(dy < -maxspeed)
			{
				dy = -maxspeed;
			}
		}else if(dy<0)
		{

			dy += stopspeed;
			if(dy>0)
			{
				dy=0;
			}
		}
		
		o.setDy(dy);
	}
	
	public void downMovement()
	{
		double dy= o.getDy();
		if(o.isDown())
		{
			dy += movespeed;
			if(dy > maxspeed)
			{
				dy = maxspeed;
			}
		}else 
			if(dy>0)
			{
				dy -= stopspeed;
				if(dy<0)
				{
					dy=0;
				}
			}
		o.setDy(dy);
		
	}
	
	
	
	public void openWorldPhysics()
	{
		left_right_movement();
		up_down_movement();
		o.collision().openWorldPhysics();
	}
	
	public void platformerPhysics(double gravityVaue,double maxFallingSpeed,double jumpHeight)
	{
		if(g==null)
		{
			g = o.gravity();
			o.gravity().initGravity(gravityVaue, maxFallingSpeed);
		}
		left_right_movement();
		o.gravity().gameObjectJump(o, jumpHeight);
		o.gravity().gameObjectFall(o);
		o.collision().platFormerPhysics();
	}
	
	
	public void openWorldPhysics_Ai()
	{
		left_right_movement();
		up_down_movement();
		o.collision().openWorldPhysics_Ai();
	}
	
	public void platformerPhysics_Ai(double gravityVaue,double maxFallingSpeed,double jumpHeight)
	{
		if(g==null)
		{
			g = o.gravity();
			o.gravity().initGravity(gravityVaue, maxFallingSpeed);
		}
		left_right_movement();
		o.gravity().gameObjectJump(o, jumpHeight);
		o.gravity().gameObjectFall(o);
		o.collision().platFormerPhysics_Ai();
	}
	
	public void arrowKeyMovement_platformer()
	{
		if(Screen.Engine.getKey().isKeyPressed(KeyEvent.VK_RIGHT))
		{
			o.setRight(true);
			o.setLeft(false);
			/*o.setJumping(true);
			o.setUp(true);
			o.setDown(true);*/
			
		}
		else
			if(Screen.Engine.getKey().isKeyReleased(KeyEvent.VK_RIGHT))
			{
				o.setRight(false);
				
				
			}
		if(Screen.Engine.getKey().isKeyPressed(KeyEvent.VK_LEFT))
		{
			o.setRight(false);
			o.setLeft(true);
		}
		else
			if(Screen.Engine.getKey().isKeyReleased(KeyEvent.VK_LEFT))
			{
				
				o.setLeft(false);
			
			}
		if(Screen.Engine.getKey().isKeyPressed(KeyEvent.VK_UP)&&!o.isFalling()&&!o.isJumping())
		{
			
			o.setJumping(true);
		}
		/*else
			if(Screen.Engine.getKey().isKeyReleased(KeyEvent.VK_UP))
			{
				
				up=false;
				
			}*/
		
	}
	
public void arrowKeyMovement_openWorld()	
{
	if(Screen.Engine.getKey().isKeyPressed(KeyEvent.VK_RIGHT))
	{
		o.setRight(true);
		o.setLeft(false);
		o.setUp(false);
		o.setDown(false);
	
	}
	else
		if(Screen.Engine.getKey().isKeyReleased(KeyEvent.VK_RIGHT))
		{
			o.setRight(false);
			
			
		}
	if(Screen.Engine.getKey().isKeyPressed(KeyEvent.VK_LEFT))
	{
		o.setRight(false);
		o.setLeft(true);
		o.setUp(false);
		o.setDown(false);
	}
	else
		if(Screen.Engine.getKey().isKeyReleased(KeyEvent.VK_LEFT))
		{
			
			o.setLeft(false);
			
		
		}
	if(Screen.Engine.getKey().isKeyPressed(KeyEvent.VK_UP))
	{
		
		o.setRight(false);
		o.setLeft(false);
		o.setUp(true);
		o.setDown(false);
	}
	else
		if(Screen.Engine.getKey().isKeyReleased(KeyEvent.VK_UP))
		{
			
			
			o.setUp(false);
			
			
		}
	if(Screen.Engine.getKey().isKeyPressed(KeyEvent.VK_DOWN))
	{
		
		o.setRight(false);
		o.setLeft(false);
		o.setUp(false);
		o.setDown(true);
	}
	else
		if(Screen.Engine.getKey().isKeyReleased(KeyEvent.VK_DOWN))
		{
	
			o.setDown(false);
		}
}
	
public void setMovespeed(double movespeed) {
	this.movespeed = movespeed;
}


public void setMaxspeed(double maxspeed) {
	this.maxspeed = maxspeed;
}
}
