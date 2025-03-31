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
    public int gcd(int a,int b){
        if(b == 0)
            return a;
        return gcd(b,a % b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null)
            return head;
        ListNode curr = head;
        ListNode fwd = head;
        while(curr.next != null){
            fwd = curr.next;
            ListNode newNode = new ListNode(gcd(fwd.val,curr.val));
            curr.next = newNode;
            newNode.next = fwd;
            curr = fwd;
        }
        return head;
    }
}