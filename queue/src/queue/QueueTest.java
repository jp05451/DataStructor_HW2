package queue;

/**
 * 資料結構範例 - 佇列測試
 * @author Bor-Shen Lin at National Taiwan University of Science and Technology.
 *******************************************************************************
 *	棄絕管教的，必致貧受辱；領受責備的，必得尊榮。		箴13:18
 */

public class QueueTest {
	static void print(Queue<Character> queue) {
		System.out.printf("[");
		queue.forEach(item -> System.out.printf(" %c", item));
		System.out.printf("]\n");
	}	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws QueueEmptyException {
//		LinkedQueue<Character> queue = new LinkedQueue();
		Queue<Character> queue = new CircularQueue();
		queue.append('e');
		print(queue);
		queue.append('c');
		print(queue);
		queue.append('z');
		print(queue);
		queue.append('w');
		print(queue);
		queue.append('a');
		print(queue);
		System.out.printf("queue size is %d\n", queue.size());
		while(!queue.isEmpty()) {
			char entry = queue.serve();
			System.out.printf("Queue entry %c is served\n", entry);
			print(queue);
		}
		System.out.printf("------- after serving -----\n");
		print(queue);			
	}	
	public static void service(Queue<Character> queue) throws QueueEmptyException {
		while(true) {
			if(!queue.isEmpty()) {
				char entry = queue.serve();				
				System.out.printf("Queue entry %c is served\n", entry);
			}
		}
	}
}
