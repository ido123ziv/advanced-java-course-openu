public class Reduce {
    public static <E extends Comparable<E>> SortedGroup<E> reduce(SortedGroup<E> sGroup, E x){
        SortedGroup<E> newGroup = new SortedGroup<E>();
        int i = 0,size = sGroup.size();
        while(i<size){
            if (sGroup.get(i).compareTo(x)>0)
                break;
            i++;
        }
        while(i<size){
            newGroup.add(sGroup.get(i));
            i++;
        }
        return newGroup;
    }

}
