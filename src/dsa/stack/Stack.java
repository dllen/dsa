package dsa.stack;

/**
 * 
 * @author shichaopeng 功能描述 push(x): 将对象 x 压至栈顶 输入:一个对象 输出:无 pop():
 *         若栈非空，则将栈顶对象移除，并将其返回 否则，报错 输入:无 输出:对象 getSize(): 返回栈内当前对象的数目 输入:无
 *         输出:非负整数 isEmpty(): 检查栈是否为空 输入:无 输出:布尔标志 top(): 若栈非空，则返回栈顶对象(但并不移除)
 *         否则，报错 输入:无
 *
 */
public interface Stack {

	public int getSize();

	public boolean isEmpty();

	public Object top() throws ExceptionStackEmpty;

	public void push(Object e);

	public Object pop() throws ExceptionStackEmpty;

}
