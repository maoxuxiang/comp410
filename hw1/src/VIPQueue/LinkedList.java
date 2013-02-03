package VIPQueue;

/** Implements a custom LinkedList object that acts like a Java Standard API
 * LinkedList.  Like a Java-style LinkedList, it can grow without bound.
 * It also enforces int type objects only as elements.
 */
public class LinkedList<E> {

	private static class Node<E> {

		public E value;
		public Node<E> prev;
		public Node<E> next;

		Node(E value, Node<E> prev, Node<E> next) {
			this.value = value;
			this.prev = prev;
			this.next = next;
		}
	}

	private int size;

	private Node<E> firstNode;
	private Node<E> lastNode;

	public LinkedList() {
		doClear();
	}

	public boolean add(E data) {
		return add(size(), data);
	}

	public boolean add(int index, E data) {
		addBefore(getNode(index, 0, size()), data);
		return true;
	}
	
	public E get(int index) {
		return getNode(index).value;
	}
	
	public E set(int index, E data) {
		Node<E> node = getNode(index);
		E oldVal = node.value;
		node.value = data;
		return oldVal;
	}
	
	public E remove(int index) {
		return remove(getNode(index));
	}
	
	private E remove(Node<E> node) {
		node.next.prev = node.prev;
		node.prev.next = node.next;
		size--;
		
		return node.value;
	}
	
	private Node<E> getNode(int index) {
		return getNode(index, 0, size() - 1);
	}
	
	private Node<E> getNode(int index, int lower, int upper) {
		if (index < lower || index > upper)
			throw new IndexOutOfBoundsException();
		
		if (index < size() / 2) {
			return getHead(index);
		} else {
			return getTail(index);
		}
	}
	
	private Node<E> getHead(int index) {
		Node<E> node = firstNode.next;
		for (int i = 0; i < index; i++)
			node = node.next;
		return node;
	}
	
	private Node<E> getTail(int index) {
		Node<E> node = lastNode;
		for (int i = size(); i > index; i--)
			node = node.prev;
		return node;
	}

	private void addBefore(Node<E> node, E data) {
		Node<E> newNode = new Node<E>(data, node.prev, node);
		newNode.prev.next = newNode;
		node.prev = newNode;
		size++;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		doClear();
	}

	private void doClear() {
		firstNode = new Node<E>(null, null, null);
		lastNode = new Node<E>(null, firstNode, null);
		firstNode.next = lastNode;
		size = 0;
	}

}
