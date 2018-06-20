package com.michaelwomack.algorithms.unionfind;

public class WeightedQuickUnion {

    /**
     * One optimization to the Quick Union is to keep track of tree size
     * (number of elements) in order to avoid tall trees. Trees can be balanced
     * by linking the root of smaller trees to the root of larger trees. find() is
     * identical to QuickUnion where we compare the roots of p and q. Union is modified
     * in that we make the smaller tree's root equal to the taller tree's root, then add
     * the smaller tree's size to the taller tree. Find takes time proportional to the
     * depth of p and q. Union takes constant time, given roots. Union = lg(N), connected = lg(N).
     * We can improve performance by using Path Compression, where we set the root of each examined
     * element to point to the root. Weighted QuickUnion with Path compression = N + Mlg(N)
     */
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
            parent[p] = parent[parent[p]]; // path compression keeps tree flat
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

    public int findLargestConnection(int i) {
        int max = i;
        for (int j = 0; j < size.length; j++) {
            if (root(i) == root(j) && j > max) {
                max = j;
            }
        }
        return max;
    }

    public int[] getParent() {
        return parent;
    }

    public int[] getSize() {
        return size;
    }
}
