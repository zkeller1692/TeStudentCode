package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.verification.InOrderWrapper;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {

    @Test
    public void return_correct_amount_when_a_word_is_repeated_test() {

        WordCount wordCount = new WordCount();

        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);

        Map actual = wordCount.getCount(new String[]{"ba", "ba", "black", "sheep"});

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void no_values_passed_in_test() {

        WordCount wordCount = new WordCount();

        HashMap<String, Integer> expected = new HashMap<>();


        Map actual = wordCount.getCount(new String[0]);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void one_of_each_word_passed_in_test() {

        WordCount wordCount = new WordCount();

        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("ba", 1);
        expected.put("black", 1);
        expected.put("sheep", 1);

        Map actual = wordCount.getCount(new String[]{"ba", "black", "sheep"});

        Assert.assertEquals(expected, actual);
    }
}
