package com.test.dsa.sorting;

import java.util.Arrays;
import java.util.Calendar;

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{9,1,3,2,8,4,5,20,15,7};
        long t1 = Calendar.getInstance().getTimeInMillis();
        System.out.println("Starting Bubble Sort ");
        bubbleSort(arr);
        long t2 = Calendar.getInstance().getTimeInMillis();
        System.out.println("Ending Bubble Sort "+ Arrays.toString(arr));
        System.out.println("Time Taken By Bubble Sort "+ (t2-t1));

        t1 = Calendar.getInstance().getTimeInMillis();
        System.out.println("Starting Selection Sort");
        selectionSort(arr);
        t2 = Calendar.getInstance().getTimeInMillis();
        System.out.println("Ending Selection Sort "+ Arrays.toString(arr));
        System.out.println("Time Taken By Selection Sort "+ (t2-t1));

        int[] merged = merge_sorted_arrays(new int[]{2, 9, 12, 24}, new int[]{1, 4, 5, 7, 10, 13, 16, 21});
        System.out.println("sorted merged array "+ Arrays.toString(merged));

        System.out.println("Merge Sort Starting ");
        merge_sort(arr, 0, arr.length-1);
        System.out.println(" Merge Sort Done "+Arrays.toString(arr));

    }

    //only consecutive elements are allowed to swap.
    //in each iteration the max element moves to the last index
    //in-place yes
    //TC: O(n*n)
    //SC: O(1)
    //No Of Swaps: sum of N-1 numbesr N*(N-1)/2
    //Stable ? yes
    private static void bubbleSort(int[] arr){
        int temp = 0;
        int N = arr.length;
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //find kth min element
    //for k times find minimum element from array and move the min in each iteration at the beginning
    //TC: O(n*n)
    //sc: O(1)
    //in place
    //not stable the relative order is chaning
    //no of swaps: O(N-1) where k ~ N
    private static void selectionSort(int[] arr){
        int N = arr.length;
        int min = 0;
        int min_i = 0;
        int temp = 0 ;
        for (int k = 0; k<N ; k++) {
            for(int i=k; i<N ; i++){
                if(arr[i] > min){
                    min = arr[i];
                    min_i = i;
                }
            }
            //we have found the min need to move it at the beginning of starting the array
            if(arr[k] > arr[min_i]) {
                temp = arr[min_i];
                arr[min_i] = arr[k];
                arr[k] = temp;
            }
        }

    }

    //given two sorted arrays merge them into one
    //TC: O(N+M)
    //sc: O(N)
    //no of swaps: O(Max(N,M))
    private static int[] merge_sorted_arrays(int[] a, int [] b){
        int N = a.length;
        int M = b.length;
        int [] c = new int[N+M];
        int k = 0;
        int i = 0;
        int j = 0;
        while(i<N && j<M){
            if(a[i] < b[j]){
                c[k++] = a[i];
                i++;
            }else{
                c[k++] = b[j];
                j++;
            }
        }
        //if one of the array exhausts we need to fill the remaining array into c
        while(i<N)
            c[k++] = a[i++];
        while(j<M)
            c[k++] = a[j++];
        return c;
    }

    //if an array is split and then sorted the merged and sorted array takes
    private static void merge_sort(int[] A, int l, int r){
        if(l == r)
            return;
        //split the given array
        int mid = (l+r)/2; //((r-l)/2)+1;
        merge_sort(A, l, mid);
        merge_sort(A, mid+1, r);
        //now we have got the split array at last it will be two arrays
        //A l mid r
        merge(A,l,mid,r);
    }

    private static void merge(int[] A, int l, int mid, int r){
          //both arrays are sorted we need to merge them
          int k = mid+1;
          int temp = 0;
          while( l<= mid && k <= r){
              if(A[l] < A[k]){

                  l++;
              }
              else{
                  temp = A[k];
                  A[k] = A[l];
                  A[l] = temp;
                  k++;
              }
          }
    }

}
