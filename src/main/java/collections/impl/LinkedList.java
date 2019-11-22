package collections.impl;
import collections.List;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    public Node getFirst() {

        return first;
    }

    private Node first;

    private Node last;

    private int size;

    private Iterator iterator;

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return first ==null;
    }
    //add to the end of the list
    @Override
    public boolean add(E e) {
       Node node=new Node(e);

       if(isEmpty()){
            first =node;
            last =node;
            size++;
            return true;
        }

        last.next=node;
        node.prev=last;
        last =node;
        size++;
        return true;
    }

    @Override
    public E remove(int index) {
        if(index==0) {
            E item=(E) first.item;
            first = first.next;
            first.prev=null;
            size--;
            return item;
        }
        if(index==size-1){
            E item=(E)last.item;
            last=last.prev;
            last.next=null;
            size--;
            return item;
        }
        Node current=first;
        for(int i=0;i<index;i++){
           current=current.next;
       }
        E item=(E)current.item;
        current.prev.next=current.next;
        current.next.prev=current.prev;
        current.prev=null;//help GC
        current.next=null;//
        size--;
        return item;
    }
    @Override
    public E get(int index) {
       if (index==0){
            E item=(E)first.item;
            return item;
        }
        if(index==size-1){
            E item=(E)last.item;
            return item;
        }
        Node currNode=first;
        for (int i=0;i<index;i++){
            currNode=currNode.next;
        }
        E item=(E)currNode.item;
        return item;
    }
     class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node( E element) {
            this.item = element;
        }
    }
     class IteratorImpl  <E>implements collections.Iterator {
        private  Node cursor;
        IteratorImpl(){
            cursor=new Node(null);
            cursor.next=first;
            cursor.prev=last;
        }

        @Override
        public boolean hasNext() {
            return cursor.next!=null;
        }

        @Override
        public Object next() {
            if(!hasNext()) throw new NoSuchElementException();
            E item=(E)cursor.next.item;
            cursor=cursor.next;
            return item;
        }
    }
    @Override
    public  IteratorImpl<E> iterator() {

            return new IteratorImpl();
    }
}
