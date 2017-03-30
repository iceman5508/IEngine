package Utils.wooPack;
 
/**
 *@author Isaac Parker
 *@version 3-3-2015
 *@purpose To convert statements into boolean values based on specific<br>requirements.
 */
public class ToBool {

	
	
	public static Boolean ToBoolGreater(double value, boolean greaterOrLess, double checker) 
	{
		if(greaterOrLess==true)
		{
			if(value>checker)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			if(value<checker)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}

}
