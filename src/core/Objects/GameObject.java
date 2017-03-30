package core.Objects;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Utils.Images.Animation;
import Utils.Lists.iArrayList;
import Utils.Lists.iList;
import Utils.Math.vector.Vector;
import core.Abstract.Entity;
import core.Maps.tileMap;
import core.Physics.Gravity.gravity;
import core.Physics.collision.collision;
import core.Physics.movement.movement;



public abstract class GameObject extends Entity {
	private static iArrayList<GameObject> allObjects;
	private int objectId;
	protected Animation animation;
	protected tileMap tmap;
	protected int collisionWidth,collisionHeight;
	protected boolean removed = false;
	private boolean topLeft;
	private boolean topRight;
	private boolean bottomLeft;
	private boolean bottomRight;
	protected boolean left;
	protected boolean right;
	protected boolean jumping;	
	protected boolean falling;
	protected gravity g=new gravity();
	protected boolean up,down;
	protected movement m;
	protected collision c;
	private boolean lockMovement=false;
	private iList<Double> mapPath;
	private int action=1;
	private int pathIndex=0;
	private boolean pathReverse=false;
	
	
	
	
	
	
	
	
	public void setCollisionParams(int height, int width)
	{
		this.collisionHeight=height;
		this.collisionWidth = width;
	}
	public boolean intersects(GameObject o) {
		
		if(o.rightBound().intersects(leftBound()))
		{
			return true;
			
		}else
			if(o.leftBound().intersects(rightBound()))
			{
				return true;
				
			}
			else
				if(o.topBound().intersects(bottomBound()))
				{
					return true;
					
				}
				else
					if(o.bottomBound().intersects(topBound()))
					{
						return true;
						
					}
		return false;
		
	}
	
	
	

	
	public GameObject() {
		// TODO Auto-generated constructor stub
		super();
		if(allObjects==null)
		{
			allObjects=new iArrayList<>();
		}
		if(allObjects.count==0)
		{
			this.objectId = 0;
		}else
			{
			
				this.objectId = (int) (allObjects.last.Data1+1);
			}
		allObjects.add(this.objectId, this);
		animation = new Animation();
		m=new movement(this);
		c= new collision(this);
	}
	
	
	public GameObject(tileMap map) {
		// TODO Auto-generated constructor stub
		super(map);
		if(allObjects==null)
		{
			allObjects=new iArrayList<>();
		}
		if(allObjects.count==0)
		{
			this.objectId = 0;
		}else
			{
			
				this.objectId = (int) (allObjects.last.Data1+1);
			}
		this.objectId = allObjects.count;
		allObjects.add(this.objectId, this);
		animation = new Animation();
		this.tmap = map;

		m=new movement(this);
		c= new collision(this);
		
	}
	
	
	
	public GameObject(tileMap map,int h, int w) {
		// TODO Auto-generated constructor stub
		super(map);
		if(allObjects==null)
		{
			allObjects=new iArrayList<>();
		}
		if(allObjects.count==0)
		{
			this.objectId = 0;
		}else
			{
			
				this.objectId = (int) (allObjects.last.Data1+1);
			}
		this.objectId = allObjects.count;
		allObjects.add(this.objectId, this);
		animation = new Animation();
		this.tmap = map;
		this.height=h;
		this.width=w;
		this.setCollisionParams(h, w);

		m=new movement(this);
		c= new collision(this);
	
	}
	
	
	
	
	public GameObject(tileMap map,int h, int w,double x, double y) {
		// TODO Auto-generated constructor stub
		super(map);
		if(allObjects==null)
		{
			allObjects=new iArrayList<>();
		}
		if(allObjects.count==0)
		{
			this.objectId = 0;
		}else
			{
			
				this.objectId = (int) (allObjects.last.Data1+1);
			}
		this.objectId = allObjects.count;
		allObjects.add(this.objectId, this);
		animation = new Animation();
		this.tmap = map;
		this.height=h;
		this.width=w;
		this.setCollisionParams(h, w);
		setPosition(x, y);

		m=new movement(this);
		c= new collision(this);
	}
	
	


	@Override
	public abstract void update();

	@Override
	public abstract void render(Graphics2D g2d);
	
	
	public int getObjectId() {
		return objectId;
	}
	
	public static iArrayList<GameObject> getObjects()
	{
		return allObjects;
	}
	
	public boolean remove()
	{	this.removed = removeObject(this.objectId);
		return this.removed;
	}
	
