package das.list;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import das.doublelinkedlist.DLNode;

public class TestList {

	List list;

	@Before
	public void init() {
		list = new ListDLNode();
	}

	@Test
	public void testInsert() {
		list.insertFirst(1);
		list.insertLast(2);
		assertEquals(1, list.first().getElem());
		assertEquals(2, list.last().getElem());
		list.insertAfter(list.first(), 3);
		DLNode first = (DLNode) list.first();
		assertEquals(3, first.getNext().getElem());
		list.insertBefore(list.first(), 4);
		assertEquals(4, list.first().getElem());
	}

	@Test
	public void testRemoveReplace() {
		list.insertFirst(1);
		list.insertLast(2);
		list.removeFirst();
		assertEquals(2, list.first().getElem());
		assertEquals(2, list.last().getElem());
		
		list.insertFirst(1);
		list.insertFirst(0);
		DLNode first = (DLNode) list.first();
		list.remove(first.getNext());
		
		assertEquals(2, first.getNext().getElem());
		assertEquals(2, list.removeLast());
		assertEquals(0, list.last().getElem());
	}
	
	@Test
	public void testIterator(){
		list.insertFirst(1);
		list.insertLast(2);
		list.insertFirst(10);
		list.insertLast(100);
		Iterator iterator = list.elements();
		while (iterator.hasNext()) {
			System.out.println(iterator.getNext());
		}
		
		iterator = list.positions();
		while (iterator.hasNext()) {
			System.out.println(iterator.getNext());
		}
	}

}
