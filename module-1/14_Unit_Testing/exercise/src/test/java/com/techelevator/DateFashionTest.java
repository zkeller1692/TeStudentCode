package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {

    @Test
    public void correct_value_returned_if_date_is_8(){
        DateFashion dateFashion = new DateFashion();

        int actual = dateFashion.getATable(5, 8);

        Assert.assertEquals(2, actual);
    }

    @Test
    public void correct_value_returned_if_date_is_below_8(){
        DateFashion dateFashion = new DateFashion();

        int actual = dateFashion.getATable(5, 7);

        Assert.assertEquals(1, actual);
    }

    @Test
    public void correct_value_returned_if_date_is_2(){
        DateFashion dateFashion = new DateFashion();

        int actual = dateFashion.getATable(5, 2);

        Assert.assertEquals(0, actual);
    }

    @Test
    public void correct_value_returned_if_date_is_a_negative_number(){
        DateFashion dateFashion = new DateFashion();

        int actual = dateFashion.getATable(5, -1);

        Assert.assertEquals(0, actual);
    }


}