	private static boolean removeObject(int objectIds)
	{
		boolean found=false;
		
		for(int i=0; i<allObjects.count; i++)
		{
			iArrayList<GameObject>.iNode<GameObject> temp = allObjects.getNode(i);
			if(temp.Data1==objectIds)
			{
				allObjects.remove(i);
				found = true;
				
			}			
			if(found==true)
			{
				break;
			}
		}
		
		return found;
	}

	
	public void setPosition(double x, double y)
	{
		
		this.x=x;
		this.y=y;		
		
		positionVector = new Vector(2);		
		positionVector.fillVector(x,y);
	}
	
	
	public void placeOnTile(int id)
	{
		Tiles t = tmap.getTileById(id);
		setPosition(t.getX()+(tmap.getSize()-collisionWidth/2), t.getY()+(tmap.getSize()-collisionHeight/2));
	}
	
	public void tmapCheckContact(double x, double y)
	{
		int leftTile = tmap.getCol((int)(x-collisionWidth/2));
		int rightTile = tmap.getCol((int)((x+collisionWidth/2)-1));
		int topTile = tmap.getRow((int)(y-collisionHeight/2));
		int bottomTile = tmap.getRow((int)((y+collisionHeight/2)-1));
		topLeft = tmap.getTile(topTile,leftTile).isWalkable();
		topRight = tmap.getTile(topTile,rightTile).isWalkable();
		bottomLeft = tmap.getTile(bottomTile,leftTile).isWalkable();
		bottomRight = tmap.getTile(bottomTile,rightTile).isWalkable();
	}
	
	public void platFormerPhysics(double gravityVaue,double maxFallingSpeed, double jumpHeight)
	{
				
		m.platformerPhysics(gravityVaue, maxFallingSpeed, jumpHeight);
	}
	
	public void openWorldPhysics()
	{
		m.openWorldPhysics();
	}
	
	public void platFormerPhysics_Ai(double gravityVaue,double maxFallingSpeed, double jumpHeight)
	{
				
		m.platformerPhysics_Ai(gravityVaue, maxFallingSpeed, jumpHeight);
	}
	
	public void openWorldPhysics_Ai()
	{
		m.openWorldPhysics_Ai();
	}
	
	
	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public double getMoveSpeed() {
		return m.getMovespeed();
	
	}
	
	public void setMoveSpeed(double speed)
	{
		m.setMovespeed(speed);
	}
	
	public void setMaxSpeed(double speed)
	{
		m.setMaxspeed(speed);
	}
	
	public double getMaxSpeed() {
		return m.getMaxspeed();
	}
	
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public double getStopSpeed() {
		return m.getStopspeed();
	}
	
	public boolean isJumping() {
		return jumping;
	}
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	public double getjumpHeight() {
		return g.getJumpHeight();
	}
	
	public boolean isFalling() {
		return falling;
	}
	public void setFalling(boolean falling) {
		this.falling = falling;
	}
	
	public double getGravity() {
		return g.getGravity();
	}
	
	public double getMaxFallingSpeed() {
		return g.getMaxFallingSpeed();
	}
	
	public boolean isDown() {
		return down;
	}
	
	public boolean isUp() {
		return up;
	}
	
	public gravity gravity()
	{
		return g;
	}
	
	public tileMap getTileMap()
	{
		return this.tmap;
	}
	
	
	
	public boolean isTopLeft() {
		return topLeft;
	}
	
	public boolean isTopRight() {
		return topRight;
	}
	
	public boolean isBottomLeft() {
		return bottomLeft;
	}
	
	public boolean isBottomRight() {
		return bottomRight;
	}
	
	public int getCollisionHeight() {
		return collisionHeight;
	}
	
	public int getCollisionWidth() {
		return collisionWidth;
	}
	
	public collision collision()
	{
		return c;
	}
	
	public movement movement()
	{
		return m;
	}
	
	public Rectangle collisionBound()
	{
		return new Rectangle((int)x, (int)y, collisionWidth, collisionHeight);
	}
		
	/*
	public Rectangle topRightBound()
	{
		return new Rectangle(
				(int)x+(collisionWidth/2-((collisionWidth/2)/2))+collisionWidth/4,
				//(int)x+collisionWidth/2,
				(int)y-collisionHeight/4+collisionHeight/8,
				collisionWidth/2,
				collisionHeight/2
		);
	}*/
	
