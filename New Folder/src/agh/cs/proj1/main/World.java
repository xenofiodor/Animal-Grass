package agh.cs.proj1.main;
import static agh.cs.proj1.main.OptionParser.parse;

public class World {
    public static void main(String[] args){
        String[] s = new String[]{"b", "r", "b", "b", "b", "b", "b", "b", "b"};
        MoveDirection[] directions = parse(s);
        IWorldMap map = new GrassField(3) {};
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(4, 0)));
        System.out.println(map.toString());
        map.run(directions);
        System.out.println(map.toString());
    }

    //czemu ignoruje trawę?
}