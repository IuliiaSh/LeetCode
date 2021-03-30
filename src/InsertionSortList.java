public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(head.val);
        ListNode current;
        ListNode toBeAdded;
        while (head.next != null) {
            head = head.next;
            toBeAdded = new ListNode(head.val);
            if (toBeAdded.val <= newHead.val) {
                toBeAdded.next = newHead;
                newHead = toBeAdded;
            } else {
                current = newHead;
                while (current.next != null && toBeAdded.val > current.next.val) {
                    current = current.next;
                }
                toBeAdded.next = current.next;
                current.next = toBeAdded;
            }
        }
        return newHead; 
    }
}
