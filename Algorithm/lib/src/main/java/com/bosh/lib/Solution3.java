package com.bosh.lib;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution3 {

    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preIndex = 0;
        TreeNode node = new TreeNode(preorder[preIndex]);
        return node;
    }
}
