import java.util.Arrays;

public class Kata {
    public static long nextSmaller(long n) {
        char[] digits = String.valueOf(n).toCharArray();
        for (int i = digits.length-1; i > 0; i--) {
            //Find the last occarence of where the left > right
            if (digits[i-1] > digits[i]) {
                //find the largest number, smaller than left
                int largestIndex=i;
                for (int j = i; j < digits.length; j++)
                    if (digits[j]>digits[largestIndex] && digits[j]<digits[i-1])
                        largestIndex=j;
                //switch that number and the left
                char temp = digits[i-1];
                digits[i-1]=digits[largestIndex];
                digits[largestIndex]=temp;
                //Return -1 if it starts with zero
                if (digits[0]=='0')
                    return -1;
                //sort from i in reverseOrder
                char[] sub=Arrays.copyOfRange(digits, i, digits.length);
                Arrays.sort(sub);
                String answer=new String(digits, 0, i);
                for (int j = sub.length-1; j >= 0; j--)
                    answer+=sub[j];
                return Long.parseLong(answer);
            }
        }
        return -1;
    }
}