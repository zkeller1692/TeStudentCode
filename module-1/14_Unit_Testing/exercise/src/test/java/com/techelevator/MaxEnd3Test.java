package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MaxEnd3Test {

    @Test
    public void highest_number_three_test(){
        MaxEnd3 maxEnd3 = new MaxEnd3();

        int [] actual = maxEnd3.makeArray(new int [] {1,2,3});

        Assert.assertArrayEquals(new int[]{3,3,3},actual);
    }
    @Test
    public void highest_number_is_negative_ten_test(){
        MaxEnd3 maxEnd3 = new MaxEnd3();

        int [] actual = maxEnd3.makeArray(new int [] {-10,100,-50});

        Assert.assertArrayEquals(new int[]{-10, -10, -10},actual);
    }

    @Test
    public void highest_number_is_zero_test(){
        MaxEnd3 maxEnd3 = new MaxEnd3();

        int [] actual = maxEnd3.makeArray(new int [] {0,100,-50});

        Assert.assertArrayEquals(new int[]{0, 0, 0},actual);
    }

}
