/**
 * IEngine 4.0
 * 10-29-2016
 * Isaac Parker
 * Timer class 
 * */
package Utils.timer;

public class Timer {

	private long timer,endTime;
	private double secondsEndTime;
	private boolean timeUp;
	public Timer()
	{
		
	}
	
	/**
	 * Constructor with milliseconds time limit
	 * @param millsecondLimit
	 */
	public Timer(long millsecondLimit)
	{
		this.endTime = millsecondLimit;
	}
	
	/**
	 * constructor with seconds time limit
	 * @param secondsEndTime
	 */
	public Timer(double secondsEndTime )
	{
		this.secondsEndTime = secondsEndTime;
	}
	
	/**
	 * start the clock
	 */
	public void startTimer()
	{
		timer = System.nanoTime();
	}
	
	/**
	 * update the timer to see if time limit has been reached
	 */
	public void update()
	{
		if(secondsEndTime>0)
		{
			double passedTime = (double)(System.nanoTime()-timer)/1000000000;
			if(passedTime >= secondsEndTime)
			{
				
				timeUp= true;
			}else
			{
				timeUp= false;
			}
		}else if(endTime>0)
		{
			long passedTime = (System.nanoTime()-timer)/1000000;
			if(passedTime >= endTime)
			{
			
				timeUp= true;
			}else
			{
				timeUp= false;
			}
		}else
		{
			timeUp= false;
		}
	}
	
	
	/**
	 * get the time that has passed in milli seconds
	 * @return
	 */
	public long getTimeMilli()
	{
		return (System.nanoTime()-timer)/1000000;
	}
	
	/**
	 * get time that has passed in seconds
	 * @return
	 */
	public double getTimeSeconds()
	{
		return (double)(System.nanoTime()-timer)/1000000000;
	}
	
	
	/**
	 * Check if time limit has been reached
	 * @return
	 */
	public boolean isTimeUp()
	{
		return this.timeUp;
	}
	
	
	public double getEndTimeSec()
	{
		return this.secondsEndTime;
	}
	
	public long getEndTimeMills()
	{
		return this.endTime;
	}
}
