 /** IEngine 4.0
 * 10-29-2016
 * Isaac Parker
 * Render class to allow for drawing of images to screen
 * **/
package core.Engine;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Render{

	private static Graphics2D g2d; 
	
	/**
	 * Initialize Graphics object
	 * @param panel jpanel to use
	 */
	public static void init(JPanel panel)
	{
		
			g2d = (Graphics2D) panel.getGraphics();
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		    
	}
	
	/**
	 * Initialize Graphics object
	 * @param bi BufferedImage to use
	 */
	public static void init(BufferedImage bi)
	{
		
			g2d = (Graphics2D)bi.getGraphics(); 
			 g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			 g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
	}
	
	/**
	 * Get the Graphics object
	 * @return
	 */
	public static Graphics2D getRender() {
		
		return g2d;
	}
}
