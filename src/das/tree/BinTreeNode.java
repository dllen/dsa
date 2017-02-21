package das.tree;

import das.linkedlist.QueueLinkedList;
import das.list.Iterator;
import das.list.List;
import das.list.ListDLNode;

public class BinTreeNode implements BinTreePosition {

	protected Object element;

	protected BinTreePosition parent;

	protected BinTreePosition lChild;

	protected BinTreePosition rChild;

	protected int size;
	protected int height;
	protected int depth;

	public BinTreeNode() {
		this(null, null, true, null, null);
	}

	public BinTreeNode(Object e, // 节点内容
			BinTreePosition p, // 父节点
			boolean asLChild, // 是否作为父节点的左孩子
			BinTreePosition l, // 左孩子
			BinTreePosition r// 右孩子
	) {
		size = 1;
		height = depth = 0;
		parent = lChild = rChild = null;
		element = e;
		if (null != p)
			if (asLChild)
				p.attachL(this);
			else
				p.attachR(this);

		if (null != l)
			attachL(l);
		if (null != r)
			attachR(r);
	}

	@Override
	public Object getElem() {
		return element;
	}

	@Override
	public Object setElem(Object object) {
		Object old = element;
		element = object;
		return old;
	}

	@Override
	public boolean hasParent() {
		return null != parent;
	}

	@Override
	public BinTreePosition getParent() {
		return parent;
	}

	@Override
	public void setParent(BinTreePosition p) {
		parent = p;
	}

	@Override
	public boolean isLeaf() {
		return !hasRChild() && !hasLChild();
	}

	@Override
	public boolean isLChild() {
		return (hasParent() && this == getParent().getLChild());
	}

	@Override
	public BinTreePosition getLChild() {
		return lChild;
	}

	@Override
	public void setLChild(BinTreePosition c) {
		lChild = c;
	}

	@Override
	public boolean hasLChild() {
		return null != lChild;
	}

	@Override
	public boolean isRChild() {
		return (hasParent() && this == parent.getRChild());
	}

	@Override
	public boolean hasRChild() {
		return null != rChild;
	}

	@Override
	public BinTreePosition getRChild() {
		return rChild;
	}

	@Override
	public void setRChild(BinTreePosition p) {
		rChild = p;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void updateSize() {
		size = 1;
		if (hasLChild())
			size += getLChild().getSize();
		if (hasRChild())
			size += getRChild().getSize();
		if (hasParent())
			getParent().updateSize();
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void updateHeight() {
		height = 0;
		if (hasLChild())
			height = Math.max(height, 1 + getLChild().getHeight());
		if (hasRChild())
			height = Math.max(height, 1 + getRChild().getHeight());
		if (hasParent())
			getParent().updateHeight();
	}

	@Override
	public int getDepth() {
		return depth;
	}

	@Override
	public void updateDepth() {
		depth = hasParent() ? 1 + getParent().getDepth() : 0;
		if (hasLChild())
			getLChild().updateDepth();
		if (hasRChild())
			getRChild().updateDepth();
	}

	@Override
	public BinTreePosition secede() {
		if (null != parent) {
			if (isLChild())
				parent.setLChild(null);
			else
				parent.setRChild(null);
			parent.updateSize();
			parent.updateHeight();
			parent = null;
			updateDepth();
		}
		return this;
	}

	@Override
	public BinTreePosition attachL(BinTreePosition c) {
		if (hasLChild())
			getLChild().secede();
		if (null != c) {
			c.secede();
			lChild = c;
			c.setParent(this);
			updateSize();
			updateHeight();

			c.updateDepth();
		}
		return this;
	}

	@Override
	public BinTreePosition attachR(BinTreePosition c) {
		if (hasRChild())
			getRChild().secede();
		if (null != c) {
			c.secede();
			rChild = c;
			c.setParent(this);
			updateSize();
			updateHeight();
			c.updateDepth();
		}
		return this;
	}

	@Override
	public Iterator elementsPreorder() {
		List list = new ListDLNode();
		preorder(list, this);
		return list.elements();
	}

	@Override
	public Iterator elementsInorder() {
		List list = new ListDLNode();
		inorder(list, this);
		return list.elements();
	}

	@Override
	public Iterator elementsPostorder() {
		List list = new ListDLNode();
		postorder(list, this);
		return list.elements();
	}

	@Override
	public Iterator elementsLevelorder() {
		List list = new ListDLNode();
		levelorder(list, this);
		return list.elements();
	}

	protected static BinTreePosition findMinDescendant(BinTreePosition v) {
		if (null != v)
			while (v.hasLChild())
				v = v.getLChild();
		return v;
	}

	protected static BinTreePosition findMaxDescendant(BinTreePosition v) {
		if (null != v)
			while (v.hasRChild())
				v = v.getRChild();
		return v;
	}

	protected static void preorder(List list, BinTreePosition binTreePosition) {
		if (null == binTreePosition)
			return;
		list.insertLast(binTreePosition);
		preorder(list, binTreePosition.getLChild());
		preorder(list, binTreePosition.getRChild());
	}

	protected static void inorder(List list, BinTreePosition binTreePosition) {
		if (null == binTreePosition)
			return;
		inorder(list, binTreePosition.getLChild());
		list.insertLast(binTreePosition);
		inorder(list, binTreePosition.getRChild());
	}

	protected static void postorder(List list, BinTreePosition binTreePosition) {
		if (null == binTreePosition)
			return;
		postorder(list, binTreePosition.getLChild());
		postorder(list, binTreePosition.getRChild());
		list.insertLast(binTreePosition);
	}

	protected static void levelorder(List list, BinTreePosition binTreePosition) {
		QueueLinkedList queueLinkedList = new QueueLinkedList();
		queueLinkedList.enqueue(binTreePosition);
		while (!queueLinkedList.isEmpty()) {
			BinTreePosition temp = (BinTreePosition) queueLinkedList.dequeue();
			list.insertLast(temp);
			if (temp.hasLChild())
				queueLinkedList.enqueue(temp.getLChild());
			if (temp.hasRChild())
				queueLinkedList.enqueue(temp.getRChild());
		}
	}
}
