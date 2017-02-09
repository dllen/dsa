package das.vector;

/**
 * 
 * @author shichaopeng 操作方法
 * 
 *         功能描述 getSize(): 报告向量中的元素数目 输入:无 输出:非负整数 isEmpty(): 判断向量是否为空 输入:无
 *         输出:布尔量 getAtRank(r): 若 0 ≤ r < getSize()，则返回秩为 r 的那个元素 否则，报错 输入:一个整数
 *         输出:对象 replaceAtRank(r, e): 若 0 ≤ r < getSize()，则将秩为 r 的元素替换为
 *         e，并返回原来的元素 否则，报错 输入:一个整数和一个对象 输出:对象 insertAtRank(r, e): 若 0 ≤ r ≤
 *         getSize()，则将 e 插入向量中，作为秩为 r 的元素(原秩不小于 r 的元素顺次后移); 并返回该元素 否则，报错
 *         输入:一个整数和一个对象 输出:对象 removeAtRank(r): 若 0 ≤ r < getSize()，则删除秩为 r
 *         的那个元素并返回之(原秩大于 r 的元素顺次前移) 否则，报错 输入:一个整数 输出:对象
 *
 */
public interface Vector {

	public int getSize();

	public boolean isEmpty();

	public Object getAtRank(int r) throws ExceptionBoundaryViolation;

	public Object replaceAtRank(int r, Object o) throws ExceptionBoundaryViolation;

	public Object insertAtRank(int r, Object o) throws ExceptionBoundaryViolation;

	public Object removeAtRank(int r) throws ExceptionBoundaryViolation;

}
