package Utils.Buttons;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import core.Engine.Screen;






public class IEngineButton {
	
	private int x,y,height,width;
	private boolean clicked = false;
	private String text;
	private boolean hasString = false;
	private Rectangle but;
	private BufferedImage image;
	
	
	public IEngineButton(int x,int y,int width,int height)
	{
	
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		but = new Rectangle(x,y,width,height);
	}
	
	public IEngineButton(int x,int y,int width,int height, BufferedImage buttonImage)
	{
	
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		but = new Rectangle(x,y,width,height);
		image = buttonImage;
	}
	
	public boolean ButtonClicked()
	{
		if(	    Screen.Engine.getMouse().isMouseClicked()		
				&&getButton().contains(Screen.Engine.getMouse().getX(),Screen.Engine.getMouse().getY())
				)
		{
			
				this.clicked=true;
			 	return clicked;			
			
		}else
		{
		
			this.clicked=false;
			return false;
		}
	 
		
	}
	
	
	public void setText(String s) 
	{
		hasString = true;
		text = s;
	}
	
	

	

   public int getX() {
	return x;
}
	public int getY() {
		return y;
	}


	

	public int getHeight() {
		return height;
	}


	


	public int getWidth() {
		return width;
	}


	


	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public void drawButtonOutline(Graphics2D g2d)
	{
		g2d.draw(but);
	}
	
	
	
	public void drawButton(Graphics2D g2d)
	{
		if(image==null)
		{
			g2d.fill(but);
		}else
		{
		
			g2d.drawImage(image, x, y, width, height,null);
			
		}
	}
	
	public void drawString(Graphics2D g2d)
	{
		if(hasString)
		{
			g2d.drawString(text, (x+2), (y+(height/2)));
		}
	}
	
	public String getText()
	{
		return this.text;
	}
	
	
	
	public Rectangle getButton() {
		return but;
	}
	
	public void setButtonImage(BufferedImage image)
	{
		this.image = image;
	}
	
	public boolean mouseHover()
	{
		if(getButton().contains(Screen.Engine.getMouse().getX(),Screen.Engine.getMouse().getY()))
				{
					return true;
				}else
				{
					return false;
				}
	}

	
	
}
