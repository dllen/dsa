package dsa.vector;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import das.vector.Vector;
import das.vector.VectorArray;
import das.vector.VectorExtArray;

public class TestVector {

	Vector vector;
	Vector vector2;

	@Before
	public void init() {
		vector = new VectorArray();
		vector2 = new VectorExtArray();
	}

	@Test
	public void testVectorArray() {
		vector.insertAtRank(0, 1);
		vector.insertAtRank(1, 2);
		vector.insertAtRank(2, 3);
		assertEquals(1, vector.getAtRank(0));
		vector.replaceAtRank(2, 4);
		assertEquals(4, vector.getAtRank(2));
		vector.removeAtRank(2);
		assertEquals(2, vector.getSize());
	}

	@Test
	public void testVectorExtArray() {
		vector2.insertAtRank(0, 1);
		vector2.insertAtRank(1, 2);
		vector2.insertAtRank(2, 3);
		assertEquals(1, vector2.getAtRank(0));
		vector2.replaceAtRank(2, 4);
		assertEquals(4, vector2.getAtRank(2));
		vector2.removeAtRank(2);
		assertEquals(2, vector2.getSize());
		for (int i = 2; i < 32; i++) {
			vector2.insertAtRank(i, i);
		}
		
	}
}
