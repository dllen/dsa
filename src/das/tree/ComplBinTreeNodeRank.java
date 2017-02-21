package das.tree;

import das.vector.Vector;

public class ComplBinTreeNodeRank extends BinTreeNode implements BinTreePosition {

	private Vector vector;
	private int rank;
	private Object element;

	public ComplBinTreeNodeRank(Vector vector, Object object) {
		this.vector = vector;
		this.element = object;
		rank = this.vector.getSize();
		vector.insertAtRank(rank, this);
	}

	@Override
	public Object getElem() {
		return this.element;
	}

	@Override
	public Object setElem(Object object) {
		Object bak = this.element;
		this.element = object;
		return bak;
	}

	@Override
	public boolean hasParent() {
		return 0 != rank;
	}

	@Override
	public BinTreePosition getParent() {
		return hasParent() ? (BinTreePosition) vector.getAtRank((rank - 1) / 2) : null;
	}

	@Override
	public boolean hasLChild() {
		return (2 + rank * 2 < vector.getSize());
	}

	@Override
	public BinTreePosition getLChild() {
		return hasLChild() ? (BinTreePosition) (vector.getAtRank(1 + rank * 2)) : null;
	}

	@Override
	public boolean hasRChild() {
		return (2 + rank * 2 < vector.getSize());
	}

	@Override
	public BinTreePosition getRChild() {
		return hasRChild() ? (BinTreePosition) (vector.getAtRank(2 + rank * 2)) : null;
	}

	@Override
	public int getSize() {
		int size = 1;
		if (hasLChild())
			size += getLChild().getSize();
		if (hasRChild())
			size += getRChild().getSize();
		return size;
	}

	@Override
	public int getHeight() {
		int hL = hasLChild() ? getLChild().getHeight() : -1;
		int hR = hasRChild() ? getRChild().getHeight() : -1;
		return 1 + Math.max(hL, hR);
	}

	@Override
	public int getDepth() {
		return hasParent() ? 1 + getParent().getDepth() : 0;
	}
}
