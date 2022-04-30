package com.test.dsa.string;

public class SmallestCommonSubstring {
    /**
     * You are given two strings A and B that are made of lowercase English alphabets.
     * Find the number of different pairs ((i, j), (k,l)) such that the substrings A[i...j] andB[k...l] are equal and the value of j - i + 1 is minimum.
     */

    //count total number of pairs
    //return smallest common substring with minimum index
    //length of smallest common substring

    public static void main(String[] args) {
        smallestCommonSubstringPairs("abcd", "bc");
    }

    private static void smallestCommonSubstringPairs(String s, String s1) {
        int [] charA = new int[26];
        int [] charB = new int[26];
        int i =0;
        int count = 0;
        for(; i<s.length(); i++ )
            charA[s.charAt(i) - 'a']++;
        i=0;
        for(; i<s1.length(); i++ )
            charB[s1.charAt(i) - 'a']++;
        i=0;
        for(;i<charA.length; i++)
            count += charA[i] * charB[i];
        System.out.println(count);
    }

}
