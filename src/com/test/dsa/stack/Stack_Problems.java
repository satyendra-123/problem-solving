package com.test.dsa.stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;

public class Stack_Problems {

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static void main(String[] args) {
//        Stack_Problems sp = new Stack_Problems();
//        String[] res = sp.convertInfixToPostFix(new String[]{"3", "+", "10", "*", "(", "3", "-", "4", "/", "2", ")", "+", "3"});
//        System.out.println(res);
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    //convert a infix to postfix notations (reverse polish notation)
    /**
     *
     * INPUT -  ["3", "+", "10", "*", "(", "3", "-", "4", "/", "2", ")", "+", "3"]
     * OUTPUT - ["3", "10", "3", "4", "2", "/", "-", "*", "+", "3", "+"]
     *
     * bodmas
     * bracket, division, multiplication, addition, subtraction
     *
     * appraoach
     * if character is any character amaong *, /, +, - (   we need to push to stack.
     * if character is ')'
     * keep popping and pushing to ans string until we see  '(' this character but dont push  '(' this character to ans string
     *
     * if current charcter is lower precedence then peek character then pop the peek and push to ans
     * if current charcter is same precedence then peek character then pop the existing and push to ans. and push the current char to stack.
     *
     * if charcter is numeric value put it into the ans string array
     *
     * at last return the ans string
     *
     * @param infix
     * @return
     */
    private String[] convertInfixToPostFix(String[] infix){
        String[] arr = new String[infix.length];

        int i =  0;
        Stack<String> stck = new Stack<>();

        while(i < infix.length){
            if(isNumeric(infix[i])){
                arr[i] = infix[i];
            }else{
                if(infix[i].equals(")")){
                    //keep popping stack until we see a '('
                    while(!stck.peek().equals("("))
                        arr[i] = stck.pop();
                    stck.pop();
                }else if( ! stck.isEmpty() && precedenceCheck(infix[i], stck.peek())){
                    //dont pop from stack but push the current character into string
                    arr[i] = infix[i];
                }else{
                    //pop from stack
                    while(!stck.isEmpty() && !precedenceCheck(infix[i], stck.peek())){
                        arr[i] = stck.pop();
                    }

                    if(!stck.isEmpty())
                        arr[i] = stck.pop();
                    stck.push(infix[i]);
                }
            }
            System.out.println(Arrays.toString(arr));
            System.out.println(stck.toString());
            i++;
        }

        while(!stck.isEmpty()){
            arr[i++] = stck.pop();
        }
        return arr;
    }

    //returs true if current character has bigger precedence
    //based on this pop the character from stack
    private boolean precedenceCheck(String current, String top){
        if(current.equals("/") && top.equals("*")
                || current.equals("/") && top.equals("/")
                || current.equals("/") && top.equals("+")
                || current.equals("/") && top.equals("-"))
            return true;
        if(current.equals("*") && top.equals("+") || current.equals("*") && top.equals("-") )
            return true;
        if(current.equals("+") && top.equals("+") || current.equals("+") && top.equals("-") )
            return true;
        if(current.equals("-") && top.equals("+") || current.equals("-") && top.equals("-") )
            return true;
            return false;
    }
}
