package Lab04;

public class LinkedList {
	public Node head;

	/*
	 * First Constructor: Creates a linked list using the values from the given
	 * array. head will refer to the Node that contains the element from a[0]
	 */
	public LinkedList(Object[] a) {
		// TO DO
		Node head = new Node(a[0], null);
		this.head = head;

		Node node = head;
		for (int i = 1; i < a.length; i++) {
			node.next = new Node(a[i], null);
			node = node.next;
		}
	}

	/*
	 * Second Constructor: Sets the value of head. head will refer to the given
	 * LinkedList
	 */
	public LinkedList(Node h) {
		// TO DO
		this.head = h;
	}

	/* Counts the number of Nodes in the list */
	public int countNode() {
		// TO DO
		int count = 0;

		for (Node n = this.head; n != null; n = n.next) {
			count++;
		}

		return count; // please remove this line!
	}

	/* prints the elements in the list */
	public void printList() {
		// TO DO
		for (Node n = this.head; n != null; n = n.next) {
			if (n == this.head)
				System.out.print(n.element);
			else
				System.out.print(", " + n.element);
		}

		System.out.println(".");
	}

	// returns the reference of the Node at the given index. For invalid index
	// return null.
	public Node nodeAt(int idx) {
		// TO DO
		if (idx >= 0 && idx < countNode()) {
			int count = 0;

			for (Node n = head; n != null; n = n.next) {
				if (count == idx)
					return n;

				count++;
			}
		}

		return null; // please remove this line!
	}

// returns the element of the Node at the given index. For invalid idx return null.
	public Object get(int idx) {
		// TO DO
		return nodeAt(idx).element; // please remove this line!
	}

	/*
	 * updates the element of the Node at the given index. Returns the old element
	 * that was replaced. For invalid index return null. parameter: index, new
	 * element
	 */
	public Object set(int idx, Object elem) {
		// TO DO
		Node n = nodeAt(idx);

		if (n != null) {
			Object temp = n.element;
			n.element = elem;

			return temp;
		}

		return null; // please remove this line!
	}

	/*
	 * returns the index of the Node containing the given element. if the element
	 * does not exist in the List, return -1.
	 */
	public int indexOf(Object elem) {
		// TO DO
		int index = 0;

		for (Node n = head; n != null; n = n.next) {
			if (n.element.equals(elem))
				return index;

			index++;
		}

		return -100; // please remove this line!
	}

	// returns true if the element exists in the List, return false otherwise.
	public boolean contains(Object elem) {
		// TO DO
		return !(indexOf(elem) < 0); // please remove this line!
	}

	// Makes a duplicate copy of the given List. Returns the reference of the
	// duplicate list.
	public Node copyList() {
		// TO DO
		Node copyHead = new Node(this.head.element, null);
		Node node = copyHead;

		for (Node n = this.head.next; n != null; n = n.next) {
			Node temp = new Node(n.element, null);
			node.next = temp;
			node = temp;
		}

		return copyHead; // please remove this line!
	}

	// Makes a reversed copy of the given List. Returns the head reference of the
	// reversed list.
	public Node reverseList() {
		// TO DO
		Node newHead = new Node(this.head.element, null);

		for (Node n = this.head.next; n != null; n = n.next) {
			Node temp = new Node(n.element, null);
			temp.next = newHead;
			newHead = temp;
		}

		return newHead; // please remove this line!
	}

	/*
	 * inserts Node containing the given element at the given index Check validity
	 * of index.
	 */
	public void insert(Object elem, int idx) {
		// TO DO
		if (idx >= 0 && idx <= countNode()) {
			Node n = new Node(elem, null);

			if (idx == 0) {
				n.next = this.head;
				this.head = n;
			} else {
				Node prev = nodeAt(idx - 1);
				n.next = prev.next;
				prev.next = n;
			}
		}
	}

	/*
	 * removes Node at the given index. returns element of the removed node. Check
	 * validity of index. return null if index is invalid.
	 */
	public Object remove(int index) {
		// TO DO
		if (index >= 0 && index < countNode()) {
			if (index == 0) {
				Object temp = this.head.element;
				this.head = this.head.next;

				return temp;
			} else {
				Node prev = nodeAt(index - 1);
				prev.next = prev.next.next;

				return prev.element;
			}

		}

		return null; // please remove this line!
	}

	// Rotates the list to the left by 1 position.
	public void rotateLeft() {
		// TO DO
		Node temp = new Node(this.head.element, null);
		Node newHead = this.head.next;

		for (Node n = newHead; n != null; n = n.next) {
			if (n.next == null) {
				n.next = temp;

				break;
			}
		}

		this.head = newHead;
	}

	// Rotates the list to the right by 1 position.
	public void rotateRight() {
		// TO DO
		for (Node n = this.head; n != null; n = n.next) {
			if (n.next == null) {
				Node newHead = new Node(n.element, this.head.next);
				n.element = this.head.element;
				this.head = newHead;

				break;
			}

		}

	}

}