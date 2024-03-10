package com.test.dsa.SegmentTree;

public class SegmenTreeProblems {

    public static void main(String[] args) {
        getRangeMax(new int[] {1,2,3,4,5}, new int[][]{{2,3}, {1,4}, {4,5}});
    }

    /**
     * arr : [1,2,3,4,5]
     * get given range queries sum..
     * approach - brute force - Tc: O(n^2) SC: O(1)
     * prefix / suffix sum
     * segment tree - TC: O(N + q*logN) SC: O(2*n-1) n - arr length
     */

    private static void getRangeMax(int[] arr, int[][] q){
        int[] seg = new int[(2*arr.length)-1];
        buildMaxSegmentTree(seg, arr,0, arr.length-1, 0);
        int sum = 0;
        for (int i = 0; i < q.length; i++) {
            sum = getRangeQuerySum(seg, q[i][0], q[i][1], 0, arr.length-1, 0);
            System.out.println(" Query "+ q[i][0]+ " "+q[i][1]+ " -> "+ sum);
        }
    }

    /**
     * [1,2,3,4,5]
     * 0 1 2 3 4
     *
     * all leaf nodes of segment tree are the given array.
     *           15 - 0
     *         /    \
     *       10       5
     *     /    \
     *   3       7
     *  / \    /  \
     * 1   2   3   4
     *
     * SC: O(2*N-1)
     * for ith node the child node index is 2*i+1, 2*i+2
     *  for child i the parent node is (i+1)/2, i/2
     *  TC: O(N)
     *  approach
     *      split array into halves until reaches l==h if yes update seg[pos] = arr[l]
     *      - first halve with child
     *      - second halve with child
     *      update seg[pos] = seg[child1] + seg[child2]
     *  pos - root of the tree is 0
     */
    private static void buildMaxSegmentTree(int[] seg, int[] arr, int l, int h, int pos){
        if(l==h){
            seg[pos] = arr[l];
            return;
        }
        int mid = (l+h)/2;
        buildMaxSegmentTree(seg, arr, l, mid, (2*pos)+1);
        buildMaxSegmentTree(seg, arr, mid+1, h, (2*pos)+2);
        seg[pos] = seg[ (2*pos)+1] + seg[ (2*pos)+2];
    }

    /**
     *
     * first we need to check if the given range is
     * - total overlaop - the pos is falling into the ql, qh then it will return seg[pos]
     * - no overlaop - pos > qh || pos < ql mean it would return nothing
     *  split the array into two half
     * - partial overlap - check both the child of pos for splitted l to mid, mid+1 to h
     *   return the sum this sum is for given ql, qh
     * -
     * @param seg
     * @param ql
     * @param qh
     * @return
     */
    private static int getRangeQuerySum(int[] seg, int ql, int qh, int l, int h, int pos){
        if(  ql <= l && h <= qh){
            return seg[pos];
        }
        if( h < ql || l > qh)
            return 0;
        int mid = (l+h)/2;
        int s1 = getRangeQuerySum(seg, ql, qh, l, mid, 2*pos+1);
        int s2 = getRangeQuerySum(seg, ql, qh, mid+1, h, 2*pos+2);
        return s1+s2;
    }
}
