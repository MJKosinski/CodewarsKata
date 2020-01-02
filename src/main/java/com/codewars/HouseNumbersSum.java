package com.codewars;

public class HouseNumbersSum {
    public static int houseNumbersSum(final int[] arr) {
        int agg = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {
                agg += arr[i];
            } else break;
        }


        return agg;
    }


}



/*
Example
        For inputArray = [5, 1, 2, 3, 0, 1, 5, 0, 2], the output should be 11.

        The answer was obtained as 5 + 1 + 2 + 3 = 11.

        Input/Output
        [input] integer array inputArray

        Constraints: 5 ≤ inputArray.length ≤ 50, 0 ≤ inputArray[i] ≤ 10.

        [output] an integer*/
