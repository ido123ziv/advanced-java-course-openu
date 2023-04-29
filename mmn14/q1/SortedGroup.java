import java.util.ArrayList;
import java.util.Iterator;

public class SortedGroup<E extends Comparable<E>> extends ArrayList<E>{

    public SortedGroup(){
        super();
    }

    public boolean add(E item){
        Boolean isAdded = false;
        for (int i =0; i <= this.size(); i ++){
            if (this.get(i).compareTo(item) <= 0){
                this.add(i, item);
                isAdded = true;
                break;
            }
        }
        if (!isAdded)
            this.add(item);
        return true;
    }
    public int remove(E item){
        int counter = 0;
        for (int i =0; i <= this.size(); i ++){
            if (this.get(i).compareTo(item) == 0){
                this.remove(i);
                counter++;
            }
            if (this.get(i).compareTo(item) > 0){
                break;
            }
        }
        return counter;
    }
    public Iterator<E> iterator(){
        return this.iterator();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (E item: this){
            s.append(item.toString());
        }
        return s.toString();

    }
}
