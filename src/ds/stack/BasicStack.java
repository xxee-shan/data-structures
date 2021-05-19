package ds.stack;

public class BasicStack<X> implements Stack<X>{
	
	private X[] data;
	private int stackPointer;
	
	public BasicStack() {
		data = (X[]) new Object[1000]; 
		stackPointer = 0;
	}
	
	@Override
	public void push(X newElement) {
		data[stackPointer++] = newElement;
	}
	
	@Override
	public X pop() {
		if(stackPointer == 0) {
			throw new IllegalStateException("No items to return from stack!");
		}
		return data[--stackPointer];
	}
	
	@Override
	public boolean contains(X item) {
		boolean found = false;
		for(int i=0;i<stackPointer;i++) {
			if(data[i].equals(item)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	@Override
	public X access(X item) {
//		for(int i=0;i<stackPointer;i++) {
//			if(data[i].equals(item)) {
//				return data[i];
//			}
//		}
//		return null;
		while(stackPointer > 0) {
			X tempItem = pop();
			if(item.equals(tempItem)) {
				return tempItem;
			}
		}
		throw new IllegalArgumentException("Unable to find given item on the stack : "+ item);
	}
	
	@Override
	public int size() {
		return stackPointer;
	}
}
