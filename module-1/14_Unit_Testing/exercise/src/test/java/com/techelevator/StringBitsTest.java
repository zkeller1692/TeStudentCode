package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {

    @Test
    public void return_correct_value_of_every_other_character_test(){

        StringBits stringBits = new StringBits();

        String actual = stringBits.getBits("Hello");

        Assert.assertEquals("Hlo", actual);
    }

    @Test
    public void return_correct_value_when_one_character_passed_in_test(){

        StringBits stringBits = new StringBits();

        String actual = stringBits.getBits("Z");

        Assert.assertEquals("Z", actual);
    }

    @Test
    public void return_correct_value_when_string_with_spaces_passed_in_test(){

        StringBits stringBits = new StringBits();

        String actual = stringBits.getBits("H e l l o");

        Assert.assertEquals("Hello", actual);
    }

    @Test
    public void return_emptry_string_when_empty_string_passed_in_test(){

        StringBits stringBits = new StringBits();

        String actual = stringBits.getBits("");

        Assert.assertEquals("", actual);
    }
}
