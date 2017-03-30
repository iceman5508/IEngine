package Utils.Images;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;



/**
 * IEngine Bravo ImageHandler
 * @author Isaac Parker<br><br>
 * @version 2.0 2-15-2016<br><br>
 * 
 * The purpose of this class is to manage images <br>
 * as well as work with sprite sheets.
  */
public class ImageHandler {

	private BufferedImage image;
	private AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
	private AffineTransformOp op;
	private InputStream in = null;
	/**
	 * 
	 * @param location the location of the image
	 */
	public ImageHandler(String location)
	{
		
		
		try {
			 in = this.getClass().getResourceAsStream("/"+location);
				image = ImageIO.read(in);
			} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			image = null;
			in=null;
		}	
	}
	
	/**
	 * 
	 * @return the requested image if found
	 */
	public BufferedImage getImage()
	{
		return image;
	}
	
	/**
	 * Returns an image in a selected col and row of the image.<br>
	 * Given that the information provided is correct.
	 * @param row row image is in
	 * @param col col image is in
	 * @param spriteWidth width of the image
	 * @param spriteHeight height of the image
	 * @return
	 */
	public BufferedImage getSprite(int row, int col, int spriteWidth, int spriteHeight)
	{
		return image.getSubimage((col-1)*spriteWidth,(row-1)*spriteHeight, spriteWidth, spriteHeight);
	}
	
	/**
	 * Get an image flipped on its Y-axis
	 * @return
	 */
	public BufferedImage getFlipedVertical()
	{
		
		
		tx.translate(0, -image.getHeight(null));
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);
		return image;
	}
	
	/**
	 * get an image flipped on it X-axis
	 * @return
	 */
	public BufferedImage getFlipedHorizontal()
	{
		
		// Flip the image horizontally
		tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-image.getWidth(null), 0);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);
		return image;
	}
	


	/**
	 * get an image that is flipped 180 degrees
	 * @return
	 */
	public BufferedImage getFliped180()
	{
	// Flip the image vertically and horizontally; equivalent to rotating the image 180 degrees
		tx = AffineTransform.getScaleInstance(-1, -1);
		tx.translate(-image.getWidth(null), -image.getHeight(null));
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);
		return image;
	}
	
	

	
	
	
	
	

}
