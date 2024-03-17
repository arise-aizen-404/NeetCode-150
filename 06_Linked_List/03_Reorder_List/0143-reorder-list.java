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
    public void reorderList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        temp = head;
        int left = 0;
        int right = arr.size() - 1;
        while(left < right) {
            temp.val = arr.get(left);
            temp = temp.next;
            left += 1;
            
            temp.val = arr.get(right);
            temp = temp.next;
            right -= 1;
        }
        if(left == right) {
            temp.val = arr.get(left);
        }
    }
}