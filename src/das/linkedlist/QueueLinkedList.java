package das.linkedlist;

import dsa.queue.ExceptionQueueEmpty;
import dsa.queue.ExceptionQueueFull;
import dsa.queue.Queue;

public class QueueLinkedList implements Queue {

	protected Node head;

	protected Node tail;

	protected int size;

	public QueueLinkedList() {
		head = tail = null;
		size = 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return 0 == size;
	}

	@Override
	public Object front() throws ExceptionQueueEmpty {
		if (isEmpty())
			throw new ExceptionQueueEmpty("empty");
		return head.getElem();
	}

	@Override
	public void enqueue(Object object) throws ExceptionQueueFull {
		Node node = new Node(object, null);
		if (0 == size) {
			head = node;
		} else {
			tail.setNext(node);
		}
		tail = node;
		size++;
	}

	@Override
	public Object dequeue() throws ExceptionQueueEmpty {
		if (0 == size)
			throw new ExceptionQueueEmpty("empty");
		Object object = head.getElem();
		head = head.getNext();
		size--;
		if (0 == size)
			tail = null;
		return object;
	}

	@Override
	public void traversal() {
		Node p = head;
		while (p != null) {
			System.out.println(p.getElem() + " ");
			p = p.getNext();
		}
	}

}
