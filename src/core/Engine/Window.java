package core.Engine;
import javax.swing.JFrame;
import javax.swing.JPanel;




/**
 * IEngine 4.0
 * 10-29-2016
 * Isaac Parker
 * IWindow Bravo
 *
 */
public class Window extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
		
	
	/**
	 * @param Height The desired Height for the game
	 * @param Width The desired width for the game
	 * @param title The desired title for the game
	 * @param wantedFPS The FPS that the game should run at 
	 */
	public Window(JPanel loop)
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(loop);
		setResizable(false);
		pack();
		setVisible(true);
		
	}
	
	
	/**
	 * This method is used to set the game icon if<br>
	 * one is wanted.<br>
	 * @param location the location of the object<br>
	 * Example setGameWindowIcon("gameImageFolder/image.png")
	 * 
	 *//*
	public void setGameWindowIcon(String location)
	{
		try{
		window.setIconImage(FileLoader.getImageFile(location));
		}catch(Exception e)
		{
			
		}		
	}*/
	
	
	
	
	

	
}
