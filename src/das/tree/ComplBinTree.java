package das.tree;

public interface ComplBinTree extends BinTree {

	public BinTreePosition addLast(Object e);

	public Object delLast();

	// 返回按照层次遍历编号为i的节点的位置，0 <= i < size()
	public BinTreePosition posOfNode(int i);

}
