package com.codewars;

public class Fracts {
//best practise z codewars
    public static void main(String[] args) {
        long[][] lst;
        lst = new long[][]{{1, 2}, {1, 3}, {10, 41}};
        System.out.println(convertFrac(lst));

    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static String convertFrac(long[][] lst) {
        long lcmall = 1;
        long[][] newlst = new long[lst.length][2];
        for  (int i = 0; i < lst.length; i++) {
            long g = gcd(lst[i][0], lst[i][1]);
            newlst[i][0] = lst[i][0] / g;
            newlst[i][1] = lst[i][1] / g;
        }
        for (long[] item : newlst) {
            lcmall = lcm(lcmall, item[1]);
        }
        String result = "";
        for (long[] item : newlst) {
            result += "(" + (item[0] * lcmall / item[1]) + "," + lcmall + ")";
        }
        return result;
    }






 /*
  moje


  public static String convertFrac(long[][] lst) {

        long dividor = 2;

        while (true) {

            long divTest = dividor;

            for (long[] num : lst) {
                if ((num[0] * dividor) % num[1] != 0) {
                    dividor++;
                }
            }

            if (divTest == dividor) {
                break;
            }

        }

        StringBuilder result = new StringBuilder();
        for (long[] num : lst) {
            result.append("(").append((num[0] * dividor) / num[1]).append(",").append(dividor).append(")");
        }


        return result.toString();
    }*/

}

/*

Common denominators

You will have a list of rationals in the form

 { {numer_1, denom_1} , ... {numer_n, denom_n} }
or

 [ [numer_1, denom_1] , ... [numer_n, denom_n] ]
or

 [ (numer_1, denom_1) , ... (numer_n, denom_n) ]
where all numbers are positive ints.

You have to produce a result in the form

 (N_1, D) ... (N_n, D)
or

 [ [N_1, D] ... [N_n, D] ]
or

 [ (N_1', D) , ... (N_n, D) ]
or

{{N_1, D} ... {N_n, D}}
or

"(N_1, D) ... (N_n, D)"
depending on the language (See Example tests)

in which D is as small as possible and

 N_1/D == numer_1/denom_1 ... N_n/D == numer_n,/denom_n.
Example:

convertFracs [(1, 2), (1, 3), (1, 4)] `shouldBe` [(6, 12), (4, 12), (3, 12)]
Note:
Due to the fact that first translations were written long ago - more than 4 years - these translations have only irreducible fractions. Newer translations have some reducible fractions. To be on the safe side it is better to do a bit more work by simplifying fractions even if they don't have to be.

Note for Bash:
input is a string, e.g "2,4,2,6,2,8"

output is then "6 12 4 12 3 12"


 */