package core.Camera;
import core.Abstract.mapBuilder;
import core.Engine.Screen;
import core.Objects.GameObject;

public class Camera {
	
	private mapBuilder map;
	public void initMapCam(mapBuilder map,double scrollValue)
	{
		map.setScroll(scrollValue);
		map.initRenderFeatures();
		map.updateRenderFeatures();
		map.setBounds();
		this.map=map;
	}
	
	 public void scrollMap(double x, double y)
	  {
		 	double setX = map.getX();
		 	setX+= (x - map.getX())*map.getScroll();
		 	
		 	
		 	map.setX(setX);
		 	
		 	
		 	double setY = map.getY();
		 	setY+= (y - map.getY())*map.getScroll();
		 	map.setY(setY);
		 	
		 	map.checkBounds();
	    	map.updateRenderFeatures();
	   }
	
	
	
	
	public void setPosition(GameObject o)
	{
		scrollMap(o.getX()-map.getWidth()/2, -o.getY());
	}
	
	public void setPosition(double x, double y)
	{
		scrollMap(x,y);
	}
	
	public void scrollByGameObject(GameObject o)
	{
		scrollMap(-o.getX()+map.getWidth()/2, -o.getY());	
	}
	
	public void scrollByGameObjectCenter(GameObject o)
	{
		scrollMap(-o.getX()+Screen.Engine.getWidth()/2, -o.getY()+Screen.Engine.getHeight()/2);	
	}
	
	public void scroll(double x, double y)
	{
		scrollMap(x, y);	
	}
	

}
