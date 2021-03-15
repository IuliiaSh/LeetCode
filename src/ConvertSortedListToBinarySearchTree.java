public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        
        ListNode current = head;
        int middleIndex = 0;
        while (current.next != null) {
            current = current.next;
            middleIndex++;
        }
        middleIndex = (middleIndex + 1)/2;
        
        ListNode previous = null;
        current = head;
        int index = 0;
        while (index != middleIndex) {
            previous = current;
            current = current.next;
            index++;
        }
        if (previous != null) previous.next = null;
        
        TreeNode result = new TreeNode(current.val);
        result.left = sortedListToBST(head);
        result.right = sortedListToBST(current.next);
        return result;
    }
}
