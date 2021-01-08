public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int reminder = 0;
        return addTwoNumbersWithReminder(l1, l2, reminder);
    }

    public ListNode addTwoNumbersWithReminder(ListNode l1, ListNode l2, int reminder) {
        if (l1 == null) {
            return addNumberWithReminder(l2, reminder);
        }
        if (l2 == null) {
            return addNumberWithReminder(l1, reminder);
        }

        int sum = l1.val + l2.val + reminder;
        reminder = sum / 10;
        ListNode head = new ListNode(sum % 10);
        head.next = addTwoNumbersWithReminder(l1.next, l2.next, reminder);
        return head;
    }

    public ListNode addNumberWithReminder(ListNode l, int reminder) {
        if (l == null) {
            if (reminder > 0) {
                return new ListNode(reminder);
            } else {
                return null;
            }
        }

        int sum = l.val + reminder;
        reminder = sum / 10;
        l.val = sum % 10;
        if (reminder > 0) {
            l.next = addNumberWithReminder(l.next, reminder);
        }
        return l;
    }
}
