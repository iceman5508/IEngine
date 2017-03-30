package Utils.Color;

import java.awt.Color;

/**
* IEngine Bravo CustomCOor
* @author Isaac Parker<br><br>
* @version 1.0 12-11-2015<br><br>
* 
* This class allows users to make custom colors by inputting<br>
* the rbg that they want.
*/
public class CustomColor {

		Color c;
		
		/**
		 * Creates a color of the provided rbg values
		 * @param r red value  max=255
		 * @param g green value max=255
		 * @param b blue value  max=255
		 */
		public CustomColor(float r,float g,float b)
		{
			c = new Color((int)r, (int)g,(int) b);
		}
		
		/**
		 * Creates a color of the provided rbg values
		 * @param r red value  max=255
		 * @param g green value max=255
		 * @param b blue value  max=255
		 * @param alpha the transparency max=255
		 * 
		 */
		public CustomColor(float r,float g,float b,float alpha)
		{
			c = new Color((int)r, (int)g,(int) b,(int)alpha);
		}
		
		/**
		 * 
		 * @return get the custom color that was created
		 */
		public Color getColor()
		{
			return c;
		}
		
		
	
		
		/**
		 * Creates a color of the provided rbg values
		 * @param r red value  max=255
		 * @param g green value max=255
		 * @param b blue value  max=255
		 */
		public void setColor(float r,float g,float b)
		{
			c = new Color((int)r, (int)g, (int)b);
		}
		
		/**
		 * returns a color of the provided rbg values
		 * @param r red value  max=255
		 * @param g green value max=255
		 * @param b blue value  max=255
		 */
		public static Color Color(float r,float g,float b)
		{
			return new Color((int)r, (int)g,(int) b);
		}
		

		/**
		 * Creates a color of the provided rbg values
		 * @param r red value  max=255
		 * @param g green value max=255
		 * @param b blue value  max=255
		 */
		public void setColor(float r,float g,float b,float alpha)
		{
			c = new Color((int)r, (int)g, (int)b,(int)alpha);
		}
		
		/**
		 * returns a color of the provided rbg values
		 * @param r red value  max=255
		 * @param g green value max=255
		 * @param b blue value  max=255
		 */
		public static Color Color(float r,float g,float b,float alpha)
		{
			return new Color((int)r, (int)g,(int) b,(int)alpha);
		}
	
		public String rgbToHex()
		{
			String hex = Integer.toHexString(c.getRGB()&0xffffff);
			if(hex.length()<6)
			{
				hex="0"+hex;
			}
			hex="#"+hex;
			return hex;
		}
		
		public static String rgbToHex(Color c)
		{
			String hex = Integer.toHexString(c.getRGB()&0xffffff);
			if(hex.length()<6)
			{
				hex="0"+hex;
			}
			hex="#"+hex;
			return hex;
		}
		
		public static String rgbToHex(int c)
		{
			String hex = Integer.toHexString(c&0xffffff);
			if(hex.length()<6)
			{
				hex="0"+hex;
			}
			hex="#"+hex;
			return hex;
		}
		
		public static Color hexToColor(String hex)
		{
			return Color.decode(hex);
		}
		
		
		
		
}
