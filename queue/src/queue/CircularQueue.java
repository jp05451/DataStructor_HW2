package queue;

/**
 * 資料結構範例 - 環形佇列/以陣列實作
 * @author Bor-Shen Lin at National Taiwan University of Science and Technology.
 *******************************************************************************
 *	你要保守你心，勝過保守一切，因為一生的果效是由心發出。	箴4:23
 */

public class CircularQueue<T> implements Queue<T> {

	final static int MAX_QUEUE_SIZE = 100;
	int count;
	int front;	// position to read
	int rear;	// position to write
	T entries[] = (T[]) new Object[MAX_QUEUE_SIZE];

	public CircularQueue() {
		count = 0;
		front = 0;
		rear = 0;
	}

	@Override
	public void clear() {
		count = 0;
		front = 0;
		rear = 0;
	}

	@Override
	public boolean append(T entry) {
		if (isFull()) {
			return false;
		}
		entries[rear] = entry;
		rear = (++rear) % MAX_QUEUE_SIZE;
		count++;
		return true;
	}

	@Override
	public T serve() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException();
		}
		T entry = entries[front];
		front = (++front) % MAX_QUEUE_SIZE; // circular increment
		count--;
		return entry;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public boolean isFull() {
		return count == MAX_QUEUE_SIZE;
	}

	@Override
	public void forEach(Process<T> process) {
		for (int i = front; i != rear; i = (++i) % MAX_QUEUE_SIZE) {
			process.todo(entries[i]);
		}
	}

}
