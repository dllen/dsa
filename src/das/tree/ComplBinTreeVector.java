package das.tree;

import das.vector.Vector;
import das.vector.VectorExtArray;
import dsa.sequence.Sequence;

/**
 * 在完全二叉树中， 若节点v有左孩子，则i(lchild(v)) = 若节点 v 有右孩子，则 i(rchild(v)) = 若节点 v 有父节点，则
 * i(parent(v)) = 2×i(v)+1; 2 ×i(v) + 2; ⎣(i(v) - 1)/2⎦ = ⎡(i(v)/2⎤ - 1。
 * 
 * 若将节点v的这种编号记作i(v)，则根节点的编号i(root) = 0，i(lchild(root)) = 1，i(rchild(root)) = 2，
 * i(lchild(lchild(root)) = 3 ，...。
 * 
 * @author shichaopeng
 *
 */
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
