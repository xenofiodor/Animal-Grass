package agh.cs.proj1.test;

import agh.cs.proj1.main.MapDirection;
import org.junit.Assert;
import org.junit.Test;

public class MapDirectionTest {
    @Test
    public void nextTest(){
        Assert.assertEquals("failure - EAST expected", MapDirection.EAST, MapDirection.NORTH.next());
        Assert.assertEquals("failure - SOUTH expected", MapDirection.SOUTH, MapDirection.EAST.next());
        Assert.assertEquals("failure - WEST expected", MapDirection.WEST, MapDirection.SOUTH.next());
        Assert.assertEquals("failure - NORTH expected", MapDirection.NORTH, MapDirection.WEST.next());
    }

    @Test
    public void previousTest(){
        Assert.assertEquals("failure - WEST expected", MapDirection.WEST, MapDirection.NORTH.previous());
        Assert.assertEquals("failure - NORTH expected", MapDirection.NORTH, MapDirection.EAST.previous());
        Assert.assertEquals("failure - EAST expected", MapDirection.EAST, MapDirection.SOUTH.previous());
        Assert.assertEquals("failure - SOUTH expected", MapDirection.SOUTH, MapDirection.WEST.previous());
    }
}
