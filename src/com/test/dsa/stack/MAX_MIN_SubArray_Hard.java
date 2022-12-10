package com.test.dsa.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given an array of integers A.
 *
 * value of a array = max(array) - min(array).
 *
 * Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 1000000
 *
 * A = [4, 7, 3, 8]
 */
public class MAX_MIN_SubArray_Hard {
        public static void main(String[] args) {
                MAX_MIN_SubArray_Hard mmsh = new MAX_MIN_SubArray_Hard();
        }

        public int solve(ArrayList<Integer> A) {
                return (int) approach1(A);
        }

        /**
         1 <= |A| <= 100000
         Brute Force:

         sum of a subarray value
         value is max(subarray) - min(subarray)

         find all possible subarray AND get max/min in each subarray and get its value
         TC: O(n*n) for finding all subarray
         TC: O(N*N*N)

         */

        /**
         if we can find ith element present as max / min in which are all subarray
         mean we are looking for finding contribution of each ith element in the subarray value sum

         value = max(subarray) - min(subarray)

         if NGL[i] != -1 && NGR[i] != -1
         (i-s) * (e-i) here s,e is nothing but same NGL[i], NGR[i]

         if NGL[i] == -1 && NGR[i] != -1
         (i+1) * (e-i)

         if NGL[i] !=-1 and NGR[i] == -1
         (i-s) * (N-i)

         if both are -1 mean it would be present in (i+1) * (N-i) subarray
         as MAX

         multiply with A[i] for max value

         similarly the A[i] is present as min in which are all subarray

         if NSL[i] != -1 && NSR[i] != -1
         (i-s) * (e-i) here s,e is nothing but same NSL[i], NSR[i]

         if NSL[i] == -1 && NSR[i] != -1
         (i+1) * (e-i)

         if NSL[i] !=-1 and NSR[i] == -1
         (i-s) * (N-i)

         if both are -1 mean it would be present in (i+1) * (N-i) subarray
         as MAX

         */

        private long approach1(ArrayList<Integer> A){
                ArrayList<Integer> nsl = nslIdx(A);
                ArrayList<Integer> nsr =  nsrIdx(A);
                ArrayList<Integer> ngl =  nglIdx(A);
                ArrayList<Integer> ngr =  ngrIdx(A);


                int mod = 1000000007;

                int nglI = 0;
                int ngrI = 0;
                int nslI = 0;
                int nsrI = 0;

                long dist = 0;

                long maxNg = 0;
                long minNs = 0;
                long sum = 0;

                long ans = 0;
                int N = A.size();

                for( int i=0; i<A.size(); i++){

                        //ith element is present as max in ngl, ngr  total subarray
                        nglI = ngl.get(i);
                        ngrI = ngr.get(i);

                        if(nglI == -1 && ngrI != -1)
                                dist = (long)(i+1) * (ngrI-i);
                        else if(nglI != -1 && ngrI == -1)
                                dist = (long)(i-nglI) * (N-i);
                        else if(nglI == -1 && ngrI == -1)
                                dist = (long)(i+1) * (N-i);
                        else
                                dist = (long)(i-nglI) * (ngrI-i);

                        maxNg = (dist % mod * A.get(i) % mod) % mod ;

                        //ith element is present as min in nsl, nsr  total subarray
                        nslI = nsl.get(i);
                        nsrI = nsr.get(i);

                        if(nslI == -1 && nsrI != -1)
                                dist = (long)(i+1) * (nsrI-i);
                        else if(nslI != -1 && nsrI == -1)
                                dist = (long)(i-nslI) * (N-i);
                        else if(nslI == -1 && nsrI == -1)
                                dist = (long)(i+1) * (N-i);
                        else
                                dist = (long)(i-nslI) * (nsrI-i);

                        minNs = (dist % mod * A.get(i) % mod) % mod ;

                        sum = (maxNg % mod - minNs % mod ) % mod;

                        ans  = (ans % mod + sum % mod) % mod;

                }

                return (ans % mod + mod) % mod;
        }

        private ArrayList<Integer> nslIdx(ArrayList<Integer> A){
                ArrayList<Integer> res = new ArrayList<>();
                Stack<Integer> st = new Stack<>();
                int i = 0;
                for( ; i< A.size(); i++){

                        if( !st.isEmpty() && A.get(st.peek()) < A.get(i) ){
                                res.add(st.peek());
                                st.push(i);
                        }else if( st.isEmpty() ){
                                res.add(-1);
                                st.push(i);
                        }else{
                                while( !st.isEmpty() && A.get(st.peek()) >= A.get(i) )
                                        st.pop();
                                if(st.isEmpty())
                                        res.add(-1);
                                else
                                        res.add(st.peek());
                                st.push(i);
                        }
                }
                return res;
        }

        private ArrayList<Integer> nsrIdx(ArrayList<Integer> A){
                ArrayList<Integer> res = new ArrayList<>();
                Stack<Integer> st = new Stack<>();
                int i = A.size()-1;
                for( ; i>=0; i--){

                        if( !st.isEmpty() && A.get(st.peek()) < A.get(i) ){
                                res.add(st.peek());
                                st.push(i);
                        }else if( st.isEmpty() ){
                                res.add(-1);
                                st.push(i);
                        }else{
                                while( !st.isEmpty() && A.get(st.peek()) >= A.get(i) )
                                        st.pop();
                                if(st.isEmpty())
                                        res.add(-1);
                                else
                                        res.add(st.peek());
                                st.push(i);
                        }
                }
                return reverseList(res);
        }


        private ArrayList<Integer> reverseList(ArrayList<Integer> res){
                int i = 0;
                int j = res.size()-1;
                int temp = 0;
                while( i < j){
                        temp = res.get(i);
                        res.set(i, res.get(j));
                        res.set(j, temp);
                        i++; j--;
                }
                return res;
        }


        private ArrayList<Integer> nglIdx(ArrayList<Integer> A){
                ArrayList<Integer> res = new ArrayList<>();
                Stack<Integer> st = new Stack<>();
                int i = 0;
                for( ; i<A.size(); i++){
                        if(!st.isEmpty() && A.get(st.peek()) > A.get(i) ){
                                res.add(st.peek());
                                st.push(i);
                        }else if (st.isEmpty()){
                                res.add(-1);
                                st.push(i);
                        }else{
                                while( !st.isEmpty() && A.get(st.peek()) <= A.get(i) )
                                        st.pop();
                                if(st.isEmpty())
                                        res.add(-1);
                                else
                                        res.add(st.peek());
                                st.push(i);
                        }
                }
                return res;
        }


        private ArrayList<Integer> ngrIdx(ArrayList<Integer> A){
                ArrayList<Integer> res = new ArrayList<>();
                Stack<Integer> st = new Stack<>();
                int i = A.size()-1;
                for( ; i >= 0; i--){
                        if(!st.isEmpty() && A.get(st.peek()) > A.get(i) ){
                                res.add(st.peek());
                                st.push(i);
                        }else if (st.isEmpty()){
                                res.add(-1);
                                st.push(i);
                        }else{
                                while( !st.isEmpty() && A.get(st.peek()) <= A.get(i) )
                                        st.pop();
                                if(st.isEmpty())
                                        res.add(-1);
                                else
                                        res.add(st.peek());
                                st.push(i);
                        }
                }
                return reverseList(res);
        }
}