	public Rectangle topBound()
	{
		return new Rectangle(
				(int)x+collisionWidth/8-collisionWidth/16-collisionWidth/32-collisionWidth/64,
				(int)y-collisionHeight/4+collisionHeight/8,
				collisionWidth,
				collisionHeight/2
		);
	}
	
	
	public Rectangle bottomBound()
	{
		return new Rectangle(
				//(int)x+(collisionWidth/2-((collisionWidth/2)/2))+collisionWidth/4,
				(int)x+collisionWidth/8-collisionWidth/16-collisionWidth/32-collisionWidth/64,
				(int)y+collisionHeight/2,
				collisionWidth,
				collisionHeight/2
		);
	}
	
	/*
	public Rectangle topLeftBound()
	{
		return new Rectangle(
				(int)x,
				(int)y-collisionHeight/4+collisionHeight/8,
				collisionWidth/2,
				collisionHeight/2
		);
	}
	
	public Rectangle bottomRightBound()
	{
		return new Rectangle(
				(int)x+(collisionWidth/2-((collisionWidth/2)/2))+collisionWidth/4,
				//(int)x+collisionWidth/2,
				(int)y+collisionHeight/2,
				collisionWidth/2,
				collisionHeight/2
		);
	}
	
	
	public Rectangle bottomLeftBound()
	{
		return new Rectangle(
				(int)x,
				(int)y+collisionHeight/2,
				collisionWidth/2,
				collisionHeight/2
		);
	}*/
	
	
	public Rectangle rightBound()
	{
		return new Rectangle(
				//(int)x+(collisionWidth/2-((collisionWidth/2)/2))+collisionWidth/4,
				(int)x+collisionWidth/2+collisionWidth/8+collisionWidth/32,
				(int)y,
				collisionWidth/2,
				collisionHeight-collisionHeight/4
		);
	}
	
	public Rectangle leftBound()
	{
		return new Rectangle(
				//(int)x+(collisionWidth/2-((collisionWidth/2)/2))+collisionWidth/4,
				(int)x-collisionWidth/8,
				(int)y,
				collisionWidth/2,
				collisionHeight-collisionHeight/4
		);
	}
	
	
	

	
	
	public void renderBound(Graphics2D g2d,Rectangle r)
	{
		g2d.fillRect((int)(tmap.getX()+r.getX()-r.getWidth()/2), 
				(int)(tmap.getY()+r.getY()-r.getHeight()/2), 
				(int)r.getWidth(), (int)r.getHeight());
	}
	
	
	public void setTopLeft(boolean topLeft) {
		this.topLeft = topLeft;
	}
	
	public void setTopRight(boolean topRight) {
		this.topRight = topRight;
	}
	
	public void setBottomLeft(boolean bottomLeft) {
		this.bottomLeft = bottomLeft;
	}
	
	public void setBottomRight(boolean bottomRight) {
		this.bottomRight = bottomRight;
	}
	
	public void setUp(boolean up) {
		this.up = up;
	}
	
	public void setDown(boolean down) {
		this.down = down;
	}
	
	public Tiles getTopBlock()
	{
		int ty = tmap.getRow((int)y)-1;
		if(ty<0)
		{
			ty=0;
		}
		return tmap.getTile(ty, tmap.getCol((int)x));
	}
	
	public Tiles getBottomBlock()
	{
		int ty = tmap.getRow((int)y)+1;
		if(ty>map.getNumRows()-1)
		{
			ty=map.getNumRows()-1;
		}
		return tmap.getTile(ty, tmap.getCol((int)x));
	}
	
	public Tiles getLeftBlock()
	{
		int ty = tmap.getCol((int)x)-1;
		if(ty<0)
		{
			ty=0;
		}
		return tmap.getTile(tmap.getRow((int)y), ty);
	}
	
	public Tiles getRightBlock()
	{
		int ty = tmap.getCol((int)x)+1;
		if(ty>map.getNumCols()-1)
		{
			ty=map.getNumCols()-1;
		}
		return tmap.getTile(tmap.getRow((int)y), ty);
	}
	
	public Tiles getCurrentBlock()
	{
		return tmap.getTile(tmap.getRow((int)y), tmap.getCol((int)x));
	}
	public Tiles getTopLeftBlock()
	{
		int top = tmap.getRow((int)y)-1;
		
		if(top<0)
		{
			top=0;
		}
		int left = tmap.getCol((int)x)-1;
		if(left<0)
		{
			left=0;
		}
		
		return tmap.getTile(top, left);
	}
	
