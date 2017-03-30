package core.Background;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import Utils.Images.ImageHandler;





public class BackgroundManager {
	
	private BufferedImage image;
	private double scroll,x,y;
	private int height,width;
	
	
	public BackgroundManager(String location, double scroll) {
		// TODO Auto-generated constructor stub
		image = new ImageHandler(location).getImage();
		this.scroll=scroll;
		x=0;
		y=0;
		height=image.getHeight();
		width=image.getWidth();
	}
	
	public BackgroundManager(String location, double scroll,int height, int width) {
		// TODO Auto-generated constructor stub
		image = new ImageHandler(location).getImage();
		this.scroll=scroll;
		x=0;
		y=0;
		this.height=height;
		this.width=width;
	}
	
	public BackgroundManager(String location, double scroll, double x, double y) {
		// TODO Auto-generated constructor stub
		image = new ImageHandler(location).getImage();
		this.scroll=scroll;
		this.x=x;
		this.y=y;
		height=image.getHeight();
		width=image.getWidth();
	}
	
	public BackgroundManager(String location, double scroll,
		int height, int width, double y,double x) {
		// TODO Auto-generated constructor stub
		image = new ImageHandler(location).getImage();
		this.scroll=scroll;
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
	}
	
	
	public void render(Graphics2D g2d)
	{
		g2d.drawImage(image, (int)x, (int)y, width, height,null);
	}
	
	
	public void update()
	{
		x*=scroll;
		y*=scroll;
	}
	
	

	
}







