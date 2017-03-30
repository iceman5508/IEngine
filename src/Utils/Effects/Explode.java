package Utils.Effects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
public class Explode{
	

	private int r;
	private int maxR;
	private Color c;
	private double x,y;
	
	public Explode(double x,double y,int r,int max,Color c)
	{ 
	 
		
		this.r=r;
		this.maxR=max;
		this.c=c;
		this.x=x;
		this.y=y;
	}
	
	
	
	public boolean finished()
	{
		r+=2;
		if(r>=maxR){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void render(Graphics2D g2d)
	{
		
			g2d.setColor(c);
			g2d.setStroke(new BasicStroke(3));
			g2d.drawOval((int)x-r, (int)y-r, r*2, r*2);
			g2d.setStroke(new BasicStroke(1));	
		
	}

	
	

}
