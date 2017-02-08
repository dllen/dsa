package das.queue;

import dsa.queue.Queue;
import dsa.queue.QueueArray;

/**
 * 孩提时的你是否玩过“烫手山芋”游戏:一群小孩围成一圈，有一个刚出锅的山芋在他们之间
 * 传递。其中一个孩子负责数数，每数一次，拿着山芋的孩子就把山芋转交给右边的邻居。一旦数到
 * 某个特定的数，拿着山芋的孩子就必须退出，然后重新数数。如此不断，最后剩下的那个孩子就是 幸运者。
 *
 */
public class Josephus {

	public static Object josephus(Queue q, int k) {
		if (q.isEmpty())
			return null;
		while (q.getSize() > 1) {
			q.traversal();
			for (int i = 0; i < k; i++) {
				q.enqueue(q.dequeue());
			}
			Object object = q.dequeue();
			System.out.println("\n\t" + object + "退出");
		}
		return q.dequeue();
	}

	public static Queue buildQueue(Object a[]) {
		Queue queue = new QueueArray();
		for (Object object : a) {
			queue.enqueue(object);
		}
		return queue;
	}

	public static void main(String[] args) {
		String[] kid = { "Alice", "Bob", "Cindy", "Doug", "Ed", "Fred", "Gene", "Hope", "Irene", "Jack", "Kim", "Lance",
				"Mike", "Nancy", "Ollie" };
		System.out.println("最终的幸运者是" + josephus(buildQueue(kid), 3));
	}

}
