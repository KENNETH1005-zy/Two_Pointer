import java.util.*;

class Solution3 {
    public static boolean isStrobogrammatic(String num) {
        Map <Character, Character> dict= new HashMap<>();
        dict.put ('0' , '0');
        dict.put ('1' , '1');
        dict.put ('6' , '9');
        dict.put ('8' , '8');
        dict.put ('9' , '6');
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            if (dict.containsKey(num.charAt(left)) && dict.get(num.charAt(left)) == num.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String[] nums = {
                "609",
                "88",
                "962",
                "101",
                "123"
        };

        int i = 0;
        for (String num : nums) {
            System.out.println((i + 1) + ".\tnum: " + num);
            System.out.println("\n\tIs strobogrammatic: " + (isStrobogrammatic(num) ? "true" : "false"));
            System.out.println(new String(new char[100]).replace("\0", "-"));
            i++;
        }
    }
}