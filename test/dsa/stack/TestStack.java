package dsa.stack;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

import dsa.stack.Stack;
import dsa.stack.StackArray;
import dsa.stack.StackExample;

public class TestStack {

	Stack stack;

	@Before
	public void init() {
		stack = new StackArray();
		stack.push(1);
		stack.push(2);
		stack.push(3);
	}

	@Test
	public void testPush() {
		stack.push(4);
		assertEquals(4, stack.top());
	}

	@Test
	public void testPop() {
		assertEquals(3, stack.pop());
		assertEquals(2, stack.pop());
	}

	@Test
	public void testReverse() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] b = new int[a.length];
		Stack s = new StackArray(a.length);
		for (int i = 0; i < a.length; i++)
			s.push(a[i]);
		for (int i = 0; i < b.length; i++)
			b[i] = (int) s.pop();
		assertArrayEquals(new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 }, b);
	}
	
	@Test
	public void testMatch1() {
		assertFalse(StackExample.match1("{(}"));
		assertTrue(StackExample.match1("{}"));
	}

}
