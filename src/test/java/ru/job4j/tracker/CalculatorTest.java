package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test

    public void when4number7(){
        double expected = 7.0;
        double actual;
        Calculator out = new Calculator();
        actual = out.max(1,2,4,7);
        Assert.assertEquals(expected, actual, 0.01);
    }
}