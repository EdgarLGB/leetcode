/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // check the rest if it can form a group
        ListNode tail = getTail(head, k);
        if (head == null || tail == null) {
          // can not form the group
          return head;
        }
        ListNode newHead = head;
        head.next = reverseKGroup(tail.next, k);
        // reverse the linkedlist
        return reverseLinkedList(newHead, k);
    }

    private ListNode reverseLinkedList(ListNode node, int k) {
      if (k == 1) {
        return node;
      }
      reverseLinkedList(node.next, k - 1).next = node;
      return node;
    }

    private ListNode getTail(ListNode node, int k) {
      if (node == null || k == 1) {
        return node;
      }
      return getTail(node.next, k - 1);
    }
}
