import java.util.ArrayList;

public class SortedGroup<E extends Comparable>{
    private ArrayList<E> sortedList;

    public SortedGroup(){
        this.sortedList = new ArrayList<E>();
    }

    public void add(Comparable<E> item){
        Boolean isAdded = false;
        for (int i =0; i <= this.sortedList.size(); i ++){
            if (sortedList.get(i).compareTo(item) <= 0){
                this.sortedList.add(i, (E) item);
                isAdded = true;
                break;
            }
        }
        if (!isAdded)
            this.sortedList.add((E) item);
    }

    public int remove(Comparable<E> item){
        int counter = 0;
        for (int i =0; i <= this.sortedList.size(); i ++){
            if (sortedList.get(i).compareTo(item) == 0){
                this.sortedList.remove(i);
                counter++;
            }
            if (sortedList.get(i).compareTo(item) > 0){
                break;
            }
        }
        return counter;
    }
}
