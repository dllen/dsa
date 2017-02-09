package das.doubleendedqueue;

import dsa.queue.ExceptionQueueEmpty;

/**
 * 
 * @author shichaopeng 操作方法
 * 
 *         功能描述 insertFirst(x): 将对象 x 作为首元素插入 输入:一个对象 输出:无 insertLast(x): 将对象 x
 *         作为末元素插入 输入:一个对象 输出:无 removeFirst(): 若队列非空，则将首元素删除，并将其内容返回 否则，报错 输入:无
 *         输出:对象 removeLast(): 若队列非空，则将末元素删除，并将其内容返回 否则，报错 输入:无 输出:对象 first():
 *         若队列非空，则返回首元素的内容 否则，报错 输入:无 输出:对象 last(): 若队列非空，则返回末元素的内容 否则，报错 输入:无
 *         输出:对象
 */
public interface Deque {

	public int getSize();

	public boolean isEmpty();

	public Object first() throws ExceptionQueueEmpty;

	public Object last() throws ExceptionQueueEmpty;

	public void insertFirst(Object o);

	public void insertLast(Object o);

	public Object removeFirst() throws ExceptionQueueEmpty;

	public Object removeLast() throws ExceptionQueueEmpty;

	public void travsersal();
}
