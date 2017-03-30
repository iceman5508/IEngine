package Utils.Font;
import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics2D;









public class iFont {
	
	
	
	public iFont() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void setSize(float size, Graphics2D g2d)
	{
		Font currentFont = g2d.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * size);
		g2d.setFont(newFont);
	}
	
	
	public void setStrokeSize(int size, Graphics2D g2d)
	{
		if(size<1)
		{
			size=1;
		}
		g2d.setStroke(new BasicStroke(size));
	}
	
	
	
	
	

}
