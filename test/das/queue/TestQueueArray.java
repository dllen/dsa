package das.queue;

import org.junit.Before;
import org.junit.Test;

import dsa.queue.Queue;
import dsa.queue.QueueArray;

import static org.junit.Assert.*;

public class TestQueueArray {

	Queue queue;

	@Before
	public void init() {
		queue = new QueueArray();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
	}

	@Test
	public void testFront() {
		assertEquals(1, queue.front());
	}
	
	@Test
	public void testDequeue(){
		assertEquals(1, queue.dequeue());
		assertEquals(2, queue.dequeue());
	}

}
