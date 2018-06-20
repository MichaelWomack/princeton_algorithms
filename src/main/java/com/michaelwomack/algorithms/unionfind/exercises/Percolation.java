package com.michaelwomack.algorithms.unionfind.exercises;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF weightedQuickUnionUF;
    private boolean[][] grid;
    private int numOpenSites;
    private int N;

    /** create n-by-n grid, with all sites blocked */
    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("N argument must be greater than 0!");
        }
        N = n;
        grid = new boolean[n][n]; // defaults all to false (closed)
        weightedQuickUnionUF = new WeightedQuickUnionUF(n); // subtract 1 when using this.
    }

    /**  open site (row, col) if it is not open already */
    public void open(int row, int col) {
        validateSite(row, col);
        if (!grid[row - 1][col - 1]) {
            grid[row - 1][col - 1] = true;
            numOpenSites++;
            connectValidNeighbors(row, col);
        }
    }

    /** is site (row, col) open? */
    public boolean isOpen(int row, int col) {
        validateSite(row, col);
        return grid[row - 1][col - 1];
    }

    /** is site (row, col) full?
     * A full site is an open site that can be connected to an open site
     * in the top row via a chain of neighboring (left, right, up, down) open sites.
     * */
    public boolean isFull(int row, int col) {
        boolean[] topRowSite = grid[0];
        int site = (row - 1) * (col - 1);
        for (int i = 0; i < topRowSite.length; i++) {
            boolean isOpenSite = topRowSite[i];
            int openSitePos = i + 1;
            if (isOpenSite && weightedQuickUnionUF.connected(site, openSitePos)) {
                return true;
            }
        }
        return false;
    }

    /** number of open sites */
    public int numberOfOpenSites() {
        return numOpenSites;
    }

    private void connectValidNeighbors(int row, int col) {
        connectUp(row, col);
        connectDown(row, col);
        connectRight(row, col);
        connectLeft(row, col);
    }

    private void connectUp(int row, int col) {
        if (row > 1) {
            int site = row * col;
            int aboveSite = (row - 1) * col;
            weightedQuickUnionUF.union(site - 1, aboveSite - 1);
        }
    }

    private void connectDown(int row, int col) {
        if (row < N) {
            int site = row * col;
            int belowSite = (row + 1) * col;
            weightedQuickUnionUF.union(site - 1, belowSite - 1);
        }
    }

    private void connectRight(int row, int col) {
        if (col < N) {
            int site = row * col;
            int rightSite = row * (col + 1);
            weightedQuickUnionUF.union(site - 1, rightSite - 1);
        }
    }

    private void connectLeft(int row, int col) {
        if (col > 1) {
            int site = row * col;
            int leftSite = row * (col - 1);
            weightedQuickUnionUF.union(site - 1, leftSite - 1);
        }
    }

    private void validateSite(int row, int col) throws IllegalArgumentException {
        if (row < 1 || col < 1 || row > N || col > N) {
            throw new IllegalArgumentException("Row and Column must be between 1 and " + N);
        }
    }

    /** does the system percolate?
     * We say the system percolates if there is a full site in the bottom row. In other words, a system percolates
     * if we fill all open sites connected to the top row and that process fills some open site on the bottom row.
     * */
    public boolean percolates() {
        boolean[] bottomRowSites = grid[N - 1];
        for (int i = 0; i < bottomRowSites.length; i++) {
            int row = N;
            int col = i + 1;
            int currentSite = row * col; //bottom row current site accounting for off by 1.
            if (isOpen(row, col) && isFull(row, col)) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args){

    }   // test client (optional)
}
