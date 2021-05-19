package ds.stack;

import java.util.ArrayList;
import java.util.List;

public final class ListStack<X> implements Stack<X> {
	
	private List<X> data;
	
	public ListStack() {
		data = new ArrayList<X>();
	}
	
	@Override
	public void push(X newElement) {
		data.add(newElement);
	}

	@Override
	public X pop() {
		if(data.size()>0) {
			return data.remove(data.size()-1);
		}
		throw new IllegalStateException("No items in the stack!");
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean contains(X item) {
		return data.contains(item);
	}

	@Override
	public X access(X item) {
		X temp;
		while(data.size()>0) {
			temp = data.remove(data.size()-1);
			if(temp.equals(item)) {
				return temp;
			}
		}
		throw new IllegalArgumentException("Unable to find item on Stack : "+ item);
	}

}
