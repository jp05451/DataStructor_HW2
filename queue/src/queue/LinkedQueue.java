package queue;

/**
 * 資料結構範例 - 佇列/以鏈結串列實作
 * @author Bor-Shen Lin at National Taiwan University of Science and Technology.
 *******************************************************************************
 *	不勞而得之財必然消耗；勤勞積蓄的，必見加增。	箴13:11
 */
public class LinkedQueue<T> implements Queue<T> {

	int count;
	Node<T> front;
	Node<T> rear;

	public LinkedQueue() {
		count = 0;
		front = rear = null;
	}

	@Override
	public boolean isEmpty() {
		return front == null;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean append(T entry) {
		Node node = new Node(entry);
		if (node == null) {
			return false;
		} else if (isEmpty()) {
			front = rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
		count++;
		return true;
	}

	@Override
	public T serve() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException();
		}
		T entry = front.entry;
		front = front.next;
		if (isEmpty()) {
			rear = null;
		}
		count--;
		return entry;
	}

	@Override
	public void forEach(Process<T> proess) {
		for (Node<T> node = front; node != null; node = node.next) {
			proess.todo(node.entry);
		}
	}

	public void clear() {
		front = rear = null;
	}
	@Override
	public boolean isFull() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
