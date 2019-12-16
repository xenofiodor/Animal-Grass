package agh.cs.proj1.test;

import agh.cs.proj1.main.*;
import org.junit.Assert;
import org.junit.Test;

import static agh.cs.proj1.main.OptionParser.parse;

public class AnimalTest {
    @Test
    public void moveTest(){
        IWorldMap map1 = new RectangularMap(4,4);
        Animal animal = new Animal(map1);
        String [] s = new String[] {"f", "f", "f", "l"};
        MoveDirection[] directions = parse(s);
        for (MoveDirection direction : directions) animal.move(direction);
        Assert.assertTrue(animal.getDirection().equals(MapDirection.WEST));
        Assert.assertTrue(animal.getPosition().equals(new Vector2d(2, 4)));

        IWorldMap map2 = new RectangularMap(4,4);
        animal = new Animal(map2);
        s = new String[] {"b", "b", "f", "b", "l", "o", "l", "f", "r", "f", "f", "f"};
        directions = parse(s);
        for (MoveDirection direction : directions) animal.move(direction);
        Assert.assertTrue(animal.getDirection().equals(MapDirection.WEST));
        Assert.assertTrue(animal.getPosition().equals(new Vector2d(0, 0)));
    }
}
