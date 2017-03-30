 /** IEngine 4.0
 * 10-29-2016
 * Isaac Parker
 * IEngine Screen class
 * The purpose of this class is to be extended by other classes
 * to create scnes for the application. 
**/

package core.Engine;
import java.awt.Graphics2D;

import core.Input.keys.Keys;
import core.Input.mouse.Mouse;
import core.Maps.tileMap;







public abstract class Screen {

	public static final IEngine Engine = IEngine.getInstance();
	//public static final ISL ISL = new ISL();
	public static String lastScreen="none",currentScreen="none";
	
	
	
	private boolean screenLoaded=false;
	private String screenName;
	
	
	
	/**
	 * 
	 * @param e - the current instance of the engine being used
	 */
	public Screen()
	{
		this.screenName=getClass().getName();
	}
	
	/**
	 * initiation of all application objects for the scene
	 */
	public abstract void init();
	
	
	/**
	 * Render application objects for the scene
	 * @param graphics2d - drawing object
	 */
	public abstract void render(Graphics2D graphics2d);
	
	
	/**
	 * Update objects on the scene
	 */
	public abstract void update();
	
	
	/**
	 * Key class being used by engine
	 * @return
	 */
	public Keys getKeysInput()
	{
		return Engine.getKey();
	}
	
	
	/**
	 * Mouse class being used by the engine
	 * @return
	 */
	public Mouse getMouseInput()
	{
		return  Engine.getMouse();
	}
	
	
	
	
	public static double xposOnScreen(double x)
	{
		if(x>Engine.getWidth())
		{
			return x-Engine.getWidth();
		}else
		{
			return x;
		}
	}
	
	public static double yposOnScreen(double y)
	{
		if(y>Engine.getHeight())
		{
			return y-Engine.getHeight();
		}else
		{
			return y;
		}
	}
	
	public static double xposOnMap(double x,tileMap map)
	{
		return (x+map.getX());
	}
	
	public static double yposOnMap(double y,tileMap map)
	{
		return (y+map.getY());
	}
	

	public static boolean seenOnScreen(double x, double y, int width, int height) {
		boolean seen =  x + width < 0 ||
			x - width > Engine.getWidth() ||
			y + height < 0 ||
			y - height > Engine.getHeight();
			
			return !seen;
	}
	
	public boolean isScreenLoaded() {
		return screenLoaded;
	}
	
	public void setScreenLoaded(boolean screenLoaded) {
		this.screenLoaded = screenLoaded;
	}
	
	public String getScreenName() {
		return screenName;
	}
	
	public boolean isCurrentScreen()
	{
		return currentScreen.equals(screenName);
	}
	
	
}
