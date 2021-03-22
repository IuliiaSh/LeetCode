class DesignLinkedList {
    Node head;

    public DesignLinkedList() { 
        head = null;
    }
    
	private Node getCurrent(int index) {
		int i = 0;
	    Node current = head;
	    while (current != null && i < index) {
	    	current = current.next;
	        i++;
	    }
	    return current;
	}
    
	private Node getPrevious(int index) {
		int i = 1;
        Node previous = head;
        while (previous != null && i < index) {
        	previous = previous.next;
            i++;
        }
		return previous;
	}
	
    public int get(int index) {
        Node current = getCurrent(index);
        if (current != null) {
        	return current.val;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        head = new Node(val, head);
    }
    
    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        
        Node previous = getPrevious(index);
        if (previous != null) {
        	previous.next = new Node(val, previous.next);
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index == 0 && head != null) {
        	head = head.next;
            return;
        }
        
        Node previous = getPrevious(index);
        if (previous != null && previous.next != null) {
        	previous.next = previous.next.next;
        }
    }
}

class Node {
    int val;
    Node next;
    
    public Node() {}
    
    public Node(int val) {
        this.val = val;
    }
    
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}