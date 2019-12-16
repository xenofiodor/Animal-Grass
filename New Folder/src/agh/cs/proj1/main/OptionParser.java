package agh.cs.proj1.main;
import java.util.LinkedList;
import java.util.List;


public class OptionParser {
    public static MoveDirection[] parse(String[] s){
        List<MoveDirection> firstDirections = new LinkedList<>();
        for (String value : s) {
            switch (value) {
                case "f":
                case "forward":
                    firstDirections.add(MoveDirection.FORWARD);
                    break;
                case "r":
                case "right":
                    firstDirections.add(MoveDirection.RIGHT);
                    break;
                case "b":
                case "backward":
                    firstDirections.add(MoveDirection.BACKWARD);
                    break;
                case "l":
                case "left":
                    firstDirections.add(MoveDirection.LEFT);
                    break;
                default:
                    throw new IllegalArgumentException("\"" + value + "\" is not legal move specification");
            }
        }
        int size = firstDirections.size();
        MoveDirection [] directions = new MoveDirection[size];
        for (int i = 0; i < size; i++){
            directions[i] = firstDirections.get(i);
        }
        return directions;
    }

    // przepisać z tablicą
}