package agh.cs.proj1.main;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Vector2d lowerLeft = new Vector2d(0,0);
    protected Vector2d upperRight;
    protected Map<Vector2d,Animal> animals = new HashMap<>();
    protected MapVisualizer visualisation;
    protected MapBoundary mapBoundary = new MapBoundary();

    AbstractWorldMap(int width, int height){
        this.upperRight = new Vector2d(width, height);
        this.visualisation = new MapVisualizer(this);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, animal);
    }


    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if(this.canMoveTo(position)){
            animal.addObserver(this);
            animal.addObserver(this.mapBoundary);
            this.animals.put(position, animal);
            this.mapBoundary.place(animal);
            return true;
        }
        else if(this.objectAt(position) != null) throw new IllegalArgumentException("position " +
                position + " is already occupied.");
        else throw new IllegalArgumentException("position " + position + " is out of the map.");
    }

    @Override
    public void run(MoveDirection[] directions) {
        LinkedList<Animal> numberedAnimals = new LinkedList<Animal>();
        for (Map.Entry<Vector2d, Animal> vector2dAnimalEntry : this.animals.entrySet()) {
            Animal tempAnimal = (Animal) ((Map.Entry) vector2dAnimalEntry).getValue();
            numberedAnimals.add(tempAnimal);
        }

        ListIterator animal = numberedAnimals.listIterator(0);
        for (MoveDirection direction : directions) {
            if (!animal.hasNext())
                animal = numberedAnimals.listIterator(0);

            Animal tempAnimal = (Animal)animal.next();
            tempAnimal.move(direction);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (this.objectAt(position)!=null);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!(this.objectAt(position) instanceof Animal));
    }

    public String toString(){
        return (this.visualisation.draw(this.lowerLeft, this.upperRight));
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Map.Entry<Vector2d, Animal> vector2dAnimalEntry : this.animals.entrySet()) {
            Map.Entry mapElement = vector2dAnimalEntry;
            if (mapElement.getKey().equals(position))
                return mapElement.getValue();
        }
        return null;
    }

}
