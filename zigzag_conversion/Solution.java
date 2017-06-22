public class Solution {
    public String convert(String s, int numRows) {
        if (s == "" || numRows == 1) {
          return s;
        }
        char[] result = new char[s.length()];
        int currentIndex = 0;
        for (int l = 0; l < numRows; l++) {
          for (int i = 0; ; i++) {
            // downside
            int downsideIndex = l + i * (2 * numRows - 2);
            if (downsideIndex < s.length()) {
              result[currentIndex++] = s.charAt(downsideIndex);
            } else {
              break;
            }
            // upside
            if (l == 0 || l == numRows - 1) {
              continue;
            }
            int upsideIndex = (i + 1) * (2 * numRows - 2) - l;
            if (upsideIndex < s.length()) {
              result[currentIndex++] = s.charAt(upsideIndex);
            } else {
              break;
            }
          }
        }
        return new String(result);
    }
}
