package core.Physics.Gravity;

import core.Objects.GameObject;

public class gravity {

	private double gravity,maxFallingSpeed,jumpHeight=0;
	
	
	public void initGravity(double gravityVaue){
		this.gravity =  gravityVaue;
		this.maxFallingSpeed = 20;
		
	}
	
	public void initGravity(double gravityVaue, double maxFallingSpeed){
		this.gravity =  gravityVaue;
		this.maxFallingSpeed = maxFallingSpeed;
	}
	
	
	public void gameObjectJump(GameObject o, double jumpHeight)
	{
		this.jumpHeight=jumpHeight;		
		if(o.isJumping())
		{
		o.setDy(jumpHeight);
		o.setFalling(true);
		o.setJumping(false);
		}
		
	}
	
	public void gameObjectJump(GameObject o)
	{
		if(this.jumpHeight==0)
		{
			this.jumpHeight=-11.0;
		}
		if(o.isJumping())
		{
		o.setDy(jumpHeight);
		o.setFalling(true);
		o.setJumping(false);
		}
	}
	
	public void gameObjectFall(GameObject o)
	{
		double dy = o.getDy();
		if(o.isFalling())
		{
			
			dy+=gravity;
			if(dy>maxFallingSpeed)
			{
				dy=maxFallingSpeed;
			}
		}else
		{
			dy=0;
		}
		o.setDy(dy);
		
	}
	
	public double getGravity() {
		return gravity;
	}
	
	public double getMaxFallingSpeed() {
		return maxFallingSpeed;
	}

	public double getJumpHeight() {
		// TODO Auto-generated method stub
		return this.jumpHeight;
	}
}
