 /** IEngine 4.0
 * 10-29-2016
 * Isaac Parker
 * IEngine Keys class. 
 * This class as the name suggests is to be used as a key listener
 * for keyboard input. 
 */


package core.Input.keys;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Utils.Lists.iNodeList;



public class Keys implements KeyListener {
	
	protected boolean keys[] = new boolean[256];
	private int lastKey;
	public static iNodeList<String> keyBoard;
	private boolean keysSet=false;
	private boolean pressed = false;
	
	public Keys()
	{
		if(keyBoard==null)
		{
			keyBoard=new iNodeList<>();
		}
	}
	
	private void setConstants(KeyEvent e)
	{
	
		/*************American alphabet*********/
		keyBoard.add("a", ""+KeyEvent.VK_A);
		keyBoard.add("b", ""+KeyEvent.VK_B);
		keyBoard.add("c", ""+KeyEvent.VK_C);
		keyBoard.add("d", ""+KeyEvent.VK_D);
		keyBoard.add("e", ""+KeyEvent.VK_E);
		keyBoard.add("f", ""+KeyEvent.VK_F);
		keyBoard.add("g", ""+KeyEvent.VK_G);
		keyBoard.add("h", ""+KeyEvent.VK_H);
		keyBoard.add("i", ""+KeyEvent.VK_I);
		keyBoard.add("j", ""+KeyEvent.VK_J);
		keyBoard.add("k", ""+KeyEvent.VK_K);
		keyBoard.add("l", ""+KeyEvent.VK_L);
		keyBoard.add("m", ""+KeyEvent.VK_M);
		keyBoard.add("n", ""+KeyEvent.VK_N);
		keyBoard.add("o", ""+KeyEvent.VK_O);
		keyBoard.add("p", ""+KeyEvent.VK_P);
		keyBoard.add("q", ""+KeyEvent.VK_Q);
		keyBoard.add("r", ""+KeyEvent.VK_R);
		keyBoard.add("s", ""+KeyEvent.VK_S);
		keyBoard.add("t", ""+KeyEvent.VK_T);
		keyBoard.add("u", ""+KeyEvent.VK_U);
		keyBoard.add("v", ""+KeyEvent.VK_V);
		keyBoard.add("w", ""+KeyEvent.VK_W);
		keyBoard.add("x", ""+KeyEvent.VK_X);
		keyBoard.add("y", ""+KeyEvent.VK_Y);
		keyBoard.add("z", ""+KeyEvent.VK_Z);
		/*************American Alphabet***************/
		
		/***************numbers**********************/
		keyBoard.add("0", ""+KeyEvent.VK_0);
		keyBoard.add("1", ""+KeyEvent.VK_1);
		keyBoard.add("2", ""+KeyEvent.VK_2);
		keyBoard.add("3", ""+KeyEvent.VK_3);
		keyBoard.add("4", ""+KeyEvent.VK_4);
		keyBoard.add("5", ""+KeyEvent.VK_5);
		keyBoard.add("6", ""+KeyEvent.VK_6);
		keyBoard.add("7", ""+KeyEvent.VK_7);	
		keyBoard.add("8", ""+KeyEvent.VK_8);
		keyBoard.add("9", ""+KeyEvent.VK_9);
		/****************numbers***************************/
		 
		/***********Punctuation***************************/
		keyBoard.add(".", ""+KeyEvent.VK_PERIOD);
		keyBoard.add(",", ""+KeyEvent.VK_COMMA);
		keyBoard.add(":", ""+KeyEvent.VK_COLON);
		keyBoard.add(";", ""+KeyEvent.VK_SEMICOLON);
		keyBoard.add("\"", ""+KeyEvent.VK_QUOTE);
		keyBoard.add("!", ""+KeyEvent.VK_EXCLAMATION_MARK);
		/**************Punctuation********************************/
		
		/***************function keys****************************/
		keyBoard.add("SPACE", ""+KeyEvent.VK_SPACE);
		keyBoard.add("BACKSPACE", ""+KeyEvent.VK_BACK_SPACE);
		keyBoard.add("ENTER", ""+KeyEvent.VK_ENTER);
		keyBoard.add("SHIFT", ""+KeyEvent.VK_SHIFT);
		keyBoard.add("CTRL", ""+KeyEvent.VK_CONTROL);
		keyBoard.add("ALT", ""+KeyEvent.VK_ALT);
		keyBoard.add("DELETE", ""+KeyEvent.VK_DELETE);
		keyBoard.add("CAP", ""+KeyEvent.VK_CAPS_LOCK);
		/*****************function keys************************/
		
		/***************Math*********************************/
		keyBoard.add("+", ""+KeyEvent.VK_PLUS);
		keyBoard.add("-", ""+KeyEvent.VK_MINUS);
		keyBoard.add("%", ""+KeyEvent.VK_AMPERSAND);
		keyBoard.add("@", ""+KeyEvent.VK_AT);
		keyBoard.add("#", ""+KeyEvent.VK_NUMBER_SIGN);
		keyBoard.add("$", ""+KeyEvent.VK_DOLLAR);
		keyBoard.add("*", ""+KeyEvent.VK_MULTIPLY);
		keyBoard.add("=", ""+KeyEvent.VK_EQUALS);
		keyBoard.add("/", ""+KeyEvent.VK_DIVIDE);
		keyBoard.add("(", ""+KeyEvent.VK_LEFT_PARENTHESIS);
		keyBoard.add(")", ""+KeyEvent.VK_RIGHT_PARENTHESIS);
		keyBoard.add("{", ""+KeyEvent.VK_BRACELEFT);
		keyBoard.add("}", ""+KeyEvent.VK_BRACERIGHT);
		keyBoard.add("[", ""+KeyEvent.VK_OPEN_BRACKET);
		keyBoard.add("]", ""+KeyEvent.VK_CLOSE_BRACKET);
		keyBoard.add("|", ""+KeyEvent.VK_SEPARATOR);
		keyBoard.add("<", ""+KeyEvent.VK_LESS);
		keyBoard.add(">", ""+KeyEvent.VK_GREATER);
				
		/****************Math*********************************/
		
		
		
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		try
		{
			if(!keysSet)
			{
				setConstants(e);
				keysSet=true;
			}
			keys[e.getKeyCode()] = true;
			this.pressed=true;
			this.lastKey=e.getKeyCode();
		}catch(ArrayIndexOutOfBoundsException ec)
		{
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		try
		{
			if(!keysSet)
			{
				setConstants(e);
				keysSet=true;
			}
			keys[e.getKeyCode()] = false;
			this.pressed=false;
			this.lastKey=e.getKeyCode();
		}catch(ArrayIndexOutOfBoundsException ec)
		{
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Check if a specific key is pressed
	 * @param key - keycode to check
	 * @return true if presed, false if not
	 */
	public boolean isKeyPressed(int key)
	{
		
		return keys[key];
	}
	
	/**
	 * Check if a specific key was released
	 * @param key the keycode to check
	 * @return true if released, false if not
	 */
	public boolean isKeyReleased(int key)
	{
		return !keys[key];
	}

	/**
	 * Get the keycode for the last key used
	 * @return keyCode
	 */
	public int lastKeyPressed()
	{
		return this.lastKey;
	}
	
	
	public void resetLastKey()
	{
		lastKey=-1;
	}
	
	/**
	 * Check if a key is currently being pressed down
	 * @return true if pressed, false if not
	 */
	public boolean getPressed()
	{
		return pressed;
	}
}
