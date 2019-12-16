package agh.cs.proj1.test;

import agh.cs.proj1.main.Vector2d;
import org.junit.Assert;
import org.junit.Test;

public class Vector2dTest {
    @Test
    public void equalsTest(){
        Vector2d v = new Vector2d(1, 0);
        Vector2d u = new Vector2d(1, 0);
        Assert.assertTrue(v.equals(u));
        u = new Vector2d(1, 2);
        Assert.assertFalse(v.equals(u));
    }
    @Test
    public void toStringTest(){
        Vector2d v = new Vector2d(1, 1);
        Assert.assertEquals("failure - \"(1, 1)\" expected", "(1, 1)", v.toString());
        v = new Vector2d(0, 3);
        Assert.assertEquals("failure - \"(0, 3)\" expected", "(0, 3)", v.toString());
    }
    @Test
    public void precedesTest(){
        Vector2d v = new Vector2d(1, 1);
        Vector2d u = new Vector2d(2, 2);
        Assert.assertTrue(v.precedes(u));
        Assert.assertFalse(u.precedes(v));

        v = new Vector2d(3, 3);
        u = new Vector2d(0, 0);
        Assert.assertFalse(v.precedes(u));
        Assert.assertTrue(u.precedes(v));
    }
    @Test
    public void followsTest() {
        Vector2d v = new Vector2d(0, 1);
        Vector2d u = new Vector2d(3, 2);
        Assert.assertTrue(u.follows(v));
        Assert.assertFalse(v.follows(u));

        v = new Vector2d(3, 3);
        u = new Vector2d(0, 0);
        Assert.assertFalse(u.follows(v));
        Assert.assertTrue(v.follows(u));
    }
    @Test
    public void upperRightTest(){
        Vector2d v = new Vector2d(-1, 1);
        Vector2d u = new Vector2d(2, 2);
        Assert.assertTrue("failure - (2, 2) expected", (new Vector2d(2, 2)).equals(v.upperRight(u)));
        v = new Vector2d(3, 1);
        u = new Vector2d(2, 4);
        Assert.assertTrue("failure - (3, 4) expected", (new Vector2d(3, 4)).equals(v.upperRight(u)));
    }
    @Test
    public void lowerLeftTest(){
        Vector2d v = new Vector2d(2, 0);
        Vector2d u = new Vector2d(0, 1);
        Assert.assertTrue("failure - (0, 0) expected", (new Vector2d(0, 0)).equals(v.lowerLeft(u)));
        v = new Vector2d(3, 1);
        u = new Vector2d(2, 4);
        Assert.assertTrue("failure - (2, 1) expected", (new Vector2d(2, 1)).equals(v.lowerLeft(u)));
    }
    @Test
    public void addTest(){
        Vector2d v = new Vector2d(99, 2);
        Vector2d u = new Vector2d(1, 98);
        Assert.assertTrue("failure - (100, 100) expected", (new Vector2d(100, 100).equals(v.add(u))));
        v = new Vector2d(97, 4);
        u = new Vector2d(3, 96);
        Assert.assertTrue("failure - (100, 100) expected", (new Vector2d(100, 100).equals(v.add(u))));
    }
    @Test
    public void oppositeTest(){
        Vector2d v = new Vector2d(10, 10);
        Assert.assertTrue("failure - (-10, -10) expected", (new Vector2d(-10,-10)).equals(v.opposite()));
        v = new Vector2d(-99, 1);
        Assert.assertTrue("failure - (99, -1) expected", (new Vector2d(99,-1)).equals(v.opposite()));
    }
}