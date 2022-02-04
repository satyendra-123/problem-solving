package com.test.aocdec21;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
       // solution.findCountOfDepthMeasurements();
        solution.findThreeMeasurementsFromSlidingWindow();
    }

    private void findCountOfDepthMeasurements()  {
        Path path = Paths.get("input.txt");
        Stream<String> streamOfStrings = null;
        try {
            streamOfStrings = Files.lines(path);
            //Stream<String> streamOfStrings  = Stream.of("199 200 208 210 200 207 240 269 260 263".split(" "));
            int count=0;
            List<Integer> num = streamOfStrings.map(Integer::parseInt).collect(Collectors.toList());
            for (int i = 0; i <num.size() ; i++)
            {
               if(i < num.size()-1 && num.get(i) < num.get(i+1)){
                    count++;
                }
            }
           System.out.println("increased "+count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findThreeMeasurementsFromSlidingWindow(){
        try {
            Path path = Paths.get("input2.txt");
            Stream<String> streamOfStrings = Files.lines(path);
            //Stream<String> streamOfStrings = Stream.of("199 200 208 210 200 207 240 269 260 263".split(" "));
            int count = 0;
            List<Integer> num = streamOfStrings.map(Integer::parseInt).collect(Collectors.toList());
            for (int i = 0; i < num.size(); i++) {
                if (i + 3 < num.size()) {
                    int sum1 = num.get(i) + num.get(i + 1) + num.get(i + 2);
                    int sum2 = num.get(i + 1) + num.get(i + 2) + num.get(i + 3);
                    if (sum1 < sum2) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
