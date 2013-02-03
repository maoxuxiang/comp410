package VIPQueue;

import java.util.Random;

public class VIPQueueTester {
	
	public static final int TEST_SIZE = 10;
	
	public final Random randomGenerator = new Random();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean passed = new VIPQueueTester().runAllTests();
		String resultString;
		if (passed)
			resultString = "Hooray! All tests passed!";
		else
			resultString = "Oh noes! One or more tests failed!";
		System.out.println("Testing results:\n\t" + resultString);
	}

	public boolean runAllTests() {
		boolean passed = true;
		
		VIPQueue<Integer> llQueue = new VIPQueueLL<Integer>(TEST_SIZE);
		VIPQueue<Integer> arrayQueue = new VIPQueueArray<Integer>(TEST_SIZE);
		
		System.out.println("Testing linked-list implementation:");
		passed &= testVIPQueue(llQueue);
		
		System.out.println("Testing array implementation:");
		passed &= testVIPQueue(arrayQueue);
				
		return passed;
	}
	
	public boolean testVIPQueue(VIPQueue<Integer> queue) {
		boolean passed = true;
		boolean result;
		
		queue.clear();
		result = testBasicQueue(queue);
		passed &= result;
		if (!result)
			System.out.println("\tTesting basic queue functionality failed");
		
		
		queue.clear();
		result = testVIPEnqueue(queue);
		passed &= result;
		if (!result)
			System.out.println("\tTesting VIP queue functionality failed");
		
		queue.clear();
		result = testOverflow(queue);
		passed &= result;
		if (!result)
			System.out.println("\tTesting overflow condition failed");
		
		queue.clear();
		result = testUnderflow(queue);
		passed &= result;
		if (!result)
			System.out.println("\tTesting undeflow condition failed");
		
		return passed;
	}

	private boolean testUnderflow(VIPQueue<Integer> queue) {
		try {
			queue.dequeue();
			return false;
		} catch (UnderflowException under) {
			return true;
		}
	}

	private boolean testOverflow(VIPQueue<Integer> queue) {
		boolean passed = true;
		
		boolean isFull = false;
		while (!isFull) {
			queue.enqueue(randomGenerator.nextInt());
			isFull = queue.isFull();
		}
		
		try {
			queue.enqueue(randomGenerator.nextInt());
			passed &= false;
		} catch (OverflowException over) {
			passed &= true;
		}
		
		return passed;
	}

	private boolean testVIPEnqueue(VIPQueue<Integer> queue) {
		queue.enqueue(5);
		queue.enqueue(5);
		queue.enqueueVIP(10);
		
		return (queue.dequeue() == 10);
	}

	private boolean testBasicQueue(VIPQueue<Integer> queue) {
		for (int i = 0; i < TEST_SIZE; i++) {
			queue.enqueue(i);
		}
		for (int i = 0; i < TEST_SIZE; i++) {
			int popped = queue.dequeue();
			if (i != popped) {
				return false;
			}
		}
		return true;
	}

}
