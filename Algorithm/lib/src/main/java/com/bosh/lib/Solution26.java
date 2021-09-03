package com.bosh.lib;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution26 {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * @param l1
     * @param l2
     * @return
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tmpResult = result;
        int up = 0;
        do {
            if (l1 != null && l2 != null) {
                tmpResult.val = (l1.val + l2.val + up) % 10;
                up = (l1.val + l2.val + up) / 10;
            } else if (l1 == null) {
                tmpResult.val = (l2.val + up) % 10;
                up = (l2.val + up) / 10;
            } else {
                tmpResult.val = (l1.val + up) % 10;
                up = (l1.val + up) / 10;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 == null && l2 == null) {
                break;
            }
            tmpResult.next = new ListNode(0);
            tmpResult = tmpResult.next;
        } while (true);
        if (up != 0) {
            tmpResult.next = new ListNode(up);
        }
        return result;
    }
}
