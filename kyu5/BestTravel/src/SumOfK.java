//Creates a for loop iterating through all the numbers recursively
//for every town to visit
//Add all those travelTimes and see if they are below the limit and bigger than the previous
import java.util.List;
import java.util.Stack;

public class SumOfK {
    public static Stack<Integer> stack;
    public static Integer biggest;
    public static List<Integer> list;
    public static int time;

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        biggest = 0;
        stack = new Stack<>();
        list=ls;
        time=t;
        
        chooseBestSum(k, 0);
        
        if (biggest == 0)
            return null;
        return biggest;
    }
    
    public static void chooseBestSum(int k, int start) {
        if (k == 0) {
            int distance = 0;
            distance = stack.stream().map((index) -> list.get(index)).reduce(distance, Integer::sum);
            if (distance <= time)
                biggest = Math.max(biggest, distance);
        } else {
            for (int i = start; i < list.size(); i++) {
                stack.push(i);
                chooseBestSum(k - 1, i + 1);
                stack.pop();
            }
        }
    }
}
