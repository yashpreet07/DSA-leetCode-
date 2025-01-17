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
//  Your Code 
// class Solution {
//     public ListNode deleteMiddle(ListNode head) {
//         ListNode fastPtr = head;
//         ListNode slowPtr = head;
//         ListNode prev = head;
//         if(head.next == null)
//             head = head.next;
//         while(fastPtr != null && fastPtr.next != null){
//             fastPtr = fastPtr.next.next;
//             prev = slowPtr;
//             slowPtr = slowPtr.next;
//         }
//         prev.next = slowPtr.next;
//         slowPtr.next = null;
//         return head;
//     }
// }

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // If there's 0 or 1 node, return null (nothing to delete).
        }

        ListNode fastPtr = head;
        ListNode slowPtr = head;
        ListNode prev = null;

        // Traverse the list to find the middle node.
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            prev = slowPtr;
            slowPtr = slowPtr.next;
        }

        // Delete the middle node.
        if (prev != null) {
            prev.next = slowPtr.next;
        }

        return head;
    }
}