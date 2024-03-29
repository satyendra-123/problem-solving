package com.test.dsa;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DSATester {
    int a = 10;

    public static void main(String[] args) {

        DSATester dsaTester = new DSATester();
        //dsaTester.testValueByRef();
        //dsaTester.testIfThrowError();
        //findMean(new int[][] { { 1, 2, 3, 4, 5 }, { 2, 4, 5, 6, 7 } });
		/*findKnightAllPositions(3, 3, 8,
				new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 1, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, });*/
        //printPascalTriangle(9);
        //shortestDistanceOfChar("helloworld", 'l');
        //dsaTester.myDate();

        //findSubarrayWithGivenSum(new int[] { 2, 3, 5, 6, 8, 9}, 16);
        //getNonPrime(100);
        //testInOrderTraverse();
        //printInTriangle(new int[] { 1, 2, 3, 4, 5, 6});
        //System.out.println(dsaTester.findKSmallest(new int[]{11,21,3,21,14,5,1,6,7}, 6));
        //dsaTester.findSqrt(7);
        //System.out.println(Arrays.toString(dsaTester.insertionSort(new int[]{4,3,5,12,1,7,8,3,6})));
        //dsaTester.mergeSortedArrays(new int[]{1,2,3,0,0,0,0}, 3, new int[]{1,1,3,3}, 4);
        //dsaTester.balancedBinaryTree(new int[]{-10,-3,0,4,5});
        //dsaTester.printPattern(21);
        ///dsaTester.printOneZeroPattern(6);
        //dsaTester.printNumPattern(5);
        //System.out.println(dsaTester.validParanthesis("([()({})])"));
        //dsaTester.finishCourse();
//        System.out.println(dsaTester.kthSmallestNumber(new ArrayList<>(Arrays.asList(8, 16, 80, 55,
//                32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35,
//                91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92)), 9));

       // dsaTester.solve(createList());
       // System.out.println(dsaTester.longestConsecutiveOnes("-010100110101-"));
//        dsaTester.minStepsToTransform(new ArrayList<>(Arrays.asList(85, 21, 10, 12, 48, 66, 12, 70, 31, 100, 10, 97,
//                87, 30, 82, 58, 25, 59, 57, 77, 39, 98, 3, 61, 39, 46, 4, 74, 39, 14, 25, 74, 99, 76, 36,
//                78, 51, 18, 98, 82, 11, 5, 47, 36, 42, 1, 76, 24, 25, 34, 62, 72, 80)), 3);

//        System.out.println(dsaTester.lszero(new ArrayList<>(Arrays.asList(15, -25, 10, -8, -15, 14, -11, 12, 25, 26, -15, -23, -7, -7, 20,
//                21, -7, -15))).toString() );

         //System.out.println(new int[][]{ {1,0,1,0},  {1,0,0,1}, {0,1,0,1}, {1,0,1,0} });
        System.out.println(foo(3,5));

    }

    /**
     * given a 2D array
     * count the number of islands in the array
     * 1 0 1 0
     * 1 0 0 1
     * 0 1 0 1
     * 1 0 1 0
     * count = 4
     * @param arr
     * @return
     */
    private int countIslands(int[][] arr){
        int count=0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                    if(arr[i][j] == 1){
                        //check if it is island
                        //if(checkIsland(arr, i, j))
                           //     count ++;
                    }
            }
        }
        return count;
    }

