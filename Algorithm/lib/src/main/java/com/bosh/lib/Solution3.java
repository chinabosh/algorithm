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
        int inIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[preIndex] == inorder[i]) {
                inIndex = i;
                break;
            }
        }
        if (inIndex == -1) {
            return null;
        }
//        int[] preLeft = new int[inIndex];
//        int[] inLeft = new int[inIndex];
//        TreeNode treeNode = new TreeNode(preorder[preIndex]);
//        for (int i = 0; i < inIndex; i++) {
//            inLeft[i] = inorder[i];
//            preLeft[i] = preorder[preIndex + i + 1];
//        }
//        treeNode.left = buildTree(preLeft, inLeft);
//        int[] preRight = new int[inorder.length - inIndex - 1];
//        int[] inRight = new int[inorder.length - inIndex - 1];
//        for (int i = 0; i < inorder.length - inIndex - 1; i++) {
//            inRight[i] = inorder[inIndex + i + 1];
//            preRight[i] = preorder[inIndex + i + 1];
//        }
//        treeNode.right = buildTree(preRight, inRight);
//        return treeNode;
        return buildTree(preorder, inorder, 0, 0, preorder[preIndex]);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder,
                              int preStart, int inStart, int end) {
        if (preStart >= preorder.length) {
            return null;
        }
        int inIndex = -1;
        for (int i = inStart; inorder[i] != end; i++) {
            if (preorder[preStart] == inorder[i]) {
                inIndex = i;
                break;
            }
        }
        if (inIndex == -1) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        treeNode.left = buildTree(preorder, inorder, preStart + 1,
                 inStart, inIndex - 1);
        treeNode.right = buildTree(preorder, inorder, preStart + inIndex - inStart + 1,
                 inIndex + 1, preorder[preStart]);
        return treeNode;
    }
}
