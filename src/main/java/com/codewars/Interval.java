package com.codewars;

public class Interval {

    public static void main(String[] args) {

        int[][] tests = new int[][]{{9247, 9692}, {-7305, 8217}, {0, 0},{0, 0}, {0, 0}, {-4274, 2603}};

        System.out.println(isGotIntersections(tests));
        System.out.println(sumIntervals(tests));

    }


    public static int sumIntervals(int[][] intervals) {

        if(intervals == null) return 0;


        while(true) {

            for (int i = 0; i < intervals.length; i++) {

                if (intervals[i][0] != intervals[i][1]) {

                    for (int j = i+1; j < intervals.length; j++) {
                        if(   isGotIntersections(new int[][] {intervals[i],intervals[j]})){

                            intervals[i][0] = Integer.min(intervals[i][0],intervals[j][0]);
                            intervals[i][1] = Integer.max(intervals[i][1],intervals[j][1]);
                            intervals[j][0] = intervals[i][0];
                            intervals[j][1] = intervals[i][0];
                        }
                    }
                }
            }
            if (!isGotIntersections(intervals)) break;
        }

        int result = 0;
        for (int[] intz:intervals) {
            result += (intz[1]-intz[0]);

        }



        return result;
    }

    public static boolean isGotIntersections(int [][] intervals) {

        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][0] != intervals[i][1]) {

                for (int j = i+1; j < intervals.length; j++) {
                    if(intervals[j][0] != intervals[j][1]) {

                        if (intervals[j][0] >= intervals[i][0] && intervals[j][0] < intervals[i][1]) {
                            return true;
                        } //check intersection "on the right"
                        if (intervals[j][1] <= intervals[i][1] && intervals[j][1] > intervals[i][0]) {
                            return true;
                        } //check intersection "on the left"
                        if (intervals[j][0] <= intervals[i][0] && intervals[j][1] >= intervals[i][1]) {
                            return true;
                        } //check if they are equal or a include b
                        if (intervals[j][0] > intervals[i][0] && intervals[j][1]<intervals[i][1])
                            { return true; }
                        //check if b include a

                    }
                }
            }
        }
        return false;
    }

}


/*

[9247, 9692], [-7305, 8217], [0, 0], [0, 0], [0, 0], [0, 0], [0, 0], [0, 0], [0, 0], [0, 0], [-4274, 2603]
 expected:<15967> but was:<22844>
Write a function called sumIntervals/sum_intervals() that accepts an array of intervals, and returns the sum of all the interval lengths.
Overlapping intervals should only be counted once.

Intervals
Intervals are represented by a pair of integers in the form of an array. The first value of the interval will always be less than the second value.
Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.

Overlapping Intervals
List containing overlapping intervals:

[
   [1,4],
   [7, 10],
   [3, 5]
]
The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval as [1, 5], which has a length of 4.

Examples:
// null argument
Interval.sumIntervals(null);  // => 0

// empty intervals
Interval.sumIntervals(new int[][]{});  // => 0
Interval.sumIntervals(new int[][]{2,2}, {5,5});  // => 0

// disjoined intervals
Interval.sumIntervals(new int[][]{
  {1,2},{3,5}
});  // => (2-1) + (5-3) = 3

// overlapping intervals
Interval.sumIntervals(new int[][]{
  {1,4},{3,6},{2,8}
});  // [1,8] => 7
 */