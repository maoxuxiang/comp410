package VIPQueue;

public interface VIPQueue<E> {
	
	public boolean isFull();
	public boolean isEmpty();
	
	public void enqueue(E data) throws OverflowException;
	public void enqueueVIP(E data) throws OverflowException;
	
	public E dequeue() throws UnderflowException;
	
	public void clear();
}
