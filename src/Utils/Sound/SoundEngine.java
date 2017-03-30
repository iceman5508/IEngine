package Utils.Sound;


import java.util.HashMap;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/** IEngine 4.0
* 10-29-2016
* Isaac Parker 
 *The SoundEngine class can be used instead of the Audio player class.<br>
 *This class also manages sound file, however, it uses hashmaps to reduce<br>
 *the work load on the ram.
 *<br>
 *
 */
public class SoundEngine {
	
	private static HashMap<String, Clip> clips;
	private static int gap;
	private static boolean mute = false;
	private static String current;
	
	/**
	 * There is no need to call this method as it is automatically called when the engine is started. 
	 */
	public static void init() {
		clips = new HashMap<String, Clip>();
		gap = 0;
	}
	
	/**
	 * 
	 * @param s the location of the sound file 
	 * @param n the name it will be known as in the hashmap
	 */
	public static void load(String s, String n) {
		if(clips.get(n) != null) return;
		Clip clip;
		try {			
			AudioInputStream ais =
				AudioSystem.getAudioInputStream(
					SoundEngine.class.getResourceAsStream("/"+s)
				);
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(
				AudioFormat.Encoding.PCM_SIGNED,
				baseFormat.getSampleRate(),
				16,
				baseFormat.getChannels(),
				baseFormat.getChannels() * 2,
				baseFormat.getSampleRate(),
				false
			);
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
			clips.put(n, clip);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Play the given music file
	 * @param s the name of the file as it is in the hashmap
	 */
	public static void play(String s) {
		play(s, gap);
		
	}
	
	/**
	 * Play the given hashmap file
	 * @param s the hashmap name of the audio file
	 * @param i the given position in the audio file to start 
	 */
	public static void play(String s, int i) {
		if(current==null)
		{
			current=s;
		}
		if(mute) return;
		Clip c = clips.get(s);
		if(c == null) return;
		if(c.isRunning()) c.stop();
		c.setFramePosition(i);
		while(!c.isRunning()) c.start();
	}
	
	/**
	 * Stop playing the given sound file
	 * @param s the hashmap file name
	 */
	public static void stop(String s) {
		if(clips.get(s) == null) return;
		if(clips.get(s).isRunning()) clips.get(s).stop();
	}
	
	public static void stopAndRemove(String s) {
		if(clips.get(s) == null) return;
		if(clips.get(s).isRunning()) clips.get(s).stop();
		clips.remove(s);
	}
	
	
	/**
	 * Resume the playing of a sound file
	 * @param s the haspmap file name
	 */
	public static void resume(String s) {
		if(mute) return;
		if(clips.get(s).isRunning()) return;
		clips.get(s).start();
	}
	
	/**
	 * Loop through the given hashmap file name
	 * @param s the haspmap file name
	 */
	public static void loop(String s) {
		loop(s, gap, gap, clips.get(s).getFrameLength() - 1);
	}
	
	/**
	 * loop the give sound file 
	 * @param s the haspmap file name
	 * @param frame starting point of the loop
	 */
	public static void loop(String s, int frame) {
		loop(s, frame, gap, clips.get(s).getFrameLength() - 1);
	}
	
	/**
	 * loop through the given sound file
	 * @param s the haspmap file name
	 * @param start starting point
	 * @param end end point
	 */
	public static void loop(String s, int start, int end) {
		loop(s, gap, start, end);
	}
	
	/**
	 * Loop through the given sound file 
	 * @param s the haspmap file name
	 * @param frame set the frame to loop through between the start and end point
	 * @param start the starting point of the loop
	 * @param end the ending point of the loop
	 */
	public static void loop(String s, int frame, int start, int end) {
		if(current==null)
		{
			current=s;
		}
		stop(s);
		if(mute) return;
		clips.get(s).setLoopPoints(start, end);
		clips.get(s).setFramePosition(frame);
		clips.get(s).loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	/**
	 * Set the position of the sound file
	 * @param s the haspmap file name
	 * @param frame the position
	 */
	public static void setPosition(String s, int frame) {
		clips.get(s).setFramePosition(frame);
	}
	
	/**
	 * get the frame of the music file
	 * @param s the haspmap file name
	 * @return
	 */
	public static int getFrames(String s) { return clips.get(s).getFrameLength(); }
	
	/**
	 * Get current position of the sound file
	 * @param s the haspmap file name
	 * @return
	 */
	public static int getPosition(String s) { return clips.get(s).getFramePosition(); }
	
	/**
	 * Close a given sound file 
	 * @param s the haspmap file name
	 */
	public static void close(String s) {
		stop(s);
		clips.get(s).close();
		
	}
	
	public static void closeAndRemove(String s) {
		stop(s);
		clips.get(s).close();
		clips.remove(s);
		
	}
	
	public static void stop()
	{
		stop(current);
	}
	
	public static void close()
	{
		close(current);
	}
	
	public static void stopAndRemove()
	{
		stop(current);
		clips.remove(current);
	}
	
	public static void closeAndRemove()
	{
		close(current);
		clips.remove(current);
	}
	
	
	
}