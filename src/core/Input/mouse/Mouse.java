package core.Input.mouse;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import Utils.timer.Timer;


/**
 * @author Isaac Parker
 * @version 4.13.2015
 * @purpose This class acts as both a mouse motion adapter<br>
 *          while also acting as an event listener.<br>
 * 
 *          Note that this class is meant to be extended so that full
 *          declaration could be given<br>
 *          to each method for whatever project you are working on.<br>
 *  
 */

public class Mouse extends MouseMotionAdapter implements MouseListener {

	private int mouseX, mouseY;
	protected boolean clicked;
	private Timer time = new Timer(1.0);
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		mouseX = e.getX();
		mouseY = e.getY();
		clicked=true;		
		time.startTimer();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = e.getX();
		mouseY = e.getY();
		clicked=true;
		
			
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		clicked = false;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}
	
	/**
	 * Check if mouse is being pressed down
	 * @return true if pressed, false if not
	 */
	public boolean isMousePressed()
	{
		
		return clicked;
	}
	
	/**
	 * Check if mouse is clicked
	 * @return true if mouse is clicked, false if not 
	 */
	public boolean isMouseClicked()
	{
		time.update();
		if(time.isTimeUp())
		{
			clicked = false;
		}
		return clicked;
	}
	
	
	
	/**
	 * get mouse x position on the Frame
	 * @return
	 */
	public int getX()
	{
		
		return mouseX;
		
	}
	
	
	/**
	 * Get mouse y position on the frame
	 * @return
	 */
	public int getY()
	{
		
	   return mouseY;
	}
	
	/**
	 * Set the clicked param of the mouse.
	 * True if want to set click to yes
	 * false if want to set click to false
	 * @param clicked
	 */
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	
	
	
    

}
