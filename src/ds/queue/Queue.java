package ds.queue;

public interface Queue<X> {

	public int size();

	public void enQueue(X item);

	public X deQueue();

	public X access(int position);

	public boolean contains(X item);
}
