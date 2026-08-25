import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Add first node of every list
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {

            // Get smallest node
            ListNode current = pq.poll();

            // Add it to result
            tail.next = current;
            tail = tail.next;

            // Add next node from same list
            if (current.next != null) {
                pq.add(current.next);
            }
        }

        return dummy.next;
    }
}