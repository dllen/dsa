package das.tree;

/**
 * 
 * @author shichaopeng 
 *         getElement(): 返回存放于当前节点处的对象 输入:无 输出:对象 
 *         setElement(e): 将对象 e 存入当前节点，并返回其中此前所存的内容 输入:一个对象 输出:对象 
 *         getParent(): 返回当前节点的父节点 输入:无 输出:树节点 
 *         getFirstChild(): 返回当前节点的长子 输入:无 输出:树节点 
 *         getNextSibling():返回当前节点的最大弟弟 输入:无 输出:树节点
 */
public interface Tree {

	//返回当前节点中存放的对象
	public Object getElem();
	
	//将对象obj存入当前节点，并返回此前的内容
	public Object setElem(Object obj);
	
	//返回当前节点的父节点
	public TreeLinkedList getParent();
	
	//返回当前节点的长子
	public TreeLinkedList getFirstChild();
	
	//返回当前节点的最大弟弟
	public TreeLinkedList getNextSibling();
	
	//返回当前节点后代元素的数目，即以当前节点为根的子树的规模
	public int getSize();
	
	//返回当前节点的高度
	public int getHeight();
	
	//返回当前节点的深度
	public int getDepth();
}
/**
 * 1 在树结构中， 每个节点的深度都是一个非负整数; 深度为0的节点有且仅有一个，称作树根(Root); 对于深度为 k (k≥1)的每个节点
 * u，都有且仅有一个深度为 k-1 的节点 v 与之对应，称作 u 的父 亲(Parent)或父节点。
 * 
 * 2 若节点v是节点u的父亲，则u称作v的孩子(Child)，并在二者之间建立一条树边(Edge)。
 * 
 * 3 树中所有节点的最大深度，称作树的深度或高度。
 * 
 * 4 任一节点的孩子数目，称作它的“度”(Degree)。
 * 
 * 5 至少拥有一个孩子的节点称作“内部节点”(Internal node);没有任何孩子的节点则称作 “外部节点”(External
 * node)或“叶子”(Leaf)。
 * 
 * 6 由树中 k+1 节点通过树边首尾衔接而构成的序列{ (v0, v1), (v1, v2), ..., (vk-1, vk) | k ≥ 0}，称
 * 作树中长度为 k 的一条路径(Path)。
 * 
 * 7 0. 每个节点都是自己的“祖先”(Ancestor)，也是自己的“后代”(Descendent); 1. 若v是u的父节点的祖先，则v也是u的祖先;
 * 2. 若u的父节点是v的后代，则u也是v的后代。
 * 
 * 8 除节点本身以外的祖先(后代)，称作真祖先(后代)。
 * 
 * 9 树 T 中每一节点 v 的所有后代也构成一棵树，称作 T 的“以 v 为根的子树(Subtree)”。
 * 
 * 10 若子树 v 的深度(高度)为 h，则称 v 的高度为 h，记作 height(v) = h。
 * 
 * 11 在树 T 中，若节点 u 和 v 都是节点 a 的后代，则称节点 a 为节点 u 和 v 的共同祖先(Common ancestor)。
 * 
 * 12 在一对节点 u 和 v 的所有共同祖先中，深度最大者称为它们的最低共同祖先(Lowerest common ancestor)，记作 lca(u,
 * v)。
 * 
 * 13 在树 T 中，若在每个节点的所有孩子之间都可以定义某一线性次序，则称 T 为一棵“有 序树(Ordered tree)”。
 * 
 * 14 每个内部节点均为 m 度的有序树，称作 m 叉树。
 * 
 * 15 每个节点均不超过 2 度的有序树，称作二叉树(Binary tree)。
 * 
 * 16 不含 1 度节点的二叉树，称作真二叉树(Proper bina ry tree )，否则称作非真二叉树 (Improper binary
 * tree)。
 * 
 * 17 若二叉树 T 中所有叶子的深度完全相同，则称之为满二叉树(Full binary tree)。
 * 
 * 18 若在一棵满二叉树中，从最右侧起将相邻的若干匹叶子节点摘除掉，则得到的二叉树称 作完全二叉树(Complete binary tree)。
 */
/**
 * 1 树中节点的数目，总是等于边数加一。
 * 
 * 2 树中任何两个节点之间都存在唯一的一条路径。
 * 
 * 3 若v是u的父亲，则depth(v)+1=depth(u)。
 * 
 * 4 任一节点v的深度，等于其真祖先的数目。
 * 
 * 5 任一节点v的祖先，在每一深度上最多只有一个。
 * 
 * 6 对于叶子节点u的任何祖先v，必有depth(v)+height(v)≥depth(u)。
 * 
 * 7 每一对节点至少存在一个共同祖先。
 * 
 * 8 每一对节点的最低共同祖先必存在且唯一。
 * 
 * 9 在二叉树中，深度为k的节点不超过2k个。
 * 
 * 10 在二叉树中，叶子总是比 2 度节点多一个。
 * 
 * 11 高度为 h 的二叉树是满的，当且仅当它拥有 2h 匹叶子、2h+1-1 个节点。
 * 
 * 12 一棵树的规模，等于根节点下所有子树规模之和再加一，也等于根节点的后代总数。getSize()
 */

/**
 * 1 从树根通往任一节点的路径长度，恰好等于该节点的深度。
 * 
 * 2 高度为 h 的二叉树最多包含 2h+1-1 个节点。
 * 
 * 3 由 n 个节点构成的二叉树，高度至少为⎣log2n⎦。
 * 
 * 4 在由固定数目的节点所组成的所有二叉树中，完全二叉树的高度最低。
 * 
 * 5 若 u 是 v 的孩子，则 height(v) ≥ height(u) + 1; height(v) = 1 + max height(u) 。 u是v的孩子 getHeight
 * 
 * 6 若 u 是 v 的孩子，则 depth(u) = depth(v) + 1。 getDepth()
 */

/**
 * 1 由 n 个节点构成的完全二叉树，高度 h = ⎣log2n⎦。
 */
