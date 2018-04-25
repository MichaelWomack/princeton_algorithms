package com.michaelwomack.algorithms.unionfind;

public class WeightedQuickUnion {

    private int[] parent;
    private int[] size;

    public WeightedQuickUnion(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int root(int p) {
        while(parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        if (connected(p, q)) {
            return;
        }

        int pRoot = root(p);
        int qRoot = root(q);

        /** p tree is smaller, so q becomes parent  */
        if (size[pRoot] < size[qRoot]) {
            size[qRoot] += size[pRoot];
            parent[pRoot] = qRoot;
        }
        else {
            size[pRoot] += size[qRoot];
            parent[qRoot] = pRoot;
        }
    }
}
