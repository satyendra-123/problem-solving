package com.test.dsa.string;

import java.util.HashSet;

public class LongestSubstringNonRepeating {
    public static void main(String[] args) {
        longestSubStringNonRepeating("pwwkew");
    }
    private static  void longestSubStringNonRepeating(String s){
        int count = 0;
        int maxLen = 0;
        int j = 0;
        //index of matching character in substring
        int k = 0;
        HashSet<Character> cset = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            if(cset.contains(s.charAt(i))){
                maxLen = maxLen < count ? count : maxLen;
                count = 0;
                String unq = s.substring(j, i);
                //System.out.println(unq);
                k = unq.indexOf(s.charAt(i));

                i = j+k+1;
                j = i;
                cset = new HashSet<>();
            }else{
                count++;
                cset.add(s.charAt(i));
            }
        }
        maxLen = maxLen < count ? count : maxLen;
        System.out.println(maxLen);
    }
}
