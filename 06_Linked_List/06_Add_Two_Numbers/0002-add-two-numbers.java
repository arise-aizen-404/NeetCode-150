/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        // Traverse both linked lists
        while (head1 != null || head2 != null) {
            int sum = carry;

            // Add the values of the current nodes, if they exist
            if (head1 != null) {
                sum += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.val;
                head2 = head2.next;
            }

            // Update the carry and create a new node with the sum % 10
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        // If there is a remaining carry, create a new node for it
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        // Return the head of the result linked list
        return dummy.next;
    }
}