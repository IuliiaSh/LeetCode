public class ReorderList {
	public void reorderList(ListNode head) {
        ListNode current = head;
        int size = 1;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        
        current = head;
        ListNode beforeLast;
        int count = 0;
        while (count < (size - 1) / 2) { 
        	beforeLast = current;
            while (beforeLast.next.next != null) {
                beforeLast = beforeLast.next;
            }
            beforeLast.next.next = current.next;
            current.next = beforeLast.next;
            beforeLast.next = null;            
            current = current.next.next;
            count++;
        }
    }
}