package queue;

public class QueueIsFullNotSupported extends Exception {
	public QueueIsFullNotSupported() {
		super("Implementation class do not support isFull method");
	}
}
