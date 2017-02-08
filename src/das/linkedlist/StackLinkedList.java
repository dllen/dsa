package das.linkedlist;

import dsa.stack.ExceptionStackEmpty;
import dsa.stack.Stack;

public class StackLinkedList implements Stack {

	protected Node top;

	protected int size;

	public StackLinkedList() {
		top = null;
		size = 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public Object top() throws ExceptionStackEmpty {
		if (isEmpty())
			throw new ExceptionStackEmpty("empty");
		return top.getElem();
	}

	@Override
	public void push(Object e) {
		Node node = new Node(e, top);
		top = node;
		size++;
	}

	@Override
	public Object pop() throws ExceptionStackEmpty {
		if (isEmpty())
			throw new ExceptionStackEmpty("empty");
		Object temp = top.getElem();
		top = top.getNext();
		size--;
		return temp;
	}

}
