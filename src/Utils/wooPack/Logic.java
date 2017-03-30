package Utils.wooPack;



/**
 * @author Isaac Parker
 * @version 3/2/2015
 *@category The Simple form logical checker for the program
 */
public class Logic {

	/**
	 * 
	 */
	public Logic() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @method ModusPonens: Acts like as the logical function<br>
	 * ModusPonens to check the validity of a data being passed in.
	 * @param p
	 * @param q
	* @return value of q 
	 * @see ModusTollens
	 */
	public boolean ModusPonens(boolean p, boolean q)
	{
		/**
		 * Logical rule for mp goes as follow
		 * if p then q
		 * p
		 *therefore q
		 */
		boolean qTest=true;
		if(p&qTest)
		{
			if(p&qTest==q)
			{
			  return q;
			}else return ModusTollens(p,q);
		}
		else
			return ModusTollens(p,q);		
	}
	
	/**
	 * @method ModusTollens: Acts like as the logical function<br>
	 * ModusTollens to check the validity of a data being passed in.
	 * @param p
	 * @param q
	 * @return value of p 
	 * @see ModusPonens
	 */
	public boolean ModusTollens(boolean p, boolean q)
	{
		/**
		 * Logical rule for mt goes as follow
		 * if p then q
		 * if not q
		 *therefore not p
		 */
		boolean qTest=true;
		if(p==false && q==true)
		{
			p=true;
			q=false;
		}
		if(p&qTest)
		{
			if(q!=qTest)
			{
				p=q;
				return p;
			}else return ModusPonens(p, q);	
		}
		else
			return ModusPonens(p, q);		
	}
	
	/**
	 * @method isDouble
	 * @purpose to check if a double can be found in the string<br>
	 * can also be used to check if an int could be found
	 * @param value
	 * @return true or false
	 */
	public static boolean isDouble(String value) {
	    try {
	        Double.parseDouble(value);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	

}
