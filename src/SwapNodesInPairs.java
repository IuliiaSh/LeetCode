public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode previous;
        ListNode first = head;
        ListNode second = head.next;
        ListNode next = second.next;
        ListNode result = second;
        second.next = first;
        first.next = next;
        while (next != null) {
            previous = first;
            first = previous.next;
            second = first.next;
            if (second == null) break;
            next = second.next;
            
            previous.next = second;
            second.next = first;
            first.next = next;
        }
        return result;
    }
}
