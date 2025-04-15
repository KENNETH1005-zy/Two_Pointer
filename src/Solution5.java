import java.util.*;
class Solution5 {
    public static boolean findpermutation(List <Character> digits) {
        int i = digits.size() - 2;
        while (i >=0 && digits.get(i) >= digits.get(i +1)) {
            i--;
        }
        if (i == -1) {
            return false;
        }
        int j = digits.size() - 1;
        while (digits.get(j) <= digits.get(i)) {
            j--;
        }
        Collections.swap(digits, i, j);
        Collections.reverse(digits.subList(i + 1, digits.size()));
        return true;
    }
    public static String findPalindrome(String numStr) {
        int n = numStr.length();
        int halfLeft = n / 2;
        List <Character> LeftHalf = new ArrayList<>();
        for (int i = 0; i < halfLeft; i++) {
            LeftHalf.add(numStr.charAt(i));
        }
        StringBuilder nextPalindrome = new StringBuilder();
        if (!findpermutation (LeftHalf)){
            return "";
        }
        for (char c : LeftHalf) {
            nextPalindrome.append(c);
        }
        if (n % 2 == 0) {
            nextPalindrome.append(new StringBuilder(nextPalindrome).reverse());
        } else {
            nextPalindrome.append(numStr.charAt(halfLeft));
            nextPalindrome.append(new StringBuilder(nextPalindrome.substring(0, halfLeft)));
        }
        if (nextPalindrome.toString().compareTo(numStr) > 0){
            return nextPalindrome.toString();
        }
        return "";
    }
    public static void main(String[] args) {
        String[] testCases = {"1221", "54345", "999", "12321", "89798"};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println(i + 1 + ".\t Original palindrome: '" + testCases[i] + "'");
            String nextPalindrome = findPalindrome(testCases[i]);
            System.out.println("\t Next greater palindrome: '" + nextPalindrome + "'");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}