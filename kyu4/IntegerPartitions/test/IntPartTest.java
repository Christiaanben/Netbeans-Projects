import static org.junit.Assert.*;
import org.junit.Test;

public class IntPartTest {
	
  @Test
  public void Numbers1() {
	  assertEquals("Range: 1 Average: 1.50 Median: 1.50", IntPart.part(2));
  }	
  @Test
  public void Numbers2() {
	  assertEquals("Range: 2 Average: 2.00 Median: 2.00", IntPart.part(3));
  }	
  @Test
  public void Numbers3() {
	  assertEquals("Range: 3 Average: 2.50 Median: 2.50", IntPart.part(4));
  }	
  @Test
  public void Numbers4() {
	  assertEquals("Range: 5 Average: 3.50 Median: 3.50", IntPart.part(5));
  }	
  @Test
  public void Numbers5() {
	  assertEquals("Range: 8 Average: 4.75 Median: 4.50", IntPart.part(6));
  }
  @Test
  public void Numbers11() {
	  assertEquals("Range: 53 Average: 19.69 Median: 16.00", IntPart.part(11));
  }
  @Test
  public void Numbers21() {
	  assertEquals("Range: 2186 Average: 358.10 Median: 197.00", IntPart.part(21));
  }
  @Test
  public void Numbers26() {
	  assertEquals("Range: 13121 Average: 1500.90 Median: 625.00", IntPart.part(26));
  }
}