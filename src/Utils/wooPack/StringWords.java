package Utils.wooPack;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;



public class StringWords
{
	
	public static String[] toWords(String str)
	{
		str = str.replaceAll("\n", " ");
		String[] strgs = str.split(" ");
		return strgs;
	}
	
	public static int wordCount(String str)
	{
		String[] strgs = str.split(" ");
		return strgs.length;
	}
	
	public static Graphics setFontSize(Graphics g, float size)
	{
		Font currentFont = g.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
		g.setFont(newFont);
		return g;
	}
	
	public static Graphics2D setFontSize(Graphics2D g2d, float size)
	{
		Font currentFont = g2d.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * size);
		g2d.setFont(newFont);
		return g2d;
	}
	
	public static int count(String[] words,  String word)
	{
		int count=0;
		for(int i=0; i<words.length; i++)
		{
			if(words[i].equals(word))
			{
				count++;
			}
		}
		return count;
	}
	
	public static int countCaseIgnore(String[] words,  String word)
	{
		int count=0;
		for(int i=0; i<words.length; i++)
		{
			if(words[i].equalsIgnoreCase(word))
			{
				count++;
			}
		}
		return count;
	}
	
	/*********************comparision**********************/
	public static boolean deepEquals(String s1,String s2)
	{
		if(s1.equalsIgnoreCase(s2))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	/****************split*************************/
	public static String[] partition(String[] map,int start, int end)
    {
    	int size;
    	if(start<end)
    	{
    		
    		if(start==0)
    		{
    			size = (end-start)+1;
    		}else
    		{
    			size = (end-start);
    		}
    	}else
    	{
    		size=end;
    		end=start;
    		start=end;
    		if(start==0)
    		{
    			size = (end-start)+1;
    		}else
    		{
    			size = (end-start);
    		}
    	}
    	String[] re = new String[size];
    	for(int i=0; start<end; i++,start++)
    	{
    		re[i] = map[start];
    	}
    	return re;
    }
	
	/**********************************/
	public static boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	

}
