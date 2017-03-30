package Utils.Menu;

import java.awt.Graphics2D;

import Utils.Buttons.IEngineButton;
import Utils.Lists.iList;
import core.Engine.Screen;



public class Menu {
	
	private iList<IEngineButton> buttons;
	private iList<Screen> screens;
	public boolean selection =false;
	private int index=-1;
	public Menu() {
		// TODO Auto-generated constructor stub
		buttons = new iList<IEngineButton>();
		screens = new iList<Screen>();
	}
	
	public void addButton(IEngineButton button, Screen screen)
	{
		buttons.addItem(button);
		screens.addItem(screen);
	}
	
	public void displayButton(Graphics2D g2d)
	{
		for(int i=0; i<buttons.getCount(); i++)
		{
			buttons.getAtIndex(i).Data.drawButton(g2d);
		}
	}
	
	public void buttonClicked()
	{
		for(int i=0; i<buttons.getCount(); i++)
		{
			if(buttons.getAtIndex(i).Data.ButtonClicked())
			{
				selection = true;
				index=i;
				break;
			}else
			{
				selection=false;
			}
		}
		
		if(selection)
		{
			Screen.Engine.getMouse().setClicked(false);
			Screen sc = screens.getAtIndex(index).Data;
			Screen.Engine.setActiveScreen(sc);
			
		}
	}
	
	public int numButtons()
	{
		return this.buttons.getCount();
	}
	
	public IEngineButton getButton(int index)
	{
		return buttons.getAtIndex(index).Data;
	}

}
