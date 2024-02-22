package com.eric.tree;

/**
 * 二叉树
 * @author Chen 2017/11/20
 */
public class BinaryTree {
    private Node root  = null;


    public BinaryTree(int value) {
        root = new Node(value);
        root.leftChild = null;
        root.rightChild = null;
    }

    /**
     * 查找
     */
    public Node findKey(int value) {
        Node current = root;
        while (true){
            if(value ==current.value){
                return current;
            }else if(value< current.value){
                return current.leftChild;
            }else if(value > current.value){
                current = current.rightChild;
            }
            if(current == null){
                return null;
            }
        }
    }

    /**
     * 插入当节点为空时插入
     */
    public Node insert(int value){
        Node current = root;
        while (true){
            if(value == current.value){
                return current;
            }
        }
    }
}