	public Tiles getBottomLeftBlock()
	{
		int top = tmap.getRow((int)y)+1;
		if(top>=tmap.getNumRows())
		{
			top=tmap.getNumRows()-1;
		}
		int left = tmap.getCol((int)x)-1;
		if(left<0)
		{
			left=0;
		}
		return tmap.getTile(top, left);
	}
	
	public Tiles getTopRightBlock()
	{
		int top = tmap.getRow((int)y)-1;
		if(top<0)
		{
			top=0;
		}
		int left = tmap.getCol((int)x)+1;
		if(left>=tmap.getNumCols())
		{
			left=tmap.getNumCols()-1;
		}
		return tmap.getTile(top, left);
	}
	
	public Tiles getBottomRightBlock()
	{
		int top = tmap.getRow((int)y)+1;
		if(top>=tmap.getNumRows())
		{
			top=tmap.getNumRows()-1;
		}
		int left = tmap.getCol((int)x)+1;
		if(left>=tmap.getNumCols())
		{
			left=tmap.getNumCols()-1;
		}
		return tmap.getTile(top, left);
	}
	
	public boolean isAtTopLeft(GameObject obj)
	{
		return getTopLeftBlock().getId()==obj.getCurrentBlock().getId();
	}
	
	public boolean isAtTopRight(GameObject obj)
	{
		return getTopRightBlock().getId()==obj.getCurrentBlock().getId();
	}
	
	public boolean isAtLeft(GameObject obj)
	{
		return getLeftBlock().getId()==obj.getCurrentBlock().getId();
	}
	
	public boolean isAtRight(GameObject obj)
	{
		return getRightBlock().getId()==obj.getCurrentBlock().getId();
	}
	
	public boolean isAtCurrent(GameObject obj)
	{
		return getCurrentBlock().getId()==obj.getCurrentBlock().getId();
	}
	
	public boolean isAtTop(GameObject obj)
	{
		return getTopBlock().getId()==obj.getCurrentBlock().getId();
	}
	
	public boolean isAtBottom(GameObject obj)
	{
		return getBottomBlock().getId()==obj.getCurrentBlock().getId();
	}
	
	public boolean isAtBottomRight(GameObject obj)
	{
		return getBottomRightBlock().getId()==obj.getCurrentBlock().getId();
	}
	
	public boolean isAtBottomLeft(GameObject obj)
	{
		return getBottomLeftBlock().getId()==obj.getCurrentBlock().getId();
	}
	public boolean isLockMovement() {
		return lockMovement;
	}
	public void setLockMovement(boolean lockMovement) {
		this.lockMovement = lockMovement;
	}
	public iList<Double> getMapPath() {
		return mapPath;
	}
	public void setMapPath(iList<Double> mapPath) {
		
		this.mapPath = mapPath;
	}
	
	
	public void followPathOpenWorld()
	{
		
		checkActionOpenWorld();
		walkPathOpenWorld();
		
		
		
	}
	
	

	private void checkActionOpenWorld()
	{
		if(action==1)
		{
			up=true;
			down=false;
			left=false;
			right=false;
		}else if(action==2)
		{
			up=false;
			down=false;
			left=false;
			right=true;
		}else if(action==3)
		{
			up=false;
			down=true;
			left=false;
			right=false;
		}else if(action==4)
		{
			up=false;
			down=false;
			left=true;
			right=false;
		}
	}
	
	private void walkPathOpenWorld()
	{
		if(this.mapPath!=null)
		{
			if(mapPath.getCount()>0)
			{
				Double id = mapPath.getAtIndex(pathIndex).Data;
				if(id==getCurrentBlock().getId()-1)
				{
					action=4;
				}else if(id==getCurrentBlock().getId()+1)
				{
					action=2;
				}
				else if(id==getCurrentBlock().getId()+tmap.getNumCols())
				{
					action=3;
					
				}else if(id==getCurrentBlock().getId()-tmap.getNumCols())
				{
					action=1;
				}
				else
				{
					action =0;
				}
				
				
				if(getCurrentBlock().getId()==id)
				{
					if(pathReverse)
					{
						if(pathIndex<=0)
						{
							pathReverse=false;
						}else
						{
							pathIndex--;
						}
					}else
					{
						if(pathIndex>=mapPath.getCount()-1)
						{
							pathReverse=true;
						}else{
							pathIndex++;
						}
					}
				}
				
				
				
			}
		}
	}
	
	
}
