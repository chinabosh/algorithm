package com.bosh.lib;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author lzq
 * @date 2021/9/1
 */
public class SolutionTest {

    @Test
    public void reverse() {
        Solution solution = new Solution();
        System.out.println(Integer.MAX_VALUE);
        assertEquals(321, solution.reverse(123));
        assertEquals(-321, solution.reverse(-123));
        assertEquals(21, solution.reverse(120));
        assertEquals(0, solution.reverse(0));
        assertEquals(0, solution.reverse((int )Math.pow(2, 31) - 1));
        assertEquals(0, solution.reverse(1534236469));
    }

    @Test
    public void testListOfDepth() {
        Solution1 solution1 = new Solution1();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left.left = new TreeNode(8);
        ListNode[] listNodes = solution1.listOfDepth(treeNode);
        for (ListNode node : listNodes) {
            ListNode tmp = node;
            while (tmp != null) {
                System.out.print(tmp.val);
                tmp = tmp.next;
            }
            System.out.print("\t");
        }
    }

    @Test
    public void testMergeKLists() {
        Solution2 solution2 = new Solution2();
        ListNode[] lists = new ListNode[2];
//        ListNode node1 = new ListNode(1);
//        node1.next = new ListNode(4);
//        node1.next.next = new ListNode(5);
//        lists[0] = node1;
//        ListNode node2 = new ListNode(1);
//        node2.next = new ListNode(3);
//        node2.next.next = new ListNode(4);
//        lists[1] = node2;
//        ListNode node3 = new ListNode(2);
//        node3.next = new ListNode(6);
//        lists[2] = node3;
        lists[0] = new ListNode(1);
        lists[1] = new ListNode(0);
        ListNode node = solution2.mergeKLists1(lists);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}