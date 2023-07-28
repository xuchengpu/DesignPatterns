package com.xcp.designpatterns.lecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by 许成谱 on 2023/2/22 14:08.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class LeetCodeAlgorithm {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        ListNode l2 = new ListNode(4);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(5);
//        ListNode l5 = new ListNode(6);
//        ListNode l6 = new ListNode(4);
//        l1.next = l2;
//        l2.next = l3;
//        l4.next = l5;
//        l5.next = l6;
//        ListNode listNode = addTwoNumbers(l1, l4);
        int[] nums=new int[]{5,7,7,8,8,10};
        searchRange(nums,8);

    }


    /**
     * 两数之和
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int a = 0, b = 0, carry = 0;
        while (l1 != null || l2 != null) {
            a = l1 != null ? l1.val : 0;
            b = l2 != null ? l2.val : 0;
            if (head == null) {
                head = tail = new ListNode((a + b + carry) % 10);
            } else {
                tail.next = new ListNode((a + b + carry) % 10);
                tail = tail.next;
            }
            carry = (a + b + carry) / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        //通过移动左右指针逐个比较的方式来实现判断是否对称二叉树
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);//如果root为对称二叉树，那两个root组成的树必然也是对称二叉树
        }

        private boolean check(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
        }

        int ans = 1;

        public int diameterOfBinaryTree(TreeNode root) {

            depth(root);
            return ans;
        }

        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = 0, r = 0;
            if (root.left != null) {
                l = depth(root.left) + 1;
            }
            if (root.right != null) {
                r = depth(root.right) + 1;
            }
            ans = Math.max(ans, l + r);
            return Math.max(l, r);
        }

        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            ArrayList list = new ArrayList();
            Iterator iterator = list.iterator();
            iterator.remove();
            if (root1 == null && root2 == null) {
                return null;
            }
            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
                return root1;
            }
            root1.val = root1.val + root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }

        /*   给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
        并且每个节点只能存储 一位 数字。

           请你将两个数相加，并以相同形式返回一个表示和的链表。

           你可以假设除了数字 0 之外，这两个数都不会以 0 开头。*/
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode node = new ListNode();
            ListNode head = node;
            int dig = 0;
            while (l1 != null || l2 != null) {
                int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + dig;
                node.val = sum % 10;
                dig = sum / 10;

                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
                if (l1 == null && l2 == null && dig == 0) {
                    break;
                }
                node.next = new ListNode();
                node = node.next;
            }

            if (dig > 0) {
                node.val++;
            }
            return head;
        }

        //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int left = 0;
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    left = Math.max(left, map.get(s.charAt(i) + 1));//取最大值是应为map从来没有移除过历史数据，所以可能取的是i之前的字符串位置
                }
                map.put(s.charAt(i), i);
                maxLen = Math.max(maxLen, i - left + 1);
            }
            return maxLen;
        }

        //给你一个字符串 s，找到 s 中最长的回文子串。
        //如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return null;
            }
            //中心扩散法
            char[] chars = s.toCharArray();
            int maxlen = 1;
            int len = 1;
            int left = 0;
            int right = 0;
            int start = -1;
            for (int i = 0; i < chars.length; i++) {
                left = i - 1;
                right = i + 1;
                while (left >= 0 && chars[left] == chars[i]) {
                    left--;
                    len++;
                }
                while (right < chars.length && chars[right] == chars[i]) {
                    right++;
                    len++;
                }
                while (left >= 0 && right < chars.length && chars[right] == chars[left]) {
                    len += 2;
                    left--;
                    right++;
                }
                if (len >= maxlen) {
                    maxlen = len;
                    start = left;
                }
                len = 1;
            }
            return s.substring(start + 1, start + 1 + maxlen);
        }

    }

    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    //电话号码组合，回溯算法
    public List<String> letterCombinations(String digits) {
        List<String> letters = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return letters;
        }
        combine(letters, digits, 0, new StringBuilder());
        return letters;
    }

    private void combine(List<String> letters, String digits, int index, StringBuilder temp) {
        if (index == digits.length()) {
            letters.add(temp.toString());
            return;
        }
        char c = digits.charAt(index);
        String chars = letterMap[c - '0'];
        for (int i = 0; i < chars.length(); i++) {
            combine(letters, digits, index + 1, temp.append(chars.charAt(i)));
            temp.deleteCharAt(index);
        }

    }

    //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode origin = head;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        if (n >= length) {
            return origin;
        }
        head = origin;
        for (int i = 1; i < length - n; i++) {
            head = head.next;
        }
        head.next = head.next == null ? null : head.next.next;
        return origin;
    }

    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     * 示例 1：
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     */
    public int search(int[] nums, int target) {
        //核心思想：看见有序，再看见查找，第一反应应该是二分查找。本题中将数组一分为二，有一边必然是有序的，另一边或许有序。
        // 根据这些就可以不断淘汰掉一边。
        //特殊值的判断
        if (nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[l] <= nums[mid]) {//注意这里等号 l和mid有可能相等
                //左边有序，拿左边数据来决定淘汰谁
                if (nums[l] <= target && target < nums[mid]) {
                    //target在有序的区间内
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                //右边有序，拿右边数据来判断该淘汰谁
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int[]{-1, -1};
        }
        int l = 0, r = nums.length - 1;
        return binarySearch(nums, l, r, target);
    }
    private static int[] binarySearch(int[] nums, int l, int r, int target) {
        if(l>r) {
            return new int[]{-1, -1};
        }
        int mid = (l + r) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, l, mid-1, target);
        } else if (nums[mid] < target) {
           return binarySearch(nums, mid+1, r, target);
        } else {
            int i = mid, j = mid;

            while (i>=0&&nums[i] == target) {
                i--;
            }
            while (j<=nums.length-1&&nums[j] == target) {
                j++;
            }
            return new int[]{++i,--j};
        }
    }

}

