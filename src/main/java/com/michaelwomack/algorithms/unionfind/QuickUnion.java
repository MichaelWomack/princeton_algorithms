package com.michaelwomack.algorithms.unionfind;

public class QuickUnion implements UnionFind {

    /**
     * Quick-union is the lazy approach. id[i] is the parent of i and the root
     * is when the id[i] == i. To find, we check if p and q have the same root,
     * which also means p and q are connected. To merge components containing p
     * and q, set the id of p's root to the id of q's root. Quick-union is also
     * too slow, as the union takes N array accesses as well as the find. One
     * defect is that trees can get very tall.
     */
    private int[] id;

    public QuickUnion(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while(id[i] != i) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        id[pRoot] = qRoot;
    }

    public int find(int p) {
        return root(p);
    }


    public int count() {
        int count = 0;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == i) {
                count++;
            }
        }
        return count;
    }
}
