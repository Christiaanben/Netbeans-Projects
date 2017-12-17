import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KataTest {
    
    @Test
    public void basicTest1() {
         assertEquals(12, Kata.nextSmaller(21));
    }      
    
    @Test
    public void basicTest2() {
         assertEquals(790, Kata.nextSmaller(907));
    }   
    
    @Test
    public void basicTest3() {
         assertEquals(513, Kata.nextSmaller(531));
    }   
    
    @Test
    public void basicTest4() {
         assertEquals(-1, Kata.nextSmaller(1027));
    }   
    
    @Test
    public void basicTest5() {
         assertEquals(414, Kata.nextSmaller(441));
    }   
    
    @Test
    public void basicTest6() {
         assertEquals(123456789, Kata.nextSmaller(123456798));
    }   
}