package Utils.Util2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;


public class Transformation {
	
	public static AffineTransformOp rotation(double angle,int x,int y)
	{
		AffineTransform tx = AffineTransform.getRotateInstance(angle, x, y);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		return op;
	}
	
	
	

}
