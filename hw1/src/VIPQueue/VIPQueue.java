package VIPQueue;

public interface VIPQueue<E> {
	
	/**
	 * @return whether the size of this queue is at its maximum capacity
	 * (it should never be greater than the maximum capacity) defined at creation time
	 */
	public boolean isFull();
	
	/**
	 * @return whether this queue is empty or not
	 */
	public boolean isEmpty();
	
	/**
	 * @param data object to be inserted at the end of this queue
	 * @throws OverflowException when the queue is full
	 */
	public void enqueue(E data) throws OverflowException;
	
	/**
	 * @param data object to be inserted at the beginning of this queue
	 * @throws OverflowException when the queue is full
	 */
	public void enqueueVIP(E data) throws OverflowException;
	
	/**
	 * Remove the object at the beginning of the queue and return it
	 * @return object at the beginning of the queue (no longer a member of that queue)
	 * @throws UnderflowException when the queue is empty
	 */
	public E dequeue() throws UnderflowException;
	
	/**
	 * Remove all objects from this queue
	 */
	public void clear();
}
