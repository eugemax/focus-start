package collections.impl;

import collections.List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
private static final int DEFAULT_CAPACITY=10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    Object[] elementData;
    private int size;
    int modCount = 0;
    public ArrayList() {
        this.elementData = EMPTY_ELEMENTDATA;
    }
    public void trimToSize() {
        modCount++;
        if (size < elementData.length) {
            elementData = Arrays.copyOf(elementData, size);
        }
    }
    public void ensureCapacity(int minCapacity) {
        int minExpand = (elementData != EMPTY_ELEMENTDATA) ? 0 : DEFAULT_CAPACITY;

        if (minCapacity > minExpand) {
            ensureExplicitCapacity(minCapacity);
        }
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity)
            newCapacity = minCapacity;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        modCount++;
        E oldValue = elementData(index);

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }
    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException();
    }
    E elementData(int index) {
        return (E) elementData[index];
    }
    @Override
    public E get(int index) {
        rangeCheck(index);

        return elementData(index);
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }
    private class Itr implements Iterator<E> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != size;
        }
        public E next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new RuntimeException();
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

    }
}
