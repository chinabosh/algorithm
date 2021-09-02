package com.bosh.lib;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lzq
 * @date 2021/9/2
 */
public class Solution1 {

    /**
     * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
     *
     *  
     *
     * 示例：
     *
     * 输入：[1,2,3,4,5,null,7,8]
     *
     *         1
     *        /  \
     *       2    3
     *      / \    \
     *     4   5    7
     *    /
     *   8
     *
     * 输出：[[1],[2,3],[4,5,7],[8]]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> listNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode head = new ListNode(0);
            ListNode node = head;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                node.next = new ListNode(treeNode.val);
                node = node.next;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            listNodes.add(head.next);
        }
        return listNodes.toArray(new ListNode[0]);
    }

    /**
     * 用一个队列来缓存一层中的所有节点，就可以知道下一层的所有节点
     */
}
