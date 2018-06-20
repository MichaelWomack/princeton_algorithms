package com.michaelwomack.algorithms.unionfind;

public class QuickFind implements UnionFind {
    /**
     * QuickFind is the eager approach. p and q are connected if they
     * have the same id (id[p] == id[q]). To Union components containing
     * p and q, change all entries whose id equals id[p] to id[q]. This model is slow
     * because it takes N^2 array accesses to process a sequence of N union commands
     * on N objects.
     */

    private int[] id;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pId = id[p];
        int qId = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
               id[i] = qId;
            }
        }
    }

    public int find(int p) {
        return id[p];
    }

    public int count() {
        return 0;
    }
}
