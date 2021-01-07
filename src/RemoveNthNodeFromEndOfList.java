public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode firstPointer = head;
        for (int i = 0; i < n; i++) {
        	firstPointer = firstPointer.next;
        }
        
        if (firstPointer == null) return head.next;
        ListNode secondPointer = head;
        while (firstPointer.next != null) {
        	firstPointer = firstPointer.next;
        	secondPointer = secondPointer.next;
        }
        secondPointer.next = secondPointer.next.next;
        return head;
    }
}

