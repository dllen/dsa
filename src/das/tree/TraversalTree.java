package das.tree;

import dsa.queue.Queue;
import dsa.queue.QueueArray;

public class TraversalTree {

	/**
	 * 对任一(子)树的前序遍历，将首先访问其根节点，然后再递归地对其下的各棵子树进行前序
	 * 遍历。对于同一根节点下的各棵子树，遍历的次序通常是任意的;但若换成有序树，则可以按照兄
	 * 弟间相应的次序对它们实施遍历。由前序遍历生成的节点序列，称作前序遍历序列。
	 * 
	 * @param v
	 */
	public void PreorderTraversal(TreeLinkedList v) {
		if (null == v)
			return;
		for (TreeLinkedList u = v.getFirstChild(); null != u; u = u.getNextSibling()) {
			System.out.println(u.getElem());
			PostorderTraversal(u);
		}
	}

	/**
	 * 对称地，对任一(子)树的后序遍历将首先递归地对根节点下的各棵子树进行后序遍历，最后 才访问根节点。由后序遍历生成的节点序列，称作后序遍历序列。
	 * 
	 * @param v
	 */
	public void PostorderTraversal(TreeLinkedList v) {
		if (null == v)
			return;
		for (TreeLinkedList u = v.getFirstChild(); null != u; u = u.getNextSibling()) {
			System.out.println(u.getElem());
			PostorderTraversal(u);
		}
	}

	public void LevelorderTraversal(TreeLinkedList v) {
		if (null == v)
			return;
		Queue queue = new QueueArray();
		queue.enqueue(v);
		while (!queue.isEmpty()) {
			TreeLinkedList u = (TreeLinkedList) queue.dequeue();
			for (TreeLinkedList w = u.getFirstChild(); null != w; w = w.getNextSibling()) {
				System.out.println(w.getElem());
				queue.enqueue(w);
			}
		}
	}

}
