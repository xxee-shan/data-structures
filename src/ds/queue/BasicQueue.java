package ds.queue;

public class BasicQueue<X> implements Queue<X>{
	private X[] data;
	private int front;
	private int end;

	public BasicQueue() {
		this(1000);
	}

	public BasicQueue(int size) {
		this.front = -1;
		this.end = -1;
		data = (X[]) new Object[size];
	}

	@Override
	public int size() {
		if (front == -1 && end == -1) {
			return 0;
		}
		return end - front + 1;
	}

	@Override
	public void enQueue(X item) {
		// check if queue is full
		if ((end + 1) % data.length == front) {
			throw new IllegalStateException("Queue is full");
		}

		// check if queue is empty
		if (size() == 0) {
			front++;
			end++;
			data[end] = item;
		}

		// else add item to end of queue
		else {
			end++;
			data[end] = item;
		}
	}

	@Override
	public X deQueue() {
		X item = null;

		// Check if queue is empty
		if (size() == 0) {
			throw new IllegalStateException("Cannot remove elements from empty queue!");
		}

		// if there is only one element in queue
		else if (front == end) {
			item = data[front];
			data[front] = null;
			front = -1;
			end = -1;
		} else {
			item = data[front];
			data[front] = null;
			front++;
		}

		return item;
	}
	
	@Override
	public boolean contains(X item) {
		boolean conatins = false;
		if(size() == 0 ) throw new IllegalArgumentException("Queue is empty!");
		for(int i = front ; i<end;i++) {
			if(data[i].equals(item)) {
				conatins = true;
				break;
			}
		}
		return conatins;
	}

	@Override
	public X access(int position) {
		if (size() == 0 || position > size()) {
			throw new IllegalStateException("Cannot remove elements from empty queue!");
		}
		
		
		// See if position is actually in array and if so return item from that position
		int trueIndex = 0;
		for(int i=front;i<end;i++) {
			if(trueIndex == position) {
				return data[i];
			}
			trueIndex++;
		}
			
		// If item not found throw exception that item not found
		throw new IllegalArgumentException("Unable to find item in the queue!");
	}
}
