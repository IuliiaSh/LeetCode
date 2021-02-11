public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode lessHead = null;
        ListNode greaterOrEqualHead = null;
        if (head.val >= x) {
            greaterOrEqualHead = new ListNode(head.val);
            lessHead = findAndRemoveLessHead(head, x);
            
            if (lessHead == null) return head;
        } else {
            lessHead = new ListNode(head.val);
            greaterOrEqualHead = findAndRemoveGreaterOrEqualHead(head, x);
            
            if (greaterOrEqualHead == null) return head;
        }
        head = head.next;
        
        ListNode currentLess = lessHead;
        ListNode currentGreaterOrEqualHead = greaterOrEqualHead;
        while (head != null) {
            if (head.val < x) {
            	currentLess.next = new ListNode(head.val);
            	currentLess = currentLess.next;
            } else {
            	currentGreaterOrEqualHead.next = new ListNode(head.val);
            	currentGreaterOrEqualHead = currentGreaterOrEqualHead.next;
            }
            head = head.next;
        }
        currentLess.next = greaterOrEqualHead;
        return lessHead;
    }
    
    private ListNode findAndRemoveLessHead(ListNode head, int x) {
        ListNode result = null;
        while (head.next != null) {
            if (head.next.val < x) {
                result = new ListNode(head.next.val);
                head.next = head.next.next;
                return result;
            }
            head = head.next;
        }
        return result;
    }
    
    private ListNode findAndRemoveGreaterOrEqualHead(ListNode head, int x) {
        ListNode result = null;
        while (head.next != null) {
            if (head.next.val >= x) {
                result = new ListNode(head.next.val);
                head.next = head.next.next;
                return result;
            }
            head = head.next;
        }
        return result;
    }
}
