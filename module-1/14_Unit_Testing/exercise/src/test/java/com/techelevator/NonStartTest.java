package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {

    @Test
    public void return_correct_value_when_two_strings_passed_in_test(){
        NonStart nonStart = new NonStart();

        String actual = nonStart.getPartialString("Hello", "There");

        Assert.assertEquals("ellohere", actual);
    }

    @Test
    public void return_nothing_when_one_letter_passed_in_test(){
        NonStart nonStart = new NonStart();

        String actual = nonStart.getPartialString("Z", "K");

        Assert.assertEquals("", actual);
    }


}
