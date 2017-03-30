package Utils.Images;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class imageTransform {
	
	public static void renderImage(Graphics2D g2d,double angle,BufferedImage image,double x,double y, double h, double w )
	{

		AffineTransform backup = g2d.getTransform();
		AffineTransform trans = new AffineTransform();
		trans.rotate( angle, x, y ); // the points to rotate around (the center in my example, your left side for your problem)

		g2d.transform( trans );
		g2d.drawImage( image,(int) x, (int)y,(int)w,(int)h,null );  // the actual location of the sprite

		g2d.setTransform( backup );
		
	}
	
	
	/**
	 * get an image that is flipped 180 degrees
	 * @return
	 */
	public static BufferedImage getFliped180(BufferedImage image)
	{
	// Flip the image vertically and horizontally; equivalent to rotating the image 180 degrees
		AffineTransform tx = AffineTransform.getScaleInstance(-1, -1);
		tx.translate(-image.getWidth(null), -image.getHeight(null));
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);
		return image;
	}
	
	/**
	 * Get an image flipped on its Y-axis
	 * @return
	 */
	public static BufferedImage getFlipedVertical(BufferedImage image)
	{
		AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
		
		tx.translate(0, -image.getHeight(null));
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);
		return image;
	}
	
	/**
	 * get an image flipped on it X-axis
	 * @return
	 */
	public static BufferedImage getFlipedHorizontal(BufferedImage image)
	{
		
		// Flip the image horizontally
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-image.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		image = op.filter(image, null);
		return image;
	}
	
	public static void renderFlipedLeft(Graphics2D g2d, BufferedImage image, 
	int x,int y,int width, int height)
	{
		g2d.drawImage(image,x+width, y, -width, height,null);
	}
	
	public static void renderFlipedUpsideDown(Graphics2D g2d, BufferedImage image, 
			int x,int y,int width, int height)
			{
				g2d.drawImage(image,x, y+height, width, -height,null);
			}
	
	public static void renderFlipedUpsideDown_Left(Graphics2D g2d, BufferedImage image, 
			int x,int y,int width, int height)
			{
				g2d.drawImage(image,x+width, y+height, -width, -height,null);
				
			}
	
	
	

}
