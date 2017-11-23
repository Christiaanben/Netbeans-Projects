import java.util.ArrayList;
import java.util.Arrays;

public class Dinglemouse {
    public static int[] theLift(final int[][] queues, final int capacity) {
        //Initialize lift
        ArrayList<Integer> stop = new ArrayList<>();
        boolean direction = true; //True up, False down
        int floor = 0;
        stop.add(floor);
        ArrayList<Integer> lift=new ArrayList<>();
        
        while (!isEmpty(queues) || !lift.isEmpty()) {
            //Remove people that want to be at this floor
            if (lift.contains(floor)) {
                stop.add(floor);
                lift.removeAll(new ArrayList<>(Arrays.asList(floor)));
            }
            
            //Add people that want to go in direction (if there's space)
            ArrayList<Integer> newFloor=new ArrayList<>();
            for (int i = 0; i < queues[floor].length; i++) {
                int target = queues[floor][i];
                if (lift.size()<capacity && (target>floor)==direction) {
                    if (stop.get(stop.size()-1)!=floor)
                        stop.add(floor);
                    lift.add(target);
                }else
                    newFloor.add(target);
            }
            queues[floor]=newFloor.stream().mapToInt(i->i).toArray();
            
            //If at end turn around
            if (direction && floor==queues.length-1)
                direction=false;
            else if (!direction && floor==0)
                direction=true;
            
            //Go to next floor
            floor = (direction)? floor+1 : floor-1;
        }
        
        //End at ground floor
        floor=0;
        if (stop.get(stop.size()-1)!=floor)
            stop.add(floor);
        
        //Create array from list
        return stop.stream().mapToInt(i->i).toArray();
        
    }

    private static boolean isEmpty(int[][] queues) {
        for (int[] queue : queues)
            if (queue.length != 0)
                return false;
        return true;
    }

}
