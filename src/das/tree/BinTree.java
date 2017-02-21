package das.tree;

import das.list.Iterator;

/**
 * 
 * @author shichaopeng 操作方法
 * 
 *         功能描述 getElement(): 返回存放当前节点处的对象 输入:无 输出:对象 setElement(e): 将对象 e
 *         存入当前节点，并返回其中此前所存的内容 输入:一个对象 输出:对象 getParent(): 返回当前节点的父节点 输入:无 输出:树节点
 *         getLChild(): 返回当前节点的左孩子 输入:无 输出:二叉树节点 getRChild(): 返回当前节点的右孩子 输入:无
 *         输出:二叉树节点
 */
public interface BinTree {

	public BinTreePosition getRoot();

	public boolean isEmpty();

	public int getSize();

	public int getHeight();

	public Iterator elementsPreorder();

	public Iterator elementsInorder();

	public Iterator elementsPostorder();

	public Iterator elementsLevelorder();

}
