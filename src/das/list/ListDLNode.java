package das.list;

import das.doublelinkedlist.DLNode;
import das.linkedlist.Position;
import das.vector.ExceptionBoundaryViolation;

public class ListDLNode implements List {

	protected int numElem;

	protected DLNode header, trailer;

	public ListDLNode() {
		numElem = 0;
		header = new DLNode();
		trailer = new DLNode();
		header.setNext(trailer);
	}

	// 检查给定位置在列表中是否合法，若是，则将其转换为*DLNode
	protected DLNode checkPosition(Position p) throws ExceptionPositionInvalid {
		if (null == p)
			throw new ExceptionPositionInvalid("意外:传递给ListDLNode的位置是null");
		if (header == p)
			throw new ExceptionPositionInvalid("意外:头节点哨兵位置非法");
		if (trailer == p)
			throw new ExceptionPositionInvalid("意外:尾结点哨兵位置非法");
		DLNode temp = (DLNode) p;
		return temp;
	}

	@Override
	public int getSize() {
		return numElem;
	}

	@Override
	public boolean isEmpty() {
		return 0 == numElem;
	}

	@Override
	public Position first() {
		if (isEmpty())
			throw new ExceptionListEmpty("empty");
		return header.getNext();
	}

	@Override
	public Position last() {
		if (isEmpty())
			throw new ExceptionListEmpty("empty");
		return trailer.getPrev();
	}

	@Override
	public Position getNext(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
		DLNode v = checkPosition(p);
		DLNode next = v.getNext();
		if (next == trailer) {
			throw new ExceptionBoundaryViolation("error");
		}
		return next;
	}

	@Override
	public Position getPrev(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
		DLNode v = checkPosition(p);
		DLNode prev = v.getPrev();
		if (prev == header)
			throw new ExceptionBoundaryViolation("error");
		return prev;
	}

	@Override
	public Position insertFirst(Object e) {
		DLNode first = header.getNext();
		DLNode node = new DLNode(e, header, first);
		header.setNext(node);
		first.setPrev(node);
		numElem++;
		return node;
	}

	@Override
	public Position insertLast(Object e) {
		DLNode last = trailer.getPrev();
		DLNode node = new DLNode(e, last, trailer);
		last.setNext(node);
		trailer.setPrev(node);
		numElem++;
		return node;
	}

	@Override
	public Position insertAfter(Position p, Object e) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		DLNode node = new DLNode(e, v, v.getNext());
		v.getNext().setPrev(node);
		v.setNext(node);
		numElem++;
		return node;
	}

	@Override
	public Position insertBefore(Position p, Object e) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		DLNode node = new DLNode(e, v.getPrev(), v);
		v.getPrev().setNext(node);
		v.setPrev(node);
		numElem++;
		return null;
	}

	@Override
	public Object remove(Position p) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		DLNode prev = v.getPrev();
		DLNode next = v.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		v.setNext(null);
		v.setPrev(null);
		numElem--;
		return v.getElem();
	}

	@Override
	public Object removeFirst() {
		return remove(header.getNext());
	}

	@Override
	public Object removeLast() {
		return remove(trailer.getPrev());
	}

	@Override
	public Object replace(Position p, Object e) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		Object old = v.getElem();
		v.setElem(e);
		return old;
	}

	@Override
	public Iterator positions() {
		return new IteratorPosition(this);
	}

	@Override
	public Iterator elements() {
		return new IteratorElement(this);
	}

}
