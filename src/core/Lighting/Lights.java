package core.Lighting;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;
import Utils.Lists.iNodeList;
import core.Engine.Screen;


public class Lights {
	
	private static iNodeList<Lights> allLights;
	private float x, y,radius;
	private int width,height,startx,starty;
	private int index;
	private Color lightColor;
	private Color lightBackground;
	
	public Lights(double x, double y, double radius,int width,int height,int startx,int starty) {
		// TODO Auto-generated constructor stub
		if(allLights == null)
		{
			allLights = new iNodeList<>();
		}
		
		this.x=(float) x;
		this.y=(float) y;
		this.radius = (float) radius;
		this.width = width;
		this.height=height;
		this.startx=startx;
		this.starty=starty;		
		index = allLights.count;
		
		lightColor = new Color(0.0f,0.0f,0.0f,0.0f);
		lightBackground = Color.BLACK;
		allLights.add(null, this);
		
	}
	
	public void configLight(Color lightColor, Color lightBackground, int intensity)
	{
		
		this.lightColor = new Color(lightColor.getRed(), lightColor.getGreen(), 
				lightColor.getBlue(),intensity);
		this.lightBackground=lightBackground;
	}
	
	public void update(double x,double y)
	{
	 
		this.x=(float) x;
		this.y=(float) y;
	}
	
	public void renderLight(Graphics2D g2d)
	{
/***************light system***************/
	
		if(Screen.seenOnScreen(x, y, width, height))
		{
			Point2D center = new Point2D.Float(x, y);
			
			float[] intensity = {0.0f,1.0f};
			                                          //alpha
			Color[] colors = {lightColor,lightBackground};  //light color , background color
			
			RadialGradientPaint paint = new RadialGradientPaint(center, radius, intensity, colors);
			
			g2d.setPaint(paint);
			
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.95f));
			
			g2d.fillRect(startx, starty, width, height);
			
			g2d.dispose();
		}
	}
	
	
	public static void renderAllLights(Graphics2D g2d)
	{
		for(int i=0; i<allLights.count; i++)
		{
			Lights temp = allLights.getNode(i).Data2;
			temp.renderLight(g2d);
			
		}
	}
	
	public void remove()
	{
		allLights.remove(index);
	}
	
	

}
