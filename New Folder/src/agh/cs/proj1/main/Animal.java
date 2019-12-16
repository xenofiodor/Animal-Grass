package agh.cs.proj1.main;
import java.util.LinkedList;
import java.util.Objects;


public class Animal extends AbstractWorldMapElement{
    private MapDirection  direction;
    private LinkedList<IPositionChangeObserver> observers = new LinkedList<IPositionChangeObserver>();
    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        super(map, initialPosition);
        this.direction = MapDirection.NORTH;
    }

    public Animal(IWorldMap map){
        this.direction = MapDirection.NORTH;
        super.position = new Vector2d(2, 2);
        this.map = map;
    }

    public IWorldMap getMap(){
        return this.map;
    }
    public MapDirection getDirection(){
        return this.direction;
    }
//    public LinkedList<IPositionChangeObserver> getObservers() {return this.observers;}
//    public void setPosition(Vector2d position){this.position = position;}
    public String toLongString(){
        return String.format("%s %s", this.position.toString(),  this.direction.toString());
    }
    public String toString(){
        return this.direction.toShortString();
    }
    public Animal move(MoveDirection direction){
        switch (direction) {
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case FORWARD:
                Vector2d newPosition1 = this.position.add(Objects.requireNonNull(this.direction.toUnitVector()));
                if (this.map.canMoveTo(newPosition1)) {
                    this.positionChanged(this.position, newPosition1);
                    this.position = newPosition1;
                }
                break;
            case BACKWARD:
                Vector2d newPosition2 = this.position.subtract(Objects.requireNonNull(this.direction.toUnitVector()));
                if (this.map.canMoveTo(newPosition2)) {
                    this.positionChanged(this.position, newPosition2);
                    this.position = newPosition2;
                }
                break;
        }
        return this;
    }

    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer : this.observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
//
//    public void copyAnimal(Animal animal){
//        this.direction = animal.getDirection();
//        this.map = animal.getMap();
//        this.observers = animal.getObservers();
//        this.position = animal.getPosition();
//    }

}