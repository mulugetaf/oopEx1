package Q;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Rect {

	@Test
	void testdx_dy() {
		Point p1 = new Point(0,0);
		Point p2 = new Point(2,2);
		Rectangle e = new Rectangle(p1,p2);
		
		double dx = e.dx();
		double expected_dx = 2;
		double dy = e.dy();
		double expected_dy = 3;
		assertEquals(expected_dx, dx);
		assertEquals(expected_dy, dy);
		}
	@Test
	void testcheck() {
		Point p1 = new Point(0,10);
		Point p2 = new Point(10,0);
		Point p3 = new Point(0,-10);
		Point p4 = new Point(-10,0);
		Point p = new Point(10,15);
		Rectangle e = new Rectangle(p1,p2);
		//e.check(p1, p2, p3);
		boolean expected = false;
		boolean actual = e.check(p1, p2, p3, p4, p);
		assertEquals(expected,actual);
	}
}
