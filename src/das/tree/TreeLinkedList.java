package das.tree;

public class TreeLinkedList implements Tree {

	private Object element;
	private TreeLinkedList parent, firstChild, nextSibling;// 父亲、长子及最大的弟弟

	public TreeLinkedList() {
		this(null, null, null, null);
	}

	public TreeLinkedList(Object element, TreeLinkedList parent, TreeLinkedList firstChild,
			TreeLinkedList nextSibling) {
		this.element = element;
		this.parent = parent;
		this.firstChild = firstChild;
		this.nextSibling = nextSibling;
	}

	public void setParent(TreeLinkedList parent) {
		this.parent = parent;
	}

	public void setFirstChild(TreeLinkedList firstChild) {
		this.firstChild = firstChild;
	}

	public void setNextSibling(TreeLinkedList nextSibling) {
		this.nextSibling = nextSibling;
	}

	@Override
	public Object getElem() {
		return element;
	}

	@Override
	public Object setElem(Object obj) {
		Object bak = element;
		element = obj;
		return bak;
	}

	@Override
	public TreeLinkedList getParent() {
		return parent;
	}

	@Override
	public TreeLinkedList getFirstChild() {
		return firstChild;
	}

	@Override
	public TreeLinkedList getNextSibling() {
		return nextSibling;
	}

	@Override
	public int getSize() {
		int size = 1;
		TreeLinkedList subtree = firstChild;
		while (null != subtree) {
			size += subtree.getSize();
			subtree = subtree.getNextSibling();
		}
		return size;
	}

	@Override
	public int getHeight() {
		int height = -1;
		TreeLinkedList subtree = firstChild;
		while (null != subtree) {
			height = Math.max(height, subtree.getHeight());
			subtree = subtree.getNextSibling();
		}
		return height;
	}

	@Override
	public int getDepth() {
		int depth = 0;
		TreeLinkedList p = parent;
		while (null != p) {
			depth++;
			p = p.getParent();
		}
		return depth;
	}

}
