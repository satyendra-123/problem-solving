package com.test.dsa.string;

import java.util.Arrays;

public class String_Pattern_Matching {
    public static void main(String[] args) {
        String_Pattern_Matching spm = new String_Pattern_Matching();
        spm.longestPrefixSubstring();
    }

    /**
     * Given a string find the length of longest prefix substring which is also a suffix substring
     *
     * a b c d a b c
     *
     * ans : abc
     *
     *
     */
    private void longestPrefixSubstring(){
        //System.out.println(approach1("acaeycaca"));
        //lpsConstructWithBruteForce("acaeycaca");
        System.out.println(Arrays.toString(kmpApproachForLPS("acaeycaca")));
    }



    //Brute Force
    //we need to find the longest prefix substring possible
    //TC: O(N*N)
    private String approach1(String str){
        int i = 0;
        int j = 1;
        int k = str.length()-1;
        int l = 0;
        while( k >= 0){
            l = j;
            for(i=0; i < k; i++){
                if(str.charAt(i) == str.charAt(l))
                        l++;
                else
                    break;
            }
            if(i == k && l == str.length()){
                return str.substring(0, i);
            }
            j++;
            k--;
        }
        return "";
    }


    //Build LPS Array
    /**
     *
     * KMP Algorithm
     * (knuth morris pratt)
     * a b c d a b c
     *
     * for each ith index we need to find the longest prefix which is also a suffix
     * using brute force
     * TC O(N*N*N)
     * SC O(N*N)
     * a c a e y c a c a
     * 0 0 1 0 0 0 1 2 3
     * */
    private void lpsConstructWithBruteForce(String str){
        int [] lps = new int[str.length()];
        int i = 0;
        for( ; i< str.length(); i++){
            lps[i] = approach1(str.substring(0, i+1)).length();
        }
        System.out.println(Arrays.toString(lps));
    }

    /***
     *
     *  As explained by Deepak Kasera
     *  KMP
     *  step 1
     *  lps[0] = 0;
     *
     *  eq:
     *  lps[i-1] + 1 >= lps[i]
     *  int x = lps[i-1] //here we take it out because till lps[i-1] it must have at least x length prefix which is also a suffix
     *  while iterating over string if
     *  str[i] != str[x]
     *  x= lps[x-1] // we need to go backward till x is > 0 if x reaches 0 break and assign x = -1;
     *
     *  if the str[i] == str[x] it means that at x there is same character as at ith which mean this can be the max prefix/suffix for ith position
     *
     *  lps[i] = x+1;
     *
     */

    public int[] kmpApproachForLPS(String str){
            int [] lps = new int[str.length()];
            int i = 1;
            lps[0] = 0;
            int j = 0;

            for(; i<str.length(); i++){
                j  = lps[i-1];
                while(str.charAt(i) != str.charAt(j)){
                    if(j == 0) {
                        j = -1;
                        break;
                    }
                    j = lps[j-1];
                }
                lps[i] = j+1;
            }
            return lps;
    }


    /**
     *
     *
     * here also we follow the same appraoch but we move backward when character does not match
     *
     * if character matches increase i++, lps[j] =i, j++;
     * if character does not match only if i > 0
     * i = lps[i-1]
     * if character does not match only if i == 0
     * lps[j] = 0;
     * j++;
     *
     * */
    public int[] kmpApproach2ForLPS(String str){
        int [] lps = new int[str.length()];
        lps[0] = 0;
        int j = 1;
        int i = 0;
        while( j < str.length() ){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                lps[j] = i;
                j++;
            }else{
                if(i != 0)
                    i = lps[i-1];
                else {
                    lps[j] = 0;
                    j++;
                }
            }
        }
        return lps;
    }


    /**
     *
     *
     * Given two binary strings A and B, count how many cyclic permutations of B when taken XOR with A give 0.
     *
     * NOTE: If there is a string, S0, S1, ... Sn-1 , then it is a cyclic permutation is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1
     * where k can be any integer from 0 to N-1.
     *
     * String A: adbc
     * String B: dbca
     *
     * there will be cyclic permuation which will be same as A then xor will be 0;
     *
     * B.F. => find all cyclic permutations and if permuation is equal to A count it.
     * dbca
     *  bcad
     *   cadb
     *    adbc -> matches
     *     dbca
     *
     *  alternative:
     *  A pattern match in string which contains all cyclic permutaions possible
     *  if we make B such that it becomes all cyclic permutations
     *  adbc+$+dbca+dbca
     *  0000 0 0001 2341 (create lps check if length of pattern is present in lps]
     *
     *  abab
     *  abab+$+abab+abab
     *  0012 0 1234 1234   the length is present two times
     *
     * find cycling permutations
     * @param str
     * @return
     *
     */


    /**
     *
     */


}
