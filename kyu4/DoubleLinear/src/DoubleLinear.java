//The function creates a sorted set
//It adds the 2x+1 and 3x+1 values recursively to the set
//The intger, val, easily overflows when working with large values, so I just added the empty return
//The counter says how "deep" each recursive function needs to go
//The counter is initialised with a value relative to log of input n
import java.util.*;

class DoubleLinear {
    private static int counter;
    private static SortedSet<Integer> set;
    
    public static int dblLinear (int n)  {
        counter=(int) (Math.log(n)*1.8);
        set=new TreeSet<>();
        recAdd(1);
        Iterator<Integer> it=set.iterator();
        for (int i = 0; i < n; i++)
            it.next();
        return it.next();
    }
    
    public static void recAdd(int val){
        if (val<0)
            return;
        set.add(val);
        if (counter>0) {
            counter--;
            recAdd(2*val+1);
            recAdd(3*val+1);
            counter++;
        }
    }
}