package com.test.dsa.bitmanipulation;

public class BitManipulation {

    public static void main(String[] args) {
        divideWithoutArithmeticOperators();
    }

    static void divideWithoutArithmeticOperators(){
        System.out.println(approach3(-2147483648, -1));
    }

    private static int approach3(int dividend, int divisor){
        if(dividend == divisor)
            return 1;
        boolean isPositive = (dividend<0 == divisor<0);    // if both are of same sign, answer is positive
        int a = dividend < 0 ? dividend*-1 : dividend;
        int b = divisor < 0 ? divisor*-1 : divisor;
        int ans = 0;
        while(a >= b){  // while dividend is greater than or equal to divisor
            short q = 0;
            while(a > (b<<(q+1)))
                q++;
            ans += (1<<q);  // add the power of 2 found to the answer
            a = a - (b<<q);  // reduce the dividend by divisor * power of 2 found
        }
        if(ans == (1<<31) && isPositive)   // if ans cannot be stored in signed int
        return Integer.MAX_VALUE;
        return isPositive ? ans : -ans;
    }

    private static int approach2(int a, int b){
        boolean isPos = true;
        if( (a < 0 && b > 0) || (b < 0 && a > 0))
            isPos = false;
        int A = a < 0 ? a*-1 : a;
        int B = b < 0 ? b*-1 : b;
        if(A == 0)
            return 0;
        if(B == 1)
            return isPos ? A : a;
        int sum = 0;
        int q;
        int val;
        while(A >= B){
            val = B;
            q = 0;
            while( (val << q+1) < A ){
                q++;
                // if((val << q+1) < 0) {
                //     break;
                // }
            }
            sum += (1L<<q);
            A = A - (val << q);
        }
        if(sum >= Integer.MAX_VALUE && isPos)
            return  Integer.MAX_VALUE;
        else
            return isPos ? sum : -sum;
    }


}
