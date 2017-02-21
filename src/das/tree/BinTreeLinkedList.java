package das.tree;

import das.list.Iterator;

public class BinTreeLinkedList implements BinTree {

	protected BinTreePosition root;

	public BinTreeLinkedList(BinTreePosition r) {
		root = r;
	}

	public BinTreeLinkedList() {
		this(null);
	}

	@Override
	public BinTreePosition getRoot() {
		return root;
	}

	@Override
	public boolean isEmpty() {
		return null == root;
	}

	@Override
	public int getSize() {
		return isEmpty() ? 0 : root.getSize();
	}

	@Override
	public int getHeight() {
		return isEmpty() ? -1 : root.getHeight();
	}

	@Override
	public Iterator elementsPreorder() {
		return root.elementsPreorder();
	}

	@Override
	public Iterator elementsInorder() {
		return root.elementsInorder();
	}

	@Override
	public Iterator elementsPostorder() {
		return root.elementsPostorder();
	}

	@Override
	public Iterator elementsLevelorder() {
		return root.elementsLevelorder();
	}

}
