package com.xcp.designpatterns.lecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/*
  Created by 许成谱 on 2019/7/19 11:45.
  qq:1550540124
  热爱生活每一天！
  力扣算法练习*/

public class AlgorithmClient {
    public static void main(String[] args) {
//        ListNode node1 = new ListNode(9, null);
//        ListNode node2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(
//                9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))))))))));
//
//
//        ListNode listNode = addTwoNumbers(node1, node2);
//        printNum(listNode);
//        System.out.println(Integer.MAX_VALUE % 10);
        new Solution3().isHappy(19);


    }

    public static void printNum(ListNode listNode) {
        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }

    public int reverse(int x) {
        int base = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            } else if (base < Integer.MIN_VALUE / 10 || (base == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
//            base = base  10 + pop;

        }
        return base;

    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        int add = 0;
        ListNode head = null, tail = null;

        while (node1 != null || node2 != null) {
            int m = node1 != null ? node1.val : 0;
            int n = node2 != null ? node2.val : 0;

            int value = (m + n + add) % 10;
            add = (m + n + add) / 10;
            if (head == null) {
                head = tail = new ListNode(value, null);
            } else {
                tail.next = new ListNode(value, null);
                tail = tail.next;
            }
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        if (add != 0) {
            tail.next = new ListNode(add, null);
        }

        return head;

    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        String str = "";

        for (int i = 0; i < strs[0].length(); i++) {
            str = str + strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(str)) {
                    return str.substring(0,str.length()-1);
                }
            }

        }
        return str;

    }
}
class Solution3 {
    public boolean isHappy(int n) {
        Set<Integer> map=new HashSet();
        while(n!=1){
            int temp=n;
            int total=0;
            while(temp!=0){
                int a=temp%10;
                total+=a*a;
                temp/=10;
            }
            n=total;
            if(!map.add(n)){
                return false;
            }

        }
        return true;
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution2 {
    public int maxDepth(TreeNode root) {
        if(root.right==null&&root.left==null){
            return 0;
        }
        int right=maxDepth(root.right);
        int left=maxDepth(root.left);
        return Math.max(right++,left++);

    }
}

