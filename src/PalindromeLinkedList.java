public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        int size = getSize(head);
        int middleIndex = size/2 + size%2;
        ListNode middle = moveToIndex(head, middleIndex);
        ListNode tail = reverse(middle);
        for (int i = 1; i <= middleIndex; i++) {
            if (head.val != tail.val) return false;
            
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next; 
        }
        return size;
    }
    
    private ListNode moveToIndex(ListNode head, int index) {
    	ListNode previous = head;
        int previousIndex = 1;
        while (previousIndex != index) {
            previous = previous.next;
            previousIndex++;
        }
        return previous;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode previous = head;
        ListNode current = previous.next;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
