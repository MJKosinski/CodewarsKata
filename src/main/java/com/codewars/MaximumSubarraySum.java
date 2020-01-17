package com.codewars;


import java.util.Arrays;

import static java.util.Arrays.stream;

public class MaximumSubarraySum {

    public static int sequence(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }

        else {

            while (true) {

                int[] stripped = stripLeft(arr);
                if (stripped.length != arr.length) {
                    arr = stripped;
                } else {
                    break;
                }

            }
            return  Arrays.stream(arr).sum();
        }

    }

    public static int[] stripLeft(int arr[]) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            counter += arr[i];
            if (counter < 0) {
                arr = Arrays.copyOfRange(arr, i+1,arr.length);
                arr = stripRight(arr);
            }

        }

        return arr;
    }


    public static int[] stripRight(int arr[]) {
        int counter = 0;
        for (int i = arr.length-1; i >= 0 ; i--) {
            counter += arr[i];
            if (counter < 0) {
                return Arrays.copyOfRange(arr, 0 , i);
            }
        }

    return arr;
    }

    public static int sumOfArray(int arr[]) {
        return  Arrays.stream(arr).sum();
    }
}



/*The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an
array or list of integers:


Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
// should be 6: {4, -1, 2, 1}

Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array.
        If the list is made up of only negative numbers, return 0 instead.

Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.

  */