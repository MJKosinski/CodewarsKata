package com.codewars;

import sun.awt.image.IntegerComponentRaster;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

//        int x = '\n';
//
//        System.out.printcghjkln(x);

        String test = "acd!fg\nsrut!ututu\ni cześć!$";
        String regexInput = "!";
        String replaced = test.replaceFirst(regexInput+".*", "<>");
        System.out.println(replaced);




    }


}
