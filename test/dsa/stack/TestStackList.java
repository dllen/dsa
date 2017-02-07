package dsa.stack;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import dsa.stack.StackList;

public class TestStackList {

	StackList stackList;

	@Before
	public void init() {
		stackList = new StackList();
		stackList.push(1);
		stackList.push(2);
		stackList.push(3);
		stackList.push(4);
		stackList.push(5);
	}

	@Test
	public void testTop() {
		assertEquals(5, stackList.pop());
	}
	
	@Test
	public void testPop() {
		assertEquals(5, stackList.pop());
		assertEquals(4, stackList.top());
	}

}
