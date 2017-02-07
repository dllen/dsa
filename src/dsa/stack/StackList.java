package dsa.stack;

import java.util.ArrayList;
import java.util.List;

public class StackList implements Stack {

	protected List<Object> s;

	protected int top = -1;

	public StackList() {
		s = new ArrayList<>();
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
		return s.get(top);
	}

	@Override
	public void push(Object e) {
		s.add(e);
		top++;
	}

	@Override
	public Object pop() throws ExceptionStackEmpty {
		if (isEmpty()) {
			throw new ExceptionStackEmpty("empty");
		}
		return s.remove(top--);
	}

}
