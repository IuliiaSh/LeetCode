public class CopyListWithRandomPointer {
	public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Node newHead = new Node(head.val);
        Node currentOrigin = head;
        Node currentCopy = newHead;
        Node nextCopy;
        while (currentOrigin.next != null) {
            nextCopy = new Node(currentOrigin.next.val);
            currentCopy.next = nextCopy;
            currentCopy = nextCopy;
            currentOrigin = currentOrigin.next;
        }
        
        currentOrigin = head;
        currentCopy = newHead;
        Node randomOriginal;
        Node randomCopy;
        while (currentOrigin != null) {
            if (currentOrigin.random != null) {
                randomOriginal = head;
                randomCopy = newHead;
                while (randomOriginal != currentOrigin.random) {
                    randomOriginal = randomOriginal.next; 
                    randomCopy = randomCopy.next;
                }
                currentCopy.random = randomCopy;
            }
            currentOrigin = currentOrigin.next;
            currentCopy = currentCopy.next;
        }
        return newHead;
    }
}