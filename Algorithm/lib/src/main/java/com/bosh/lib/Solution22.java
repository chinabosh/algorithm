package com.bosh.lib;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution22 {
    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。
     * <p>
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 示例 :
     * <p>
     * 给定这个链表：1->2->3->4->5
     * <p>
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * <p>
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     * <p>
     * 说明 :
     * <p>
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode curHead = head;
        boolean firstReverse = true;
        ListNode last = head;
        do {
            ListNode nextHead = getReverseLast(curHead, k);
            if (nextHead == null) {
                break;
            } else {
                nextHead = nextHead.next;
            }
            ListNode indexAfter = curHead.next;
            ListNode index = curHead;
            ListNode indexBefore = nextHead;
            for (int i = 0; i < k; i++) {
                index.next = indexBefore;
                if (i < k - 1) {
                    indexBefore = index;
                    index = indexAfter;
                    indexAfter = indexAfter.next;
                }
            }
            if (firstReverse) {
                head = index;
                firstReverse = false;
                last = curHead;
            } else {
                last.next = index;
                last = curHead;
            }
            curHead = nextHead;
        } while (true);
        return head;
    }

    private ListNode getReverseLast(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int i = 1;
        while (head.next != null && i < k) {
            head = head.next;
            i++;
        }
        if (i < k) {
            return null;
        } else {
            return head;
        }
    }
}
