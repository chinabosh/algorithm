package com.bosh.lib;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

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

    @Test
    public void testBuildTree() {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        Solution3 solution3 = new Solution3();
        TreeNode treeNode = solution3.buildTree(preorder, inorder);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode head = new ListNode(0);
            ListNode node = head;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode1 = queue.poll();
                System.out.print(treeNode1.val + "\t");
                node.next = new ListNode(treeNode1.val);
                node = node.next;
                if (treeNode1.left != null) {
                    queue.add(treeNode1.left);
                }
                if (treeNode1.right != null) {
                    queue.add(treeNode1.right);
                }
            }
            System.out.println();
        }
    }

    @Test
    public void testNumberOfSubarrays() {
        Solution4 solution = new Solution4();
        int[] nums = new int[]{1, 1, 2, 1, 1};
        assertEquals(2, solution.numberOfSubarrays(nums, 3));
        nums = new int[]{2, 4, 6};
        assertEquals(0, solution.numberOfSubarrays(nums, 1));
        nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        assertEquals(16, solution.numberOfSubarrays(nums, 2));
        nums = new int[]{1, 1, 1, 1, 1};
        assertEquals(5, solution.numberOfSubarrays(nums, 1));
    }

    @Test
    public void testNumIslands() {
        Solution5 solution = new Solution5();
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        assertEquals(1, solution.numIslands(grid));
        grid = new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    public void testMovingCount() {
        Solution6 solution = new Solution6();
        assertEquals(3, solution.movingCount(2, 3, 1));
        assertEquals(1, solution.movingCount(3, 1, 0));
        assertEquals(88, solution.movingCount(11, 8, 16));
        assertEquals(135, solution.movingCount(38, 15, 9));
    }

    @Test
    public void testRotate() {
        Solution7 solution = new Solution7();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix);
        int[][] resMatrix = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertArrayEquals(matrix, resMatrix);
        matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        resMatrix = new int[][]{{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        solution.rotate(matrix);
        assertArrayEquals(matrix, resMatrix);
    }

    @Test
    public void testLongestValidParentheses() {
        Solution9 solution = new Solution9();
        assertEquals(2, solution.longestValidParentheses("(()"));
        assertEquals(4, solution.longestValidParentheses(")()())"));
        assertEquals(0, solution.longestValidParentheses(""));
        assertEquals(2, solution.longestValidParentheses("()(()"));
        assertEquals(2, solution.longestValidParentheses("())"));
        assertEquals(6, solution.longestValidParentheses("(()())"));
    }

    @Test
    public void testTrap() {
        Solution10 solution = new Solution10();
        assertEquals(6, solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    public void testLastRemaining() throws Exception {
        Solution11 solution = new Solution11();
        assertEquals(3, solution.lastRemaining(5, 3));
        assertEquals(2, solution.lastRemaining(10, 17));
    }

    @Test
    public void testHasGroupsSizeX() throws Exception {
        Solution12 solution = new Solution12();
        assertTrue(solution.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        assertFalse(solution.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        assertFalse(solution.hasGroupsSizeX(new int[]{1}));
        assertTrue(solution.hasGroupsSizeX(new int[]{1, 1}));
        assertTrue(solution.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
    }

    @Test
    public void testNumRookCaptures() throws Exception {
        Solution13 solution = new Solution13();
        assertEquals(3, solution.numRookCaptures(new char[][]{{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', 'R', '.', '.', '.', 'p'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}}));
        assertEquals(0, solution.numRookCaptures(new char[][]{{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'}, {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'}, {'.', 'p', 'B', 'R', 'B', 'p', '.', '.'}, {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'}, {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}}));
        assertEquals(3, solution.numRookCaptures(new char[][]{{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'p', 'p', '.', 'R', '.', 'p', 'B', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'B', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}}));
    }

    @Test
    public void testSurfaceArea() throws Exception {
        Solution14 solution = new Solution14();
        assertEquals(10, solution.surfaceArea(new int[][]{{2}}));
        assertEquals(34, solution.surfaceArea(new int[][]{{1, 2}, {3, 4}}));
        assertEquals(16, solution.surfaceArea(new int[][]{{1, 0}, {0, 2}}));
        assertEquals(32, solution.surfaceArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        assertEquals(46, solution.surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }

    @Test
    public void testMessage() throws Exception {
        Solution15 solution = new Solution15();
        assertEquals(4, solution.message(new int[]{1, 2, 3, 1}));
        assertEquals(12, solution.message(new int[]{2, 7, 9, 3, 1}));
        assertEquals(12, solution.message(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
    }

    @Test
    public void testMiddleNode() throws Exception {
        Solution16 solution = new Solution16();
        ListNode head = new ListNode(1);
        ListNode next = head;
        for (int i = 0; i < 4; i++) {
            next.next = new ListNode(i + 2);
            next = next.next;
        }
        System.out.print(solution.middleNode(head).val);
    }

    @Test
    public void testMinIncrementForUnique() throws Exception {
        Solution17 solution = new Solution17();
        assertEquals(6, solution.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
        assertEquals(1, solution.minIncrementForUnique(new int[]{0, 2, 0}));
        assertEquals(1, solution.minIncrementForUnique(new int[]{1, 2, 2}));
        assertEquals(5, solution.minIncrementForUnique(new int[]{7, 7, 8, 9, 9}));
        assertEquals(5, solution.minIncrementForUnique(new int[]{2, 1, 1, 1}));
        assertEquals(3, solution.minIncrementForUnique(new int[]{2, 2, 2, 1}));
        assertEquals(393, solution.minIncrementForUnique(new int[]{87, 46, 87, 13, 56, 1, 93, 0, 38, 80, 99, 1, 82, 51, 3, 77, 11, 61, 77, 67, 37, 2, 43, 91, 33, 24, 13, 51, 53, 7, 40, 65, 96, 43, 43, 47, 22, 39, 64, 39, 58, 83, 99, 88, 37, 2, 61, 47, 23, 4, 32, 79, 96, 10, 87, 4, 71, 2, 42, 87, 39, 92, 71, 60, 16, 34, 41, 59, 99, 28, 50, 93, 34, 62, 76, 63, 75, 19, 95, 17, 58, 29, 63, 29, 43, 68, 26, 72, 34, 13, 61, 16, 43, 39, 7, 71, 68, 77, 54, 55}));
        assertEquals(1838, solution.minIncrementForUnique(new int[]{25, 62, 36, 17, 15, 7, 9, 53, 9, 57, 54, 9, 36, 0, 56, 36, 49, 32, 45, 61, 36, 57, 22, 6, 0, 14, 55, 20, 14, 32, 62, 33, 22, 5, 37, 14, 24, 25, 50, 15, 61, 48, 31, 58, 23, 25, 8, 51, 26, 33, 31, 43, 24, 60, 28, 23, 26, 50, 65, 57, 31, 19, 29, 22, 16, 12, 63, 32, 7, 25, 25, 33, 64, 64, 37, 40, 44, 33, 32, 20, 45, 6, 20, 58, 15, 63, 64, 37, 2, 6, 13, 21, 7, 52, 24, 15, 2, 25, 0, 7}));
    }

    @Test
    public void testThreeNum() throws Exception {
        Solution18 solution = new Solution18();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{3,0,-2,-1,1,2};
        List<List<Integer>> list = solution.threeSum(nums);
        System.out.print(list);
    }

    @Test
    public void testIsValid() throws Exception {
        Solution19 solution = new Solution19();
        assertTrue(solution.isValid("()"));
        assertTrue(solution.isValid("()[]{}"));
        assertFalse(solution.isValid("(]"));
        assertFalse(solution.isValid("([)]"));
        assertTrue(solution.isValid("{[]}"));
        assertFalse(solution.isValid("["));
    }

    @Test
    public void testSolveSoduku() throws Exception {
        Solution20 solution = new Solution20();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//                board = new char[][]{
//                        {'5', '3', '4',  '6', '7', '8',  '9', '1', '2'},
//                        {'6', '7', '2',  '1', '9', '5',  '3', '4', '8'},
//                        {'1', '9', '8',  '3', '4', '2',  '5', '6', '7'},
//
//                        {'8', '5', '9',  '7', '6', '1',  '4', '2', '3'},
//                        {'4', '2', '6',  '8', '5', '3',  '7', '9', '1'},
//                        {'7', '1', '3',  '9', '2', '4',  '8', '5', '6'},
//
//                        {'9', '6', '1',  '5', '3', '7',  '2', '8', '4'},
//                        {'2', '8', '7',  '4', '1', '9',  '6', '3', '5'},
//                        {'3', '4', '5',  '2', '8', '6',  '1', '7', '9'}};
        board = new char[][]{
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},

                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},

                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
//                board = new char[][]{
//                        {'.','.','9', '7','4','8', '.','.','2'},
//                        {'7','.','.', '6','.','2', '.','.','9'},
//                        {'.','2','.', '1','.','9', '.','.','.'},
//
//                        {'.','.','7', '9','8','6', '2','4','1'},
//                        {'2','6','4', '3','1','7', '5','9','8'},
//                        {'1','9','8', '5','2','4', '3','6','7'},
//
//                        {'9','.','.', '8','6','3', '.','2','.'},
//                        {'.','.','2', '4','9','1', '.','.','6'},
//                        {'.','.','.', '2','7','5', '9','.','.'}};
        solution.solveSudoku(board);
    }

    @Test
    public void testLongestPalindrome() throws Exception {
        Solution21 solution = new Solution21();
//        String res = solution.longestPalindrome("babad");
        String res = solution.longestPalindrome("abcda");
//        String res = solution.longestPalindrome("cbbd");
//        String res = solution.longestPalindrome("ccc");
        System.out.println(res);
    }

    @Test
    public void testReverseKGroup() throws Exception {
        Solution22 solution = new Solution22();
        ListNode head = new ListNode(1);
        ListNode next = head;
        for (int i = 0; i < 8; i++) {
            next.next = new ListNode(i + 2);
            next = next.next;
        }
        head = solution.reverseKGroup(head, 3);
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val);
            builder.append("->");
            head = head.next;
        }
        System.out.println(builder);
    }

    @Test
    public void testConvert() throws Exception {
        Solution23 solution = new Solution23();
        String ans = solution.convert("PAYPALISHIRING", 3);
        assertEquals("PAHNAPLSIIGYIR", ans);
    }

    @Test
    public void testIsMatch() throws Exception {
        Solution8 solution = new Solution8();
        assert !solution.isMatch("aa", "a");
        assert solution.isMatch("aa", "a*");
        assert solution.isMatch("ab", ".*");
        assert solution.isMatch("aab", "c*a*b*");
        assert !solution.isMatch("mississippi", "mis*is*p*.");
    }

    @Test
    public void testFindMedianSortedArrays() throws Exception {
        Solution24 solution = new Solution24();
        int[] nums1 = new int[]{1, 1};
        int[] nums2 = new int[]{1, 1};
        double res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    @Test
    public void testLengthOfLongestSubstring() throws Exception {
        Solution25 solution = new Solution25();
        System.out.println("ab".substring(0, 1));
        int num = solution.lengthOfLongestSubstring("");
        System.out.println(num);
    }

    @Test
    public void testAddTwoNumbers() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = new Solution27().addTwoNumbers(l1, l2);
        do {
            System.out.print(res.val);
            res = res.next;
        } while (res != null);
    }

    @Test
    public void testMaxSubarraySumCircular() throws Exception {
        Solution28 solution = new Solution28();
        //        int[] test = new int[]{9,7,-6,7,9,-10,5,9,0,-1};
        int[] test = new int[]{-5, 3, 5};
        int max = solution.maxSubarraySumCircular(test);
        assertEquals(8, max);
    }

    @Test
    public void testReverseOnlyLetters() throws Exception {
        Solution29 solution = new Solution29();
        String res = solution.reverseOnlyLetters("Test1ng-Leet=code-Q!");
//        String res = solution.reverseOnlyLetters("dc-ba");
        assertEquals("Qedo1ct-eeLg=ntse-T!", res);
    }

    @Test
    public void testIsRobotBounded() throws Exception {
        Solution30 solution = new Solution30();
        boolean res = solution.isRobotBounded("GGLLGG");
        assertTrue(res);
    }

    @Test
    public void testGroupAnagrams() {
        Solution31 solution = new Solution31();
        String[] test = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = solution.groupAnagrams(test);
        for (List<String> list : res) {
            for (String s : list) {
                System.out.print(s + "  ");
            }
            System.out.println();
        }
    }

    @Test
    public void testFirstMissingPositive() {
        Solution32 solution = new Solution32();
        assertEquals(3, solution.firstMissingPositive(new int[]{1,2,0}));
        assertEquals(2, solution.firstMissingPositive(new int[]{3,4,-1,1}));
        assertEquals(1, solution.firstMissingPositive(new int[]{7,8,9,11,12}));
        assertEquals(2, solution.firstMissingPositive(new int[]{1}));
    }

    @Test
    public void testSolveNQueens() {
        Solution33 solution = new Solution33();
//        List<List<String>> res = solution.solveNQueens(5);
        for (int i = 1; i<=9;i++) {
            System.out.println( i+":" + solution.solveNQueens(i).size());
        }
//        for (List<String> list : res) {
//            for (String s : list) {
//                System.out.println(s);
//            }
//            System.out.println();
//        }
    }

    @Test
    public void testGetPermutation() {
        Solution34 solution = new Solution34();
        assertEquals("132", solution.getPermutation(3, 2));
        assertEquals("21", solution.getPermutation(2, 2));
        assertEquals("2314", solution.getPermutation(4, 9));
        assertEquals("213", solution.getPermutation(3, 3));
        assertEquals("123", solution.getPermutation(3, 1));
        assertEquals("12", solution.getPermutation(2, 1));
    }

    @Test
    public void testMinWindow() {
        Solution35 solution = new Solution35();
        assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("a", solution.minWindow("a", "a"));
        assertEquals("", solution.minWindow("a", "aa"));
    }

    @Test
    public void testMaxProfit() {
        Solution36 solution = new Solution36();
        assertEquals(6, solution.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        assertEquals(4, solution.maxProfit(new int[]{1,2,3,4,5}));
        assertEquals(0, solution.maxProfit(new int[]{7,6,4,3,1}));
        assertEquals(0, solution.maxProfit(new int[]{1}));
        int count = (int) (Math.random() * 105);
        int[] in = new int[count];
        for (int i = 0; i < count; i++) {
            in[i] = (int) (Math.random() * 105);
            System.out.print(in[i] + ",");
        }
        System.out.println();
        System.out.println(solution.maxProfit(in));
    }

    @Test
    public void testMaxProfit1() {
        Solution37 solution = new Solution37();
        assertEquals(5, solution.maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(0, solution.maxProfit(new int[]{7,6,4,3,1}));
        int count = (int) (Math.random() * 105);
        int[] in = new int[count];
        for (int i = 0; i < count; i++) {
            in[i] = (int) (Math.random() * 105);
            System.out.print(in[i] + ",");
        }
        System.out.println();
        System.out.println(solution.maxProfit(in));
    }

    @Test
    public void testRestoreIpAddresses() {
        Solution38 solution = new Solution38();
        List<String> res = solution.restoreIpAddresses("25525511135");
        assert res.contains("255.255.11.135");
        assert res.contains("255.255.111.35");
        assert res.size() == 2;
        res = solution.restoreIpAddresses("0000");
        assert res.contains("0.0.0.0");
        assert res.size() == 1;
        res = solution.restoreIpAddresses("1111");
        assert res.contains("1.1.1.1");
        assert res.size() == 1;
        res = solution.restoreIpAddresses("010010");
        assert res.contains("0.10.0.10");
        assert res.contains("0.100.1.0");
        assert res.size() == 2;
        res = solution.restoreIpAddresses("101023");
        assert res.contains("1.0.10.23");
        assert res.contains("1.0.102.3");
        assert res.contains("10.1.0.23");
        assert res.contains("10.10.2.3");
        assert res.contains("101.0.2.3");
        assert res.size() == 5;
    }

    @Test
    public void testIsNumber() {
        Solution39 solution = new Solution39();
        assert solution.isNumber("0");
        assert !solution.isNumber("e");
        assert !solution.isNumber(".");
        assert solution.isNumber(".1");
        assert solution.isNumber("2");
        assert solution.isNumber("0089");
        assert solution.isNumber("-0.1");
        assert solution.isNumber("+3.14");
        assert solution.isNumber("4.");
        assert solution.isNumber("-.9");
        assert solution.isNumber("2e10");
        assert solution.isNumber("-90E3");
        assert solution.isNumber("3e+7");
        assert solution.isNumber("+6e-1");
        assert solution.isNumber("53.5e93");
        assert solution.isNumber("-123.456e789");
        assert !solution.isNumber("abc");
        assert !solution.isNumber("1a");
        assert !solution.isNumber("1e");
        assert !solution.isNumber("e3");
        assert !solution.isNumber("99e2.5");
        assert !solution.isNumber("--6");
        assert !solution.isNumber("-+3");
        assert !solution.isNumber("95a54e53");
    }

    @Test
    public void testUniquePathsWithObstacles() {
        Solution41 solution = new Solution41();
        assertEquals(1, solution.uniquePathsWithObstacles(new int[][]{{0,0}}));
        assertEquals(2, solution.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        assertEquals(1, solution.uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
    }

    @Test
    public void testCandy() {
        Solution42 solution42 = new Solution42();
        assertEquals(5, solution42.candy(new int[]{1,0,2}));
        assertEquals(4, solution42.candy(new int[]{1,2,2}));
    }

    @Test
    public void testContainsNearbyDuplicate() {
        Solution43 solution43 = new Solution43();
        assert solution43.containsNearbyDuplicate2(new int[]{1,0,1,1}, 1);
        assert solution43.containsNearbyDuplicate2(new int[]{1,2,3,1}, 3);
        assert !solution43.containsNearbyDuplicate2(new int[]{1,2,3,1,2,3}, 2);
    }

    @Test
    public void testCountDigitOne() {
        Solution44 solution44 = new Solution44();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + ":"+solution44.countDigitOne(i));
        }
        assertEquals(6, solution44.countDigitOne(13));
        assertEquals(0, solution44.countDigitOne(0));
//        assertEquals(767944060, solution44.countDigitOne(824883294));
    }

    @Test
    public void testMaxSlidingWindow() {
        Solution45 solution45 = new Solution45();
        assertArrayEquals(new int[]{3,3,2,5}, solution45.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3));
        assertArrayEquals(new int[]{3,3,5,5,6,7}, solution45.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }

    @Test
    public void testMaxPoints() {
        Solution46 solution46 = new Solution46();
        assertEquals(3, solution46.maxPoints(new int[][]{{1,1},{2,2},{3,3}}));
        assertEquals(4, solution46.maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));
    }

    @Test
    public void testCountAndSay() {
        Solution47 solution47 = new Solution47();
        assertEquals("111221", solution47.countAndSay(5));
        assertEquals("1211", solution47.countAndSay(4));
        assertEquals("21", solution47.countAndSay(3));
        assertEquals("11", solution47.countAndSay(2));
        assertEquals("1", solution47.countAndSay(1));
    }

    @Test
    public void testStrStr() {
        Solution48 solution48 = new Solution48();
        assertEquals(4, solution48.strStr("mississippi", "issip"));
        assertEquals(2, solution48.strStr("hello", "ll"));
        assertEquals(-1, solution48.strStr("aaaaa", "bba"));
        assertEquals(0, solution48.strStr("", ""));
    }

    @Test
    public void testJump() {
        Solution49 solution49 = new Solution49();
        assertEquals(2, solution49.jump(new int[]{2,3,1,1,4}));
        assertEquals(1, solution49.jump(new int[]{2,1}));
        assertEquals(2, solution49.jump(new int[]{2,3,0,1,4}));
    }
}