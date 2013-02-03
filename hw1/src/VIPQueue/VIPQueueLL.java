package VIPQueue;

public class VIPQueueLL<E> implements VIPQueue<E> {

	private final LinkedList<E> backingData;
	private final int maxSize;
	
	VIPQueueLL(int maxSize) {
		this.maxSize = maxSize;
		backingData = new LinkedList<E>();
	}

	@Override
	public void enqueue(E data) throws OverflowException {
		if (backingData.size() + 1 > maxSize)
			throw new OverflowException();
		
		backingData.add(data);
	}

	@Override
	public void enqueueVIP(E data) throws OverflowException {
		if (backingData.size() + 1 > maxSize)
			throw new OverflowException();
		
		backingData.add(0, data);
	}

	@Override
	public E dequeue() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		
		return backingData.remove(0);
	}

	@Override
	public boolean isFull() {
		return backingData.size() >= maxSize;
	}

	@Override
	public boolean isEmpty() {
		return backingData.isEmpty();
	}

	@Override
	public void clear() {
		backingData.clear();
	}
}