/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
      ListNode node = head;
      if (node == null || node.next == null) {
        return node;
      }
      ListNode node2 = node.next;
      ListNode nextNode = node2.next;
      node2.next = node;
      node.next = swapPairs(nextNode);
      return node2;
    }
}
