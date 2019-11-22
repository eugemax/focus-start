package collections.impl;

import java.util.Iterator;
import java.util.Stack;

// monster mode сделать на объъектах с дженериками
public class BinarySearchTree implements Iterable {
    private   Node root;
    private Node mainRoot;
    private TreeIterator treeIterator;


    @Override
    public Iterator iterator() {

            //if(treeIterator==null){
                treeIterator=new TreeIterator(root);
           // }
            return treeIterator;
    }
    private class TreeIterator implements Iterator{
        Stack <Node>stack;
        public TreeIterator(Node root){
            stack=new Stack<>();
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
        }
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Object next() {
            Node node=stack.pop();
            int result=node.value;
            if(node.right!=null){
                node=node.right;
                while (node!=null){
                    stack.push(node);
                    node=node.left;
                }
            }
            return result;
        }
    }
    class Node {
        int value;
        Node left = null;
        Node right = null;
        Node(int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        Node node=new Node(value);
        if(root==null) {
            root = node;
            mainRoot = node;
        }else {
            Node curr=root;
            Node parent;
            while (true){
                parent=curr;
                if(value<curr.value){
                    curr=curr.left;
                    if(curr==null){
                        parent.left=node;
                        return;
                    }
                }else {
                    curr=curr.right;
                    if(curr==null){
                        parent.right=node;
                        return;
                    }
                }
            }

        }
    }
    public void reverse(){
        reverseNodes(mainRoot);
    }
    public void reverseNodes( Node root) {
        Node temp = root.right;
        root.right = root.left;
        root.left = temp;
        if (root.left != null) {
            reverseNodes(root.left);
        }
        if (root.right != null) {
            reverseNodes(root.right);
        }
    }

    }