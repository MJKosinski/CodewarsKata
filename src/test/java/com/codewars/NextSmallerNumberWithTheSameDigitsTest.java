package com.codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class NextSmallerNumberWithTheSameDigitsTest {

    @Test
    public void basicTests() {
//        assertEquals(12, NextSmallerNumberWithTheSameDigits.nextSmaller(21));66554433222
        assertEquals(-1, NextSmallerNumberWithTheSameDigits.nextSmaller(112334455566L));
        assertEquals(790, NextSmallerNumberWithTheSameDigits.nextSmaller(907));
        assertEquals(513, NextSmallerNumberWithTheSameDigits.nextSmaller(531));
        assertEquals(1720, NextSmallerNumberWithTheSameDigits.nextSmaller(2017));
        assertEquals(-1, NextSmallerNumberWithTheSameDigits.nextSmaller(1027));
        assertEquals(414, NextSmallerNumberWithTheSameDigits.nextSmaller(441));
        assertEquals(123456789, NextSmallerNumberWithTheSameDigits.nextSmaller(123456798));
    }

}