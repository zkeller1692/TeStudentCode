package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {

    @Test
    public void return_true_when_no_ones_or_threes_test(){
        Lucky13 lucky13 = new Lucky13();

       boolean actual = lucky13.getLucky(new int[]{0,2,4});

        Assert.assertTrue(actual);
    }

    @Test
    public void return_false_when_ones_or_threes_in_array_test(){
        Lucky13 lucky13 = new Lucky13();

        boolean actual = lucky13.getLucky(new int[]{1,2,3});

        Assert.assertFalse(actual);
    }

}
