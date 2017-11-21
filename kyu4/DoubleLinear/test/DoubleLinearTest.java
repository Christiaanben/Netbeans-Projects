import static org.junit.Assert.*;
import org.junit.Test;


public class DoubleLinearTest {

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }
 
    
    
    @Test
    public void test1() {
        System.out.println("Fixed Tests dblLinear");
        testing(DoubleLinear.dblLinear(10), 22);
    }
    
    @Test
    public void test2() {
        testing(DoubleLinear.dblLinear(20), 57);
    }
    
    @Test
    public void test3() {
        testing(DoubleLinear.dblLinear(30), 91); 
    }
    
    @Test
    public void test4() {
        testing(DoubleLinear.dblLinear(50), 175);  
    }
    
    @Test
    public void test5() {
        testing(DoubleLinear.dblLinear(1000), 8488);  
    }
    
    @Test
    public void test6() {
        testing(DoubleLinear.dblLinear(13536), 227799);  
    }
}
