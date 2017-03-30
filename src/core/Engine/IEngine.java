/**
 * IEngine 4.0
 * 10-29-2016
 * Isaac Parker
 * IEngine class, all interactions with the gameloop
 * will be done through this class. Additionally, initiation 
 * for any application using this engine must first use this class to
 * start inits. 
 */


package core.Engine;
import java.awt.Graphics2D;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Utils.Sound.SoundEngine;
import core.Input.keys.Keys;
import core.Input.mouse.Mouse;


public class IEngine {
	
	private Mouse mouse;
	private Keys key;
	private JFrame  window; 
	private JPanel loop;
	private boolean running;
	private double actualFPS;
	private int FPS=30;
	private int width,height;
	private int scale=1;
	public static IEngine e;
	private Screen activeScreen=null;
	private String title;
	private boolean devMode=false;
	
	
	
	public static String getCurrentFilePath()
	{
		try {
			return IEngine.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 
	 * @return current running instance of the Engine
	 */
	public static IEngine getInstance()
	{
		if(e==null)
		{
			e = new IEngine();
			SoundEngine.init();
		}
		
		return e;
	}
	
	
	
	private IEngine()
	{
		
	}
	
	
	
	
	
	/**
	 * 
	 * @param window The JFrame that will be displayed  by the engine
	 */
	public void loadWindow(JFrame window)
	{
		this.window = window;
		
	}
	
	
	/**
	 * 
	 * @param window the JFrame that will be displayed by the engine
	 * @param fps the desired fps that application will run at
	 */
	public void loadWindow(JFrame window, int fps)
	{
		this.window = window;
		this.FPS = fps;
	}
	
	/**
	 * 
	 * @param loop provide the gameloop/jpanel to manage the scene. 
	 */
	public void loadGameLoop(JPanel loop)
	{
		this.loop = loop;
	}
	
	/**
	 * 
	 * @param mouseClass the mouse control class for Engine
	 * @param keyClass the key control class for the Engine
	 */
	public void loadInputEngine(Mouse mouseClass, Keys keyClass)
	{
		this.key=keyClass;
		this.mouse = mouseClass;
	}
	
	
	/**
	 * 
	 * @return The current real time FPS
	 */
	public double getActualFPS() {
		return actualFPS;
	}

	/**
	 * 
	 * @param actualFPS set the current real time FPS.
	 * It is not recommended that this method is ever used. 
	 */
	public void setActualFPS(double actualFPS) {
		this.actualFPS = actualFPS;
	}

	
	/**
	 * 
	 * @return The running boolean. True if application is running,
	 * false if it is not. 
	 */
	public boolean getRunning() {
		return running;
	}

	/**
	 * 
	 * @param running - boolean value. Set true if application 
	 * should run and set to false to turn application off. 
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	/**
	 * 
	 * @return returns the desired FPS. Note this
	 * FPS is not the current running FPS of the application, 
	 * it is only the desired running FPS.
	 */
	public int getFPS() {
		return FPS;
	}

	/**
	 * 
	 * @return get the key controller
	 */
	public Keys getKey() {
		return key;
	}
	
	/**
	 * 
	 * @return get the mouse controller
	 */
	public Mouse getMouse() {
		return mouse;
	}

	/**
	
	public JPanel getLoop() {
		return loop;
	}*/
	
	
	/**
	 * Build The game Engine with the set Engine properties.
	 *  @param Title - the title of the game
	 * @param width - width of the window
	 * @param height - height of the window
	 */
	public void buildEngine(String Title,int width,int height)
	{
		if(e!=null)
		{
			this.title = Title;
		this.width = width;
		this.height = height;
		loadInputEngine(new Mouse(), new Keys());
		loadGameLoop(new Loop());
		Window win=new Window(this.loop);		
		win.addKeyListener(key);
		win.addMouseListener(mouse);
		loadWindow(win);
		SoundEngine.init();
		}
	}
	
	
	
	
	/**
	 * Build The game Engine with the set Engine properties.
	 * @param Title - title of application
	 * @param width - width if application
	 * @param height - height of application
	 * @param scale - scale to adjust application by.
	 * 
	 */
	public void buildEngine(String Title,int width,int height, int scale)
	{
		if(e!=null)
		{
			this.title = Title;
		this.width = width;
		this.height = height;
		this.scale = scale;
		loadInputEngine(new Mouse(), new Keys());
		loadGameLoop(new Loop());
		Window win=new Window(this.loop);			
		win.addKeyListener(key);
		win.addMouseListener(mouse);
		loadWindow(win);
		SoundEngine.init();
		}
	}
	
	
	
	/**
	 * Build The game Engine with the set Engine properties.
	 * @param Title - title of application
	 * @param width - width if application
	 * @param height - height of application
	 * @param scale - scale to adjust application by.
	 * @param mouse - mouse input to use
	 * @param keys - key input to use
	 */
	public void buildEngine(String Title,int width,int height, int scale, Mouse mouse, Keys keys)
	{
		if(e!=null)
		{
			this.title = Title;
		this.width = width;
		this.height = height;
		this.scale = scale;
		loadInputEngine(mouse, keys);
		loadGameLoop(new Loop());
		Window win=new Window(this.loop);		
		win.addKeyListener(this.key);
		win.addMouseListener(this.mouse);
		loadWindow(win);
		SoundEngine.init();
	}
	}
	
	/**
	 * Build The game Engine with the set Engine properties.
	 *  @param Title - the title of the game
	 * @param width - width of the application
	 * @param height - height of the application
	 * @param fps - desired fps for the application
	 *
	public void buildEngine(String Title,int width,int height, int fps)
	{
		if(e!=null)
		{
		this.title = Title;
		this.width = width;
		this.height = height;
		loadInputEngine(new Mouse(), new Keys());
		loadGameLoop(new Loop(e));
		Window win=new Window(this.loop,fps);		
		win.addKeyListener(key);
		win.addMouseListener(mouse);
		loadWindow(win,fps);
		SoundEngine.init();
		}
	}
	*/
	
	
	
	/**
	 * Build The game Engine with the set Engine properties.
	 * @param Title - title of application
	 * @param width - width if application
	 * @param height - height of application
	 * @param scale - scale to adjust application by.
	 *  @param fps - desired fps for the application
	 */
	public void buildEngine(String Title,int width,int height, int scale, int fps)
	{
		if(e!=null)
		{
		this.title = Title;
		this.width = width;
		this.height = height;
		this.scale = scale;
		loadInputEngine(new Mouse(), new Keys());
		loadGameLoop(new Loop());
		Window win=new Window(this.loop);			
		win.addKeyListener(key);
		win.addMouseListener(mouse);
		loadWindow(win,fps);
		SoundEngine.init();
		}
	}
	
	
	
	/**
	 * Build The game Engine with the set Engine properties.
	 * @param Title - title of application
	 * @param width - width if application
	 * @param height - height of application
	 * @param scale - scale to adjust application by.
	 * @param mouse - mouse input to use
	 * @param keys - key input to use
	 * @param fps - desired fps for the application
	 */
	public void buildEngine(String Title,int width,int height, int scale, Mouse mouse, Keys keys, int fps)
	{
		if(e!=null)
		{
			this.title = Title;
		this.width = width;
		this.height = height;
		this.scale = scale;
		loadInputEngine(mouse, keys);
		loadGameLoop(new Loop());
		Window win=new Window(this.loop);		
		win.addKeyListener(this.key);
		win.addMouseListener(this.mouse);
		loadWindow(win,fps);
		SoundEngine.init();
	}
	}
	
	
	/**
	 * 
	 * @return - gives the current JFrame being used as the window
	 */
	public JFrame getWindow() {
		return window;
	}

		
	
	/**
	 * 
	 * @return The current active Screen
	 * @see Screen
	 */
	public Screen getScreen() {
		// TODO Auto-generated method stub
		return activeScreen;
	}
	
	/**
	 * 
	 * @param sc the Screen that should be made active
	 */
	public void setActiveScreen(Screen sc)
	{
		if(activeScreen!=null)
		{
			Screen.lastScreen = activeScreen.getScreenName();
		}
		sc.init();
		activeScreen = sc;
		
		
		
	}
	
	
	/**
	 * stop the application from running
	 */
	public void stop()
	{
		running=false;
	}
	
	/**
	 * 
	 * @param fPS - the desired FPS that user 
	 * wants to use.
	 */
    public void setDesiredFPS(int fPS) {
		FPS = fPS;
	}
    
    
    /**
     * 
     * @return - The Graphics buffer user wants to use.
     */
    public Graphics2D getRenderer()
    {
    	return Render.getRender();
    }
    
    /**
     * 
     * @return - Title of the application.
     */
    public String getTitle() {
		return title;
	}
    
    
    /**
     * 
     * @return the width of the application
     */
    public int getWidth() {
		return width;
	}
    
    
    /**
     * 
     * @return the height of the application
     */
   public int getHeight() {
	return height;
   }
   
   /**
    * Return the scale value being used
    * @return
    */
   public int getScale() {
	return scale;
}
   
   public int[] getPixels()
   {
	   return Loop.getPixels();
   }
   
   public void setPixels(int pixels[])
   {
	   Loop.setPixels(pixels);
   }
   
   public boolean isDevMode() {
	return devMode;
}
   
   public void devModeOn()
   {
	   this.devMode=true;
   }

}
