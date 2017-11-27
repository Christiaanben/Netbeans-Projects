import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfKTest {
 
    @Test
    public void BasicTests1() {
        System.out.println("****** Basic Tests small numbers******");
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        int n = SumOfK.chooseBestSum(163, 3, ts);
        assertEquals(163, n);
    }
    
    @Test
    public void BasicTests2() {
        List<Integer> ts = new ArrayList<>(Arrays.asList(50));
        Integer m = SumOfK.chooseBestSum(163, 3, ts);
        assertEquals(null, m);
    }
    
    @Test
    public void BasicTests3() {
        List<Integer> ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        int n = SumOfK.chooseBestSum(230, 3, ts);
        assertEquals(228, n);
    }
}
