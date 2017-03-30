package Utils.Math.operations;

import java.util.Random;

public class Numbers {
	
	public static int randIntInclue(int min, int max) 
	{

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    
	    int randomNum = rand.nextInt((max - min)) + min;

	    return randomNum;
	}

}
