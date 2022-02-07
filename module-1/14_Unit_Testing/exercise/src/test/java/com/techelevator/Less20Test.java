package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {

    @Test
    public void return_true_test(){
        Less20 less20 = new Less20();

        boolean actual = less20.isLessThanMultipleOf20(18);

        Assert.assertTrue(actual);
    }

    @Test
    public void return_false_test(){
        Less20 less20 = new Less20();

        boolean actual = less20.isLessThanMultipleOf20(20);

        Assert.assertFalse(actual);
    }

    @Test
    public void return_value_of_zero_test(){
        Less20 less20 = new Less20();

        boolean actual = less20.isLessThanMultipleOf20(0);

        Assert.assertFalse(actual);
    }


}
