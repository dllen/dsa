package das.list;

import das.linkedlist.Position;
import das.vector.ExceptionBoundaryViolation;

/**
 * 
 * @author shichaopeng
 *
 *         操作方法
 * 
 *         功能与描述 first(): 若 S 非空，则给出其中第一个元素的位置 否则，报错 输入:无 输出:位置 last(): 若 S
 *         非空，则给出其中最后一个元素的位置 否则，报错 输入:无 输出:位置 getPrev(p): 若 p 不是第一个位置，则给出 S 中 p
 *         的前驱所在的位置 否则，报错 输入:位置 输出:位置 getNext(p): 若 p 不是最后一个位置，则给出 S 中 p
 *         的前驱所在的位置 否则，报错 输入:位置 输出:位置 replace(p, e): 将处于位置 p 处的元素替换为 e，并返回被替换的元素
 *         输入:一个位置和一个对象 输出:对象 insertFirst(e): 将元素 e 作为第一个元素插入 S 中，并返回 e 的位置
 *         输入:一个对象 输出:位置 insertLast(e): 将元素 e 作为最后一个元素插入 S 中，并返回 e 的位置 输入:一个对象
 *         输出:位置 insertBefore(p, e): 将元素 e 插入于 S 中位置 p 之前，并返回 e 的位置 输入:一个位置和一个对象
 *         输出:位置 insertAfter(p, e): 将元素 e 插入于 S 中位置 p 之后，并返回 e 的位置 输入:一个位置和一个对象
 *         输出:位置 remove(p): 删除 S 中位置 p 处的元素 输入:一个位置 输出:对象
 */
public interface List {

	public int getSize();

	public boolean isEmpty();

	public Position first();

	public Position last();

	public Position getNext(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation;

	public Position getPrev(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation;

	public Position insertFirst(Object e);

	public Position insertLast(Object e);

	public Position insertAfter(Position p, Object e) throws ExceptionPositionInvalid;

	public Position insertBefore(Position p, Object e) throws ExceptionPositionInvalid;

	public Object remove(Position p) throws ExceptionPositionInvalid;

	public Object removeFirst();

	public Object removeLast();

	public Object replace(Position p, Object e) throws ExceptionPositionInvalid;

	public Iterator positions();

	public Iterator elements();
}
