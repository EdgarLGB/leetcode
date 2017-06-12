public class Solution {
    // public List<String> letterCombinations(String digits) {
    //   List<String> result = new ArrayList();
    //   if (digits == "") {
    //     return result;
    //   }
    //   int possible = 1;
    //
    // }
    public List<String> letterCombinations(String digits) {
      LinkedList<String> result = new LinkedList();
      if (digits == "") {
        return result;
      }
      String[] keyMappings = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
      result.addLast("");
      for(int i = 0; i < digits.length(); i++) {
        String mappings = keyMappings[digits.charAt(i) - '0'];
        int times = result.size();
        while(times-- > 0) {
          String target = result.remove();
          for(int j = 0; j < mappings.length(); j++) {
            result.push(target + mappings.charAt(j));
          }
        }
      }
      if (result.get(0) == "") {
        result.remove(0);
      }
      return result;
    }
}
