package Utils.Files;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

/**
 * IEngine Bravo FileLoader
 * @author Isaac Parker<br><br>
 * @version 1.0 12-11-2015<br><br>
 * 
 * <br>
 * This class makes it to load in Image files or text files.<br>
 * Simply place the location of the file in the constructor<br>
 * and let the class do the rest of the work.
 */
public class FileLoader {
	
	private InputStream in;
	private BufferedImage im;
	private BufferedReader br;
	static ClassLoader classLoader = ClassLoader.getSystemClassLoader();
	
	public FileLoader(String fileLocation)
	{
		 in = getClass().getResourceAsStream("/"+fileLocation); 
		 
	}
	
	/**
	 * If the file you are looking for is a text file<br>
	 * Then this method will preload the file before use.
	 */
	public void loadTextFile()
	{
		try {
			br = new BufferedReader(new InputStreamReader(in));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * If the file you are looking for is a image file<br>
	 * Then this method will preload the file before use.
	 */
	 
	public void loadImgFile()
	{
	  try {
			im = ImageIO.read(in);
			
		   } catch (IOException e)
	  	  {
			e.printStackTrace();	
	  	  }
		
	}
	
	
	/**
	 * Returns the preloaded text file
	 * @return the text file as a bufferedreader object
	 * <br><br>
	 * Note be sure to call the loadTextFile method<br>
	 * before calling this method
	 */
	public BufferedReader getTextFile()
	{
		return br;
	}
	
	/**
	 * This method is to close the reading stream.<br>
	 * Use this once you are done reading the file so,
	 * <br>No possible leaking of memory happens.
	 */
	public void close()
	{
		try {
			br.close();
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the preloaded image file
	 * @return the text file as a bufferedimage object
	 * <br><br>
	 * Note be sure to call the loadImgFile method<br>
	 * before calling this method
	 */
	public BufferedImage getImage()
	{
		return im;
	}
	

	/**
	 * Returns the an text file at given location<br>
	 * if that text is found.
	 * @return 
	 * @return the text file as a bufferedreader object
	 */
	public static BufferedReader getTextFile(String location)
	{
		try
		{
			return new BufferedReader(new InputStreamReader(classLoader.getClass().getResourceAsStream("/"+location)));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns the an image file at given location<br>
	 * if that image is found.
	 * @return 
	 * @return the text file as a bufferedimage object
	 */
	public static BufferedImage getImageFile(String location)
	{
		
		
		try {
			return  ImageIO.read(classLoader.getClass().getResourceAsStream("/"+location));
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
   
}
