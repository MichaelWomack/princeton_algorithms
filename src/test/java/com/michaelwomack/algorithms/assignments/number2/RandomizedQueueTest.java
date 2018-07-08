package com.michaelwomack.algorithms.assignments.number2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedQueueTest {

    private RandomizedQueue<Integer> rq;

    @BeforeEach
    void setUp() {
        rq = new RandomizedQueue<>();
    }

    @Test
    void testEnqueue() {
        rq.enqueue(1);
        assertEquals(1, rq.size());
        assertFalse(rq.isEmpty());

        Integer dequeued = rq.dequeue();
        assertEquals(1, dequeued.intValue());
        assertTrue(rq.isEmpty());
    }

    @Test
    void testSample() {
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
    }

    @Test
    void testResizing() {
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(4);
        rq.enqueue(5);
        rq.enqueue(6);
        rq.enqueue(7);
        rq.enqueue(8);
        rq.enqueue(9);
        assertEquals(9, rq.size());

        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        assertTrue(rq.isEmpty());
    }

    @Test
    void testToString() {
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        assertEquals("123", rq.toString());
    }

    @Test
    void testRandomCalls() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(0);
        deque.addFirst(1);
        deque.addFirst(2);
        System.out.println(deque.toString());
        assertEquals(0, deque.removeLast().intValue());
        assertEquals(1, deque.removeLast().intValue());
    }
}