import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class IpValidatorTest {

    @Test
    public void test() {
        assertFalse("empty string should not be valid", IpValidator.isValidIp(""));
        assertFalse("letters should not be valid", IpValidator.isValidIp("abc.def.ghi.jkl"));
        assertFalse("numbers > 255 should not be valid", IpValidator.isValidIp("123.456.789.0"));
        assertFalse("less than four numbers should not be valid", IpValidator.isValidIp("12.34.56"));
        assertFalse("numbers > 255 should not be valid", IpValidator.isValidIp("256.1.2.3"));
        assertFalse("more than four numbers should not be valid", IpValidator.isValidIp("1.2.3.4.5"));
        assertFalse("numbers not separated by dots should not be valid", IpValidator.isValidIp("123,45,67,89"));
        assertFalse("numbers containing white space should not be valid", IpValidator.isValidIp(" 1.2.3.4"));
        assertFalse("numbers containing leading zero's are not valid", IpValidator.isValidIp("000.12.12.034"));

        for (String address : asList(
                "0.0.0.0", "123.45.67.89", "255.255.255.255", "1.2.3.4",
                "31.41.59.26", "53.58.97.93", "238.46.26.43", "38.32.79.50",
                "28.84.197.169", "39.93.75.105", "82.0.97.49", "44.59.230.78",
                "164.0.62.86", "208.99.86.28", "0.34.82.53", "42.117.0.67",
                "98.214.80.86", "51.32.82.30", "66.47.0.93", "84.46.0.95",
                "50.58.22.31", "72.53.59.40", "81.28.48.1")) {
            assertTrue(address + " should be valid", IpValidator.isValidIp(address));
        }
    }
}