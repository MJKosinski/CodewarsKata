package com.codewars;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class NextSmallerNumberWithTheSameDigits {

    public static long nextSmaller(long n) {

        String stringn = String.valueOf(n);


        String[] splited = stringn.split("");
        for (int i = splited.length - 1; i > 0; i--) {
            int j = i - 1;


            if (Integer.parseInt(splited[i]) < Integer.parseInt(splited[j])) {
                StringBuilder result = new StringBuilder();

//                prepare the left side of nuber
                if (i != 1) {
                    String[] left = Arrays.copyOfRange(splited, 0, j);
                    Stream<String> stream = Arrays.stream(left);
                    stream.forEach(result::append);
                }

//                splited[j] is the number to change
                int firstLarger = Integer.parseInt(splited[j]) - 1;
                if (firstLarger == 0 && j == 0) {return -1L;}


//                prepare right side of number
                for (int k = firstLarger; k >= 0; k--) {
                    Stream<String> stream = Arrays.stream(splited, i, splited.length);
                    if (stream.anyMatch(Predicate.isEqual(String.valueOf(k)))) {
                        firstLarger = k;
                        result.append(k);
                        break;
                    }
                    stream.close();


                }
                String right = stringn.substring(i);
                String replaced = right.replaceFirst(String.valueOf(firstLarger), splited[j]);
                String[] splitRight = replaced.split("");
                Arrays.sort(splitRight, Collections.reverseOrder());
                for (String s : splitRight) {
                    result.append(s);
                }
                return Long.parseLong(result.toString());

            }
        }
        return -1L;
    }

}




/*
Write a function that takes a positive integer and returns the next smaller positive integer containing the same digits.

For example:

nextSmaller(21) == 12
nextSmaller(531) == 513
nextSmaller(2071) == 2017
Return -1 (for Haskell: return Nothing, for Rust: return None), when there is no smaller number that contains the same digits. Also return -1 when the next smaller number with the same digits would require the leading digit to be zero.

nextSmaller(9) == -1
nextSmaller(111) == -1
nextSmaller(135) == -1
nextSmaller(1027) == -1 // 0721 is out since we don't write numbers with leading zeros
some tests will include very large numbers.
test data only employs positive integers.
The function you write for this challenge is the inverse of this kata: "Next bigger number with the same digits."
 */