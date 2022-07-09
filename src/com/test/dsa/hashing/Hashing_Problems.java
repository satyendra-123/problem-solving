package com.test.dsa.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Hashing_Problems {
    public static void main(String[] args) {
        Hashing_Problems h = new Hashing_Problems();
        //h.countPointLieOnSameLine();
        h.longestContigousSeq();
    }

    /**
     * Given two arrays of integers A and B describing a pair of (A[i], B[i]) coordinates in a 2D plane. A[i] describe x coordinates of the ith point in the 2D plane, whereas B[i] describes the y-coordinate of the ith point in the 2D plane.
     * <p>
     * Find and return the maximum number of points that lie on the same line.
     * <p>
     * 1 <= (length of the array A = length of array B) <= 1000
     * <p>
     * -10^5 <= A[i], B[i] <= 10^5
     * A = [-1, 0, 1, 2, 3, 3]
     * B = [1, 0, 1, 2, 3, 4]
     * ans = 4
     */
    public void countPointLieOnSameLine() {
        System.out.println(approach1(Arrays.stream(new int[]{-1, 0, 1, 2, 3, 3}).boxed().collect(Collectors.toList()), Arrays.stream(new int[]{1, 0, 1, 2, 3, 4}).boxed().collect(Collectors.toList())
        ));
    }

    //Brute Force
    //find all the pairs and check if their slope is same
    /**
     * when all points can be in a same line
     * for each ith coordinates if there exists another coordinate which has same slope as all other subsequent coordinate has
     * eg:
     * A = [-1, 0, 1, 2, 3, 3]
     * B = [1, 0, 1, 2, 3, 4]
     * <p>
     * [0,0] [1,1] [2,2] [3,3] these has same slope
     * <p>
     * y = mx
     * m = y/x
     * m between two points.  y2-y2/x2-x1
     * <p>
     * if slope matches we can maintain in a map if same slope is coming again
     * <p>
     * problem : we might encounter a case when
     * <p>
     * slope1 11/6 and another is 22/12 which is acutally same
     * to over come this first get gcd(22, 12) 2 then divide by gcd to each dx/g and dy/g
     * <p>
     * HashMap<String, Integer>
     * <dx/g +"_"+dy/g> <counts>
     * <p>
     * duplicate points are also always falls on same line hence we need to add the duplicate points also to ans
     */

    private int approach1(List<Integer> A, List<Integer> B) {
        int i = 0;
        int j = 0;

        int x1 = 0;
        int y1 = 0;

        int x2 = 0;
        int y2 = 0;

        int dx = 0;
        int dy = 0;


        String slpk = null;
        int dup = 0;
        int g = 0;
        int ans = 0;
        int maxLocal = 0;

        for (; i < A.size(); i++) {
            x1 = A.get(i);
            y1 = B.get(i);
            dup = 1;
            HashMap<String, Integer> map = new HashMap<>();
            for (j = i + 1; j < A.size(); j++) {
                x2 = A.get(j);
                y2 = B.get(j);

                if (x1 == x2 && y1 == y2) {
                    dup++;
                    continue;
                }

                dy = y2 - y1;
                dx = x2 - x1;

                g = gcd(dy, dx);

                //System.out.print(g+" "+x1+" "+x2+" "+y1+" "+y2+" :: ");

                //slope1 11/6 and another is 22/12 which is acutally same
                // to over come this first get gcd(22, 12) 2 then divide by gcd to each dx/g and dy/g
                slpk = (dx / g) + "_" + (dy / g);
                map.put(slpk, map.getOrDefault(slpk, 0) + 1);
                maxLocal = Math.max(maxLocal, map.get(slpk));
                //System.out.print(slpk +" "+maxLocal+" -> ");
            }

            //System.out.println();
            // ans = Math.max(ans, dup);
            // for(String s: map.keySet()){
            //     ans = Math.max(ans, map.get(s));
            // }
            ans = Math.max(ans, dup);
            ans = Math.max(ans, maxLocal + dup);
        }
        return ans;
    }

    private int gcd(int A, int B) {
        if (A == 0)
            return B;
        return gcd(B % A, A);
    }


    /**
     * Given N points on 2D plane find the no of rectangles can be formed using these points
     * [ [1,1],[1,3],[3,1],[3,3],[5,1],[5,3] ]
     */
    private int countRectangles(){
        return 0;
    }
    /**
     * approach 1
     * Brute Force:
     * rectangle can be formed by four points which are as below
     * [x1, y1] [x2, y2] [x3,y3] [x4,y4]
     * [x1, y1] [x2, y2] [x1, y2] [x2, y1]
     * we can iterate the 2d array and find all the points which passes these conditions
     * count the numbers
     * TC: O(N^4)
     */

    /**
     * alternative
     * # 1 we need to find two diagonal points such that they are not equal to each other
     * # 2 put all the x, y points in x_set, y_set
     * # 3 for each diagnoal point check if the required 2 points present in the map / set
     * # count++
     * TC: O(N*N)
     * SC: O(N)
     */

    /**
     * Given N points on 2D plane find the no of triangles can be formed using these points
     * [ [1,1],[1,3],[3,1],[3,3],[5,1],[5,3] ]
     */

    /**
     * Given N length array find the length of largest seq which can be rearranged to a seq of consecutive numbers
     * [5, 9, 100, 1, -1, 2, 3, 4, 99, 98, 11, 10, 15, 100, 101]
     *
     * Brute Force
     * sort the array
     * find the contigous longest sequence
     * tc: O(nlogn)
     * sc: depends
     *
     * approach 2:
     * use hashset
     * put all the values in hashset
     * iterate over array to check if each value can form the longest sequence
     * TC: O(N*N)
     * sc: O(N)
     * it performs bad because we are going to recalculate the example as if 9 is the value to check we need to check all the number followed by 9 in set
     * if array gives ith value as 10 mean we are again calculating the same seq
     *
     * approach 3:
     * use hashset
     * put all values in hashset
     * we need to check the sequence only if current element is the first element of the seq
     *
     * worst case
     * 1 1 1 1 1 1 1 1 1 1
     *
     * Best Case
     * 1 2 3 4 5 6 7 8 9 10
     *
     * O(n)
     *
     */
    private void longestContigousSeq(){
        System.out.println(approach3(new int[]{4, 9, 100, 1, -1, 2, 3, 4, 99, 98, 11, 10, 15, 102, 101}));
    }

    private int approach3(int[] arr){
        int count = 0;
        int max = 0;
        int ele = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int k: arr)
            set.add(k);
        for (int i = 0; i < arr.length ; i++) {
            if(set.contains(arr[i]-1))
                continue;
            //this is the first element of the seq
            count = 0;
            ele = arr[i];
            while(set.contains(ele)){
                count++;
                ele++;
            }
            max = max < count ? count : max;
        }
        return max;
    }

    //find the min/max distance between any two duplicate elements

}