package dsa.sequence;

import das.linkedlist.Position;
import das.list.ExceptionPositionInvalid;
import das.list.List;
import das.vector.ExceptionBoundaryViolation;
import das.vector.Vector;

/**
 * 
 * @author shichaopeng 操作方法
 * 
 *         功能描述 
 *         rank2Pos(r): 若 0 ≤ r < getSize()，则返回秩为 r 的元素所在的位置;否则，报错
 *         输入:一个(作为秩的)整数 输出:位置 
 *         pos2Rank(p): 若 p 是序列中的合法位置，则返回存放于 p 处的元素的秩;否则，报错
 *         输入:一个位置 输出:(作为秩的)整数
 */
public interface Sequence extends Vector, List {

	// 若0 <= r < getSize()，则返回秩为r的元素所在的位置;否则，报错
	public Position rank2Pos(int r) throws ExceptionBoundaryViolation;

	// 若p是序列中的合法位置，则返回存放于p处的元素的秩;否则，报错
	public int pos2Rank(Position p) throws ExceptionPositionInvalid;
}
