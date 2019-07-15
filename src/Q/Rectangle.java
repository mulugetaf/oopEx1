package Q;


//https://introcs.cs.princeton.edu/java/32class/Rectangle.java.html
public class Rectangle implements Drawable {

	private Point p1,p2;

	public Rectangle(Point p1,Point p2 ){
		/* @throws IllegalArgumentException if {@code p2.get_x() < p1.get_x()} 
		 * or {@code p2.get_y() <  p1.get_y()}.
		 */
		//		if (p2.get_x() < p1.get_x() || p2.get_y() < p1.get_y()) {
		//			throw new IllegalArgumentException("Invalid rectangle");
		//		}
		this.p1 = p1;
		this.p2 = p2;

	}
	public Rectangle(Rectangle other) {
		if (other==null) {return;}
		this.p1 = other.p1;
		this.p2  =other.p2;
	}

	public Rectangle() {}
	//length
	public double dx() {
		return this.p2.get_x()-this.p1.get_x();
	}


	//wedth
	public double dy() {
		return this.p2.get_y()-this.p1.get_y();
	}


	@Override
	public String toString() {
		return "Rectangle [p1=" + p1 + ", p2=" + p2 + "]";
	}


	public double distance(Point A,Point B) {
		double ans=Math.sqrt((Math.pow(B.get_x()-A.get_x(), 2)+Math.pow(B.get_y()-A.get_y(),2)));
		return ans;
	}


	@Override
	public boolean equals(Drawable d) {

		if(d instanceof Rectangle) {
			if((distance(this.p1, this.p2))!=(distance(((Rectangle) d).getP1(),((Rectangle) d).getP2()))) {
				return false;
			}
			else 	return true;
		}
		return false;
	}


	/* A utility function to calculate area of  
triangle formed by p1, p2 and 
p3 */
	public double AreaOf_3Ps(Point p1,Point p2,Point p3) {
		{ 
			double Ax = p1.get_x();
			double Ay = p1.get_y();
			double Bx = p2.get_x();
			double By = p2.get_y();
			double Cx = p3.get_x();
			double Cy = p3.get_y();

			return ((Ax*(By -Cy) + Bx*(Cy -Ay) + Cx*(Ay - By))/2.0);

		}	
	}

	/* A function to check whether point P(x, y)  
    lies inside the rectangle formed by A(x1, y1),  
    B(x2, y2), C(x3, y3) and D(x4, y4) */
	public boolean check(Point p1, Point p2, 
			Point p3, Point p4, Point p_0) 
	{ 

		/* Calculate area of rectangle ABCD */
		double A = AreaOf_3Ps(p1, p2, p3)+  
				AreaOf_3Ps(p1, p4, p3); 

		/* Calculate area of triangle PAB */
		double A1 = AreaOf_3Ps(p_0, p1, p2); 

		/* Calculate area of triangle PBC */
		double A2 = AreaOf_3Ps(p_0, p2, p3); 

		/* Calculate area of triangle PCD */
		double A3 = AreaOf_3Ps(p_0, p3, p4); 

		/* Calculate area of triangle PAD */
		double A4 = AreaOf_3Ps(p_0, p1, p4); 

		/* Check if sum of A1, A2, A3 and A4  
        is same as A */
		return (A == A1 + A2 + A3 + A4); 
	} 
	@Override
	public boolean contains(Point p) {
		if(p==null) {return false;}
		/* Calculate area of rectangle ABCD */
		double Ax = p1.get_x();
		double Ay = p1.get_y();
		double Bx = p2.get_x();
		double By = p2.get_y();
		double Cx = p2.get_x();
		double Cy = p1.get_y();
		double Dx = p1.get_x();
		double Dy = p1.get_y();
		if((((Ax==Bx)&&(Ay==By)||((Cx==Dx)&&(Cy==Dy))))){
			return false;
		}
		if 
		((p.get_x() > p1.get_x() && p.get_x() < p2.get_x()) 
				&& (p.get_y() > p1.get_y() && p.get_y() < p2.get_y())) {
			return true; 
		}
		else return false;

	}

	@Override
	//around
	public double perimeter() {
		double weidth =2*(p2.get_x()-p1.get_x());
		double height =2*(p2.get_y()-p1.get_y());
		return (weidth+height);
	}

	@Override
	public double area() {
		double Ax = p1.get_x();
		double Ay = p1.get_y();
		double Bx = p2.get_x();
		double By = p2.get_y();


		if((((Ax==Bx)&&(Ay==By)))){
			return 0;
		}
		double height = By-Ay;
		double weidth = Bx -Ax;
		return height*weidth;
	}


	@Override
	public void translate(Point p) {
		Point a = new Point(this.p1.get_x()+p.get_x(), this.p1.get_y()+p.get_y());
		Point b = new Point(this.p2.get_x()+p.get_x(), this.p2.get_y()+p.get_y());

		setP1(a);
		setP2(b);
	}
	public Point getP1() {
		return p1;
	}
	public void setP1(Point p1) {
		this.p1 = p1;
	}
	public Point getP2() {
		return p2;
	}
	public void setP2(Point p2) {
		this.p2 = p2;
	}
	public Point p1() {
		return new Point(p1.get_x(),p1.get_y());
		// TODO Auto-generated method stub

	}
	public Point p2() {
		return new Point(p2.get_x(),p2.get_y());
	}
}