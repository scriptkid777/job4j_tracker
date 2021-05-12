package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test

    public void when4number11(){
        double expected = 11;
        double out = Calculator.add(1,2,3,5);
        Assert.assertEquals(expected, out, 0.01);
    }
}