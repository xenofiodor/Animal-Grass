package agh.cs.proj1.main;

import java.util.*;
import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap implements IPositionChangeObserver{
    private int n;
    protected Map<Vector2d,Grass> grass = new HashMap<>();
    private MapBoundary mapBoundary = new MapBoundary();

    public GrassField(int n){
        super((int)sqrt(n*10), (int)sqrt(n*10));
        this.n = n;
        this.fieldInit();
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object obj = super.objectAt(position);
        if (obj != null)
            return obj;
        else{
            for (Map.Entry<Vector2d, Grass> vector2dGrassEntry : this.grass.entrySet()) {
                Map.Entry mapElement = vector2dGrassEntry;
                if (mapElement.getKey().equals(position))
                    return mapElement.getValue();
            }
        }
        return null;
    }

    private Vector2d randomPosition(){
        int x = (int)(Math.random() * this.n);
        int y = (int)(Math.random() * this.n);
        return new Vector2d(x, y);
    }


    private void fieldInit(){
        for(int i = 0; i < this.n; i++){
            Grass grass;
            Vector2d position;
            do{
                position = this.randomPosition();
            }
            while(this.isOccupied(position));
            grass = new Grass(this, position);
            this.place(grass);
        }
    }

    private boolean place(Grass grass){
        Vector2d position = grass.getPosition();
        if(this.objectAt(position) == null){
            this.grass.put(position, grass);
            this.mapBoundary.place(grass);
            return true;
        }
        else throw new IllegalArgumentException("position " + position + " is already occupied.");
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if(this.canMoveTo(position)){
            animal.addObserver(this);
            animal.addObserver(this.mapBoundary);
            this.animals.put(position, animal);
            this.mapBoundary.place(animal);
            this.lowerLeft = this.mapBoundary.lowerLeft();
            this.upperRight = this.mapBoundary.upperRight();
            return true;
        }
        else throw new IllegalArgumentException("position " +
                position+ " is already occupied.");
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!(this.objectAt(position) instanceof Animal));
    }

    @Override
    public void run(MoveDirection[] directions) {
        super.run(directions);
        this.lowerLeft = this.mapBoundary.lowerLeft();
        this.upperRight = this.mapBoundary.upperRight();
    }
}
