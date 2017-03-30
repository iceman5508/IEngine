package core.Spritesheet;
import java.awt.image.BufferedImage;
import Utils.Images.ImageHandler;
import Utils.Lists.iArray;





public class spriteSheet {

	
	private static iArray<ImageHandler> list;
	private ImageHandler image;
	

	public spriteSheet(String fileLocation) {
		// TODO Auto-generated constructor stub
		if(list == null)
		{
			list = new iArray<>();
		}
		image = new ImageHandler(fileLocation);
		list.add(image);
		
		
	}
	
	public BufferedImage getSprite(int row,int col,int height,int width)
	{
		return image.getSprite(row, col, width, height);
	}
	

	public static ImageHandler getSheetAt(int i)
	{
		return list.get(0,i);
	}
	

	public static ImageHandler  getFirst()
	{
		return list.get(0, 0);
	}
	

	public static ImageHandler getLast()
	{
		return list.get(0, list.getElementCount()-1);
	}
	
	
	
	public static void unlinkSheetAt(int index)
	{
		list.remove(0, index);
	}
	
	public static void unlinkLastSheet()
	{
		list.remove(0,list.getElementCount()-1);
	}
	
	public static void unlinkFirstSheet()
	{
		list.remove(0,0);
	}
	
	public static void unlinkAll()
	{
		for(int i=0; i<list.getSize(); i++)
		{
			list.remove(0);
		}
	}
	
	
	public static int getSize()
	{
		return list.getElementCount();
	}
	
	public static iArray<ImageHandler> getSheetList()
	{
		return list;
	}

	public ImageHandler getSheet()
	{
		return this.image;
	}
}
