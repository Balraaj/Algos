package com.example.practice.problems;

/** LeetCode problem
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list
 */
public class LinkedListAddition {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return add(l1,l2,0);
        }

        private ListNode add(ListNode l1, ListNode l2, int carry){
            if(l1==null && l2==null){
                if(carry==0) return null;
                else return new ListNode(carry);
            }
            ListNode l1Next = l1==null ? null : l1.next;
            int l1Val = l1==null ? 0 : l1.val;

            ListNode l2Next = l2==null ? null : l2.next;
            int l2Val = l2==null ? 0 : l2.val;

            int value = (l1Val+l2Val+carry);
            ListNode node = new ListNode(value%10);
            node.next = add(l1Next,l2Next,value/10);
            return node;
        }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

