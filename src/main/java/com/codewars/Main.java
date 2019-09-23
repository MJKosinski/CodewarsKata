package com.codewars;

public class Main {
    public static void main(String[] args) {


        System.out.println(gcd(10,41));
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
