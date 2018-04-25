package com.michaelwomack.algorithms.unionfind;

public interface UnionFind {

    /**
     * Are p and q in the same component
     * @param p
     * @param q
     */
    boolean connected(int p, int q);

    /**
     * Add connection between p and q
     * @param p
     * @param q
     */
    void union(int p, int q);

    /**
     * Component identifier for p (0 to N-1)
     * @param p
     * @return
     */
    int find(int p);

    /**
     * Number of components
     * @return
     */
    int count();
}
