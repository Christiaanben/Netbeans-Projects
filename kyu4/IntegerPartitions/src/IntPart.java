
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;


public class IntPart {

    public static String part(int n) {
        SortedSet<Integer> set=partProd(n);
        int range=set.last()-1;
        double avg=0;
        double med=0;
        String str=String.format("Range: %d Average: %.2f Median: %.2f", range,avg,med);
        System.out.println(str);
        return str;
    }
    
    public static TreeSet<Integer> partProd(int n){
        if (n<2) 
            return new TreeSet<>(Arrays.asList(1));
        if (n==2)
            return new TreeSet<>(Arrays.asList(2,1));
        if (n==3)
            return new TreeSet<>(Arrays.asList(3,2,1));
        if (n==4)
            return new TreeSet<>(Arrays.asList(4,3,2,1));
        TreeSet<Integer> set = new TreeSet<>();
        set.add(n--);
        set.add((n-1)*1);
        set.addAll(Arrays.asList((n-2)*2,(n-2)*1*1));
        return set;
    }
}
