import java.util.ArrayList;
import java.util.Iterator;


public class SortedGroup<E extends Comparable<E>> extends ArrayList<E>{

    /**
     * Constructor for new collection type
     */
    public SortedGroup(){
        super();
    }

    /**
     * sorted add to the collection
     * @param item element whose presence in this collection is to be ensured
     * @return if adding was successful
     */
    public boolean add(E item){
        int saver =0;
        for (int i =0; i < this.size(); i ++){
            if (this.get(i).compareTo(item) > 0){
                saver = i;
                break;
            }
        }
        this.add(saver, item);
        return true;
    }

    /**
     * sorted remove of items
     * @param item -> which item to remove
     * @return -> how many items removed
     */
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

    /**
     * Iterator for this collection
     * @return -> iterator object
     */
    public Iterator<E> iterator(){
        return this.iterator();
    }

    /**
     * pretty print of the collection
     * @return -> string representing the collection
     */
    @Override
    public String toString() {
        String s = "[ ";
        for (int i=0;i<this.size()-1;i++){
            s += this.get(i).toString() +",\n";
        }
        if (this.size() > 0){
            s += this.get(this.size() - 1).toString() +"]";
        }
        else {
            s+= " ]";
        }
        return s;
    }
}
