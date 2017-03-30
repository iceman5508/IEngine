
/**
 * IEngine 4.0
 * 10-29-2016
 * Isaac Parker
 * This class is not meant to be interacted with directly
 * However, it manages the states of the game and how it runs. 
 */

package core.Engine;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JPanel;






public class Loop extends JPanel implements Runnable {

	
	private static final long serialVersionUID = 1L;
	private final IEngine e = IEngine.getInstance();
	private Thread thread;
	private int FPS = 30;
	private BufferedImage gameImage; 
	private static int pixels[];
	

	
	
	/**
	 * 
	 * @param e
	 */
	public Loop()
	{
		super();
		FPS = e.getFPS();
		setPreferredSize(new Dimension(e.getWidth()*e.getScale(),e.getHeight()*e.getScale()));
		setFocusable(true);
		requestFocus();	
		addKeyListener(e.getKey());
		addMouseListener(e.getMouse());		
		gameImage =  new BufferedImage(e.getWidth(),e.getHeight(), BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)gameImage.getRaster().getDataBuffer()).getData();
	}
	
	/**
	 * 
	 */
	public synchronized void start()
	{
		if(thread==null)
		{
			thread = new Thread(this, "Display");
			thread.start();
			e.setRunning(true);
		}
	}
	
	/**
	 * 
	 */
	public synchronized void stop()
	{
		e.setRunning(false);
		try {
			thread.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	@Override
	public void addNotify()
	{
		super.addNotify();
		start();
	
	}
	
	/**
	 * 
	 */
	@Override
	public void run()
	{
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0/FPS;
		double delta=0;
		int frames=0;
		int updates=0;
		
		
		while(e.getRunning())
		{
			
			long now = System.nanoTime();
			
			delta+= (now-lastTime)/ns;
			lastTime=now;
			
			while(delta>=1)
			{
				update();
				updates++;
				delta--;
				
				
			}
			
			render();
			frames++;
			
			
			if(System.currentTimeMillis()-timer>1000)
			{
				 timer+=1000;
				 e.setActualFPS(frames);
				 if(e.isDevMode())
				 {
					 e.getWindow().setTitle(e.getTitle()+ " | "+ updates + " ups, "+ frames+ " fps");
				 }else
				 {
					 e.getWindow().setTitle(e.getTitle()); 
				 }
				 updates=0;
				 frames=0;
			}
		}
		stop();
	}

	/**
	 * 
	 */
	private void update() {
		// TODO Auto-generated method stub
		if(e.getKey().isKeyPressed(KeyEvent.VK_ESCAPE))
		{
			System.exit(0);
		}
		
		if(e.getScreen()!=null)
		{
			e.getScreen().update();
			if(!e.getScreen().isScreenLoaded())
			{
				e.getScreen().setScreenLoaded(true);
			}
		}
	}

	/**
	 * 
	 */
	private void render() {
		// TODO Auto-generated method stub
		Render.init(gameImage);
		 {
			
			Render.getRender().setColor(Color.BLACK);
			Render.getRender().fillRect(0, 0, getWidth(), getHeight());
			if(e.getScreen()!=null)
			{
				e.getScreen().render(Render.getRender());
				if(!Screen.currentScreen.equals(e.getScreen().getScreenName()))
				{
					Screen.currentScreen = e.getScreen().getScreenName();
					
				}
			}
		
			
			 
		 }
		
			Render.getRender().dispose();
		
		
		/***************************/
		 Graphics2D g2d = (Graphics2D) getGraphics();
			g2d.drawImage(gameImage, 0, 0, getWidth(), getHeight(),null);
			g2d.dispose();
			
		/*******************************/
	}

	public static int[] getPixels() {
		return pixels;
	}

	public static void setPixels(int pixels[]) {
		Loop.pixels = pixels;
	}
	
	

}
