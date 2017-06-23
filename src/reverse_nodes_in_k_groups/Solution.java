import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


public class Solution1 {

    public ListNode reverseKGroup(ListNode head, int k) {
        // check the rest if it can form a group
        ListNode tail = getTail(head, k);
        if (head == null || tail == null) {
            // can not form the group
            return head;
        }
        ListNode nodeNextToHead = head.next;
        head.next = reverseKGroup(tail.next, k);
        // reverse the linkedlist
        ListNode newHead = reverseLinkedList(nodeNextToHead, k - 1);
        nodeNextToHead.next = head;
        return newHead;
    }

    private ListNode reverseLinkedList(ListNode node, int k) {
        if (k == 1) {
            return node;
        }
        ListNode tail = reverseLinkedList(node.next, k - 1);
        tail.next = node;
        return tail;
    }

    private ListNode getTail(ListNode node, int k) {
        if (node == null || k == 1) {
            return node;
        }
        return getTail(node.next, k - 1);
    }
}
