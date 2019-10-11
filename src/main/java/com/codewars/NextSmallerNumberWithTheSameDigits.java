package com.codewars;

import java.util.stream.Stream;

public class NextSmallerNumberWithTheSameDigits {

    public static long nextSmaller(long n)
    {

        String stringn = String.valueOf(n);


        String[] splited = stringn.split("");
        for (int i = splited.length-1; i > 0 ; i--) {
            int j = i-1;

            while(true) {
                if(!testPair(splited[i], splited[j], j) ) {

//                j > 0 ? j--;  break;
                }


            }



        }


        return n;
    }

    public static boolean testPair(String current, String compareTo, int placeOfCompared) {

        if (current.compareTo(compareTo) < 0) {

            if (!current.contains("0") && placeOfCompared==0) {
                return false;
            }

            return true;
        }
        return false;
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