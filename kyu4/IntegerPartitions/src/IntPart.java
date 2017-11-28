import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class IntPart {
    public static TreeSet<Integer>[] memo;

    public static String part(int n) {
        memo=new TreeSet[n+1];
        ArrayList<Integer> list=new ArrayList<>(partProd(n));
        
        int range=list.get(list.size()-1)-1;
        
        double avg=0;
        for (Integer l : list) 
            avg+=l;
        avg/=list.size();
        
        double med=list.get(list.size()/2);
        if (list.size()%2==0) 
            med=(med+list.get(list.size()/2-1))/2.0;
        
        return String.format("Range: %d Average: %.2f Median: %.2f", range,avg,med);
    }
    
    public static TreeSet<Integer> partProd(int n){
        if (n<2) 
            return new TreeSet<>(Arrays.asList(1));
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            TreeSet<Integer> auxSet;
            if (memo[i]==null)
                auxSet=partProd(i);
            else
                auxSet=memo[i];
            for (Integer aux: auxSet)
                set.add((n-i)*aux);
        }
        memo[n]=set;
        return set;
    }
}
