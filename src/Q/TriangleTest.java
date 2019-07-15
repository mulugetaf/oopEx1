package Q;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TriangleTest {

	@Test
	void test() {
		
		Point p1 = new Point (1,2);
		Point p2 = new Point (3,5);
		Point p3 = new Point (7,8);
		Triangle t = new Triangle(p1,p2,p3);
		
		t.equals (t);
		t.perimeter();
		t.area();
		t.translate (p1);
		t.contains(p2);
	}

}
