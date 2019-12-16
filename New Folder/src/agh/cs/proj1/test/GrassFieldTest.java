package agh.cs.proj1.test;

import agh.cs.proj1.main.*;
import org.junit.Assert;
import org.junit.Test;

import static agh.cs.proj1.main.OptionParser.parse;


public class GrassFieldTest {
    @Test
    public void canMoveToTest(){
        IWorldMap map = new GrassField(4);
        Animal animal1 = new Animal(map, new Vector2d(2, 2));
        Animal animal2 = new Animal(map, new Vector2d(2, 3));
        map.place(animal1);
        Assert.assertFalse(map.canMoveTo(animal1.getPosition()));
        Assert.assertTrue(map.canMoveTo(animal2.getPosition()));
    }

    @Test
    public void placeTest(){
        IWorldMap map = new GrassField(4);
        Animal animal1 = new Animal(map, new Vector2d(2, 2));
        Animal animal2 = new Animal(map, new Vector2d(2, 3));
        map.place(animal1);
        Assert.assertFalse(map.place(animal1));
        Assert.assertTrue(map.place(animal2));
    }

    @Test
    public void runTest(){
        String [] s = new String[] {"b", "b", "f", "b", "l", "l", "f", "r", "f", "f", "f"};
        MoveDirection[] directions = parse(s);
        IWorldMap map = new GrassField(3);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        Assert.assertTrue(map.isOccupied(new Vector2d(-1,2)));
        Assert.assertTrue(map.isOccupied(new Vector2d(3,3)));

        s = new String[] {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f","f", "f", "f", "f", "f"};
        directions = parse(s);
        map = new GrassField(3);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        Assert.assertTrue(map.isOccupied(new Vector2d(2,-3)));
        Assert.assertTrue(map.isOccupied(new Vector2d(3,9)));
    }

    @Test
    public void isOccupiedTest(){
        IWorldMap map = new GrassField(4);
        map.place(new Animal(map, new Vector2d(2,2)));
        map.place(new Animal(map, new Vector2d(8, 9)));
        Assert.assertTrue(map.isOccupied(new Vector2d(2, 2)));
        Assert.assertFalse(map.isOccupied(new Vector2d(4, 5)));
    }

}
