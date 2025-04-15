import java.util.*;

class Solution4 {
    public  static int minMovesToMakePalindrome (String s) {
        char[] chars = s.toCharArray();
        int moves = 0;
        for (int i = 0,  j = chars.length - 1; i < j; i++){
            int k = j;
            for( ; k > i; k--) {
                if (chars[i] == chars[k]) {
                    for ( ; k < j; k++){
                        char temp = chars[k];
                        chars[k] = chars[k + 1];
                        chars[k + 1] = temp;
                        moves++;
                    }
                    j--;
                    break;
                }
            }
            if (k == i) {
                moves += chars.length/2 - i;
            }
        }
        return moves;
    }
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("ccxx", "arcacer", "w", "ooooooo", "eggeekgbbeg");


        for (int i = 0; i < strings.size(); ++i) {
            System.out.println((i + 1) + ".\ts: " + strings.get(i));
            System.out.println("\tMoves: " + minMovesToMakePalindrome(strings.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}