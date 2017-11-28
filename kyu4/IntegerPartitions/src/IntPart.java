
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;


public class IntPart {

    public static String part(int n) {
        SortedSet<Integer> set=partProd(n);
        ArrayList<Integer> list=new ArrayList<>();
        list.addAll(set);
        
        int range=set.last()-1;
        
        double avg=0;
        for (Integer l : list) {
            avg+=l;
        }
        avg/=list.size();
        
        double med;
        if (list.size()%2==0) {
            med=(list.get(list.size()/2)+list.get(list.size()/2-1))/2;
        }else{
            med=list.get(list.size()/2);
        }
        System.out.println(set);
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
        for (int i = 0; i < n; i++) {
            TreeSet<Integer> auxSet=partProd(i);
            for (Integer aux: auxSet) {
                set.add((n-i)*aux);
            }
        }
        return set;
    }
}
