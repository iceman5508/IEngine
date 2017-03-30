package Utils.wooPack;
/**
 * @author Isaac Parker
 * @version 3-3-2015
 * @purpose An improved version of the scanner class allowing <br>
 *input stream to only take input characters upon hitting the enter key<br>
 *rather than the traditional route of input stream taking in all characters<br>
 *as they are typed.
 *
 */
import java.io.*;


public class BufferScanner {

	
	private BufferedReader input; 
	private String streamData;
	
	/**
	 * @method BufferScanner()
	 * @purpose To create a stream input for taking in keyboard characters.
	 * @throws IOException
	 */
	public BufferScanner() 
	{
		try 
		{ 
			this.input = new BufferedReader(new InputStreamReader(System.in));
			streamData = input.readLine();
		}
		catch ( IOException e) 
		{ e.printStackTrace(); } 
		
		
	}
	
	
	public BufferScanner(String filename)
	{
		try 
		{ 
			FileInputStream in = new FileInputStream(filename);
			this.input = new BufferedReader(new InputStreamReader(in));
			
		}
		catch ( IOException e) 
		{ e.printStackTrace(); } 
	}
	
	/**
	 * @purpose To return the final stream data after the closing key is hit. 
	 * @method getStreamData()
	 * @return the streamData
	 */
	public String getStreamData() 
	{
		return streamData;
	}
	
	/**
	 * @purpose To return a converted stream data of int if ints are found. 
	 * @method toInt
	 * @return parsed int of stream. 
	 */
	public int toInt() 
	{
		if(Logic.isDouble(streamData))
		{
			return Integer.parseInt(streamData);
		}else return 0;
	}
	/**
	 * @purpose To return a converted stream data of double if doubles are found. 
	 * @method toDouble()
	 * @return parsed double of stream
	 */
	public double toDouble() 
	{
		if(Logic.isDouble(streamData))
		{
			return Double.parseDouble(streamData);
		}else return 0.00;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{	
		return getStreamData();
	}
	
	
	
	

}
