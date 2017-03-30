/**
 * IEngine 4.0
 * 10-29-2016
 * Isaac Parker
 * Mapbuilder class
 * This class acts as a parent class for both map types user is able to design.
 */
package core.Abstract;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Utils.Lists.iList;
import Utils.Math.operations.Numbers;
import core.Engine.Screen;



public abstract class mapBuilder {
	
	protected double x,y;
	
	
	protected int blockHeight, blockWidth;
	protected int numRows;
	protected int numCols;
	protected int width, height;
	protected int screenWidth=Screen.Engine.getWidth(),screenHeight=Screen.Engine.getHeight();
	protected iList<Integer> solids;
	protected iList<Integer> noSolids;
	
	protected double xmin,ymin,xmax,ymax;
	
	protected int numberOfBlocks=0;
	protected int blocksRendering=0;
	
	protected boolean rotated=false;

	
	// drawing
		protected int rowOffset;
		protected int colOffset;
		protected int numRowsToDraw;
		protected int numColsToDraw;
		
		
		protected double scroll=0.3;
	
		
		/**
		 * initiate rendering properties of the map
		 */
		 public void initRenderFeatures()
		 {
			 
			 numRowsToDraw = Screen.Engine.getHeight() / blockHeight + 2;
			numColsToDraw = Screen.Engine.getWidth() / blockWidth + 2;
		 }
		 
		 /**
		  * Update the rendering properties of the map
		  */
		 public void updateRenderFeatures()
		 {
			 
			 colOffset = (int)-this.x / blockWidth;
			 rowOffset = (int)-this.y / blockHeight;
			
		 }
		 
		 /**
		  * Get the x position of the map
		  * @return
		  */
		 public double getX() {
			return x;
		}
		 
		 /**
		  * Set the x position of the map
		  * @param x
		  */
		public void setX(double x) {
			this.x = x;
		}

		/**
		 * get the y position of the map
		 * @return
		 */
		public double getY() {
			return y;
		}

		/**
		 * set the y position of the map
		 * @param y
		 */
		public void setY(double y) {
			this.y = y;
		}

		
		/**
		 * Check if the map is rotated from its original position.
		 * @return
		 */
		public boolean isRotated() {
			return rotated;
		}

		/**
		 * Set rotation to true or false
		 * @param rotated
		 */
		public void setRotated(boolean rotated) {
			this.rotated = rotated;
		}

		/**
		 * Get the width of the map
		 * @return
		 */
		public int getWidth() {
			return width;
		}

		
		/**
		 * Get the height of the map
		 * @return
		 */
		public int getHeight() {
			return height;
		}

		
		/**
		 * Get the number of blocks the map has
		 * @return
		 */
		public int getNumberOfBlocks() {
			return numberOfBlocks;
		}

		/**
		 * Return the number of blocks currently being rendered
		 * @return
		 */
		public int getBlocksRendering() {
			return blocksRendering;
		}

		/**
		 * Set the value that the map will scroll by
		 * @param x
		 */
		public void setScroll(double x)
		 {
			 this.scroll=x;
		 }
		 
		/**
		 * Get the scroll value of the map
		 * @return
		 */
		public double getScroll() {
			return scroll;
		}
		
		
		/**
		 * Set the map bounds within the view of the screen
		 */
		public void setBounds()
		{
			xmin = Screen.Engine.getWidth() - width;
			xmax = 0;
			ymin =Screen.Engine.getHeight() - height;
			ymax = 0;
		}
		
		/**
		 * Check the bound of the map
		 */
		public void checkBounds() {
			if(x < xmin) x = xmin;
			if(y < ymin) y = ymin;
			if(x > xmax) x = xmax;
			if(y > ymax) y = ymax;
		}
		
		
		public abstract void renderWithValue(Graphics2D g2d);
		
		public abstract void renderWithId(Graphics2D g2d);
		
		public abstract void setSprite(String value, BufferedImage sprite);
		
		public abstract void setSprite(float r,float g, float b, BufferedImage sprite,boolean hex);
		
		public abstract void setSprite(Color c, BufferedImage sprite,boolean hex);
		
		public abstract void setXY(double x, double y);
		
		public void setBounds(double xmin, double ymin, double xmax, double ymax)
		{
			this.xmin=xmin;
			this.xmax=xmax;
			this.ymin=ymin;
			this.ymax=ymax;
		}
		
		public int getNumRows() {
			return numRows;
		}
		
		public int getNumCols() {
			return numCols;
		}
		
		public double getMinX() {
			return xmin;
		}
		
		public double getMaxX() {
			return xmax;
		}
		
		public double getMaxY() {
			return ymax;
		}
		
		public double getMinY() {
			return ymin;
		}
		
		public iList<Integer> getSolids() {
			return solids;
		}
		
		public iList<Integer> getNoSolids() {
			return noSolids;
		}
		
		public int randomSolidId()
		{
			int index =Numbers.randIntInclue(0, solids.getCount()-1);
			return solids.getAtIndex(index).Data;
		}
		
		public int randomNoSolidId()
		{
			int index =Numbers.randIntInclue(0, noSolids.getCount()-1);
			return noSolids.getAtIndex(index).Data;
		}
}
