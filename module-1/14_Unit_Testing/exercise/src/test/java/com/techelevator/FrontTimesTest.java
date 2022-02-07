package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {

    @Test
    public void return_first_three_characters_3_times_test(){
        FrontTimes frontTimes = new FrontTimes();

        String actual = frontTimes.generateString("Chocolate", 3);

        Assert.assertEquals("ChoChoCho", actual);
    }

    @Test
    public void return_value_zero_times_test(){
        FrontTimes frontTimes = new FrontTimes();

        String actual = frontTimes.generateString("Chocolate", 0);

        Assert.assertEquals("", actual);
    }

    @Test
    public void return_value_one_time_test(){
        FrontTimes frontTimes = new FrontTimes();

        String actual = frontTimes.generateString("Chocolate", 1);

        Assert.assertEquals("Cho", actual);
    }

    @Test
    public void return_first_two_characters_test(){
        FrontTimes frontTimes = new FrontTimes();

        String actual = frontTimes.generateString("Lo", 4);

        Assert.assertEquals("LoLoLoLo", actual);
    }

    @Test
    public void return_first_character_test(){
        FrontTimes frontTimes = new FrontTimes();

        String actual = frontTimes.generateString("Z", 5);

        Assert.assertEquals("ZZZZZ", actual);
    }

    @Test
    public void no_string_entered_test(){
        FrontTimes frontTimes = new FrontTimes();

        String actual = frontTimes.generateString("", 5);

        Assert.assertEquals("", actual);
    }



    }
