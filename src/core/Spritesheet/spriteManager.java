package core.Spritesheet;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class spriteManager {

	private static Map<String, BufferedImage> sprites;
	public static void init(){ 
		// TODO Auto-generated constructor stub
		if(sprites==null)
		{
			sprites = new HashMap<String,BufferedImage>();
		}
	}
	
	public static void addSprite(String spritename, BufferedImage sprite)
	{
		sprites.put(spritename, sprite);
	}
	
	public static void clearAll()
	{
		sprites.clear();
	}

	public static void removeSprite(String spritename)
	{
		sprites.remove(spritename);
	}
	
	public static BufferedImage getSprite(String spritename)
	{
		return sprites.get(spritename);
	}
}
