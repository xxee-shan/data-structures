package ds.queue;

import java.util.ArrayList;
import java.util.List;

public final class ListQueue<X> implements Queue<X> {

	private List<X> data;

	public ListQueue() {
		data = new ArrayList<X>();
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public void enQueue(X item) {
		data.add(item);
	}

	@Override
	public X deQueue() {

		if (size() == 0) {
			throw new IllegalStateException("Cannot remove elements from empty queue!");
		}

		return data.remove(data.size() - 1);
	}

	@Override
	public X access(int position) {
		if (size() == 0 || position > size()) {
			throw new IllegalStateException("Cannot remove elements from empty queue!");
		}

		return data.get(position);
	}

	@Override
	public boolean contains(X item) {
		if (size() == 0)
			throw new IllegalArgumentException("Queue is empty!");
		return data.contains(item);
	}

}
