import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class IpValidatorTest {

    @Test
    public void it_should_be_valid() {
        assertTrue(IpValidator.isValidIp("1.2.3.4"));
    }

    @Test
    public void it_should_be_invalid() {
        assertFalse(IpValidator.isValidIp("1.2.3.4.5"));
    }
}