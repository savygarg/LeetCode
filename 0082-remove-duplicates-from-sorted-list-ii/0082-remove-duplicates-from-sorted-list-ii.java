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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while(head != null){
            if(head.next != null && head.val == head.next.val){
               int dup = head.val;
               while(head != null && head.val == dup){
                head = head.next;
               }
               temp.next = head;
            }
            else {
                temp = head;
                head = head.next;
            }
        }
        return dummy.next;
    }
}