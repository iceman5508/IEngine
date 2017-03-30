 /** IEngine 4.0
 * 10-29-2016
 * Isaac Parker
 * Key logger class, made to track keyboard input and log it
 */

package core.Input.keys;

import Utils.Lists.iList;
import core.Engine.Screen;

public class KeyLogger {
	
	private iList<String> logger;
	private int max=0;
	private boolean shifted=false;
	private int cap=0;

	
	/**
	 * Init keylogger
	 */
	public KeyLogger() {
		// TODO Auto-generated constructor stub
		logger=new iList<>();
		
	}
  
	/**
	 * Init keylogger with max number of characters
	 * @param max the limit of characters to log
	 */
	public KeyLogger(int max)
	{
		logger=new iList<>();
		this.max=max;
	}
	
	
	/**
	 * Start the log process
	 * @param sc the current screen to log data from
	 */
	public void Log(Screen sc)
	{
		
		
		if(Keys.keyBoard.count>0 && sc.getKeysInput().lastKeyPressed()!=-1)
		{
			if(max==0 && sc.getKeysInput().getPressed()==false)
			{
			
				for(int i=0; i<Keys.keyBoard.count; i++)
				{
					if(sc.getKeysInput().lastKeyPressed()==Integer.parseInt(Keys.keyBoard.getNode(i).Data2))
					{
					
						logger.addItem(Keys.keyBoard.getNode(i).Data1);					
						sc.getKeysInput().resetLastKey();
					
					}
				}
			}else if(max>0 && sc.getKeysInput().getPressed()==false)
			{
				if(max>logger.getCount())
				{
					for(int i=0; i<Keys.keyBoard.count; i++)
					{
						if(sc.getKeysInput().lastKeyPressed()==Integer.parseInt(Keys.keyBoard.getNode(i).Data2))
						{
						
							logger.addItem(Keys.keyBoard.getNode(i).Data1);					
							sc.getKeysInput().resetLastKey();
						
						}
					}
				}
			}
		}
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String toData="";
		for(int i=0; i<logger.getCount(); i++)
		{
			toData+=logger.getAtIndex(i).Data;
		}
		return toData;
	}
	
	
	/**
	 * Empty the logger
	 * @return
	 */
	public boolean resetLogger()
	{
		while(logger.getCount()>0)
		{
			logger.removeLast();
		}
		
		if(logger.getCount()==0)
		{
			return true;
		}else
		{
			resetLogger();
		}
		return false;
	}
	
	/**
	 * Convert the log data to a 1d array
	 * @return Array of logged data
	 */
	public String[] arrayLoggedData()
	{
		String[] returnArray = new String[logger.getCount()];
		for(int i=0; i<logger.getCount(); i++)
		{
			returnArray[i]=logger.getAtIndex(i).Data;
			
		}
		return returnArray;
	}
	
	
	/**
	 * return the logged data
	 * @return ilist of logged data
	 */
	public iList<String> iListLoggedData()
	{
		return logger;
	}
	
	
	
	
	/**
	 * Perform a basic keyboard loggin operation
	 * @param sc the screen to keep track of
	 * @return a string of the logged data
	 */
	public String basicKeyboardLog(Screen sc)
	{
		
			Log(sc);
			iList<String> Data = iListLoggedData();
			if(Data.getCount()>0&&Data.getLast().Data.equals("BACKSPACE"))
			{
				
				Data.removeLast();
				if(Data.getCount()>0)
				{
					Data.removeLast();
				}
			}
			
			if(Data.getCount()>0&&Data.getLast().Data.equals("SPACE"))
			{
				
				Data.removeLast();
				Data.addItem(" ");
			}
			if(shifted==true)
			{  
				if(Data.getCount()>0)
				{
					String last = Data.getLast().Data;
					Data.removeLast();
					Data.addItem(last.toUpperCase());
					shifted=false;
				}
			}
			if(Data.getCount()>0&&Data.getLast().Data.equals("SHIFT"))
			{
				if(Data.getCount()>0)
				{
					shifted=true;
					Data.removeLast();
				}
				
			}
			if(cap==1)
			{  
				if(Data.getCount()>0)
				{
					String last = Data.getLast().Data;
					Data.removeLast();
					Data.addItem(last.toUpperCase());
					
				}
			}
			if(Data.getCount()>0&&Data.getLast().Data.equals("CAP"))
			{
				if(Data.getCount()>0)
				{
					cap++;
					Data.removeLast();
					if(cap>1)
					{
						cap=0;
					}else if(cap<1)
					{
						cap=0;
					}
				}
				
			}
			
			if(Data.getCount()>0&&Data.getLast().Data.equals("ENTER"))
			{
				if(Data.getCount()>0)
				{
					
					Data.removeLast();
					
				}
				
			}
		return toString();
		
	}
	
	
	
}
