package dsa.stack;

public class StackArray implements Stack {

	public static final int CAPACITY = 1024;

	protected int capacity;

	protected Object[] s;

	protected int top = -1;

	public StackArray() {
		this(CAPACITY);
	}

	public StackArray(int cap) {
		capacity = cap;
		s = new Object[cap];
	}

	@Override
	public int getSize() {
		return top + 1;
	}

	@Override
	public boolean isEmpty() {
		return top < 0;
	}

	@Override
	public Object top() throws ExceptionStackEmpty {
		if (isEmpty()) {
			throw new ExceptionStackEmpty("empty");
		}
		return s[top];
	}

	@Override
	public void push(Object e) {
		if (getSize() == capacity) {
			throw new ExceptionStackFull("full");
		}
		s[++top] = e;
	}

	@Override
	public Object pop() throws ExceptionStackEmpty {
		if (isEmpty()) {
			throw new ExceptionStackEmpty("empty");
		}
		Object e = s[top];
		s[top--] = null;
		return e;
	}

}
