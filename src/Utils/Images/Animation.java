package Utils.Images;
/**
 * IEngine Bravo
 * @author Isaac Parker<br>
 * @version 2.0 2-15-2016<br>
 * 
 *This animation class allows you to, create an <br>
 *Animation from separate images or a sprite sheet.
 *<br>It also checks if the animation has been ran through<br>
 *at least once. 
 */
import java.awt.image.BufferedImage;

public class Animation {
	
	private BufferedImage[] frames;
	private int currentFrame;
	private long startTime;
	private long delay;
	private boolean finished = false;
	
	
	public Animation(){}
	
	/**
	 * Give the image(s) that will be used for the animation.
	 * @param images
	 */
	public void setAnimation(BufferedImage[] images)
	{   
		frames = images;
		if(currentFrame >= frames.length)
		{
			currentFrame =0;
		}
		finished = false;
		//startTime = System.nanoTime();
	}
	
	/**
	 * Sets the current frame for the animation
	 * @param i
	 */
	public void setFrame(int i)
	{
		currentFrame = i;
	}
	
	
	/**
	 * Set the time between the playing of each frame of the animation.
	 * <br>Note: setting delay to -1 is to be done if animation only has 1 image.
	 * @param Dlay
	 */
	public void setDelay(long Dlay)
	{
		delay = Dlay;
	}
	
	
	/**
	 * This method plays the animation through.
	 */
	public void animate()
	{
		if(delay==-1)
		{
			
			return;
		}
		long passedTime = (System.nanoTime()-startTime)/1000000;
		
		if(passedTime > delay)
		{
			currentFrame++;
			startTime = System.nanoTime();
		}
		if(currentFrame == frames.length)
		{
			currentFrame=0;
			finished=true;
		}
		
	}
	
	/**
	 * Return a buffered image of the animation. 
	 * @return
	 */
	public BufferedImage getImage()
	{
		return frames[currentFrame];
	}

	/**
	 * Return the current frame.
	 * @return
	 */
	public int getFrame()
	{
		return currentFrame;
	}
	
	/**
	 * Return if the animation has been played through at least once. 
	 * @return
	 */
	public boolean hasFinished()
	{
		return finished;
	}
	

}
