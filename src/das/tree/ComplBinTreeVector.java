package das.tree;

import das.vector.Vector;
import das.vector.VectorExtArray;
import dsa.sequence.Sequence;

public class ComplBinTreeVector extends BinTreeLinkedList implements ComplBinTree {

	private Vector vector;

	public ComplBinTreeVector() {
		vector = new VectorExtArray();
		root = null;
	}

	public ComplBinTreeVector(Sequence sequence) {
		this();
		if (null != sequence)
			while (!sequence.isEmpty()) {
				addLast(sequence.removeFirst());
			}
	}

	@Override
	public BinTreePosition getRoot() {
		return vector.isEmpty() ? null : posOfNode(0);
	}

	@Override
	public boolean isEmpty() {
		return vector.isEmpty();
	}

	@Override
	public int getSize() {
		return vector.getSize();
	}

	@Override
	public int getHeight() {
		return isEmpty() ? -1 : getRoot().getHeight();
	}

	@Override
	public BinTreePosition addLast(Object e) {
		BinTreePosition node = new ComplBinTreeNodeRank(vector, e);
		root = (BinTreePosition) vector.getAtRank(0);
		return node;
	}

	@Override
	public Object delLast() {
		if (isEmpty())
			return null;
		if (1 == getSize())
			root = null;
		return vector.removeAtRank(vector.getSize() - 1);
	}

	@Override
	public BinTreePosition posOfNode(int i) {
		return (BinTreePosition) vector.getAtRank(i);
	}

}
