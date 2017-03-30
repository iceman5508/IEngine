package core.Abstract;
/**
 * @author Isaac Parker
 * @version 1
 * The Entity class is an abstract super class for all objects within the program.<br>
 * Objects such as tiles and GameObjects inherits from this class 
 */
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Utils.Math.vector.Vector;
import core.Engine.Screen;

public abstract class  Entity {

	protected int height,width,id;
	protected double x,y,dx,dy;
	protected mapBuilder map;
	protected Vector positionVector;
	
	/**
	 * Empty constructor. This constructor simply sets the position vector of the object
	 */
	public Entity() {
		// TODO Auto-generated constructor stub
		positionVector = new Vector(2);
		positionVector.fillVector(x,y);
	}
	
	
	/**
	 * This constructor sets the x,y,height,width,dx,dy and id of the object
	 * @param x2 the x value
	 * @param y2 the y value
	 * @param Height the height value
	 * @param Width the width value
	 * @param dx the change in x value
	 * @param dy the change in y value
	 * @param Id the id of the object
	 */
	public Entity(double x2, double y2, int Height, int Width, int dx,
			int dy, int Id) {
		this.x=x2;
		this.y=y2;
		this.height=Height;
		this.width=Width;
		this.dx=dx;
		this.dy=dy;
		this.id=Id;
		positionVector = new Vector(2);
		positionVector.fillVector(x,y);
		
	}
	
	/**
	 * Constructor that sets the map to the object
	 * @param map
	 */
	public Entity(mapBuilder map) {
		// TODO Auto-generated constructor stub
		this.map = map;
		positionVector = new Vector(2);
		positionVector.fillVector(x,y);
	}
	
	
	/**
	 * Update method for the object
	 */
	public abstract void update();
	
	
	/**
	 * Render method for object so that it can be drawn on screen
	 * @param g2d The graphic2d object to use, that will display the object
	 */
	public abstract void render(Graphics2D g2d);
	
	
	/**
	 * Return the x value of the object
	 * @return x
	 */
	public double getX() {
		
		return x;
		
	}

	/**
	 * Set the x value of the object
	 * @param d the x value to set
	 */
	public void setX(double d) {
		this.x = d;
		positionVector = new Vector(2);
		positionVector.fillVector(x,y);
	}


	/**
	 * Return the y value of 
	 * @return the y value
	 */
	public double getY() {
		return y;
		
	}

	/**
	 * Set the y value for object
	 * @param d
	 */
	public void setY(double d) {
		this.y = d;
		positionVector = new Vector(2);
		positionVector.fillVector(x,y);
	}

/**
 * Return the height of the object
 * @return
 */
	public int getHeight() {
		return height;
	}


	/**
	 * Set the height of the object
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}


	/**
	 * get the width of the object
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Set the width of the object
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}


	/**
	 * Get the change in y of the object
	 * @return
	 */
	public double getDy() {
		return dy;
	}


	/**
	 * Set the change in y of the object
	 * @param jumpHeight
	 */
	public void setDy(double jumpHeight) {
		this.dy = jumpHeight;
	}

	/**
	 * get the change in y of the object
	 * @return
	 */
	public double getDx() {
		return dx;
	}

	
	/**
	 * Set the change in y of the object
	 * @param dx
	 */
	public void setDx(double dx) {
		this.dx = dx;
	}

	/**
	 * Return basic rectangle bound of the object
	 * @return
	 */
	public Rectangle getBasicRectangle() {
		return new Rectangle(
				(int)x,
				(int)y,
				width,
				height
		);
	}
	
	

	/**
	 * Get the id of the object
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	
	/**
	 * Draw the object on the screen relative to the position of the map object
	 * <br>This method requires an instance of the entity with a map object given to it.
	 * @return the x position relative to the map
	 */
	public int drawOnMapX()
	{
		return (int)(map.getX()+this.x-width/2);
		//return (int)(x+this.x);
	}
	
	/**
	 * Draw the object on the screen relative to the position of the map object
	 * @param y the map y or any y offset
	 * @return the y position relative to the map
	 */
	public int drawOnMapY(double y)
	{
		return (int)(y+this.y);
		//return (int)(y+this.y);
	}
	
	/**
	 * Draw the object on the screen relative to the position of the map object
	 * @param x the map x or any x offset
	 * @return the x position relative to the map
	 */
	public int drawOnMapX(double x)
	{
		return (int)(x+this.x);
		//return (int)(x+this.x);
	}
	
	/**
	 * Draw the object on the screen relative to the position of the map object
	 * <br>This method requires an instance of the entity with a map object given to it.
	 * @return the y position relative to the map.
	 */
	public int drawOnMapY()
	{
		return (int)(map.getY()+this.y-height/2);
		//return (int)(y+this.y);
	}
	
	
	/**
	 * Check if object position is within the current bounds of the screen<br>
	 * This method assumes that the object this method is being ran on has a<br>
	 * mapBuilder object attached to it.
	 * @param map The object's mapBuilder object
	 * @return true if within bounds or false if out of the bounds
	 */
	public boolean seenOnMap(mapBuilder map) {
		boolean seen =  x + map.getX() + width < 0 ||
			x + map.getX() - width > Screen.Engine.getWidth() ||
			y + map.getY() + height < 0 ||
			y + map.getY() - height > Screen.Engine.getHeight();
			
			return !seen;
	}
	
	
	/**
	 * Return the position vector of the object
	 * @return
	 */
	public Vector getPositionVector() {
		return positionVector;
	}
}
