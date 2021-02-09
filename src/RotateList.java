public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        int nodesCount = 0;
        ListNode current = head;
        while (current != null) {
            nodesCount++;
            current = current.next;
        }
        k = k % nodesCount;
        
        for (int i = 0; i < k; i++) {
            ListNode previous = head;
            current = head.next;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            current.next = head;
            previous.next = null;
            head = current;
        }
        return head;
    }
}
