public class Solution {
    public List<String> generateParenthesis(int n) {
      List<String> result = new LinkedList<>();
      generateParenthesis(result, "", 0, 0, n);
      return result;
    }

    private void generateParenthesis(List<String> result, String str, int open, int close, int max) {
      if (str.length() == 2 * max) {
        result.add(str);
        return;
      }
      if (open < max) {
        generateParenthesis(result, str + "(", open + 1, close, max);
      }
      if (close < open) {
        generateParenthesis(result, str + ")", open, close + 1, max);
      }
    }
}
