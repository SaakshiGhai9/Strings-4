// Time Complexity O(n)
// Space complexity O(1)
public class ATOI {
    public static int  stringToInt( String s){
        int i = 0, n = s.length(), sign = 1, result =0;

        // 1. check for leading whitespace, if exists then ignore
        while( i < n && s.charAt(i) == ' '){
            i++;
        }
        // 2. check for sign =ve or - ve

        if( i < n && (s.charAt(i) == '+' || s.charAt(i) =='-')) {
            sign = (s.charAt(i) == '+') ? 1 : -1;
            i++;
        }

        // convert string to digits
        while( i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) -'0';
            // handle overflows

            if(result > (Integer.MAX_VALUE - digit) / 10){
                return (sign == 1)? Integer.MAX_VALUE: Integer.MIN_VALUE;

            }
            result = result * 10 + digit;
            i++;


        }
        return result * sign;

    }

    public static void main (String [] args){
        System.out.println(stringToInt("42")); // 42
        System.out.println(stringToInt("   -42")); // -42
        System.out.println(stringToInt("4193 with words")); // 4193
        System.out.println(stringToInt("words and 987")); // 0
        System.out.println(stringToInt("-91283472332")); // -2147483648
        System.out.println(stringToInt("91283472332")); // 2147483647


    }



}
