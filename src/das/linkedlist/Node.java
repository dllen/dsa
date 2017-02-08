package das.linkedlist;

public class Node implements Position {

	private Object element;

	private Node next;

	public Node() {
		this(null, null);
	}

	public Node(Object e, Node n) {
		element = e;
		next = n;
	}

	@Override
	public Object getElem() {
		return element;
	}

	@Override
	public Object setElem(Object object) {
		Object old = this.element;
		this.element = object;
		return old;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
