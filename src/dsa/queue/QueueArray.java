package dsa.queue;

/**
 * 
 * 请注意，这里采用的依然是定长数组，故与栈一样，有可能出现空间溢出的情况。一旦空间溢出，需要给出 ExceptionQueueFull
 * 意外错。反过来，对于空队列的出队操作也需要禁止，这里将报 ExceptionQueueEmpty
 * 意外错。那么，如何判断这两种情况呢?其中的一些细节值得讨论。 我们注意到，当队列中不含任何对象时，必有 f = r。然而，反之却不然。
 * 试考虑如下情况:在数组中只剩下一个空闲单元(此时有 f ≡ (r+1) mod N)时，需要插入一个 对象。若则按照上面的
 * enqueue()算法，插入后有 f = r，但事实上此时的队列已满。如果根据“f = r”
 * 判断队列为空，则尽管队列中含有元素，但出队操作却无法进行;反过来，尽管数组空间已满，却还能插入新元素(原有的元素将被覆盖掉)。
 * 为了解决这一问题，一种简便易行的方法就是禁止队列的实际规模超过N-1。
 *
 */
public class QueueArray implements Queue {

	public static final int CAPACITY = 1000;

	protected int capacity;

	protected Object[] q;

	protected int f = 0;

	protected int r = 0;

	public QueueArray(int cap) {
		capacity = cap;
		q = new Object[capacity];
	}

	public QueueArray() {
		this(CAPACITY);
	}

	@Override
	public int getSize() {
		return (capacity - f + r) % capacity;
	}

	@Override
	public boolean isEmpty() {
		return f == r;
	}

	@Override
	public Object front() throws ExceptionQueueEmpty {
		if (isEmpty())
			throw new ExceptionQueueEmpty("empty");
		return q[f];
	}

	@Override
	public void enqueue(Object object) throws ExceptionQueueFull {
		if (getSize() == capacity - 1) {
			throw new ExceptionQueueFull("full");
		}
		q[r] = object;
		r = (r + 1) % capacity;
	}

	@Override
	public Object dequeue() throws ExceptionQueueEmpty {
		if (isEmpty())
			throw new ExceptionQueueEmpty("empty");
		Object object = q[f];
		q[f] = null;
		f = (f + 1) % capacity;
		return object;
	}

	@Override
	public void traversal() {
		for (int i = f; i < r; i++) {
			System.out.println(q[i] + " ");
		}
		System.out.println();
	}

}
