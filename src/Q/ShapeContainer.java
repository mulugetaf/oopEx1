package Q;

import java.util.Arrays;

public class ShapeContainer {
	private Drawable Shapes[];
	public static final int INIT_SIZE=10;
	public static final int RESIZE=10;

	public ShapeContainer() {
		this.Shapes = new Drawable[INIT_SIZE];
	}

	@Override
	public String toString() {
		return "ShapeContainer [Shapes=" + Arrays.toString(Shapes) + "]";
	}

	public ShapeContainer(ShapeContainer other) {
		if(other==null) {return ;}
		Drawable temp[] = new Drawable[other.Shapes.length];
		for (int i = 0; i < other.Shapes.length; i++) {
			if(other.Shapes[i]!=null) {
			if(other.Shapes[i] instanceof Point) {
				temp[i] = new Point((Point)other.Shapes[i]);
			}
			else if(other.Shapes[i] instanceof Triangle) {
				temp[i] = new Triangle((Triangle)other.Shapes[i]);
			}
			else if(other.Shapes[i] instanceof Rectangle) {
				temp[i] = new Rectangle((Rectangle)other.Shapes[i]);
			}
		}
		}
		this.Shapes = temp;
	}

	// return the number of stored shapes in the container
	public int size() {
		int count = 0;

		for (int i = 0; i < Shapes.length; i++) {
			if(Shapes[i]!=null) {
				count++;
			}
		}
		return count;
	}

	// return the number of stored triangles in the container
	public int T_size() {
		int count=0;
		for (int i = 0; i < Shapes.length; i++) {
			if(Shapes[i] instanceof Triangle) {
				count++;
			}
		}
		return count;
	}

	// return the number of stored rectangles in the container
	public int R_size() {
		int count=0;
		for (int i = 0; i < Shapes.length; i++) {
			if(Shapes[i] instanceof Rectangle) {
				count++;
			}
		}
		return count;	 
	}

	//resize the drawable array 
	public void resize() {
		Drawable temp[] = new Drawable[this.Shapes.length+RESIZE] ;
		for (int i = 0; i < this.Shapes.length; i++) {
			temp[i] = this.Shapes[i];
		}
		this.Shapes = temp;
	}

	// add the given object to the container
	public void add (Drawable d) {
		if(d==null) {return;}
		int freeSpace = Shapes.length-size();
		if(freeSpace==0){
			resize();
			this.Shapes[size()] = d;
		}
		else this.Shapes[size()] = d;
	}

	/* remove(find) triangles & rectangles containing p then call to 
	 * removeFromarry function to remove
	 */

	public void remove(Point p) {
		if(p==null) {return;}
		for (int i = 0; i < Shapes.length; i++) {
			//if(Shapes[i]==null) break;
			if(Shapes[i] instanceof Triangle) {

				if(((Triangle)Shapes[i]).contains(p)) {
					removeFromarry(this.Shapes,i);
				}
			}
			else if(Shapes[i] instanceof Rectangle) {

				if(((Rectangle)Shapes[i]).contains(p)) {
					removeFromarry(this.Shapes,i);
				}
			}
		}
	}

	// remove triangles & rectangles containing p after find them 
	public void removeFromarry(Drawable[] t,int i) {
		int newArraysize = 0;
		newArraysize = t.length;
		Drawable[] temp = new Drawable[newArraysize];
		t[i] =null;
		for (int j = 0; j < t.length; j++) {
			if(t[j]!=null) {
				temp[j]=t[j];
			}
		}
		this.Shapes = temp;
	}

	// return a new copy of the triangle number i
	public Triangle T_at(int i) {
		int count =0;
		if(T_size()>=i) {
			for (int k = 0; k < Shapes.length; k++) {

				if(Shapes[k] instanceof Triangle)
				{ 
					if(count==i) {  
						return new Triangle((Triangle)Shapes[k]);
					} 
					else{  
						count++; 
					}
				}
			}
		}
		return null;
	}
	// return a new copy of the rectangle number i
	public Rectangle R_at(int i) {
		int count =0;
		if(R_size()>=i) {
			for (int k = 0; k < Shapes.length; k++) {
				if(Shapes[k] instanceof Rectangle) {
					if(count==i) {
						return new Rectangle((Rectangle)Shapes[k]);
					}
					else {
						count++;
					}
				}
			}
		}
		return null;
	}
	/* return the sum of the
	areas of all the triangles & rectangles*/
	public double sumArea() {
		double sum = 0;
		for (int i = 0; i < Shapes.length; i++) {
			if(Shapes[i]!=null) {
				if(Shapes[i] instanceof Triangle) {
					sum+= (((Triangle)Shapes[i]).area());
				}
				else if(Shapes[i] instanceof Rectangle) {
					sum+=((Rectangle)Shapes[i]).area();
				}
			}
		}
		return sum ;
	}

	//Translates (mutator) all the shapes by a Point 
	public void translate(Point p) {
		if(p==null) {return;}
		for (int i = 0; i < Shapes.length; i++) {

			if(Shapes[i] instanceof Triangle) {
				((Triangle)Shapes[i]).translate(p);
			}
			else {
				if(Shapes[i] instanceof Rectangle) {
					((Rectangle)Shapes[i]).translate(p);

				}
			}
		}
	}
	/* calculates and prints min and max perimeter
		 of the shapes (triangles & rectangles)*/ 
	public void minMaxPerimeter(int num) {
		double minTr=1,maxTr=0,minRe=1,maxRe = 0;
		for (int i = 0; i < Shapes.length; i++) {
			if(Shapes[i]!=null) {
				if(Shapes[i] instanceof Triangle) {
					if(Shapes[i].area()>maxTr) {
						maxTr = Shapes[i].area();	
					}
					else if (Shapes[i].area()<minTr) {
						minTr = Shapes[i].area();	
					}
				}
				else if(Shapes[i] instanceof Rectangle) {
					if(Shapes[i].area()>maxRe) {
						maxRe = Shapes[i].area();	
					}
					else if (Shapes[i].area()<minRe) {
						minRe = Shapes[i].area();	
					}
				}
			}
		}
		System.out.println("min perimeter of triangles is :"+minTr +"\n" +
				"max perimeter of triangles is:"+maxTr + "\n" +
				"min perimeter of rectangles is :"+minRe +"\n" +
				"max perimeter of rectangles is :"+maxRe +"\n" );
	}

}

