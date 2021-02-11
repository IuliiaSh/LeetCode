public class RemoveDuplicatesFromSortedListTwo {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;    
            
        ListNode result = null;
        int prevValue = Integer.MIN_VALUE;
        while (head.next != null) {
            if (head.val != prevValue && head.val != head.next.val) {
                result = new ListNode(head.val);
                break;
            }
            prevValue = head.val;
            head = head.next;
        }
        
        if (head.next == null) {
        	if (head.val != prevValue) {
        		result = new ListNode(head.val);
        	}
        	return result;
        }
            
        ListNode lastAdded = result;
        prevValue = head.val;
        head = head.next;
        while (head.next != null) {
            if (head.val != prevValue && head.val != head.next.val) {
                lastAdded.next = new ListNode(head.val);
                lastAdded = lastAdded.next;
            }
            prevValue = head.val;
            head = head.next;
        }
        
        if (head.val != prevValue) {
        	    lastAdded.next = new ListNode(head.val);
        }
        return result;
    }
}
