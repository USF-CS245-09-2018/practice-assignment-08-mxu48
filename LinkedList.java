public class LinkedList implements List {

	int index;
	Node head;

	public LinkedList () {
		index = 0; /* Location in list */
		head = null;
	}

	public class Node {
		Object data;
		Node next;
	}

	public void add(Object obj) throws Exception {
		if(obj == null || index < 0) {
			throw new RuntimeException("Invalid value cannot be added to the list.");
		}
		/* Default add to end of list - if first, adds to head */
		add(index, obj);
	}

	public void add(int pos, Object obj) throws Exception {
		if(pos < 0 || pos > index) {
			throw new RuntimeException("That position is out of the scope of the linked list.");
		}
		Node node = new Node();
		node.data = obj;
		Node curr = head;

		if(pos == 0) { /* Add at head */
			/* Set head to be next of node to be added */
			node.next = head;
			/* New node is new head */
			head = node;
		}

		Node prev = findNode(pos-1);
		node.next = prev.next;
		prev.next = node;
		index++;
	}

	public Object get(int pos) throws Exception {
		if(pos < 0 || pos > index) {
			throw new RuntimeException("That position is out of the scope of the linked list.");
		}
		Node curr = head;
		Object returnData = null;
		for(int i = 0; i <= index; i++) {
			/* When at position of desired item */
			if(i == pos) {
				curr = curr;
				returnData = curr.data;
			}
			curr = curr.next;
		}
		return returnData;
	}

	public Node findNode(int pos) {
		Node curr = head;
		for(int i = 0; i < pos && curr.next != null; i++) {
			curr = curr.next;
		}
		return curr;
	}

	public Object remove(int pos) throws Exception {
		if(pos < 0 || pos > index) {
			throw new RuntimeException("That position is out of the scope of the linked list.");
		}
		/* If node to be removed is at head */
		if(pos == 0) {
			Node remove = head;
			head = head.next;
			index--;
			return remove.data;
		} 

		/* Set prev.next to be node-to-be-removed.next, skips over node so it is "removed" */
		Node prev = findNode(pos-1);
		Node remove = prev.next;
		prev.next = remove.next;
		index--;
		return remove.data;
	}

	public int size() {
		return index;
	}

}