//    private boolean checkIsland(int[][] arr, int row, int col) {
//        if(row >= 0 && row <= arr.length - 1 && col >= 0 && col <= arr.length - 1  && arr[row][col] == 0 ){
//            return true;
//        }
//        else if(row <= -1 || row >= arr.length ){
//            return true;
//        }else if(col <=-1 || col >= arr.length){
//            return true;
//        }
//        checkIsland(arr, row, col++);
//        checkIsland(arr, row, col--);
//        checkIsland(arr, row++, col);
//        checkIsland(arr, row--, col);
//        return false;
//    }

    static int bar(int x, int y){
            if (y == 0)   return 0;
            return (x + bar(x, y-1));
    }

    static int foo(int x, int y){
            if (y == 0) return 1;
            return bar(x, foo(x, y-1));
    }

    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        //find all subarrays with sum zero; one with max length smallest index
        int maxLen = Integer.MIN_VALUE;
        int minIndex = A.size();
        int lastIndex = 0;
        int sum = 0;
        int len = 0;
        for(int i=0; i<A.size(); i++){
            for(int j=i; j<A.size(); j++){
                //i to j a subarray sum
                if(arraySum(i, j, A) == 0){
                    len = j-i+1;
                    if(maxLen < len ){
                        minIndex = i;
                        lastIndex = j;
                        maxLen = len;
                    }else if(maxLen == len && minIndex >= i){
                        minIndex = i;
                        lastIndex = j;
                    }
                    //System.out.println(" maxLen "+maxLen+" minIndex "+minIndex+" lastIndex "+lastIndex);
                }
            }
        }


        ArrayList<Integer> result = new ArrayList<>();
        while( minIndex <= lastIndex){
            result.add(A.get(minIndex));
            minIndex++;
        }
        return result;
    }

    private int arraySum(int s, int e, ArrayList<Integer> A){
        int sum = 0;
        System.out.print(" s "+s);
        while(s<=e){
            sum += A.get(s);
            s++;
        }
        System.out.println(" e "+e+" sum "+sum);
        return sum;
    }




    /**
     * Given an array of integers, A, of length N, find the minimum number of steps you need to take to transform A
     * such that the sum of any two adjacent elements is less than B.
     * In one step you can reduce any number by 1.
     * @param A
     * @param B
     * @return
     */
    private int minStepsToTransform(ArrayList<Integer> A, int B) {
        int count = 0;
        int val = 0;
        if(A.get(0) > B){
            val  = A.get(0)-B;
            count += val;
            A.set(0, A.get(0)-val);
            val = 0;
        }
        for(int i=0; i<A.size()-1; i++){
            if((A.get(i) + A.get(i+1)) > B){
                val = A.get(i+1) - (B - A.get(i));
                A.set(i+1, A.get(i+1)-val);
                count += (val);
                System.out.print(A.get(i)+" "+A.get(i+1)+" -> "+count);
            }
        }
        return count;
    }

    private int longestConsecutiveOnes(String A){
        int maxLength = 0;
        boolean isSwap = false;
        String temp = "0";
        int l = 1;
        int lcount = 0;
        int r = 1;
        boolean isZeroFoundInLeft = false;
        boolean isZeroFoundInRight = false;
        int rcount = 0;

        String[] charr = A.trim().split("");
        int N = charr.length - 2;
        int i =1;
        System.out.print(charr[0]+" "+charr[1]+"- >");
        while(i < N){

            if(charr[i].equals("0")){

                //check left side
                //for i > 0
                l = i-1;
                while(l >= 1){
                    if(l >=1 && charr[l].equals("1") && !isZeroFoundInLeft){
                        lcount++;
                    }else if( l > 1  && charr[l].equals("0") && !isZeroFoundInLeft){
                        //skip till we get next 1
                        isZeroFoundInLeft = true;
                    }else if(isZeroFoundInLeft && charr[l].equals("1")){
                        isSwap = true;
                        temp = charr[i];
                        charr[i] = charr[l];
                        charr[l] = temp;
                        break;
                    }
                    l--;
                }
                //check right side
                isZeroFoundInLeft = false;
                r = i+1;
                while(r <= N){
                    if(r <= N-1 && charr[r].equals("1") && !isZeroFoundInRight){
                        rcount++;
                    }else if( r < N && charr[r].equals("0") && !isZeroFoundInRight){
                        //skip till we get next 1
                        isZeroFoundInRight = true;
                    }else if (charr[r].equals("1") && isZeroFoundInRight && !isSwap){
                        isSwap = true;
                        temp = charr[i];
                        charr[i] = charr[r];
                        charr[r] = temp;
                        break;
                    }

                    r++;
                }
                isZeroFoundInRight= false;


                if(isSwap){
                    maxLength = maxLength < (lcount+rcount)+1 ? (lcount+rcount)+1 : maxLength;
                }

                System.out.println("index "+i+"  "+lcount+" "+rcount+" "+isSwap+" "+maxLength);

                isSwap = false;
                lcount = 0;
                rcount = 0;

            }
            i++;
        }
        return maxLength;

    }

    private static ArrayList<ArrayList<Integer>> createList(){
        int [][] arr = new int[][]{
                {15, 15, 1, 68, 50, 14, 29, 72, 71, 21},
                {47, 45, 59, 56, 92, 82, 67, 24, 0, 98},
                {72, 55, 66, 50, 38, 44, 19, 89, 38, 54},
                {56, 54, 70, 10, 0, 72, 24, 3, 44, 48},
                {24, 91, 45, 84, 99, 37, 18, 67, 13, 90},
                {65, 85, 45, 83, 88, 83, 80, 7, 25, 18},
                {62, 33, 24, 32, 43, 46, 56, 20, 1, 0},
                {68, 78, 92, 65, 62, 91, 2, 32, 10, 15},
                {22, 75, 53, 67, 11, 41, 2, 91, 48, 79},
                {61, 62, 13, 86, 46, 56, 84, 2, 76, 86}
        } ;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0; j<arr.length; j++){
                list.add(arr[i][j]);
            }
            result.add(list);
        }
        return result;
    }

    private ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int prevCol = -1;
        ArrayList<Integer> prevList = new ArrayList<>();
        for(int i=0; i<A.size(); i++){
            for(int j=0; j<A.get(0).size(); j++){
                //if a value is found zero
                //first remove make all element of row to zero  .
                //make all columns zero
                //skip the row here break

                if(A.get(i).get(j) == 0){
                    if(!prevList.contains(j)){
                        makeElementsZeroInRow(A, i, j);
                        //prevCol = j;
                        prevList.add(j);
                        makeElementsZeroInColumn(A, i, j);
                        break;
                    }
                }

            }
        }

        for(int k=0; k<A.size(); k++){
            for(int l=0; l<A.size(); l++){
                System.out.print(A.get(k).get(l)+" - ");
            }
            System.out.println();
        }
        return A;
    }

    private void makeElementsZeroInRow(ArrayList<ArrayList<Integer>> A, int i, int j){
        j = 0;
        while( j <= A.get(0).size()-1){
            A.get(i).set(j, 0);
            j++;
        }

    }

    private void makeElementsZeroInColumn(ArrayList<ArrayList<Integer>> A, int i, int j){
        System.out.println(" column transform "+" row "+i+" col "+j);

        i = 0;
        while( i <= A.get(0).size()-1){

            A.get(i).set(j, 0);
            i++;
        }
    }

    /**
     * Without extra space and in O(n)
     *
     */
    private static void findEquilibriumIndex(){

    }

    /**
     * 2 1 2 4 3 8 5 7 8
     * ans = 7
     */
    private void countNumberGreaterThanNumberItself(int[] arr){
        for(int i=0; i<arr.length; i++){

        }
    }


    //TODO: incomplete solution
    private int kthSmallestNumber(final List<Integer> A, int B) {
        Integer[] arr =  A.toArray(new Integer[A.size()]);
        Integer[] brr =  new Integer[arr.length];
        IntStream.range(0,arr.length).forEach(i->
                brr[i] = arr[i]);
       // mergeSortArray(brr, arr, 0, arr.length-1);
//        int min = A.get(0);
//        int count = 1;
        /*for (int l = 1; l < A.size(); l++) {
            if (count == B)
                return min;
            else if (min < A.get(l)) {
                min = A.get(l);
                count++;
            }
        }*/
        return A.get(B-1);
    }

