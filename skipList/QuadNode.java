package skipList;

public class QuadNode {
	private QuadNode prev;
	private QuadNode next;
	private QuadNode down;
	private QuadNode up;
	private Object key;
	
	public QuadNode(Object key) {
		this.key = key;
		prev = null;
		next = null;
		down = null;
		up = null;
	}

	public QuadNode getPrev() {
		return prev;
	}

	public void setPrev(QuadNode prev) {
		this.prev = prev;
	}

	public QuadNode getNext() {
		return next;
	}

	public void setNext(QuadNode next) {
		this.next = next;
	}

	public QuadNode getDown() {
		return down;
	}

	public void setDown(QuadNode down) {
		this.down = down;
	}

	public QuadNode getUp() {
		return up;
	}

	public void setUp(QuadNode up) {
		this.up = up;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}
}
