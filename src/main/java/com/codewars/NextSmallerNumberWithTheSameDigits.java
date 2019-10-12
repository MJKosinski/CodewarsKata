package com.codewars;

import java.util.Arrays;
import java.util.Collections;


public class NextSmallerNumberWithTheSameDigits {

    public static long nextSmaller(long n)
    {

        String stringn = String.valueOf(n);


        String[] splited = stringn.split("");
        for (int i = splited.length-1; i > 0 ; i--) {
            int j = i-1;


            while(!testPair(splited[i], splited[j], j)) {
                {
                    if (j == 0) break;
                    if (splited[i].equals(splited[j])) break;
                    j--;
                }
            }

            if (testPair(splited[i], splited[j], j)) {
                String toChange = splited[j];
                splited[j] = splited[i];
                splited[i] = toChange;
                StringBuilder result = new StringBuilder();

                try {
                    String[] restOfNumber = Arrays.copyOfRange(splited, j + 1, splited.length );
                    Arrays.sort(restOfNumber, Collections.reverseOrder());
                    for (int k = 0; k < restOfNumber.length; k++) {
                        splited[splited.length-restOfNumber.length+k] = restOfNumber[k];

                }
                }
                catch (IndexOutOfBoundsException e) {}


                String collect = String.join("", splited);
                return Long.parseLong(collect);

            }

        }

        return -1L;
    }

    public static boolean testPair(String current, String compareTo, int placeOfCompared) {

        if (current.compareTo(compareTo) < 0) {

            if (current.contains("0") && placeOfCompared==0) {
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