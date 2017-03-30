package Utils.Effects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Text {
	
	private double x,y;
	private long time,startTime;
	private String s;
	private int size;
	private int r=255,b=255,g=255;

	public Text(double x, double y, long time, String s,int size)
	{
		this.s=s;
		this.x=x; 
		this.y=y;
		this.time=time;		
		startTime = System.nanoTime();
		this.size =size;
	}
	
	public Text(double x, double y, long time, String s,int size,int r,int g, int b)
	{
		this.x=x; 
		this.y=y;
		this.time=time;
		this.s=s;
		startTime = System.nanoTime();
		this.size =size;
		this.r=r;
		this.g=g;
		this.b=b;
	}
	
	public boolean finished()
	{
		long passedTime = (System.nanoTime()-startTime)/1000000;
		if(passedTime>time)
		{
			
			return true;
			
		}else
		{
			return false;
		}
	}
	
	public void render(Graphics2D g2d)
	{
		g2d.setFont(new Font("Century Gothic",Font.PLAIN,size));
		long passedTime = (System.nanoTime()-startTime)/1000000;
		int alpha = (int)(255*Math.sin(3.14*passedTime/time));
		if(alpha>=255)
		{
			alpha = 250;
		}
		try
		{
			g2d.setColor(new Color(r,g,b,alpha));
		}catch(IllegalArgumentException e)
		{
			g2d.setColor(new Color(r,g,b,64));
		}
		int length = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();//string length in px;
		g2d.drawString(s,(int)(x-length/2),(int) y);
		
	}
}
