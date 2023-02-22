package com.xcp.designpatterns.algorithm;

/**
 * Created by 许成谱 on 2023/2/22 14:08.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class LeetCodeAlgorithm {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l4.next=l5;
        l5.next=l6;
        ListNode listNode = addTwoNumbers(l1, l4);

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
}

