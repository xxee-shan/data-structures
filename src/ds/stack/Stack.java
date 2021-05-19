package ds.stack;

public interface Stack<X> {
	
	public void push(X newElement);
	
	public X pop();
	
	public int size();
	
	public boolean contains(X item);
	
	public X access(X item);
}
