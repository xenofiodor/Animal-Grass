package agh.cs.proj1.main;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;
    public String toString(){
        switch (this) {
            case EAST:
                return "East";
            case WEST:
                return "West";
            case SOUTH:
                return "South";
            case NORTH:
                return "North";
        }
        return null;
    }
    public String toShortString(){
        switch (this) {
            case EAST:
                return ">";
            case WEST:
                return "<";
            case SOUTH:
                return "∨";
            case NORTH:
                return "∧";
        }
        return null;
    }
    public MapDirection next(){
        switch (this){
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
            case SOUTH:
                return WEST;
            case NORTH:
                return EAST;
        }
        return null;
    }
    public MapDirection previous(){
        switch (this){
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
            case SOUTH:
                return EAST;
            case NORTH:
                return WEST;
        }
        return null;
    }
    public Vector2d toUnitVector(){
        switch (this){
            case NORTH:
                return new Vector2d(0,1);
            case EAST:
                return new Vector2d(1,0);
            case SOUTH:
                return new Vector2d(0, -1);
            case WEST:
                return new Vector2d(-1, 0);
            default:
                return null;
        }
    }
}