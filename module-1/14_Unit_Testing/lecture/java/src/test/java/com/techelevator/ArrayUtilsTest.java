package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ArrayUtilsTest {
    @Test
    public void correct_valued_returned_from_three_element_array(){
        int[] arguments = new int[] {1,2,3};

        int actual = ArrayUtils.max(arguments);

        Assert.assertEquals("Didn't get expected max value", 3, actual);
    }

    @Test
    public void correct_valued_returned_with_repeated_max_values(){
        int[] arguments = new int[] {3,2,3};

        int actual = ArrayUtils.max(arguments);

        Assert.assertEquals("Didn't get expected max value", 3, actual);
    }

     @Test
    public void correct_valued_returned_with_negative_numbers(){
        int[] arguments = new int[] {-1,-2,-3,-3};

        int actual = ArrayUtils.max(arguments);

        Assert.assertEquals("Didn't get expected max value", -1, actual);
    }

    @Test
    public void correct_valued_returned_with_empty_array(){
        int[] arguments = new int[] {};

        int actual = ArrayUtils.max(arguments);

        Assert.assertEquals("Didn't get expected max value", Integer.MIN_VALUE, actual);
    }






}
