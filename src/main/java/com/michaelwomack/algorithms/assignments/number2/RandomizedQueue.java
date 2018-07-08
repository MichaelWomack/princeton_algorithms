package com.michaelwomack.algorithms.assignments.number2;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private Item[] q;

    public RandomizedQueue() {
        this.q = (Item[]) new Object[4];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        this.nullCheck(item);
        if (size == q.length) {
            resize(q.length * 2);
        }
        q[size++] = item;
    }


    public Item dequeue() { // return and remove a random item
        if (this.isEmpty()) {
            throw new NoSuchElementException("RandomizedQueue is empty!");
        }

        if (q.length / 4 == size) {
            resize(q.length / 2);
        }

        /** get index from [0, size) */
        int randIndex = StdRandom.uniform(size);
        Item dequeueItem = q[randIndex];

        /** Here we replace the dequeued slot with the last item to maintain a contiguous array */
        q[randIndex] = q[--size];
        q[size] = null;
        return dequeueItem;
    }

    public Item sample() { // return but do not remove a random item
        if (this.isEmpty()) {
            throw new NoSuchElementException("RandomizedQueue is empty!");
        }

        /** get index from [0, size) */
        int randIndex = StdRandom.uniform(size);
        return q[randIndex];
    }

    private void nullCheck(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item can not be null!");
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
                s.append(q[i]);
        }
        return s.toString();
    }

    private void resize(int newSize) {
        Item[] copy = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            copy[i] = q[i];
        }
        q = copy;
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int[] randomized;
        private int currentIndex;

        public RandomizedQueueIterator() {
            this.currentIndex = 0;
            this.randomized = new int[size];
            for (int i = 0; i < size; i++) {
                randomized[i] = i;
            }
            StdRandom.shuffle(randomized);
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next() element exists!");
            }
            return q[randomized[currentIndex++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported!");
        }
    }
}