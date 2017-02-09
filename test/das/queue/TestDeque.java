package das.queue;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import das.doubleendedqueue.Deque;
import das.doubleendedqueue.DequeDLNode;

public class TestDeque {

	Deque deque;

	@Before
	public void init() {
		deque = new DequeDLNode();
		deque.insertFirst(1);
		deque.insertFirst(2);
	}

	@Test
	public void testFirst() {
		assertEquals(2, deque.first());
	}

	@Test
	public void testLast() {
		assertEquals(1, deque.last());
	}

	@Test
	public void testInsertFirst() {
		deque.insertFirst(4);
		assertEquals(4, deque.first());
		assertEquals(3, deque.getSize());
	}

	@Test
	public void testRemoveLast() {
		deque.removeLast();
		assertEquals(2, deque.first());
		assertEquals(2, deque.last());
		assertEquals(1, deque.getSize());
	}

}
