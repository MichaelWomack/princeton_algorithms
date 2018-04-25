package com.michaelwomack.algorithms.unionfind;

public class QuickFind implements UnionFind {

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
