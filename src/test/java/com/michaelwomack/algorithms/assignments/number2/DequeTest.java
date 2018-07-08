package com.michaelwomack.algorithms.assignments.number2;

import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    private Deque<Integer> deque;

    @BeforeEach
    void setUp() {
        deque = new Deque<>();
    }

    @Test
    void testIsEmpty() {
        assertTrue(deque.isEmpty());
        deque.addFirst(1);
        assertFalse(deque.isEmpty());

    }

    @Test
    void testFirst() {
        deque.addFirst(12);
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());

        Integer actualFirst = deque.removeFirst();
        assertEquals(12, actualFirst.intValue());
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
    }

    @Test
    void testLast() {
        deque.addLast(100);
        assertEquals(1, deque.size());
        assertFalse(deque.isEmpty());

        deque.addLast(101);
        assertEquals(2, deque.size());

        Integer actualLast = deque.removeLast();
        assertEquals(101, actualLast.intValue());
        assertEquals(1, deque.size());

        actualLast = deque.removeLast();
        assertEquals(100, actualLast.intValue());
        assertEquals(0, deque.size());
    }

    @Test
    void testDeque() {
        deque.addFirst(1);
        deque.addLast(3);
        deque.addFirst(0);
        deque.addLast(5);
        assertEquals("0135", deque.toString());

        deque.removeFirst();
        assertEquals("135", deque.toString());

        deque.removeLast();
        assertEquals("13", deque.toString());

        deque.removeFirst();
        assertEquals("3", deque.toString());

        deque.removeFirst();
        assertTrue(deque.isEmpty());

        assertEquals("", deque.toString());
    }
}