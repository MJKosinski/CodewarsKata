package com.codewars;

import java.util.stream.IntStream;

public class BreakCamelCase {

    public static String camelCase(String input) {

        char[] split = input.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            result.append(split[i]);
            if(i<split.length-1 &&  Character.isLowerCase(split[i]) && Character.isUpperCase(split[i+1])) {
                result.append(" ");
            }


        }
        return result.toString();
    }


}
