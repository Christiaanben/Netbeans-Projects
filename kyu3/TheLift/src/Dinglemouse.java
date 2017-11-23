
import java.util.ArrayList;

public class Dinglemouse {

    public static int[] theLift(final int[][] queues, final int capacity) {
        ArrayList<Integer> stop = new ArrayList<>();
        boolean direction = true; //True up, False down
        int floor = 0;

        while (!isEmpty(queues)) {
            break;
        }

        return new int[0];
    }

    private static boolean isEmpty(int[][] queues) {
        for (int i = 0; i < queues.length; i++) {
            if (queues[i].length!=0) {
                return false;
            }            
        }
        return true;
    }

}
