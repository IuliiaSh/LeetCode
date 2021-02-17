public class ReverseLinkedListTwo {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        
        // detach
        ListNode lastNonReversed = head;
        ListNode start;
        if (m == 1) {
        	start = head;
        } else {
            int i = 1;
            while (i < m - 1) {
                lastNonReversed = lastNonReversed.next;
                i++;
            }
        	start = lastNonReversed.next;
        }
        
        ListNode end = head;
        int i = 1;
        while (i < n) {
            end = end.next;
            i++;
        }
        ListNode firstNonReversed = end.next;
        
        // reverse
        ListNode previous = start;
        ListNode current = previous.next;
        ListNode temp;
        while (current != firstNonReversed) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        
        // attach
        if (m == 0) {
        	head = end;
        } else {
        	lastNonReversed.next = end;
        }
        start.next = firstNonReversed;
        return head; 
    }
}