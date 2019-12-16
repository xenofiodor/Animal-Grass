package agh.cs.proj1.test;

import agh.cs.proj1.main.MoveDirection;
import org.junit.Assert;
import org.junit.Test;

import static agh.cs.proj1.main.OptionParser.parse;


public class OptionParserTest {
    @Test
    public void parseTest(){
        String [] s = new String[] {"b", "b", "backward", "b", "left", "l", "forward", "right", "f", "f", "f"};
        MoveDirection[] directions1 = parse(s);
        MoveDirection[] directions2 = new MoveDirection[] {MoveDirection.BACKWARD, MoveDirection.BACKWARD,
                MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.LEFT,  MoveDirection.LEFT,
                MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD};
        Assert.assertArrayEquals(directions1, directions2);

        s = new String[] {"f", "f", "l", "xc", "left", "forward", "backward", "r", "r"};
        directions1 = parse(s);
        directions2 = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT,
                MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT,
                MoveDirection.RIGHT};
        Assert.assertArrayEquals(directions1, directions2);
    }

}
