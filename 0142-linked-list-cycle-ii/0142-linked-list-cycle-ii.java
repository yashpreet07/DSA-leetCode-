/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//  Here same to the LL Cycle-1 just when there is no cycle instead of returning false we return null. 
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        do{
            if(hare == null || hare.next == null)
                return null;  //noloop.       
            hare = hare.next.next;
            tortoise = tortoise.next;
        }while(hare != tortoise);

        // Now this means there is a loop and the hare and tortoise have meet.
        // Using the formulae Making the two pointers run at same pace.
        hare=head;
        while(hare != tortoise)
        {
            hare = hare.next;
            tortoise = tortoise.next;
        }
        return hare;
    }
}