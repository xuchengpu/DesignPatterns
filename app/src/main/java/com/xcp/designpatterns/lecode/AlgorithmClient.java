package com.xcp.designpatterns.lecode;

/*
  Created by 许成谱 on 2019/7/19 11:45.
  qq:1550540124
  热爱生活每一天！
  力扣算法练习*/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AlgorithmClient {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }


//    public class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }
//
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        if (l1.val < l2.val) {
//            return l1.next = mergeTwoLists(l1.next, l2);
//        } else {
//            return l2.next = mergeTwoLists(l1, l2.next);
//        }
//    }

    public class ListNode {
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

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode tail = null;
            while (head != null) {
                ListNode temp = head.next;
                head.next = tail;
                tail = head;
                head = temp;
            }
            return tail;
        }

        public boolean isPalindrome(ListNode head) {
            Stack<ListNode> stack=new Stack<>();
            while (head!=null){
                if(!stack.isEmpty()&&head.val==stack.peek().val) {
                    stack.pop();
                }else{
                    stack.push(head);
                }
                head=head.next;
            }
            return stack.isEmpty();
        }
//        [4,2,4,0,0,3,0,5,1,0]
//        [4,0,0,0,0,3,2,5,1,4]
        public void moveZeroes(int[] nums) {
            int i=0;
            int j=1;
            while(i<nums.length&&j<nums.length){
                if(nums[i]==0&&nums[j]!=0){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    continue;
                }
                if(nums[i]!=0){
                    i++;
                    j++;
                }
                if(nums[j]==0){
                    j++;
                }
            }


        }


        public int hammingDistance(int x, int y) {
            int s=x^y;
            int ret=0;
            while(s!=0){
                ret+=s&1;
                s>>=1;
            }
            return ret;
        }


    }

}

