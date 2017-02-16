package das.tree;

import das.linkedlist.Position;
import das.linkedlist.QueueLinkedList;
import das.list.ExceptionNoSuchElement;
import das.list.Iterator;
import das.list.List;
import das.list.ListDLNode;
import dsa.queue.Queue;

public class IteratorTree implements Iterator {

	private List list;

	private Position nextPosition;

	public IteratorTree() {
		list = new ListDLNode();
	}

	public void initIterator() {
		nextPosition = list.first();
	}

	@Override
	public boolean hasNext() {
		return null != nextPosition;
	}

	@Override
	public Object getNext() {
		if (!hasNext())
			throw new ExceptionNoSuchElement("No next position");
		Position currentPosition = nextPosition;
		if (currentPosition == list.last())// 若已到达尾元素，则
			nextPosition = null;// 不再有下一元素
		else// 否则
			nextPosition = list.getNext(currentPosition);// 转向下一元素
		return currentPosition.getElem();
	}

	// 前序遍历
	public void elementsPreorderIterator(TreeLinkedList T) {
		if (null == T)
			return;// 递归基
		list.insertLast(T);// 首先输出当前节点
		TreeLinkedList subtree = T.getFirstChild();// 从当前节点的长子开始
		while (null != subtree) {// 依次对当前节点的各个孩子
			this.elementsPreorderIterator(subtree);// 做前序遍历
			subtree = subtree.getNextSibling();
		}

	}

	// 后序遍历
	public void elementsPostorderIterator(TreeLinkedList T) {
		if (null == T)
			return;// 递归基
		TreeLinkedList subtree = T.getFirstChild();// 从当前节点的长子开始
		while (null != subtree) {// 依次对当前节点的各个孩子
			this.elementsPostorderIterator(subtree);// 做后序遍历
			subtree = subtree.getNextSibling();
		}
		list.insertLast(T);// 当所有后代都访问过后，最后才访问当前节点
	}

	// 层次遍历
	public void levelTraversalIterator(TreeLinkedList T) {
		if (null == T)
			return;
		Queue queue = new QueueLinkedList();// 空队
		queue.enqueue(T);// 根节点入队
		while (!queue.isEmpty()) {// 在队列重新变空之前
			TreeLinkedList tree = (TreeLinkedList) (queue.dequeue());// 取出队列首节点
			list.insertLast(tree);// 将新出队的节点接入迭代器中
			TreeLinkedList subtree = tree.getFirstChild();// 从tree的第一个孩子起
			while (null != subtree) {// 依次找出所有孩子，并
				queue.enqueue(subtree);// 将其加至队列中
				subtree = subtree.getNextSibling();
			}

		}
	}

}
