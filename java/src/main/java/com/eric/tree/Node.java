package com.eric.tree;

/**
 * 二叉树节点
 * @author Chen 2017/11/20
 */
public class Node {
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int value) {
        this.value = value;
    }
    public void display(){
        System.out.println(this.value+"\t");
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
