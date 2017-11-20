package com.eric.off.U233;

import java.util.ArrayList;
import java.util.Stack;

/**
 *输入一个链表，从尾到头打印链表每个节点的值。
 * @author Chen 2017/11/16
 */
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

public class PrintListNode {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (listNode !=null){
            stack.push(listNode);
            listNode =listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (!stack.isEmpty()){
            result.add(stack.pop().val);
        }
        return result;
    }


    public static void main(String[] args) {
        //输入的链表有多个结点
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
          node1.next=node2;
          node2.next=node3;
        ArrayList<Integer> integers = printListFromTailToHead(node1);
        System.out.println(integers);
    }
}
