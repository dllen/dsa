package das.doubleendedqueue;

import das.doublelinkedlist.DLNode;
import dsa.queue.ExceptionQueueEmpty;

public class DequeDLNode implements Deque {

	protected DLNode header;

	protected DLNode tail;

	protected int size;

	public DequeDLNode() {
		header = new DLNode();
		tail = new DLNode();
		header.setNext(tail);
		tail.setPrev(header);
		size = 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Object first() throws ExceptionQueueEmpty {
		if (isEmpty())
			throw new ExceptionQueueEmpty("empty");
		return header.getNext().getElem();
	}

	@Override
	public Object last() throws ExceptionQueueEmpty {
		if (isEmpty())
			throw new ExceptionQueueEmpty("empty");
		return tail.getPrev().getElem();
	}

	@Override
	public void insertFirst(Object o) {
		DLNode second = header.getNext();
		DLNode first = new DLNode(o, header, second);
		second.setPrev(first);
		header.setNext(first);
		size++;
	}

	@Override
	public void insertLast(Object o) {
		DLNode second = tail.getPrev();
		DLNode last = new DLNode(o, second, tail);
		second.setNext(last);
		last.setNext(tail);
		size++;
	}

	@Override
	public Object removeFirst() throws ExceptionQueueEmpty {
		if (isEmpty())
			throw new ExceptionQueueEmpty("empty");
		DLNode first = header.getNext();
		DLNode second = first.getNext();
		header.setNext(second);
		second.setPrev(header);
		size--;
		return first.getElem();
	}

	@Override
	public Object removeLast() throws ExceptionQueueEmpty {
		if (isEmpty())
			throw new ExceptionQueueEmpty("empty");
		DLNode last = tail.getPrev();
		DLNode second = last.getPrev();
		tail.setPrev(second);
		second.setNext(tail);
		size--;
		return last.getElem();
	}

	@Override
	public void travsersal() {
		DLNode p = header.getNext();
		while (p != null) {
			System.out.println(p.getElem() + " ");
			p = p.getNext();
		}
	}

}
