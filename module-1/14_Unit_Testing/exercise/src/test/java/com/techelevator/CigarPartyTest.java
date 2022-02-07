package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.security.PublicKey;

public class CigarPartyTest {

    @Test
    public void not_enough_cigars_and_not_weekend_test() {

        CigarParty cigarParty = new CigarParty();

        boolean actual = cigarParty.haveParty(39, false);

        Assert.assertFalse(actual);
    }

    @Test
    public void too_many_cigars_and_not_weekend_test() {

        CigarParty cigarParty = new CigarParty();

        boolean actual = cigarParty.haveParty(61, false);

        Assert.assertFalse(actual);
    }

    @Test
    public void is_weekend_and_more_than_60_cigars_test(){

        CigarParty cigarParty = new CigarParty();

        boolean actual = cigarParty.haveParty(61, true);

        Assert.assertTrue(actual);
    }

    @Test
    public void is_weekend_and_less_than_40_cigars_test(){

        CigarParty cigarParty = new CigarParty();

        boolean actual = cigarParty.haveParty(39, true);

        Assert.assertFalse(actual);
    }

    @Test
    public void is_not_weekend_and_has_enough_cigars_upperbounds(){
        CigarParty cigarParty = new CigarParty();

        boolean actual = cigarParty.haveParty(60, false);

        Assert.assertTrue(actual);
    }

    @Test
    public void is_not_weekend_and_has_just_enough_cigars(){
        CigarParty cigarParty = new CigarParty();

        boolean actual = cigarParty.haveParty(40, true);

        Assert.assertTrue(actual);
    }


}
