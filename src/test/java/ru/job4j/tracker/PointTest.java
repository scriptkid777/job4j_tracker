package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void when00to30then9() {
        int expected = 3;
        Point a = new Point(0,0);
        Point b = new Point(3,0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when10to20then9() {
        int expected = 1;
        Point a = new Point(1,0);
        Point b = new Point(2,0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

}