package com.michaelwomack.algorithms.assignments.number2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private class Node<T> {
        public T item;
        public Node<T> next;
        public Node<Item> prev;

        public Node(T item) {
            this.item = item;
        }
    }


    public Deque() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        this.nullCheck(item);
        Node<Item> newFirst = new Node<>(item);
        newFirst.next = first;
        if (!isEmpty()) { first.prev = newFirst; }
        first = newFirst;
        size++;

        if (last == null) {
            last = first;
        }
    }

    public void addLast(Item item) {
        this.nullCheck(item);
        Node<Item> newLast = new Node<>(item);

        if (first == null) {
            this.addFirst(item);
        } else {
            newLast.prev = last;
            last.next = newLast;
            last = newLast;
            size++;
        }
    }

    public Item removeFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty!");
        }

        Node<Item> oldFirst = first;
        first = first.next;
        size--;
        if (isEmpty()) { last = first; }
        else { first.prev = null; }
        return oldFirst.item;
    }

    public Item removeLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Deque is empty!");
        }
        Node<Item> oldLast = last;
        last = last.prev;
        size--;
        if (isEmpty()) { first = last; }
        else { last.next = null; }
        return oldLast.item;
    }

    private void nullCheck(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item can not be null!");
        }
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        Iterator<Item> it = this.iterator();
        while (it.hasNext()) {
            s.append(it.next());
        }
        return s.toString();
    }



    private class DequeIterator implements Iterator<Item> {

        private Node<Item> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {throw new NoSuchElementException();}
            Item currentItem = current.item;
            current = current.next;
            return currentItem;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported in DequeIterator");
        }
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    public static void main(String[] args) {
    }

}