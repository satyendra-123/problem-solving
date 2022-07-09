package com.test.dsa.string;

import java.util.Arrays;
import java.util.HashMap;

public class Rabin_Karp_Algorithm {
    public static void main(String[] args) {
        Rabin_Karp_Algorithm rka = new Rabin_Karp_Algorithm();
        rka.countOccurencesOfWordInText();
    }

    private void countOccurencesOfWordInText(){
        String text = "abababaababa";
        String pattern = "ab";
        System.out.println(" using Rabbin Karp ");
        System.out.println(approach1(text, pattern));
        System.out.println(" using kmp approach 2 ");
        System.out.println(approach2(text, pattern));
        System.out.println(" using kmp approach 1 ");
        System.out.println(approach3(text, pattern));
    }

    private int approach2(String text, String pattern){
        String_Pattern_Matching spm = new String_Pattern_Matching();
        String str = pattern+"$"+text;
        int[] lps = spm.kmpApproach2ForLPS(str);
        //System.out.println(Arrays.toString(lps));
        int count = 0;
        for (int i = 0; i < lps.length; i++) {
            if(lps[i] == pattern.length())
                    count++;
        }
        return count;
    }

    private int approach3(String text, String pattern){
        String_Pattern_Matching spm = new String_Pattern_Matching();
        String str = pattern+"$"+text;
        int[] lps = spm.kmpApproachForLPS(str);
        //System.out.println(Arrays.toString(lps));
        int count = 0;
        for (int i = 0; i < lps.length; i++) {
            if(lps[i] == pattern.length())
                count++;
        }
        return count;
    }

    /**
     * given a string text find the another string occurences in it.
     * text: abc def abc def abc
     * pattern: abc
     *
     * Brute Force:
     * 1) iterate over text and compare the pattern upto k characters (pattern length)
     * 2) slide the window
     * 3) if all characters of pattern matches in text increase the count slide the window.
     * TC: O(N*K)
     *
     * approach 1:
     * put all the k length parts of text in an array and search
     * TC: O(n*k+n) SC: O(N/K)
     *
     */


    /**
     * Approach 2:
     * instead of an array dump all the k length string in hashmap
     * TC: (here put/get tc for string is not O(1) its O(K) the length of the string
     *
     * for hash collision we need to make sure that each string produces the diff hashcode as per its ascii values
     *
     * to calculat the hash we need to slide the window on text for k length characters and
     * abc def abc def abc
     *
     * ascii
     * a -> a-'a'+1 = 1
     * b -> b-'a'+1 = 2
     * c -> c-'a'+1 = 3
     *
     * 1*10^0 + 2*10^1 + 3*10^2
     *
     * - keep a variable
     * - when we move the window we need to subtract the previous value and add a new value
     *
     */
    private int approach1(String A, String B){
        HashMap<Long, Integer> fmap = new HashMap<>();
        int k = B.length();
        int mod = 1000000007;
        long[] parr = powerArray(k, mod);
        int i = 0;
        long sum = 0;
        for ( ;i<k; i++){
            sum += ((long)getChAscii(A.charAt(i)) % mod * parr[i] % mod) % mod;
        }
        fmap.put(sum, fmap.getOrDefault(sum,0)+1);
        i=1;
        int e = k;
        while(i <= (A.length()-k)){
            sum -= ((long)getChAscii(A.charAt(i-1)) % mod * parr[0] % mod) % mod ;
            sum /= 10;
            sum += ((long)getChAscii(A.charAt(e)) % mod * parr[k-1] % mod) % mod;
            e++;
            fmap.put(sum, fmap.getOrDefault(sum,0)+1);
            i++;
        }

        //find the occurences
        long hc = getHashCodeForWord(B, mod, parr);
        if(fmap.containsKey(hc))
                return fmap.get(hc);
        return 0;
    }

    private int getChAscii(char c){
        if(c >= 'a' && c <= 'z')
            return c-'a';
        else if(c >= 'A' && c <= 'Z')
            return c-'A';
        return -1;
    }

    private long getHashCodeForWord(String A, int mod, long[] parr){
        int k = A.length();
        long sum  = 0;
        for (int i =0;i<k; i++){
            sum += ((long)getChAscii(A.charAt(i)) % mod * parr[i] % mod) % mod;
        }
        return sum % mod;
    }

    private long[] powerArray(int k, int mod){
        long[] parr = new long[k+1];
        int i = 1;
        parr[0] = 1;
        for(; i<parr.length; i++){
            parr[i] = (parr[i-1] % mod * 10 % mod) % mod;
        }
        return parr;
    }

}
