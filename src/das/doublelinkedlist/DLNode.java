package das.doublelinkedlist;

import das.linkedlist.Position;

public class DLNode implements Position {

	private Object element;

	private DLNode prev;

	private DLNode next;

	public DLNode() {
		this(null, null, null);
	}

	public DLNode(Object e, DLNode p, DLNode n) {
		this.element = e;
		this.prev = p;
		this.next = n;
	}

	@Override
	public Object getElem() {
		return element;
	}

	@Override
	public Object setElem(Object object) {
		Object old = element;
		element = object;
		return old;
	}

	public DLNode getPrev() {
		return prev;
	}

	public void setPrev(DLNode prev) {
		this.prev = prev;
	}

	public DLNode getNext() {
		return next;
	}

	public void setNext(DLNode next) {
		this.next = next;
	}

}
