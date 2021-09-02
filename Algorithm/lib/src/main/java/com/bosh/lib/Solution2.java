package com.bosh.lib;

import java.util.List;

/**
 * @author lzq
 * @date 2021/9/2
 */
public class Solution2 {

    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        int count = 0;
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (true) {
            count = 0;
            int max = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < lists.length; i++) {
                ListNode listNode = lists[i];
                if (listNode != null) {
                    if (listNode.val <= max) {
                        max = listNode.val;
                        index = i;
                    }
                } else {
                    count++;
                }
            }
            if (count == length) {
                return result.next;
            }
            head.next = new ListNode(lists[index].val);
            head = head.next;
            lists[index] = lists[index].next;
        }
    }
    /**
     * 每次比较每组中的数据，最小的往前移动
     */

    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode listNode = null;
        int begin = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                listNode = lists[i];
                begin = i+1;
                break;
            }
        }
        if (listNode == null) {
            return null;
        }
       for (int i = begin; i < lists.length; i++) {
           ListNode head = listNode;
           ListNode pre = head;
           ListNode tmp = lists[i];
           while (tmp != null) {
               if(head == null) {
                   pre.next = tmp;
                   tmp = null;
                   continue;
               }
               if (head.val <= tmp.val) {
                   pre = head;
                   head = head.next;
               } else {
                   if (pre == head) {
                       listNode = new ListNode(tmp.val);
                       listNode.next = head;
                       head = listNode;
                       pre = head;
                       tmp = tmp.next;
                   } else {
                       pre.next = new ListNode(tmp.val);
                       pre.next.next = head;
                       pre = pre.next;
                       tmp = tmp.next;
                   }
               }
           }
       }
       return listNode;
    }
    /**
     *
     */

    /**
     * 官方方法
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}
