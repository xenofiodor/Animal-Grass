package agh.cs.proj1.main;
import java.util.Comparator;

public class MyComparator implements Comparator<AbstractWorldMapElement>{
    private char compareBy;
    MyComparator (char c){
        if (c != 'x' && c != 'y')
            throw new IllegalArgumentException("\'x\' or \'y\' expected.");
        this.compareBy = c;
    }

    @Override
    public int compare(AbstractWorldMapElement abstractWorldMapElement, AbstractWorldMapElement t1) {
        Vector2d pos1 = abstractWorldMapElement.getPosition();
        Vector2d pos2 = t1.getPosition();
        switch (this.compareBy){
            case 'x':
                if (pos1.x > pos2.x) return 1;
                if (pos1.x < pos2.x) return -1;
                if (pos1.y > pos2.y) return 1;
                if (pos1.y < pos2.y) return -1;
                if (t1 instanceof Animal) return 1;
                if (abstractWorldMapElement instanceof Animal) return -1;
                return 0;
            case 'y':
                if (pos1.y > pos2.y) return 1;
                if (pos1.y < pos2.y) return -1;
                if (pos1.x > pos2.x) return 1;
                if (pos1.x < pos2.x) return -1;
                if (t1 instanceof Animal) return 1;
                if (abstractWorldMapElement instanceof Animal) return -1;
                return 0;
        }
        return 0;
    }
}
