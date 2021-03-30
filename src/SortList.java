public class SortList {
	public ListNode sortList(ListNode head) {
        if (head == null) return null;
        
        return sortListRecursive(head);
    }
    
    private ListNode sortListRecursive(ListNode head) {
        if (head.next == null) return head;
        
		ListNode rightHead = divide(head);       
        ListNode leftHead = sortListRecursive(head);
        rightHead = sortListRecursive(rightHead);
        return combine(rightHead, leftHead);
    }

	private ListNode divide(ListNode head) {
		int length = 0;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        
        length = length / 2;
        ListNode leftTail = head;
        while (length > 0) {
        	leftTail = leftTail.next;
            length--;
        }
        
        ListNode rightHead = leftTail.next;
        leftTail.next = null;
		return rightHead;
	}
    
	private ListNode combine(ListNode rightHead, ListNode leftHead) {
		ListNode head;
		if (leftHead.val <= rightHead.val) {
            head = leftHead;
            leftHead = leftHead.next;
        } else {
            head = rightHead;
            rightHead = rightHead.next;
        }
        
        ListNode current = head;
        while (leftHead != null && rightHead != null) {
            if (leftHead.val <= rightHead.val) {
                current.next = leftHead;
                leftHead = leftHead.next;
            } else {
                current.next = rightHead;
                rightHead = rightHead.next;
            }
            current = current.next;
        }
        
        if (leftHead != null) {
            current.next = leftHead;
        } else {
            current.next = rightHead;
        }
		return head;
	}
}