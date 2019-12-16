package agh.cs.proj1.main;

public class RectangularMap extends AbstractWorldMap implements IPositionChangeObserver{
    public RectangularMap(int width, int height) {
        super(width, height);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, animal);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!(this.objectAt(position) instanceof Animal)
                && position.follows(this.lowerLeft)
                && position.precedes(this.upperRight));
    }
}


