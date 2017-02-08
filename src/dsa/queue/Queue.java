package dsa.queue;

/**
 * 
 * @author shichaopeng 
 * 功能描述 
 * enqueue(x): 将元素 x 加到队列末端 输入:一个对象 输出:无 
 * dequeue(): 若队列非空，则将队首元素移除，并将其返回 否则，报错 输入:无 输出:对象 
 * getSize(): 返回队列中当前包含的元素数目 输入:无 输出:非负整数 
 * isEmpty(): 检查队列是否为空 输入:无 输出:布尔标志 
 * front(): 若队列非空，则返回队首元素(但并不移除) 否则，报错 输入:无 输出:队头对象
 */
public interface Queue {

	public int getSize();

	public boolean isEmpty();

	public Object front() throws ExceptionQueueEmpty;

	public void enqueue(Object object) throws ExceptionQueueFull;

	public Object dequeue() throws ExceptionQueueEmpty;
	
	public void traversal();
}
