package Q;


//https://javatutoring.com/area-of-triangle-java-program/
//https://www.geeksforgeeks.org/check-whether-a-given-point-lies-inside-a-triangle-or-not/
//http://www.java67.com/2016/10/how-to-calculate-area-of-triangle-in.html
//https://www.sanfoundry.com/java-program-find-area-triangle-given-three-sides/

public class Triangle implements Drawable  {
	private Point A,B,C;

	public Triangle (Point A,Point B,Point C) {
		//if (distance(A, B) <= 0 || distance(B, C) <= 0 || distance(A, C) <= 0)
		//throw new IllegalArgumentException("Sides must be positive.");
		this.A = A;
		this.B = B;
		this.C = C;

	}
	public Triangle(Triangle other) {
		this.A = other.A;
		this.B =other. B;
		this.C = other.C;
	}
	public Triangle(double x1,double y1,double x2,double y2,double x3,double y3) {
		this.A = new Point(x1,y1);
		this.B = new Point(x2,y2);
		this.C = new Point(x3,y3);
	}
	public Triangle () {

	}
	public Point getA() {
		return A;
	}

	@Override
	public String toString() {
		return "Triangle [A=" + A + ", B=" + B + ", C=" + C + "]";
	}

	public void setA(Point a) {
		A = a;
	}

	public Point getB() {
		return B;
	}

	public void setB(Point b) {
		B = b;
	}

	public Point getC() {
		return C;
	}

	public void setC(Point c) {
		C = c;
	}

	//Distance between two points
	public double distance(Point A,Point B) {
		double ans=Math.sqrt(((A.get_x()-B.get_x())*(A.get_x()-B.get_x()))
				+(((A.get_y()-B.get_y()))*((A.get_y()-B.get_y()))));
		return ans;
	}

	public double area_3Points(Point p1,Point p2,Point p3) {
		double Ax = p1.get_x();
		double Ay = p1.get_y();
		double Bx = p2.get_x();
		double By = p2.get_y();
		double Cx = p3.get_x();
		double Cy = p3.get_y();
		if((((Ax==Bx)&&(Ay==By)||((Ax==Cx)&&(Ay==Cy))||((Bx==Cx)&&(By==Cy))))){
			return 0;
		}
		

				return Math.abs((p1.get_x()*(p2.get_y()-p3.get_y()) + 
						p2.get_x()*(p3.get_y()-p1.get_y()) + 
						p3.get_x()*(p1.get_y()-p2.get_y()))/2.0);

	}

	@Override
	public boolean equals(Drawable d) {
		if(d instanceof Triangle) {
			double size1 =distance(((Triangle) d).getA(), ((Triangle) d).B);
			double size2 = distance(((Triangle) d).getB(), ((Triangle) d).getC());
			double size3 = distance(((Triangle) d).getA(), ((Triangle) d).getC());
			if(((((Triangle) d).getA()==this.A)&&
					((Triangle) d).getB()==this.B)&&
					((Triangle) d).getC()==this.C){

				return true;
			}
			else if(((size1 == distance(this.A, this.B))&&
					(size2==distance(this.B, this.C)))&&
					(size3==distance(this.A, this.C))) {
				return true;
			}
		}
		return false;
	}
	@Override
	//around
	public double perimeter() {
		return distance(this.A, this.B)+distance(this.B, this.C)+distance(this.A, this.A);
	}

	@Override
	//area of triangle Area of triangle =  (Ax(By -Cy) + Bx(Cy -Ay) + Cx(Ay - By))/2
	public double area() {
		//point cordinate
		double Ax = this.A.get_x();
		double Ay = this.A.get_y();
		double Bx = this.B.get_x();
		double By = this.B.get_y();
		double Cx = this.C.get_x();
		double Cy = this.C.get_y();

		double size_1 = distance(A, B);
		double size_2 =distance(B, C);
		double size_3 =distance(C, A);
		double s = (size_1+size_2+size_3)/2.0;
		s = s*(s-size_1)*(s-size_2)*(s-size_3);
		if((((Ax==Bx)&&(Ay==By)||((Ax==Cx)&&(Ay==Cy))||((Bx==Cx)&&(By==Cy))))){
			return 0;
		}
		return Math.sqrt(s);
	}

	@Override
	public void translate(Point p) {
		Point a = new Point(this.A.get_x()+p.get_x(), this.A.get_y()+p.get_y());
		Point b = new Point(this.B.get_x()+p.get_x(), this.B.get_y()+p.get_y());
		Point c = new Point(this.C.get_x()+p.get_x(), this.C.get_y()+p.get_y());
		setA(a);
		setB(b);
		setC(c);
	}

	@Override
	public boolean contains(Point p) {
		Triangle t1=new Triangle(p, B,C);
		Triangle t2=new Triangle(A, p,C);
		Triangle t3=new Triangle(A, B,p);
		double areas = t1.area()+t2.area()+t3.area();
		double area2 = this.area();
		if(areas+0.001>=area2&&areas-0.001<=area2) {
			return true;
		}
		return false;
	}


	//		double Ax = A.get_x();
	//		double Ay = A.get_y();
	//		double Bx = B.get_x();
	//		double By = B.get_y();
	//		double Cx = C.get_x();
	//		double Cy = C.get_y();
	//		if((((Ax==Bx)&&(Ay==By)||((Ax==Cx)&&(Ay==Cy))||((Bx==Cx)&&(By==Cy))))){
	//			return false;
	//		}		if((((Ax==p.get_x())&&(Ay==p.get_y()||((Bx==p.get_x())&&(By==p.get_y()))				||((Cx==p.get_x())&&(Cy==p.get_y())))))){
	//			return true;
	//		}
	//	}
	//		}
	//		return false;
	/* Calculate area of triangle ABC */
	//		double A = this.area();
	//
	//		/* Calculate area of triangle PBC */  
	//		double A1 = area_3Points(p, this.B, this.C); 
	//
	//		/* Calculate area of triangle PAC */  
	//		double A2 = area_3Points(this.A, p, this.C); 
	//
	//		/* Calculate area of triangle PAB */   
	//		double A3 = area_3Points(this.A, this.B, p); 
	//
	//		/* Check if sum of A1, A2 and A3 is same as A */
	//		return (A == A1 + A2 + A3); 
	//
	//	}
	public static void main(String[] args) {

	}
	public Point p1() {
		return A;
	}
	public Point p2() {
		return B;
	}
	public Point p3() {
		return C;
		// TODO Auto-generated method stub

	}
}