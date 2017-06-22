public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
          return false;
        }
        int origin = x;
        long shadow = 0;
        while (x != 0) {
          shadow = shadow * 10 + x % 10;
          x /= 10;
        }
        if (shadow > Integer.MAX_VALUE) {
          return false;
        }
        return origin == (int) shadow;
    }
}
