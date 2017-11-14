public class IpValidator {

    public static boolean isValidIp(String str) {
        String[] stringArr=str.split("\\.");
        if (stringArr.length!=4)
            return false;
        for (String s : stringArr) {
            try {
                if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255)
                    return false;
            } catch (NumberFormatException numberFormatException) {
                return false;
            }
            if ((Integer.parseInt(s)+"").length() != s.length())
                return false;
        }
        return true;
    }
}