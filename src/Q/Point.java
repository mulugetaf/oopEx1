package Q;

/**
 * this class represents a 2d point in the plane. <br>
 * supports several operations on points in the plane.
 */
public class Point implements Drawable {

	// ******** private data ********
	private double _x, _y;

	public double get_y() {
		return _y;
	}

	public void set_y(double _y) {
		this._y = _y;
	}

	public double get_x() {
		return _x;
	}

	public void set_x(double _x) {
		this._x = _x;
	}

	// ********* constructors ********
	public Point (double x1, double y1) {
		_x = x1;
		_y = y1;
	}

	/** copy constructor:  
       1)here a direct access to a class memeber is performed,
         this will be done only in a constractor to achieve an identical copy
       2) using a call to another constractor code is not written twice
	 */  
	public Point (Point p) { this(p._x, p._y);}

	// ********** public methodes *********
	public double x() {return _x;}
	public double y() {return _y;}

	/** @return a String contains the Point data*/
	public String toString()  {
		return "name: " + this.getClass() +"[" + _x + "," + _y+"]";
	}

	public double distance(Point A) {
		double ans=Math.sqrt((Math.pow(A.get_x()-this.get_x(), 2)+Math.pow(A.get_y()-this.get_y(),2)));
		return ans;
	}

	/**    logical equals 
   @param p other Object (Point).
   @return true iff p instance of Point && logicly the same) */
	public boolean equals (Point p) {
		return p!=null && p._x == _x && p._y==_y; }

	@Override
	public boolean equals(Drawable d) {
		return false;
	}
		
	@Override
	public boolean contains(Point p) {
		if((this._x==p._x)&&(this._y==p.get_y())) {
			return true;
		}
		return false;
	}
	@Override
	public double perimeter() {
		return 0;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void translate(Point p) {
		set_x(this._x+p.get_x());;
		set_y(this._y+p.get_y());;

	}

}// class Point