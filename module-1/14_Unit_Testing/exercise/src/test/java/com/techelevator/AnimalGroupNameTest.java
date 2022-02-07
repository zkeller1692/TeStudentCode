package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {

    @Test
    public void return_animal_group_name(){
    AnimalGroupName agn = new AnimalGroupName();

    String actual = agn.getHerd("Rhino");

    Assert.assertEquals("Did not pass Crash when Rhino passed in", "Crash", actual);

    }

    @Test
    public void return_animal_group_name_regardless_of_Case() {

        AnimalGroupName agn = new AnimalGroupName();

        String actual = agn.getHerd("rHInO");

        Assert.assertEquals("Did not pass Crash when Rhino passed in regardless of case", "Crash", actual);

    }

    @Test
    public void return_unknown_when_nothing_passed_in(){

        AnimalGroupName agn = new AnimalGroupName();

        String actual = agn.getHerd(" ");

        Assert.assertEquals("Did not pass unknown when nothing passed in","unknown", actual);

    }

    @Test
    public void return_unknown_when_null_passed_in(){

        AnimalGroupName agn = new AnimalGroupName();

        String actual = agn.getHerd(null);

        Assert.assertEquals("unknown", actual);
    }

}
