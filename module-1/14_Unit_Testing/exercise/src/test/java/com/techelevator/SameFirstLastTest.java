package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {

    @Test
    public void first_number_and_last_number_do_not_match_test(){
        SameFirstLast sameFirstLast = new SameFirstLast();

        boolean actual = sameFirstLast.isItTheSame(new int[]{1,2,3});

        Assert.assertFalse(actual);
    }

    @Test
    public void first_and_last_number_do_match_test(){
        SameFirstLast sameFirstLast = new SameFirstLast();

        boolean actual = sameFirstLast.isItTheSame(new int[]{1,2,1});

        Assert.assertTrue(actual);
    }

    @Test
    public void only_one_number_passed_in_test(){
        SameFirstLast sameFirstLast = new SameFirstLast();

        boolean actual = sameFirstLast.isItTheSame(new int[]{1});

        Assert.assertTrue(actual);
    }
}
