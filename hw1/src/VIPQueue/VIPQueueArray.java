package VIPQueue;

public class VIPQueueArray<E> implements VIPQueue<E> {
	
	private final int maxSize;
	
	private Object[] backingData;
	
	private int size;
	private int firstIdx;
	private int lastIdx;
	
	VIPQueueArray(int maxSize) {
		this.maxSize = maxSize;
		clear();
	}

	@Override
	public void enqueue(E data) throws OverflowException {
		// Throw an overflow exception if this enqueue operation would exceed the specified size
		if (size + 1 > maxSize)
			throw new OverflowException();
		
		backingData[lastIdx++] = data;
		size++;
	}

	@Override
	public void enqueueVIP(E data) throws OverflowException {
		if (size + 1 > maxSize)
			throw new OverflowException();
	}

	@Override
	@SuppressWarnings("unchecked")
	public E dequeue() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		
		E tmp = (E) backingData[firstIdx];
		firstIdx++;
		size--;
		return tmp;
	}

	@Override
	public boolean isFull() {
		return size >= maxSize;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		backingData = new Object[maxSize];
		size = firstIdx = lastIdx = 0;
	}
}
