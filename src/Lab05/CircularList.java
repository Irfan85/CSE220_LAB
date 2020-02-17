package Lab05;

public class CircularList {
	Node head;

	/*
	 * Build a Circular List from the given circular array
	 */
	public void buildFromArray(int[] cir, int st, int size) {
		// TO DO
		head = new Node(cir[st], null);
		Node n = head;

		for (int i = 0, j = st + 1; i < size - 1; i++) {
			Node newNode = new Node(cir[j % cir.length], null);
			n.next = newNode;
			n = newNode;

			j++;
		}

		n.next = head;
	}

	/*
	 * Build a Circular List from the given Non Circular List
	 */
	public void buildFromList(Node h) {
		// TO DO
		this.head = new Node(h.element, null);
		Node node = this.head;
		for (Node n = h.next; n != h; n = n.next) {
			Node newNode = new Node(n.element, null);
			node.next = newNode;
			node = newNode;
		}

		node.next = head;
	}

	/*
	 * Build a Circular List from the given Non Circular List The elements of the
	 * new list must in reverse order
	 */
	public void printList() {
		// TO DO
		System.out.print(this.head.element);

		for (Node n = this.head.next; n != this.head; n = n.next) {
			System.out.print(", " + n.element);
		}

		System.out.println();

	}

	/* Prints the given list */
	public void buildReverse() {
		// TO DO
		Node tail = new Node(this.head.element, null);
		Node newHead = tail;

		for (Node n = this.head.next; n != this.head; n = n.next) {
			Node newNode = new Node(n.element, null);
			newNode.next = newHead;
			newHead = newNode;
		}

		tail.next = newHead;
		this.head = newHead;
	}

	/*
	 * Insert the element in the given index. Index 0 is the index after the dummy
	 * head
	 */
	public void addElement(int element, int index) {
		// TO DO
		Node node = new Node(element, null);

		if (index == 0) {
			node.next = this.head;
			this.head = node;
		} else {
			Node prev = nodeAt(index - 1);

			if (prev != null) {
				node.next = prev.next;
				prev.next = node;
			}
		}
	}

	/*
	 * Delete the element from the given index. Index 0 is the index after the dummy
	 * head
	 */
	public void deleteElement(int index) {
		// TO DO
		Node prev = nodeAt(index - 1);

		if (index == 0) {
			System.out.println("Removed: " + this.head.element);
			this.head = this.head.next;
		} else {
			if (prev != null) {
				if(prev.next != null)
					System.out.println("Removed: " + prev.next.element);
				prev.next = prev.next.next;
			}
		}
	}

	public Node nodeAt(int index) {
		if (index == 0)
			return this.head;

		int count = 1;

		for (Node n = this.head.next; n != this.head; n = n.next) {
			if (count == index)
				return n;

			count++;
		}

		return null;
	}
}
