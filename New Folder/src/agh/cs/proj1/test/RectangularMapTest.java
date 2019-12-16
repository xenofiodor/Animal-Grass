package agh.cs.proj1.test;

import agh.cs.proj1.main.*;
import org.junit.Assert;
import org.junit.Test;

import static agh.cs.proj1.main.OptionParser.parse;


public class RectangularMapTest {
    @Test
    public void canMoveToTest(){
        IWorldMap map = new RectangularMap(5, 5);
        Animal animal1 = new Animal(map, new Vector2d(2, 2));
        Animal animal2 = new Animal(map, new Vector2d(2, 3));
        map.place(animal1);
        Assert.assertFalse(map.canMoveTo(animal1.getPosition()));
        Assert.assertTrue(map.canMoveTo(animal2.getPosition()));
        Assert.assertFalse(map.canMoveTo(new Vector2d(7, 6)));
    }

    @Test
    public void placeTest(){
        IWorldMap map = new RectangularMap(5, 5);
        Animal animal1 = new Animal(map, new Vector2d(2, 2));
        Animal animal2 = new Animal(map, new Vector2d(2, 3));
        map.place(animal1);
        Assert.assertFalse(map.place(animal1));
        Assert.assertTrue(map.place(animal2));
    }

    @Test
    public void runTest(){
        String [] s = new String[] {"b", "b", "f", "b", "l", "o", "l", "f", "r", "f", "f", "f"};
        MoveDirection[] directions = parse(s);
        IWorldMap map = new RectangularMap(5, 5);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        Assert.assertTrue(map.isOccupied(new Vector2d(0,2)));
        Assert.assertTrue(map.isOccupied(new Vector2d(3,3)));

        s = new String[] {"f","b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        directions = parse(s);
        map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        Assert.assertTrue(map.isOccupied(new Vector2d(2,0)));
        Assert.assertTrue(map.isOccupied(new Vector2d(3,5)));
    }

    @Test
    public void isOccupiedTest(){
        IWorldMap map = new RectangularMap(7, 7);
        map.place(new Animal(map, new Vector2d(2,2)));
        map.place(new Animal(map, new Vector2d(8, 9)));
        Assert.assertTrue(map.isOccupied(new Vector2d(2, 2)));
        Assert.assertFalse(map.isOccupied(new Vector2d(4, 5)));
    }
}