//    private void mergeSortArray(Integer[] b, Integer[] a, int s, int e) {
//        if(e-s <=1){
//            return;
//        }
//        int mid = s +(e-s)/2;
//        mergeSortArray(b, a, s, mid);
//        mergeSortArray(b, a, m  id, e);
//
//    }

    /**
     * Course Schedule
     * There are a total of numCourses courses you have to take, labelled from 0 to numCourses-1. You are given an array of prerequisites where prerequisites[i] = [ai, bi] indicates that you must take the course bi first, if you want to take the course ai.
     * <p>
     * For example, the pair [1, 0], indicates that to take the course 1 you have first to take the course 0.
     * <p>
     * Return true if you can finish all courses. Otherwise, return false. You can consider all the pairs to be unique.
     * Example 1:
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     * <p>
     * Example 2:
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
     */
    private boolean finishCourse() {
        Map<Integer, String> result = new HashMap<>();
        int[][] preqs = new int[][]{{1, 0}, {2, 3}, {3, 4}, {4, 5}, {5, 0}};
        HashMap<Integer, Integer> dependency = new HashMap<>();
        //check if there is any loop or same course is dependent upon multiple course ??
        for (int i = 0; i < preqs.length; i++) {
            if (!dependency.containsKey(preqs[i][0])) {
                dependency.put(preqs[i][0], preqs[i][1]);
            } else {
                System.out.println("is same course dependent on multiple course to get finished");
                return false;
            }
        }
        for (int i = 0; i < preqs.length; i++) {
            int courseToDO = preqs[i][0];
            while (dependency.containsKey(courseToDO)) {
                courseToDO = dependency.get(courseToDO);
                if (result.get(courseToDO) == "finished") {
                    result.put(preqs[i][0], "finished");
                }

                System.out.println("----- loop" + preqs[i][0] + " --  " + courseToDO);
                if (preqs[i][1] == courseToDO) {
                    System.out.println("course " + preqs[i][0] + " is dependent on other " + courseToDO);
                    break;
                }
                //System.out.println("----- loop");
            }
            result.put(courseToDO, "finished");
        }
        result.forEach((k, v) -> System.out.println(k + " ---- " + v));
        return false;
    }

    private boolean validParanthesis(String s) {
        Stack<Character> stck = new Stack<>();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (stck.isEmpty()) {
                stck.push(c);
                continue;
            }
            switch (c) {
                case '}':
                    if (stck.peek() == '{')
                        stck.pop();
                    else
                        stck.push(c);
                    break;
                case ')':
                    if (stck.peek() == '(')
                        stck.pop();
                    else
                        stck.push(c);
                    break;
                case ']':
                    if (stck.peek() == '[')
                        stck.pop();
                    else
                        stck.push(c);
                    break;
                default:
                    stck.push(c);
                    break;
            }
        }
        return stck.isEmpty();
    }

    /**
     * - - 1
     * - 2 3 2
     * 3 4 5 3 2
     *
     * @param N
     */
    private void printNumPattern(int N) {
        int i = 0;
        int k = N - 1;
        int j = 1;
        int val = 1;
        while (i < N) {
            int track = 0;
            for (int m = 0; m < k; m++) {
                System.out.print(" 	");
                track++;
            }
            k--;

            for (int l = 0; l < j; l++) {
                System.out.print(" " + val + " ");
                if (track >= N - 1 && l != 0 && l < j - 1) {
                    val--;
                } else {
                    val++;
                }
                track++;
            }
            j = j + 2;
            System.out.print("\n");
            i++;
        }
    }

    /**
     * 1
     * 0 1
     * 1 0 1
     * 0 1 0 1
     * 1 0 1 0 1
     *
     * @param N
     */
    private void printOneZeroPattern(int N) {
        int i = 1;
        int count = 0;
        while (i <= N) {
            int j = 0;
            count = i % 2 != 0 ? 1 : 0;
            while (j < i) {
                System.out.print(count + " ");
                if (count == 0) {
                    count++;
                } else {
                    count--;
                }
                j++;
            }
            System.out.print("\n");
            i++;
        }
    }


    /**
     * N = 3
     * --*--
     * -***-
     * *****
     * <p>
     * nth = a +(n-1) * d
     *
     * @param
     */
    private void printPattern(int N) {
        int i = 0;
        int k = N - 1;
        int j = 1;
        while (i < N) {
            for (int m = 0; m < k; m++) {
                System.out.print(" ");
            }
            k--;

            for (int l = 0; l < j; l++) {
                System.out.print("*");
            }
            j = j + 2;
            System.out.print("\n");
            i++;
        }
    }

    /**
     * -10^9 < nums < 10^9
     * TreeNode
     *
     * @param
     */


    private void mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        int j = m - 1, k = n - 1, i = m + n - 1;

        while (j >= 0 && k >= 0) {
            if (nums1[j] < nums2[k]) {
                nums1[i] = nums2[k];
                i--;
                k--;
            } else {
                nums1[i] = nums1[j];
                nums1[j] = nums2[k];
                i--;
                j--;
            }
        }
        while (i >= 0 && k >= 0) {
            nums1[i--] = nums2[k--];
        }
    }


    /**
     * given a number find its square root by using +,-,* , /
     *
     * @param N
     */
    private void findSqrt(int N) {
        //hint: any square root of a number is smaller than the number which will be in the range of 1 to N
        int start = 1;
        int end = N;
        int mid = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid * mid > N) {
                end = mid - 1;
            } else if (mid * mid < N) {
                start = mid + 1;
            } else {
                System.out.println(mid);
                break;
            }
        }
        System.out.println(mid);
    }

    /**
     * Binary search on unsorted arrays
     * inputs
     * N = length of array
     * [11,2,3,1,4,5,6,9,7]
     * <p>
     * constraints
     * K < N
     * A[i] >= 0 && A[i] <= Maximum Integer Value
     * Time Complexity less than O(N*N) or O(N*K)
     */
    //Time Complexity - O(arr.length * log(range))
    private int findKSmallest(int[] arr, int k) {
        int result = 0;
        int min = arr[0];
        int max = arr[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        if (k == 1) {
            return min;
        }
        /**
         * we can apply binary search on array
         */
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int smaller_nums = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < mid) {
                    smaller_nums++;
                }
            }
            if (smaller_nums > k - 1) {
                max = mid - 1;
            } else if (smaller_nums == k - 1) {

                int min2 = Integer.MAX_VALUE;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] >= mid && arr[j] < max) {
                        if (arr[j] < min2) {
                            min2 = arr[j];
                        }
                    }
                }
                result = min2;
                break;
            } else {
                min = mid + 1;
            }
        }
        return result;
    }


    /**
     * O(N*(N-1)/2) = O(N*N) [Worst Case]
     * O(N) Best Case
     * insertion sort applies the method of example cards in deck sorting
     * S(1) ~ Constant
     * [4,3,5,12,1,7,8,3,6]
     */
    private int[] insertionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int j = i - 1;
            int k = i;
            int val = 0;
            while (k > 0 && j >= 0 && arr[j] > arr[k]) {
                val = arr[k];
                arr[k] = arr[j];
                arr[j] = val;
                j--;
                k--;
            }
        }
        return arr;
    }

    void booleanWithBinaryOperator() {
        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = true;
        if (b1 & b2 | b2 & b3 | b2) {
            System.out.println("false");
        } else if (b1 & b2 | b2 & b3 | b3) {
            System.out.println("true");
        }
    }

    void testValueByRef() {
        int[] a1 = {1, 3, 4};
        fix(a1);
        System.out.println(Arrays.toString(a1));
    }

    int[] fix(int[] a2) {
        a2[2] = 8;
        return a2;
    }

    void testIfThrowError() {
        try {
            throw new Error();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("finally throw err");
        }
        System.out.println("Done Throw Error");
    }

    // Mean of two arrays
    private static void findMean(int arr[][]) {
        int result = 0;
        for (int arr1[] : arr) {
        }
        System.out.println(result);
    }

    // Not working
    private static void findKnightAllPositions(int x, int y, int size, int[][] chess) {
        int[][] foundArr = new int[8][8];
        int i = x;
        while (i >= 0 || i <= 7) {
            int j = y;
            while (j >= 0 || j <= 7) {
                if (chess[i][j] == 1) {
                    foundArr[i][j] = 1;
                } else {
                    foundArr[i][j] = 0;
                }

                if (j == 7)
                    j = y;
                if (j == 0)
                    break;
                if (j >= y && j < 7)
                    j++;
                if (j <= y && j > 0)
                    j--;
            }
            if (i == 7)
                i = x;
            if (i == 0)
                break;
            if (i >= x && i < 7)
                i++;
            if (i <= x && i > 0)
                i--;
        }

        System.out.println(Arrays.stream(foundArr).map(a -> String.join(" ", String.valueOf(a)))
                .collect(Collectors.joining(", ")));

    }

    //pairs to get sum from an array
    //{1,2-3,4,5} -> 3 [1,2] . 1 [-3, 4]

    // String str = "helloworld" char c = 'l'
    // shortest distance from each character
    private static void shortestDistanceOfChar(String str, char c) {
        char[] ch = str.toCharArray();
        int[] disArr = new int[ch.length];
        int beginIndex = str.indexOf(c);
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != c && i < beginIndex) {
                disArr[i] = beginIndex - i;
            }
            if (ch[i] == c) {
                beginIndex = i;
                disArr[i] = beginIndex - i;
            }
            if (ch[i] != c && i > beginIndex) {
                int nxtIndex = str.indexOf(c, i);
                if (nxtIndex == -1) {
                    disArr[i] = i - beginIndex;
                } else {
                    disArr[i] = Integer.min(i - beginIndex, nxtIndex - i);
                }
            }
        }
        System.out.println(Arrays.toString(disArr));

    }

    // Formulate the situation when
    // x to reach y if 6 to 20 [ only multiply 2 or subtract 1]min number of
    // possible ways

    // pascal triangle
    /*
     * N = 5 x = 0 to 4 y = 0 to (N*2-1)-1 WHEN N > 2 y = 0 to 1 N = 1 y = 0 to 2 N
     * = 2 result = 1; result = result * 11 ----1---- ---1-1--- --1-2-1-- -1-3-3-1-
     * 1-4-6-4-1
     */
    private static void printPascalTriangle(int N) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < ((N * 2) - 1); j++) {
                if (i == 0) {
                    printOuterSpace(N - i);
                    result = 1;
                    System.out.print(result);
                    printOuterSpace(N - i);
                }
                if (i > 0) {
                    printOuterSpace(N - i);
                    result = result * 11;
                    printInnerItem(String.valueOf(result).split(""));
                    printOuterSpace(N - i);
                }
                break;
            }
            System.out.println();
        }

    }

    private static void printOuterSpace(int n) {
        for (int i = 0; i < n - 1; i++) {
            System.out.print(" ");
        }
    }

    private static void printInnerItem(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(" ");
            }
        }
    }

    // intersection of n lists
    // common characters in n strings
    private void findCommonCharacters() {

    }

    void myDate() {
        LocalDate localDate = LocalDate.now(ZoneId.of("GMT+02:30"));

        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("IST"));
        System.out.println(isoFormat.format(new Date()));


        //Date date = isoFormat.parse("2010-05-23T09:01:02");
    }

    //find subarray with given sum
    static void findSubarrayWithGivenSum(int[] arr, int sum) {
        //find the first continuous subarray of an array
        //find the all continuous subarrays of an array
        int arr1[] = null;
        int count = 0;
        boolean found = false;
        while (!found) {
            arr1 = new int[arr.length];
            int var = 0;
            for (int i = count; i < arr.length; i++) {
                arr1[var] = arr[i];
                int tempSum = sumarr(arr1);
                if (arr[i] == sum || tempSum == sum) {
                    found = true;
                    break;
                }
                if (tempSum > sum || i == arr.length - 1) {
                    count++;
                    break;
                }
                var++;
            }
        }
        System.out.println(Arrays.toString(arr1));

    }

    private static int sumarr(int[] ar) {
        return Arrays.stream(ar).sum();
    }

    //find non prime numbers sieve
    private static void getNonPrime(int N) {
        int[] testPrime = new int[N];

        for (int i = 0; i < testPrime.length; i++) testPrime[i] = i;

        Set<Integer> nonPrimes = new HashSet<>();

        //run through the array which are to be marked
        for (int i = 2; i * i < N; i++) {

            //for each element which is coming need to check if its not marked yet ?? mean we need to mark the succesive items
            //if 2-> 4,6,8,10,12 etc must be marked
            //if 3 -> 6,9,12,15,18 etc must be marked
            //if 4 -> is it marked yes then no need to go
            //mark mean put that value to a set as we need to find all unique first 50 values (non prime) and we need to make that value as 0
            if (testPrime[i] != 0) {
                for (int j = i + i; j < N; j = j + i) {
                    nonPrimes.add(testPrime[j]);
                    testPrime[j] = 0;//marked as touched;

                }
            }
        }
        nonPrimes.forEach(s -> System.out.print(s + "\t"));

        System.out.println("------------------------");

        IntStream.of(testPrime).filter(c -> c != 0).forEach(d -> System.out.print(d + " "));
        ;
    }


    //test the inorder traversal
    private static void testInOrderTraverse() {
        Node node = new Node(1);
        node.left = null;
        node.right = null;

        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);

        traverseTree(node, true);

        Node m_tree = mirrorTree(node);
        System.out.println("-------------");
        traverseTree(m_tree, true);
    }

    private static void traverseTree(Node root, boolean isOdd) {
        if (root == null)
            return;
        System.out.printf("%d", root.getData());
        traverseTree(root.left, !isOdd);
        traverseTree(root.right, !isOdd);
    }

    private static Node mirrorTree(Node root) {
        if (root == null) {
            return null;
        }
        Node left = mirrorTree(root.left);
        Node right = mirrorTree(root.right);
        Node temp = left;
        left = right;
        right = temp;
        root.left = left;
        root.right = right;
        return root;
    }

    //a string which contains a string as its substring and palindrom count the number of operations
    //aaaaa bbb -> abbba = 3, archit , ar-> arccra = 3

    //programmerxzprogrammer -> find indices

    //common character among all strings

    //print an array in triangle order {1,2,3,4,5}

    /**
     * 1
     * 12
     * 123
     * 1234
     * 12345
     */
    private static void printInTriangle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i] + "";
            System.out.println(s);
            if (i == arr.length - 1) {
                break;
            }
            for (int j = i + 1; j < arr.length; j++) {
                s = s + arr[j];
                System.out.println(s);
            }
        }
    }

    // BFS /DFS traversal

    //tic tac toe game
}
