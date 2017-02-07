package dsa.stack;

public interface Stack {

	public int getSize();

	public boolean isEmpty();

	public Object top() throws ExceptionStackEmpty;

	public void push(Object e);

	public Object pop() throws ExceptionStackEmpty;

}
