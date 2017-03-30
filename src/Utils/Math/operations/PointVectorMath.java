package Utils.Math.operations;

import Utils.Math.points.Points;
import Utils.Math.vector.Vector;

public class PointVectorMath {
	
	public static Points addVector(Points p, Vector v)
	{
		if(v.length()==2)
		{
			return new Points(p.getX()+v.x2D(), p.getY()+v.y2D());
		}return null;
	}
	
		
	public static Vector pointsDistanceVector(Points p, Points q)
	{
		double[] re = {(q.getX()-p.getX()),(q.getY()-p.getY())};
		return new Vector(re);
	}
	
	
	
	public static Points closestPointTo(Points p,Points q, Points r)
	{
		return pointsDistanceVector(q, p).magnitude_Sqr()<
		       pointsDistanceVector(r, p).magnitude_Sqr()? q:r;
	}
	
    public static double PointToDegree(Points p)
    {
    	return pointsDistanceVector(new Points(0, 0), p).unitVector().direction2D_Degree();
    }
    
    public static double PointToRadian(Points p)
    {
    	return pointsDistanceVector(new Points(0, 0), p).unitVector().direction2D_Radian();
    }
    
    public static double PointToUnitDegree(Points p)
    {
    	return pointsDistanceVector(new Points(0, 0), p).unitVector().unitCircleDegree();
    }
    
    public static double PointToUnitQuad(Points p)
    {
    	return pointsDistanceVector(new Points(0, 0), p).unitVector().unitCircleQuad();
    }
    
    public static double pointMagnitude(Points p)
    {
    	return pointsDistanceVector(new Points(0, 0), p).magnitude();
    }
    
    public static Vector approachVector(Vector goal, Vector current, Vector delta)
    {
    	Vector dif = VectorMath.subtraction(goal, current);
    	if(dif.magnitude_Sqr()>delta.magnitude_Sqr())
    	{
    		
    		return VectorMath.addition(current, delta);
    		
    	}else if(dif.magnitude()==0)
    	{
    		
    		return current;
    	}
    	return current;
    	
      	
    }
}
