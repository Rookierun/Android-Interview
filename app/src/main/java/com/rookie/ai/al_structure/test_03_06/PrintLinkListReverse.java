package com.rookie.ai.al_structure.test_03_06;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
public class PrintLinkListReverse {
    public static void main(String[] args) {
        ListNode tail = new ListNode(1, null);
        ListNode head = new ListNode(0, tail);
//        printListReverse(head);
        printLinkedListUseRecursion(head);
    }

    private static void printLinkedListUseRecursion(ListNode head) {
        //使用递归
        if (head != null) {
            printLinkedListUseRecursion(head.next);
            System.out.println(head.val + ":::::::");
        }
    }

    private static int[] printListReverse(ListNode head) {
        //将链表的每个节点入栈，然后，依次出栈，完成链表的倒序打印
        if (head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        int stackSize = stack.size();
        int[] arr = new int[stackSize];
        for (int i = 0; i < stackSize; i++) {
            ListNode pop = stack.pop();

            arr[i] = pop.val;
            System.out.println(arr[i]);
        }
        return arr;

    }


    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int value, ListNode nextNode) {
            this.val = value;
            this.next = nextNode;
        }
    }
}
