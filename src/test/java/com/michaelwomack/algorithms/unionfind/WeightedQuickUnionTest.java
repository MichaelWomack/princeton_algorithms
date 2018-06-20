package com.michaelwomack.algorithms.unionfind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightedQuickUnionTest {

    private WeightedQuickUnion weightedQuickUnion;

    @BeforeEach
    void setUp() {
        weightedQuickUnion = new WeightedQuickUnion(10);
        /** connect {1,2,6,9}*/
        weightedQuickUnion.union(1, 2);
        weightedQuickUnion.union(1, 6);
        weightedQuickUnion.union(1, 9);
    }

    @Test
    void testUnion() {
        assertEquals(weightedQuickUnion.getParent()[1], weightedQuickUnion.getParent()[2]);
        assertEquals(weightedQuickUnion.getParent()[1], weightedQuickUnion.getParent()[6]);
        assertEquals(weightedQuickUnion.getParent()[1], weightedQuickUnion.getParent()[9]);
    }

    @Test
    void testConnected() {
        assertTrue(weightedQuickUnion.connected(1, 2));
        assertTrue(weightedQuickUnion.connected(1,6));
        assertTrue(weightedQuickUnion.connected(1,9));
    }

    @Test
    void testFindLargestInConnection() {
        /** find largest element connected to 1 */
        assertEquals(9, weightedQuickUnion.findLargestConnection(1));
    }
}