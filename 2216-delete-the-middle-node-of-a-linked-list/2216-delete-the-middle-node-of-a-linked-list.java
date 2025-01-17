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
    public ListNode deleteMiddle(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        ListNode prev = head;
        if(head.next == null)
            head = head.next;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            prev = slowPtr;
            slowPtr = slowPtr.next;
        }
        prev.next = slowPtr.next;
        slowPtr.next = null;
        return head;
    }
}