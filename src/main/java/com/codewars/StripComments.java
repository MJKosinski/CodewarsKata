package com.codewars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {

        String[] split = text.split("\n");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < split.length; i++) {


            for (String c : commentSymbols) {
                if(c.contains("$")) { c = c.replace("$","\\$"); }
                if(c.contains("^")) { c = c.replace("^","\\^"); } // I don't like it

                Pattern pattern = Pattern.compile(c+"(.*)$");
                Matcher m = pattern.matcher(split[i]);
                split[i] = m.replaceAll("");

//                split[i] = split[i].replaceFirst(c + "[^\\$\\^]*", "");
            }

            split[i] = split[i].replaceFirst(" +$","");
            result.append(split[i]);

            if(i< split.length-1) {
                result.append("\n");
            }

        }


        return result.toString();

    }
}

/*
Complete the solution so that it strips all text that follows any of a set of comment markers passed in. Any whitespace at the end of the line should also be stripped out.

Example:

Given an input string of:

apples, pears # and bananas
grapes
bananas !apples
The output expected would be:

apples, pears
grapes
bananas
The code would be called like so:

var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
// result should == "apples, pears\ngrapes\nbananas"

 */