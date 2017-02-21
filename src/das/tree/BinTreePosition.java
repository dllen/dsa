package das.tree;

import das.linkedlist.Position;
import das.list.Iterator;

public interface BinTreePosition extends Position {

	public boolean hasParent();

	public BinTreePosition getParent();

	public void setParent(BinTreePosition p);

	public boolean isLeaf();

	public boolean isLChild();

	public boolean hasLChild();
	
	public BinTreePosition getLChild();

	public void setLChild(BinTreePosition c);

	public boolean isRChild();

	public boolean hasRChild();

	public BinTreePosition getRChild();

	public void setRChild(BinTreePosition p);

	public int getSize();

	// 在孩子发生变化后，更新当前节点及其祖先的规模
	public void updateSize();

	public int getHeight();

	// 在孩子发生变化后，更新当前节点及其祖先的高度
	public void updateHeight();

	public int getDepth();

	// 在父亲发生变化后，更新当前节点及其后代的深度
	public void updateDepth();

	// 按照中序遍历的次序，找到当前节点的直接前驱 public BinTreePosition getPrev();
	// 按照中序遍历的次序，找到当前节点的直接后继 public BinTreePosition getSucc();
	// 断绝当前节点与其父亲的父子关系 //返回当前节点
	public BinTreePosition secede();

	// 将节点c作为当前节点的左孩子
	public BinTreePosition attachL(BinTreePosition c);

	// 将节点c作为当前节点的右孩子
	public BinTreePosition attachR(BinTreePosition c);

	// 前序遍历
	public Iterator elementsPreorder();

	// 中序遍历
	public Iterator elementsInorder();

	// 后序遍历
	public Iterator elementsPostorder();

	// 层次遍历
	public Iterator elementsLevelorder();

}
