package com.codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class PickPeaks {

    public static void main(String[] args) {
        int[] tryIntz = {1, 2, 2, 2, 1};
        Map<String, List<Integer>> peaks = getPeaks(tryIntz);
    }

    public static Map<String, List<Integer>> getPeaks(int[] arr) {

        Map<String, List<Integer>> result = new HashMap<>();
        List<Integer> pos = new ArrayList<>();
        List<Integer> peaks = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            if (i > 0 && i != arr.length - 1) {

                if (arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) {
                    pos.add(i);
                    peaks.add(arr[i]);
                } else if (arr[i - 1] < arr[i] && arr[i] == arr[i + 1] && i + 1 != arr.length - 1) {
                    for (int j = i + 2; j <= arr.length - 1; j++) {
                        if (arr[j] < arr[i]) {
                            pos.add(i);
                            peaks.add(arr[i]);
                            break;
                        } else if (arr[j] > arr[i]) {
                            break;
                        }
                    }
                }
                result.put("pos", pos);
                result.put("peaks", peaks);
            }

        }
        return result;
    }
}

/*In this kata, you will write a function that returns the positions and the values of the "peaks" (or local maxima) of a numeric array.

        For example, the array arr = [0, 1, 2, 5, 1, 0] has a peak at position 3 with a value of 5 (since arr[3] equals 5).

        The output will be returned as a ``Map<String,List>
with two key-value pairs:
"pos"
and
"peaks"
. If there is no peak in the given array, simply return
{"pos" => [], "peaks" => []}`.

Example: pickPeaks([3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3]) should return {pos: [3, 7], peaks: [6, 3]} (or equivalent in other languages)

All input arrays will be valid integer arrays (although it could still be empty), so you won't need to validate the input.

The first and last elements of the array will not be considered as peaks (in the context of a mathematical function, we don't know what is after and before and therefore, we don't know if it is a peak or not).

Also, beware of plateaus !!! [1, 2, 2, 2, 1] has a peak while [1, 2, 2, 2, 3] does not. In case of a plateau-peak, please only return the position and value of the beginning of the plateau. For example: pickPeaks([1, 2, 2, 2, 1]) returns {pos: [1], peaks: [2]} (or equivalent in other languages)

Have fun!

 */