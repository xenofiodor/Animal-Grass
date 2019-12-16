package agh.cs.proj1.main;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    private SortedSet<AbstractWorldMapElement> objectsByX =
            new TreeSet<AbstractWorldMapElement>(new Comparator<AbstractWorldMapElement>() {
                @Override
                public int compare(AbstractWorldMapElement t1, AbstractWorldMapElement t2) {
                    Vector2d pos1 = t1.getPosition();
                    Vector2d pos2 = t2.getPosition();
                    if (pos1.x > pos2.x) return 1;
                    if (pos1.x < pos2.x) return -1;
                    if (pos1.y > pos2.y) return 1;
                    if (pos1.y < pos2.y) return -1;
                    if (t1 instanceof Animal) return 1;
                    if (t2 instanceof Animal) return -1;
                    return 0;
                }
            });
    private SortedSet<AbstractWorldMapElement> objectsByY =
            new TreeSet<AbstractWorldMapElement>(new Comparator<AbstractWorldMapElement>() {
                @Override
                public int compare(AbstractWorldMapElement t1, AbstractWorldMapElement t2) {
                    Vector2d pos1 = t1.getPosition();
                    Vector2d pos2 = t2.getPosition();
                    if (pos1.y > pos2.y) return 1;
                    if (pos1.y < pos2.y) return -1;
                    if (pos1.x > pos2.x) return 1;
                    if (pos1.x < pos2.x) return -1;
                    if (t1 instanceof Animal) return 1;
                    if (t2 instanceof Animal) return -1;
                    return 0;
                }
            });

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
    }

    public void place(AbstractWorldMapElement object){
        this.objectsByX.add(object);
        this.objectsByY.add(object);
    }

    public Vector2d lowerLeft(){
        return new Vector2d(this.objectsByX.first().getPosition().x, this.objectsByY.first().getPosition().y);
    }

    public Vector2d upperRight(){
        return new Vector2d(this.objectsByX.last().getPosition().x, this.objectsByY.last().getPosition().y);
    }
}
