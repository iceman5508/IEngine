package Utils.wooPack;

import java.util.*;

/**
 * 
 * @author Isaac Parker
 * @version 3-3-2015
 *@purpose To print message to console easily
 */
public class Echo {

	public static void echo(String s) 
	{
		System.out.println(s);
	}
	
	public static void echo(int i) 
	{
		System.out.println(i);
	}
	
	public static void echo(double d) 
	{
		System.out.println(d);
	}
	
	public static void echo(boolean b) 
	{
		if(b==true)
		{
			Echo.echo("true");
		}
		else Echo.echo("False");
	}

	public static void echo(ArrayList<String> b) 
	{
		Iterator<String> foreach = b.iterator();
		while (foreach.hasNext())
		{
			System.out.println(foreach.next());
		}
	}

	public static void echo(String[] wordsFromString) {
		// TODO Auto-generated method stub
		for(int i=0; i<wordsFromString.length; i++)
		{
			System.out.print(wordsFromString[i]+" ");
		}
	}
	
}
