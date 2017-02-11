package dsa.sequence;

import das.doublelinkedlist.DLNode;
import das.linkedlist.Position;
import das.list.ExceptionPositionInvalid;
import das.list.ListDLNode;
import das.vector.ExceptionBoundaryViolation;

public class SequenceDLNode extends ListDLNode implements Sequence {

	protected void checkRank(int r, int n) throws ExceptionBoundaryViolation {
		if (r < 0 || r >= n)
			throw new ExceptionBoundaryViolation("error");
	}

	@Override
	public Object getAtRank(int r) throws ExceptionBoundaryViolation {
		checkRank(r, getSize());
		return rank2Pos(r).getElem();
	}

	@Override
	public Object replaceAtRank(int r, Object o) throws ExceptionBoundaryViolation {
		checkRank(r, getSize());
		return replace(rank2Pos(r), o);
	}

	@Override
	public Object insertAtRank(int r, Object o) throws ExceptionBoundaryViolation {
		checkRank(r, getSize() + 1);
		if (getSize() == r)
			insertLast(o);
		else
			insertBefore(rank2Pos(r), o);
		return o;
	}

	@Override
	public Object removeAtRank(int r) throws ExceptionBoundaryViolation {
		checkRank(r, getSize());
		return remove(rank2Pos(r));
	}

	@Override
	public Position rank2Pos(int r) throws ExceptionBoundaryViolation {
		DLNode node;
		checkRank(r, getSize());
		if (r <= getSize() / 2) {
			node = header.getNext();
			for (int i = 0; i < r; i++) {
				node = node.getNext();
			}
		} else {
			node = trailer.getPrev();
			for (int i = 1; i < getSize() - r; i++) {
				node = node.getPrev();
			}
		}
		return node;
	}

	@Override
	public int pos2Rank(Position p) throws ExceptionPositionInvalid {
		DLNode node = header.getNext();
		int r = 0;
		while (node != trailer) {
			if (node == p)
				return r;
			node = node.getNext();
			r++;
		}
		throw new ExceptionPositionInvalid("error");
	}

}
