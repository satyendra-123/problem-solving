package com.test.dsa;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class DsaTester2 {
    public static void main(String[] args) {
//        Stack<Integer> stck = new Stack<>();
//        for (int i = 0; i <5 ; i++) {
//                stck.add(i);
//        }
//        ArrayList<Integer> data = fillValue(stck, new ArrayList<>());
//
//        Iterator<Integer> iterator = stck.iterator();
//        while(iterator.hasNext())
//            System.out.println(iterator.next());
    }

    private static ArrayList<Integer> fillValue(Stack<Integer> stck, ArrayList<Integer> res){
        if(stck.isEmpty())
            return res;
        int val = stck.pop();
        res = fillValue(stck, res);
        res.add(val);
        return res;
    }


}
